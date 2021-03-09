package lk.custom_process_management.asset.vessel.controller;



import lk.custom_process_management.asset.common_asset.model.enums.Title;
import lk.custom_process_management.asset.vessel.entity.Vessel;
import lk.custom_process_management.asset.vessel.service.VesselService;
import lk.custom_process_management.util.interfaces.AbstractController;
import lk.custom_process_management.util.service.EmailService;
import lk.custom_process_management.util.service.MakeAutoGenerateNumberService;
import lk.custom_process_management.util.service.TwilioMessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/vessel")
public class VesselController implements AbstractController< Vessel, Integer> {
    private final VesselService vesselService;
    private final MakeAutoGenerateNumberService makeAutoGenerateNumberService;
    private final EmailService emailService;
    private final TwilioMessageService twilioMessageService;

    public VesselController(VesselService vesselService, MakeAutoGenerateNumberService makeAutoGenerateNumberService,
                            EmailService emailService, TwilioMessageService twilioMessageService) {
        this.vesselService = vesselService;
        this.makeAutoGenerateNumberService = makeAutoGenerateNumberService;
        this.emailService = emailService;
        this.twilioMessageService = twilioMessageService;
    }


    private String commonThings(Model model, Vessel vessel, Boolean addState) {
        model.addAttribute("title", Title.values());
        model.addAttribute("vessel", vessel);
        model.addAttribute("addStatus", addState);
        return "vessel/addVessel";
    }

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("vessels", vesselService.findAll());
        return "vessel/vessel";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        return commonThings(model, new Vessel(), true);
    }

    @PostMapping(value = {"/save", "/update"})
    public String persist(Vessel vessel, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            return commonThings(model, vessel, true);
        }

//if vessel has id that vessel is not a new vessel
        if (vessel.getId() == null) {
            //if there is not vessel in db
            if (vesselService.lastVessel() == null) {
                System.out.println("last vessel null");
                //need to generate new onecustomer
                vessel.setCode("LKC"+makeAutoGenerateNumberService.numberAutoGen(null).toString());
            } else {
                System.out.println("last vessel not null");
                //if there is vessel in db need to get that vessel's code and increase its value
                String previousCode = vesselService.lastVessel().getCode().substring(3);
                vessel.setCode("LKC"+makeAutoGenerateNumberService.numberAutoGen(previousCode).toString());
            }

        }

        redirectAttributes.addFlashAttribute("vesselDetail", vesselService.persist(vessel));
        return "redirect:/vessel";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        return commonThings(model, vesselService.findById(id), false);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        vesselService.delete(id);
        return "redirect:/vessel";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("vesselDetail", vesselService.findById(id));
        return "vessel/vessel-detail";
    }
}
