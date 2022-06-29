package com.codeup.groovy_spring_notes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

@GetMapping("/add/{num1}/and/{num2}")
@ResponseBody
    public String add(@PathVariable int num1, @PathVariable int num2){
        return  "Number " + num1 + " plus "+" Number " + num2 + " equals " + (num1 + num2);
    }

    @GetMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public String subtract(@PathVariable int num1, @PathVariable int num2){
        return  "Number " + num1 + " minus "+" Number " + num2 + " equals " + (num2 - num1);
    }

    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiply(@PathVariable int num1, @PathVariable int num2){
        return  "Number " + num1 + " times "+" Number " + num2 + " equals " + (num1 * num2);
    }
    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public String divide(@PathVariable int num1, @PathVariable int num2){
        return  "Number " + num1 + " divided " + " Number " + num2 + " equals " + (num1 / num2);
    }


}
