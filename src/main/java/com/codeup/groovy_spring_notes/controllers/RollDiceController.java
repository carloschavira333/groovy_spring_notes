package com.codeup.groovy_spring_notes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String guessNumber(){
        return "guessNumber";
    }

    @GetMapping("/roll-dice/{n}")
    public String guessedNumber(@PathVariable int n, Model model){
        model.addAttribute("guessedNumber", n);

        int randomNumber = (int)(Math.floor(Math.random()*((6-1)+1))+1);
        model.addAttribute("randomNumber", randomNumber);

        return "guessedNumberResult";

    }


}
