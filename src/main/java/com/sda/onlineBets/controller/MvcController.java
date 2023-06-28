package com.sda.onlineBets.controller;

import com.sda.onlineBets.dto.EventDto;
import com.sda.onlineBets.dto.LoginDto;
import com.sda.onlineBets.dto.UserDto;
import com.sda.onlineBets.service.EventService;
import com.sda.onlineBets.service.LoginService;
import com.sda.onlineBets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class MvcController {
    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @GetMapping("/home")
    public String getHome(Model model) {
        System.out.println("S-a apelat home page ! ");
        List<EventDto> eventDtoList = eventService.getAllEventDtoList();
        model.addAttribute("eventDtoList", eventDtoList);
        return "home";

    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        System.out.println("S-a apelat login page");
        LoginDto loginDto = new LoginDto();
        model.addAttribute("loginDto", loginDto);
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute(name = "loginDto") LoginDto loginDto, Model model, BindingResult bindingResult) {
        System.out.println(loginDto);
        if (bindingResult.hasErrors()) {
            return "login";
        }
        Boolean loginSuccessful = loginService.login(loginDto);
        if (loginSuccessful) {
            model.addAttribute("loginMessage", "Login was succesful!");

        } else {
            model.addAttribute("loginMessage", "Email failed!");

        }
        return "login";

    }

    @GetMapping("/registration")
    public String getRegistration(Model model) {
        System.out.println("S-a apelat registration ! ");
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", new UserDto());
        return "registration";
    }

    @PostMapping("/registration")
    public String postRegistration(@ModelAttribute(name = "userDto") UserDto userDto, BindingResult bindingResult) {
        System.out.println("S-a apelat registration post!");
        if (bindingResult.hasErrors()) {
            return "registration";
        }
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
