/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.luckyseven;

import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author asmat
 */
@Controller
public class LuckySeven {

    @RequestMapping(value="/luckySeven", method=RequestMethod.POST)
    public String luckySeven(HttpServletRequest request,
            Model model) {
        String input = request.getParameter("amount");

        int amount = Integer.parseInt(input);

        int rolls = 0, breakingRoll = 0, highestAmount = amount;
        do {
            //Roll the dice until money is gone
            int firstDice = rollTheDice();
            int secondDice = rollTheDice();

            if (firstDice + secondDice == 7) {
                amount += 4;
            } else {
                amount--;
            }
            rolls++;
            if (amount > highestAmount) {
                highestAmount = amount;
                breakingRoll = rolls;
            }

        } while (amount >= 0);

        model.addAttribute("rolls", rolls);
        model.addAttribute("breakingRoll", breakingRoll);
        model.addAttribute("highestAmount", highestAmount);
        
        return "result";
    }

    public static int rollTheDice() {
        Random randomizer = new Random();
        return (randomizer.nextInt(7) + 1);
    }

}
