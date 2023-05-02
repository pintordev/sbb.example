package com.application.sbb.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    int num = 0;

    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }

    @GetMapping("/name")
    @ResponseBody
    public String name() {
        return "pintor";
    }

    @GetMapping("/age")
    @ResponseBody
    public String age() {
        return "31";
    }

    @GetMapping("/height")
    @ResponseBody
    public String height() {
        return "175 cm";
    }

    @GetMapping("/plus")
    @ResponseBody
    public int showPlus(int a, int b) {
        return a + b;
    }

    @GetMapping("/minus")
    @ResponseBody
    public int showMinus(int a, int b) {
        return a - b;
    }

    @GetMapping("/increase")
    @ResponseBody
    public int showIncrease() {
        return num++;
    }

    @GetMapping("/mbti/{name}")
    @ResponseBody
    public String showMbti(@PathVariable String name) {
        return switch (name) {
            case "김호현", "서빈" -> {
                char j = 'J';
                yield "IST" + j;
            }
            default -> "모름";
        };
    }
}
