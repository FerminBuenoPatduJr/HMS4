package com.sevensevengsi.springsecurity.controller;


import com.sevensevengsi.springsecurity.repository.HotelListRepository;
import com.sevensevengsi.springsecurity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HotelListController {

    @Autowired
    private HotelListRepository hotelListRepository;

    @GetMapping({"/hotellist"})
    public ModelAndView getAllHotelList() {
        ModelAndView mav = new ModelAndView("hotelList");
        mav.addObject("hotelList", hotelListRepository.findAll());
        return mav;
    }
}
