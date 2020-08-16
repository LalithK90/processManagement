package lk.customs.processManagement.asset.vezzal.controller;



import lk.customs.processManagement.asset.commonAsset.model.Enum.Title;
import lk.customs.processManagement.asset.vezzal.entity.Vezzal;
import lk.customs.processManagement.asset.vezzal.service.VezzalService;
import lk.customs.processManagement.util.interfaces.AbstractController;
import lk.customs.processManagement.util.service.EmailService;
import lk.customs.processManagement.util.service.MakeAutoGenerateNumberService;
import lk.customs.processManagement.util.service.TwilioMessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/vezzal")
public class VezzalController implements AbstractController< Vezzal, Integer> {
    private final VezzalService vezzalService;
    private final MakeAutoGenerateNumberService makeAutoGenerateNumberService;
    private final EmailService emailService;
    private final TwilioMessageService twilioMessageService;

    public VezzalController(VezzalService vezzalService, MakeAutoGenerateNumberService makeAutoGenerateNumberService,
                            EmailService emailService, TwilioMessageService twilioMessageService) {
        this.vezzalService = vezzalService;
        this.makeAutoGenerateNumberService = makeAutoGenerateNumberService;
        this.emailService = emailService;
        this.twilioMessageService = twilioMessageService;
    }


    private String commonThings(Model model, Vezzal vezzal, Boolean addState) {
        model.addAttribute("title", Title.values());
        model.addAttribute("vezzal", vezzal);
        model.addAttribute("addStatus", addState);
        return "vezzal/addVezzal";
    }

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("vezzals", vezzalService.findAll());
        return "vezzal/vezzal";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        return commonThings(model, new Vezzal(), true);
    }

    @PostMapping(value = {"/save", "/update"})
    public String persist(Vezzal vezzal, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            return commonThings(model, vezzal, true);
        }

//if vezzal has id that vezzal is not a new vezzal
        if (vezzal.getId() == null) {
            //if there is not vezzal in db
            if (vezzalService.lastCustomer() == null) {
                System.out.println("last vezzal null");
                //need to generate new onecustomer
                vezzal.setCode("LKC"+makeAutoGenerateNumberService.numberAutoGen(null).toString());
            } else {
                System.out.println("last vezzal not null");
                //if there is vezzal in db need to get that vezzal's code and increase its value
                String previousCode = vezzalService.lastCustomer().getCode().substring(3);
                vezzal.setCode("LKC"+makeAutoGenerateNumberService.numberAutoGen(previousCode).toString());
            }

        }

        redirectAttributes.addFlashAttribute("vezzalDetail", vezzalService.persist(vezzal));
        return "redirect:/vezzal";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        return commonThings(model, vezzalService.findById(id), false);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        vezzalService.delete(id);
        return "redirect:/vezzal";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("vezzalDetail", vezzalService.findById(id));
        return "vezzal/vezzal-detail";
    }
}