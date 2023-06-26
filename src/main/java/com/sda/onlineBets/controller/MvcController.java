package com.sda.onlineBets.controller;

import com.sda.onlineBets.dto.EventDto;
import com.sda.onlineBets.dto.UserDto;
import com.sda.onlineBets.service.EventService;
import com.sda.onlineBets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MvcController {
    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String getHome() {
        System.out.println("S-a apelat home page ! ");
        return "home";

    }

    @GetMapping("/registration")
    public String getRegistration(Model model) {
        System.out.println("S-a apelat registration ! ");
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", new UserDto());
        return "registration";
    }

    @PostMapping("/registration")
    public String postRegistration(@ModelAttribute(name = "userDto") UserDto userDto) {
        System.out.println("S-a apelat registration post!");
        userService.createUser(userDto);
        return "redirect:/registration";
    }

    @GetMapping("/addEvent")
    public String addEventsGet(Model model) {
        EventDto eventDto = new EventDto();
        model.addAttribute("addEvent", eventDto);
        return "addEvent";

    }

    @PostMapping("/addEvent")
    public String addEventsPost(@ModelAttribute(name = "addEvent") EventDto eventDto, Model model) {
        System.out.println(eventDto);
        eventService.addEvent(eventDto);
        return "redirect:/addEvent";

    }


}
