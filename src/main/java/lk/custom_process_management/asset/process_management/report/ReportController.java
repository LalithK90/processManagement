package lk.custom_process_management.asset.process_management.report;

import lk.custom_process_management.asset.chandler.entity.Chandler;
import lk.custom_process_management.asset.chandler.service.ChandlerService;
import lk.custom_process_management.asset.common_asset.model.TwoDate;
import lk.custom_process_management.asset.item.entity.Item;
import lk.custom_process_management.asset.item.service.ItemService;
import lk.custom_process_management.asset.payment.entity.Payment;
import lk.custom_process_management.asset.payment.entity.enums.StatusConformation;
import lk.custom_process_management.asset.payment.service.PaymentService;
import lk.custom_process_management.asset.process_management.report.model.ChandlerDetail;
import lk.custom_process_management.asset.ship_agent.service.ShipAgentService;
import lk.custom_process_management.asset.vessel_order.service.VesselOrderService;
import lk.custom_process_management.asset.vessel_order_item_bid.entity.VesselOrderItemBid;
import lk.custom_process_management.asset.vessel_order_item_bid.service.VesselOrderItemBidService;
import lk.custom_process_management.asset.vessel_order_item_bid_payment.entity.VesselOrderItemBidPayment;
import lk.custom_process_management.asset.vessel_order_item_bid_payment.service.VesselOrderItemBidPaymentService;
import lk.custom_process_management.util.service.DateTimeAgeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping( "/report" )
public class ReportController {
  private final PaymentService paymentService;
  private final DateTimeAgeService dateTimeAgeService;
  private final ChandlerService chandlerService;
  private final ShipAgentService shipAgentService;
  private final VesselOrderService vesselOrderService;
  private final ItemService itemService;
  private final VesselOrderItemBidService vesselOrderItemBidService;
  private final VesselOrderItemBidPaymentService vesselOrderItemBidPaymentService;

  public ReportController(PaymentService paymentService, DateTimeAgeService dateTimeAgeService,
                          ChandlerService chandlerService, ShipAgentService shipAgentService,
                          VesselOrderService vesselOrderService, ItemService itemService,
                          VesselOrderItemBidService vesselOrderItemBidService,
                          VesselOrderItemBidPaymentService vesselOrderItemBidPaymentService) {
    this.paymentService = paymentService;
    this.dateTimeAgeService = dateTimeAgeService;
    this.chandlerService = chandlerService;
    this.shipAgentService = shipAgentService;
    this.vesselOrderService = vesselOrderService;
    this.itemService = itemService;
    this.vesselOrderItemBidService = vesselOrderItemBidService;
    this.vesselOrderItemBidPaymentService = vesselOrderItemBidPaymentService;
  }
/*all chandler report - start*/
  private ChandlerDetail chandlerDetail(Chandler chandler, List< VesselOrderItemBid > vesselOrderItemBids,
                                        List< VesselOrderItemBidPayment > vesselOrderItemBidPayments,
                                        List< Payment > payments) {
    ChandlerDetail chandlerDetail = new ChandlerDetail();
    chandlerDetail.setChandler(chandler);
    chandlerDetail.setBiddenCount(vesselOrderItemBids.stream().filter(x -> x.getChandler().equals(chandler)).count());

    List< VesselOrderItemBidPayment > vesselOrderItemBidPaymentAccordingToC =
        vesselOrderItemBidPayments.stream().filter(x -> x.getVesselOrderItemBid().getChandler().equals(chandler)).collect(Collectors.toList());
    chandlerDetail.setApproveCount((long) vesselOrderItemBidPaymentAccordingToC.size());
    List< Item > items = new ArrayList<>();
    vesselOrderItemBidPaymentAccordingToC.forEach(x -> items.add(itemService.findById(vesselOrderItemBidService.findById(x.getVesselOrderItemBid().getId()).getVesselOrderItem().getItem().getId())));
    chandlerDetail.setProvidedItems(items.stream().distinct().collect(Collectors.toList()));
    //total amounts
    List< BigDecimal > amounts = new ArrayList<>();
    payments.stream().filter(x -> x.getChandler().equals(chandler)).collect(Collectors.toList()).forEach(y -> amounts.add(y.getAmount()));
    chandlerDetail.setTotalAmount(amounts.stream().reduce(BigDecimal.ZERO, BigDecimal::add));

    return chandlerDetail;
  }
  private String commonChandlers(Model model, LocalDate from, LocalDate to) {
    /*chandler;  biddenCount;  approveCount;  providedItems;  totalAmount;*/
    List< ChandlerDetail > chandlerDetails = new ArrayList<>();

    LocalDateTime startAt = dateTimeAgeService.dateTimeToLocalDateStartInDay(from);
    LocalDateTime endAt = dateTimeAgeService.dateTimeToLocalDateEndInDay(to);

    List< Chandler > chandlers = chandlerService.findAll();
    List< VesselOrderItemBid > vesselOrderItemBids = vesselOrderItemBidService.findByCreatedAtIsBetween(startAt, endAt);
    List< VesselOrderItemBidPayment > vesselOrderItemBidPayments =
        vesselOrderItemBidPaymentService.findByCreatedAtIsBetween(startAt, endAt);
    List< Payment > payments = paymentService.findByCreatedAtIsBetween(startAt, endAt);

    for ( Chandler chandler : chandlers ) {
      chandlerDetails.add(chandlerDetail(chandler, vesselOrderItemBids, vesselOrderItemBidPayments, payments));
    }
    model.addAttribute("chandlerDetails", chandlerDetails);

    model.addAttribute("message",
                       "Following table show details belongs from " + from + " to " + to +
                           "there month. if you need to more please search using above method");
    model.addAttribute("searchUrl", "/report/chandlers");

    return "report/chandlers";
  }

