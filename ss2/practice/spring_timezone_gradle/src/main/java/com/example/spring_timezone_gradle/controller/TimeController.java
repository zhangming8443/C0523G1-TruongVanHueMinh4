package com.example.spring_timezone_gradle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
@RequestMapping(value = "/timezone")
public class TimeController {
    @GetMapping("")
    public String getTimeByTimezone() {
        return "/home";
    }

    @GetMapping("/world_clock")
    public String getRawOffSet(ModelMap modelMap, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locale = TimeZone.getTimeZone(city);
        long localeTime = date.getTime() + (locale.getRawOffset() - local.getRawOffset());
        date.setTime(localeTime);
        modelMap.addAttribute("city", city);
        modelMap.addAttribute("date", date);
        return "home";
    }

}
