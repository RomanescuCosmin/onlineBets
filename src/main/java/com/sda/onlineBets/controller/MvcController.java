package com.sda.onlineBets.controller;

import com.sda.onlineBets.dto.*;
import com.sda.onlineBets.service.*;
import com.sda.onlineBets.validate.UserValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.net.Authenticator;
import java.util.List;
import java.util.Map;

@Controller
public class MvcController {
    @Autowired
    private SelectionService selectionService;
    @Autowired
    private UserValidator userValidator;

    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private BetService betService;

    @Autowired
    private ContactService contactService;

    @GetMapping("/home")
    public String getHome(@RequestParam(name = "eventId", required = false) String eventId,
                          @RequestParam(name = "selection", required = false) String selection, Model model) {
        System.out.println("S-a apelat home page !  " + eventId + " " + selection);
        List<EventDto> eventDtoList = eventService.getAllEventDtoList();
        model.addAttribute("eventDtoList", eventDtoList);
        SelectionDto selectionDto = selectionService.createSelection(eventId, selection);
        model.addAttribute("selectionDto", selectionDto);
        model.addAttribute("stakeDto", new StakeDto());

        Map<String, List<EventDto>> groupedEvents = eventService.groupEventsByLeague(eventDtoList);
        model.addAttribute("groupedEvents", groupedEvents);

        return "home";

    }

    @PostMapping("/home")
    public String postHome(@ModelAttribute(name = "stakeDto") StakeDto stakeDto,
                           @RequestParam(name = "eventId", required = false) String eventId,
                           @RequestParam(name = "selection", required = false) String selection,
                           Authentication authentication) {
        System.out.println("S-a apelat metoda POST ");
        System.out.println(stakeDto.getStake());
        System.out.println(eventId);
        System.out.println(selection);
        betService.placeBet(eventId, selection, stakeDto, authentication.getName());
        return "redirect:/home";
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        System.out.println("S-a apelat login page");
        LoginDto loginDto = new LoginDto();
        model.addAttribute("loginDto", loginDto);
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute(name = "loginDto") @Valid LoginDto loginDto, Model model, BindingResult bindingResult) {
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
        userValidator.validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.createUser(userDto);
        return "redirect:/login";
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

    @GetMapping("/contact")
    public String getContact(ContactDto contactDto, Model model) {
        System.out.println("S-a apelat home page ! ");
        model.addAttribute("contactDto", contactDto);
        return "contact";
    }

    @PostMapping("/contact")
    public String postContact(@ModelAttribute(name = "contactDto") ContactDto contactDto,Model model) {
        contactService.saveContact(contactDto);
        model.addAttribute("successMessage","Mesajul a fost trimis !");
        return "contact";

    }

    @GetMapping("/myBet")
    public String addBetGet(BetDto betDto, Model model, Authentication authentication) {
        System.out.println("S-a apelat my bet" + betDto);
        List<BetDto> betDtoList = betService.getAllBetDtoListByEmail(authentication.getName());
        model.addAttribute("betDtoList", betDtoList);

        return "myBet";
    }

}