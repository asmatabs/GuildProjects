/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.dto.ItemPrice;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author asmat
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {

    private Map<String, List<Item>> items = new HashMap<>();
    private Map<String, BigDecimal> itemPrices = new LinkedHashMap<>(16, 0.75f, false);  //preserve insertion order
    public static final String ITEMS_FILE = "Items.txt";
    public static final String PRICING_FILE = "Pricing.txt";
    public static final String DELIMITER = "::";

    @Override
    public Map<String, List<Item>> getItems() {
        return items;
    }
    
    @Override
    public Item getItem(String name) {

        Item item = null;
        if (items.get(name) != null && items.get(name).size() > 0) {
            item = items.get(name).get(0);
        }
        return item;
    }
    
    @Override
    public void loadInventory() throws VMPersistenceException {

        Scanner scanner;
        String[] tokens;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ITEMS_FILE)));
        } catch (FileNotFoundException e) {
            throw new VMPersistenceException(
                    "-_- Could not load items from memory.", e);
        }
        String currentLine;
        List<Item> currentList;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            tokens = currentLine.split(DELIMITER);
            Item currentItem = new Item();
            currentItem.setItemId(tokens[0]);
            currentItem.setName(tokens[1]);

            LocalDate manfDate;
            manfDate = LocalDate.parse(tokens[2]);
            currentItem.setManufacturerDate(manfDate);

            if (tokens.length >= 3) {
                currentItem.setNutriInfo(tokens[3]);
            } else {
                currentItem.setNutriInfo("");
            }

            currentList = items.get(currentItem.getName());
            if (currentList == null) {
                //First new item found
                currentList = new ArrayList<>();
            }
            currentList.add(currentItem);
            items.put(currentItem.getName(), currentList);
        }
        scanner.close();
    }

    @Override
    public void loadPricingInfo() throws VMPersistenceException {

        Scanner scanner;
        String[] tokens;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(PRICING_FILE)));
        } catch (FileNotFoundException e) {
            throw new VMPersistenceException(
                    "-_- Could not load pricing from memory.", e);
        }

        String currentLine;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            tokens = currentLine.split(DELIMITER);
            String name = tokens[0];
            BigDecimal price = new BigDecimal(tokens[1]);
            itemPrices.put(name, price);
        }
        scanner.close();
    }

    @Override
    public Map<String, BigDecimal> getItemsWithPrices() {
        return itemPrices;
    }

    @Override
    public void updateInventory() throws VMPersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ITEMS_FILE));
        } catch (IOException ex) {
            throw new VMPersistenceException("Could not save Items into memory", ex);
        }

        items.forEach((k, v)
                -> v.forEach((Item item)
                        -> out.println(item.getItemId() + DELIMITER
                        + item.getName() + DELIMITER
                        + item.getManufacturerDate() + DELIMITER
                        + item.getNutriInfo())));
        out.flush();
        out.close();
    }

    @Override
    public ItemPrice getItemPrice(int option) {
        String itemName = itemPrices.keySet().toArray()[option].toString();
        BigDecimal price = new BigDecimal(itemPrices.values().toArray()[option].toString());
        return new ItemPrice(itemName, price);
    }

    @Override
    public void removeItem(Item item) {

        List itemList = items.get(item.getName());
        itemList.remove(item);
        items.put(item.getName(), itemList);
    }
}
