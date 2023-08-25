package com.tik.tok.controller.template;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index)")
    public String getIndex(){

        return "index";
    }

}
