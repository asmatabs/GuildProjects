/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Item;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author asmat
 */
public class VendingMachineDaoDbImpl implements VendingMachineDao {

    private final String SQL_SELECT_ITEM = "Select * from Items "
                                             + "where ItemId = ? ";
    
    private final String SQL_SELECT_ALL_ITEMS = "Select * from Items ";
    
    private final String SQL_UPDATE_ITEM_QUANTITY = "Update Items "
                                                    + " set Quantity = ?"
                                                    + " where ItemId = ? ";
                                            
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    
    @Override
    public Map<Integer, Item> getItems() {
         //return jdbcTemplate.query(SQL_SELECT_ALL_ITEMS, new ItemMapper())
         //       .stream().collect(Collectors.toMap(i -> i.getItemId(), i -> i ));
         List<Item> items = jdbcTemplate.query(SQL_SELECT_ALL_ITEMS, new ItemMapper());
         Map<Integer, Item> itemsMap = items.stream().collect(Collectors.toMap(i -> i.getItemId(), i -> i ));
         return itemsMap;
    }

    @Override
    public Item getItem(int itemId) {
        return jdbcTemplate.queryForObject(SQL_SELECT_ITEM, new ItemMapper(), itemId);
    }

    @Override
    public void removeItem(int itemId) {
        Item currentItem = getItem(itemId);
        currentItem.setQuantity(currentItem.getQuantity() - 1);
        jdbcTemplate.update(SQL_UPDATE_ITEM_QUANTITY, 
                currentItem.getQuantity(),
                currentItem.getItemId());
    }
    
    private class ItemMapper implements RowMapper<Item>{

        @Override
        public Item mapRow(ResultSet rs, int i) throws SQLException {
            Item item = new Item();
            item.setItemId(rs.getInt("ItemId"));
            item.setName(rs.getString("Name"));
            item.setQuantity(rs.getInt("Quantity"));
            item.setPrice(rs.getBigDecimal("Price"));
            return item;
        }
        
    }
    
}
