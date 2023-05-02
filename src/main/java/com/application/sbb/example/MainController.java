package com.application.sbb.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/name")
    @ResponseBody
    public String name() {
        return "pintor";
    }

    @GetMapping("/age")
    @ResponseBody
    public String age() {
        return "31 in korean age";
    }

    @GetMapping("/height")
    @ResponseBody
    public String height() {
        return "175 cm";
    }

}
