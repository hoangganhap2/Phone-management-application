package com.codegym.cms.controller;

import com.codegym.cms.model.Category;
import com.codegym.cms.model.Phone;
import com.codegym.cms.service.CategoryService;
import com.codegym.cms.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("/phones")
    public ModelAndView listPhones(@RequestParam("s") Optional<String> s,@PageableDefault(size = 10,sort = "price" ) Pageable pageable) {
        Page<Phone> phones;
        if (s.isPresent()) {
            phones = phoneService.findAllByNameContaining(s.get(),pageable);
        } else {
            phones = phoneService.findAll(pageable);
        }

        ModelAndView modelAndView = new ModelAndView("/phone/list");
        modelAndView.addObject("phones", phones);
        return modelAndView;
    }

    @GetMapping("create-phone")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/phone/create");
        modelAndView.addObject("phone", new Phone());
        return modelAndView;
    }

    @PostMapping("create-phone")
    public ModelAndView savePhone(@ModelAttribute("phone")Phone phone) {
        phoneService.save(phone);
        ModelAndView modelAndView = new ModelAndView("/phone/create");
        modelAndView.addObject("phone", new Phone());
        modelAndView.addObject("message","Them dien thoai thanh cong");
        return modelAndView;
    }

    @GetMapping("/edit-phone/{id}")
    public ModelAndView showEditPhone(@PathVariable Long id) {
        Phone phone = phoneService.findById(id);
        if (phone != null) {
            ModelAndView modelAndView = new ModelAndView("/phone/edit");
            modelAndView.addObject("phone",phone);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-phone")
    public ModelAndView updatePhone(@ModelAttribute("phone") Phone phone) {
        phoneService.save(phone);
        ModelAndView modelAndView = new ModelAndView("/phone/edit");
        modelAndView.addObject("phone", phone);
        modelAndView.addObject("message", "Cap nhat dien thoai thanh cong");
        return modelAndView;
    }

    @GetMapping("/delete-phone/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
       Phone phone = phoneService.findById(id);
        if(phone != null) {
            ModelAndView modelAndView = new ModelAndView("/phone/delete");
            modelAndView.addObject("phone", phone);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-phone")
    public String deletePhone(@ModelAttribute("phone") Phone phone){
        phoneService.remove(phone.getId());
        return "redirect:phones";
    }
}
