package lk.customsProcessManagement.asset.chandlerLicense.controller;

import lk.customsProcessManagement.asset.chandler.service.ChandlerService;
import lk.customsProcessManagement.asset.chandlerLicense.entity.ChandlerLicense;
import lk.customsProcessManagement.asset.chandlerLicense.entity.Enum.LicenseStatus;
import lk.customsProcessManagement.asset.chandlerLicense.service.ChandlerLicenseService;
import lk.customsProcessManagement.util.interfaces.AbstractController;
import lk.customsProcessManagement.util.service.MakeAutoGenerateNumberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping( "/chandlerLicense" )
public class ChandlerLicenseController implements AbstractController< ChandlerLicense, Integer > {
    private final ChandlerLicenseService chandlerLicenseService;
    private final ChandlerService chandlerService;
    private final MakeAutoGenerateNumberService makeAutoGenerateNumberService;

    public ChandlerLicenseController(ChandlerLicenseService chandlerLicenseService, ChandlerService chandlerService,
                                     MakeAutoGenerateNumberService makeAutoGenerateNumberService) {
        this.chandlerLicenseService = chandlerLicenseService;
        this.chandlerService = chandlerService;
        this.makeAutoGenerateNumberService = makeAutoGenerateNumberService;
    }

    private String commonLicense(Model model, List< ChandlerLicense > chandlerLicenses, String message) {
        model.addAttribute("chandlerLicense", chandlerLicenses);
        model.addAttribute("message", message);
        return "chandlerLicense/chandlerLicense";
    }

    private String commonLicenseAdd(Model model, ChandlerLicense chandlerLicense, boolean addStatus,
                                    boolean customLicense) {
        model.addAttribute("chandlers", chandlerService.findAll());
        model.addAttribute("chandlerLicense", chandlerLicense);
        model.addAttribute("customLicense", customLicense);
        model.addAttribute("addStatus", addStatus);
        return "chandlerLicense/addChandlerLicense";
    }

    @GetMapping
    public String findAll(Model model) {
        return commonLicense(model, chandlerLicenseService.findAll(), "All Register Chandler License");
    }

    @GetMapping( "/valid" )
    public String validLicense(Model model) {
        return commonLicense(model, chandlerLicenseService.findByLicenseStatus(LicenseStatus.VALID), "Valid Chandler " +
                "List");
    }

    @GetMapping( "/process" )
    public String processingLicense(Model model) {
        return commonLicense(model, chandlerLicenseService.findByLicenseStatus(LicenseStatus.PROCEED), "On Processing" +
                " License List");
    }

    @GetMapping( "/invalid" )
    public String invalidLicense(Model model) {
        return commonLicense(model, chandlerLicenseService.findByLicenseStatus(LicenseStatus.INVALID), "Expired " +
                "Licenses");
    }

    @GetMapping( "/add" )
    public String addForm(Model model) {
        return commonLicenseAdd(model, new ChandlerLicense(), true, false);
    }

    @GetMapping( "/add/{id}" )
    public String customLicense(@PathVariable( "id" ) Integer id, Model model) {
        ChandlerLicense chandlerLicense = new ChandlerLicense();
        chandlerLicense.setChandler(chandlerService.findById(id));
        return commonLicenseAdd(model, chandlerLicense, true, true);
    }

    @PostMapping( value = {"/save", "/update"} )
    public String persist(@Valid @ModelAttribute ChandlerLicense chandlerLicense, BindingResult bindingResult,
                          RedirectAttributes redirectAttributes, Model model) {
        if ( bindingResult.hasErrors() ) {
            return commonLicenseAdd(model, chandlerLicense, true, false);
        }

        if ( chandlerLicense.getId() == null ) {
            //Manage license number
            ChandlerLicense lastLicense = chandlerLicenseService.findLastChandlerLicense();
            String code = "SLCC";
            if ( lastLicense == null ) {
                chandlerLicense.setNumber(code.concat(String.valueOf(makeAutoGenerateNumberService.numberAutoGen(null))));
            } else {
                String lastNumber = lastLicense.getNumber().substring(4);
                chandlerLicense.setNumber(code.concat(String.valueOf(makeAutoGenerateNumberService.numberAutoGen(lastNumber))));
            }
            // license status
            chandlerLicense.setLicenseStatus(LicenseStatus.PROCEED);
        }
        chandlerLicenseService.persist(chandlerLicense);
        return "redirect:/chandlerLicense";
    }

    @GetMapping( "/edit/{id}" )
    public String edit(@PathVariable Integer id, Model model) {
        return commonLicenseAdd(model, chandlerLicenseService.findById(id), false, false);
    }

    @GetMapping( "/delete/{id}" )
    public String delete(@PathVariable Integer id, Model model) {
        return "redirect:/chandlerLicense";
    }

    @GetMapping( "/view/{id}" )
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("chandlerLicenseDetail", chandlerLicenseService.findById(id));
        return "chandlerLicense/chandlerLicense-detail";
    }
}
