package ru.easyjava.spring.webmvc.sttc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.easyjava.spring.webmvc.sttc.entity.Package;
import ru.easyjava.spring.webmvc.sttc.service.PackageService;

@Controller
@RequestMapping("/packages")
public class PackageController {

    @Autowired
    private PackageService packageService;

    @GetMapping
    public ModelAndView list() {
        return new ModelAndView("list", "parcels", packageService.list());

    }

    @GetMapping("/{id}")
    public ModelAndView view(@PathVariable Integer id) {
        Package p = packageService.get(id);
        if (p == null) {
            return new ModelAndView("list", HttpStatus.NOT_FOUND);
        }
        return new ModelAndView("form", "parcel", packageService.get(id));
    }

    @PostMapping("/{id}")
    public String edit(@ModelAttribute Package p) {
        packageService.update(p);
        return "redirect:/packages";
    }
}
