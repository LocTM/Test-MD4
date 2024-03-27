package com.example.citymanager.controller;

import com.example.citymanager.model.City;
import com.example.citymanager.repo.ICountryRepository;
import com.example.citymanager.service.impl.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

@Controller
@RequestMapping(value = "/city")
public class CityController {
    @Autowired
    private CityService cityService;
    @Autowired
    private ICountryRepository countryRepository;

    @GetMapping()
    public String showCity(Model model) {
        Iterable<City> city = cityService.findAll();
        model.addAttribute("city", city);
        return "/index";
    }

    @GetMapping ("/detail/{id}")
    public String showDetail(@PathVariable Long id,  Model model) {
        Optional<City> city = cityService.findById(id);
        model.addAttribute("city", city.get());
        return "/detail";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("city", new City());
        model.addAttribute("country", countryRepository.findAll());
        return "/add";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute City city, BindingResult binding,Model model) {
        if(!binding.hasErrors()) {
            cityService.save(city);
            return "redirect:/city";
        }
        model.addAttribute("city", city);
        model.addAttribute("country", countryRepository.findAll());
        return "/add";
    }

    @GetMapping("/update/{id}")
    public String formUpdateCity(@PathVariable Long id, Model model) {
        Optional<City> city = cityService.findById(id);
        if (city.isPresent()) {
            model.addAttribute("city", city.get());
            model.addAttribute("country", countryRepository.findAll());
            return "/update";
        }
        return null;
    }
    @PostMapping("/update/{id}")
    public String updateCity(@ModelAttribute City city, BindingResult binding,Model model) {
        if(!binding.hasErrors()) {
            cityService.save(city);
            return "redirect:/city";
        }
        model.addAttribute("city", city);
        model.addAttribute("country", countryRepository.findAll());
        return "/update";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        cityService.remove(id);
        return "redirect:/city";
    }
}