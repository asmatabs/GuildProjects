/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringspringmvc;

import com.sg.flooringspringmvc.service.FlooringOrders;
import java.time.LocalDate;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author asmat
 */
@Controller
public class FlooringOrdersController {
    
   @Inject 
   FlooringOrders service;

    public FlooringOrdersController(FlooringOrders service) {
        this.service = service;
    }
   
    @RequestMapping(value="/")
    public String orders(HttpServletRequest request, Model model)
    {
        System.out.println(LocalDate.now());
        model.addAttribute("response", service.searchForOrders(3, LocalDate.now(), 0, ""));
        return "ordersPage";
    }
}
