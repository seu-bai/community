package com.bai.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: Bai
 * Description: community
 * Created in 2021/01/20 10:34
 */
@Controller
public class helloController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name",required = false,defaultValue = "World")
                           String name, Model model){
        model.addAttribute("name",name);
        return "greeting";

    }
}