  @GetMapping( "/chandlers" )
  public String chandlers(Model model) {
    return commonChandlers(model, dateTimeAgeService.getPastDateByMonth(3), LocalDate.now());
  }

  @PostMapping( "/chandlers" )
  public String chandlersSearch(@ModelAttribute TwoDate twoDate, Model model) {
    return commonChandlers(model, twoDate.getStartDate(), twoDate.getEndDate());
  }
  private String commonChandler(Model model, LocalDate from, LocalDate to, Chandler chandler) {
    LocalDateTime startAt = dateTimeAgeService.dateTimeToLocalDateStartInDay(from);
    LocalDateTime endAt = dateTimeAgeService.dateTimeToLocalDateEndInDay(to);

    List< VesselOrderItemBid > vesselOrderItemBids = vesselOrderItemBidService.findByCreatedAtIsBetween(startAt, endAt)
        .stream().filter(x -> x.getChandler().equals(chandler)).collect(Collectors.toList());
    List< VesselOrderItemBidPayment > vesselOrderItemBidPayments =
        vesselOrderItemBidPaymentService.findByCreatedAtIsBetween(startAt, endAt).stream().filter(x -> x.getVesselOrderItemBid().getChandler().equals(chandler)).collect(Collectors.toList());
    List< Payment > payments =
        paymentService.findByCreatedAtIsBetween(startAt, endAt).stream().filter(x -> x.getChandler().equals(chandler)).collect(Collectors.toList());

    model.addAttribute("chandlerDetails", chandlerDetail(chandler, vesselOrderItemBids, vesselOrderItemBidPayments,
                                                         payments));
    model.addAttribute("vesselOrderItemBidPayments", vesselOrderItemBidPayments);
    model.addAttribute("payments", payments);
    model.addAttribute("chandlerDetail", chandler);
    model.addAttribute("message",
                       "Following table show details belongs from " + from + " to " + to +
                           "there month. if you need to more please search using above method");
    model.addAttribute("searchUrl", "/report/chandler");

    return "report/chandler";
  }

  @GetMapping( "/chandler/{id}" )
  public String chandlerDetail(@PathVariable( "id" ) Integer id, Model model) {
    return commonChandler(model, dateTimeAgeService.getPastDateByMonth(3), LocalDate.now(),
                          chandlerService.findById(id));
  }

  @PostMapping( "/chandler" )
  public String chandlerDetail(@ModelAttribute TwoDate twoDate, Model model) {
    return commonChandler(model, twoDate.getStartDate(), twoDate.getEndDate(),
                          chandlerService.findById(twoDate.getId()));
  }
/*all chandler report - finished*/

  /*all ship agent report - start*/
  //todo: ship agent and vessel
}
