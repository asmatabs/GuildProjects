/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.dto.ItemPrice;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author asmat
 */
public class ItemsDaoStubImpl implements ItemsDao {

    private Map<String, List<Item>> items = new HashMap<>();
    private Map<String, BigDecimal> itemPrices = new LinkedHashMap<>(16, 0.75f, false);

    public ItemsDaoStubImpl() {
        List<Item> listItems = new ArrayList<>();
        Item onlyItem = new Item();
        onlyItem.setItemId("SNIC101");
        onlyItem.setName("Snickers");

        LocalDate manfDate;
        manfDate = LocalDate.parse("2017-07-11");
        onlyItem.setManufacturerDate(manfDate);
        onlyItem.setNutriInfo("110 calories");
        listItems.add(onlyItem);
        items.put("Snickers", listItems);
    }

    @Override
    public Map<String, List<Item>> getItems() {
        return items;
    }

    @Override
    public Item getItem(String name) {
        Item onlyItem = new Item();
        onlyItem.setItemId("SNIC101");
        onlyItem.setName("Snickers");

        LocalDate manfDate;
        manfDate = LocalDate.parse("2017-07-11");
        onlyItem.setManufacturerDate(manfDate);
        onlyItem.setNutriInfo("110 calories");

        return onlyItem;
    }

    @Override
    public ItemPrice getItemPrice(String item) {
        ItemPrice itemPrice = new ItemPrice("Snickers", BigDecimal.valueOf(1.99));
        return itemPrice;
    }

    @Override
    public void loadInventory() throws FilePersistenceException {
    }

    @Override
    public void loadPricingInfo() throws FilePersistenceException {
    }

    @Override
    public void updateInventory() throws FilePersistenceException {
    }

    @Override
    public Map<String, BigDecimal> getItemsWithPrices() {
        Map<String, BigDecimal> itemPricesMap = new HashMap<String, BigDecimal>();

        itemPricesMap.put("Snickers", BigDecimal.valueOf(1.99));
        return itemPricesMap;
    }

    @Override
    public void removeItem(Item item) {
        List itemList = items.get(item.getName());
        if (itemList != null) {
            itemList.remove(item);

            items.put(item.getName(), itemList);
        }
    }

}
