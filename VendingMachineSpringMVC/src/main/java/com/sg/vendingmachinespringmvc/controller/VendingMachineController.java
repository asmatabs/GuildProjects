/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.controller;

import com.sg.vendingmachinespringmvc.model.Item;
import com.sg.vendingmachinespringmvc.model.Response;
import com.sg.vendingmachinespringmvc.service.VendingMachineService;
import java.math.BigDecimal;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author asmat
 */
@Controller
public class VendingMachineController {

    VendingMachineService service;
    Item currentItem;
    Response response;
    BigDecimal purchaseAmount;
    
    @Inject
    public VendingMachineController(VendingMachineService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayItems(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        Map<Integer, Item> itemsMap;
        itemsMap = service.getItems();
        model.addAttribute("total", purchaseAmount);
        model.addAttribute("itemsList", itemsMap.values());
        if (currentItem != null) {
            model.addAttribute("item", currentItem);
            session.setAttribute("item", currentItem);
        }
        if (response != null) {
            if (!response.isItemDispensed()) {
                model.addAttribute("message", response.getMessage());
            }
            else{
                model.addAttribute("total", "");
                model.addAttribute("message", "Thank you!!");
                model.addAttribute("change", response.getChange());
                currentItem = null;
                response = null;
            }
        }
        return "itemsPage";
    }

    @RequestMapping(value = "/displayItem/{itemId}", method = RequestMethod.GET)
    public String displayItemDetails(Model model, HttpServletRequest request, @PathVariable int itemId) {

        currentItem = service.getItem(itemId);
        return "redirect:/";
    }

    @RequestMapping(value = "/purchase/{id}", method = RequestMethod.POST)
    public String purchaseItem(Model model, HttpServletRequest request, @PathVariable int id) {

        response = service.vendItem(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/getChange", method = RequestMethod.GET)
    public String getChange(Model model, HttpServletRequest request) {
        purchaseAmount = null;
        currentItem = null;
        response = null;
        return "redirect:/";
    }

    @RequestMapping(value = "/money/dollar", method = RequestMethod.POST)
    public String addDollar(Model model, HttpServletRequest request) {

        purchaseAmount = service.addDollar();
        return "redirect:/";
    }

    @RequestMapping(value = "/money/quarter", method = RequestMethod.POST)
    public String addQuarter(Model model, HttpServletRequest request) {

        purchaseAmount = service.addQuarter();
        return "redirect:/";
    }

    @RequestMapping(value = "/money/dime", method = RequestMethod.POST)
    public String addDime(Model model, HttpServletRequest request) {

        purchaseAmount = service.addDime();
        return "redirect:/";
    }

    @RequestMapping(value = "/money/nickel", method = RequestMethod.POST)
    public String addNickel(Model model, HttpServletRequest request) {
        purchaseAmount = service.addNickel();
        return "redirect:/";
    }
}
