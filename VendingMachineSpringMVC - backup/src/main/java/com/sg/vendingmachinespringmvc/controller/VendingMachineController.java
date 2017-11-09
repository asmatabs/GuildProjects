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

    @Inject
    public VendingMachineController(VendingMachineService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayItems(Model model, HttpServletRequest request) {
        
        HttpSession session = request.getSession();
        Map<Integer, Item> itemsMap;
        itemsMap = service.getItems(); 
        model.addAttribute("total", session.getAttribute("purchaseAmount"));
        model.addAttribute("itemsList", itemsMap.values());
        return "itemsPage";
    }

    @RequestMapping(value = "/displayItem/{itemId}", method = RequestMethod.GET)
    public String displayItemDetails(Model model, HttpServletRequest request, @PathVariable int itemId) {

        HttpSession session = request.getSession();
        Item currentItem = service.getItem(itemId);
        session.setAttribute("item", currentItem);
        
        model.addAttribute("total", session.getAttribute("purchaseAmount"));
        model.addAttribute("itemsList", service.getItems().values());
        model.addAttribute("item", currentItem);
        return "itemsPage";
    }

    @RequestMapping(value = "/purchase/{id}", method = RequestMethod.POST)
    public String purchaseItem(Model model, HttpServletRequest request, @PathVariable int id) {

        HttpSession session = request.getSession();
        BigDecimal amount = BigDecimal.ZERO;
        if (session.getAttribute("purchaseAmount") != null)
        {
            amount = (BigDecimal) session.getAttribute("purchaseAmount");
        }
        Response response = service.vendItem(id, amount);
        
        if (!response.isItemDispensed()) {
            model.addAttribute("message", response.getMessage());
            model.addAttribute("item", session.getAttribute("item"));
            model.addAttribute("total", session.getAttribute("purchaseAmount"));
        }
        else{
            model.addAttribute("message", "Thank you!!");
            model.addAttribute("item", null);
            model.addAttribute("total", "");
            session.setAttribute("purchaseAmount", BigDecimal.ZERO);
            model.addAttribute("change", response.getChange());
        }

        model.addAttribute("itemsList", service.getItems().values());
        return "itemsPage";
    }
    
    @RequestMapping(value="/getChange", method = RequestMethod.GET)
    public String getChange(Model model, HttpServletRequest request)
    {
        model.addAttribute("total", "");
        model.addAttribute("message", "");
        model.addAttribute("change", "");
        model.addAttribute("item", new Item());
        model.addAttribute("itemsList", service.getItems().values());
        
        return "itemsPage";
    }

}
