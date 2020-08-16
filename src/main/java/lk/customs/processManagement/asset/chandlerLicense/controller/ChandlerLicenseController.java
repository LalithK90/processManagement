package lk.customs.processManagement.asset.chandlerLicense.controller;

import lk.customs.processManagement.asset.chandlerLicense.entity.ChandlerLicense;
import lk.customs.processManagement.asset.chandlerLicense.service.ChandlerLicenseService;
import lk.customs.processManagement.util.interfaces.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

//todo=> all thing

@Controller
@RequestMapping( "/chandlerLicense" )
public class ChandlerLicenseController implements AbstractController< ChandlerLicense, Integer > {
    private final ChandlerLicenseService chandlerLicenseService;

    public ChandlerLicenseController(ChandlerLicenseService chandlerLicenseService) {
        this.chandlerLicenseService = chandlerLicenseService;
    }

    @GetMapping
    public String findAll(Model model) {
        return null;
    }

    @GetMapping( "/add" )
    public String addForm(Model model) {
        return null;
    }

    @PostMapping( value = {"save", "update"} )
    public String persist(@Valid @ModelAttribute ChandlerLicense chandlerLicense, BindingResult bindingResult,
                          RedirectAttributes redirectAttributes, Model model) throws Exception {
        return null;
    }

    @GetMapping( "/edit/{id}" )
    public String edit(@PathVariable Integer id, Model model) {
        return null;
    }

    @GetMapping( "/delete/{id}" )
    public String delete(@PathVariable Integer id, Model model) {
        return null;
    }

    @GetMapping( "/view/{id}" )
    public String view(@PathVariable Integer id, Model model) {
        return null;
    }
}
