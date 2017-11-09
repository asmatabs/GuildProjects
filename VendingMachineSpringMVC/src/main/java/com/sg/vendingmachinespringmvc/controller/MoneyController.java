/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.controller;

import com.sg.vendingmachinespringmvc.service.VendingMachineService;
import java.math.BigDecimal;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author asmat
 */
@Controller
public class MoneyController {

    VendingMachineService service;
    private BigDecimal purchaseAmount;

    @Inject
    public MoneyController(VendingMachineService service) {
        this.service = service;
    }

    @RequestMapping(value = "/money/dollar", method = RequestMethod.POST)
    public String addDollar(Model model, HttpServletRequest request) {

        purchaseAmount = service.addDollar();
        model.addAttribute("itemsList", service.getItems().values());
        model.addAttribute("total", purchaseAmount);
        return "itemsPage";
    }

    @RequestMapping(value = "/money/quarter", method = RequestMethod.POST)
    public String addQuarter(Model model, HttpServletRequest request) {
        purchaseAmount = service.addQuarter();
        model.addAttribute("itemsList", service.getItems().values());
        model.addAttribute("total", purchaseAmount);
        return "itemsPage";
    }

    @RequestMapping(value = "/money/dime", method = RequestMethod.POST)
    public String addDime(Model model, HttpServletRequest request) {
        purchaseAmount = service.addDime();
        model.addAttribute("itemsList", service.getItems().values());
        model.addAttribute("total", purchaseAmount);
        return "itemsPage";
    }

    @RequestMapping(value = "/money/nickel", method = RequestMethod.POST)
    public String addNickel(Model model, HttpServletRequest request) {
        purchaseAmount = service.addNickel();
        model.addAttribute("itemsList", service.getItems().values());
        model.addAttribute("total", purchaseAmount);
        return "itemsPage";
    }

}
