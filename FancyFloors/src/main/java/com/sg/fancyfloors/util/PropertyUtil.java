/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fancyfloors.util;

import com.sg.fancyfloors.dao.FilePersistenceException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author asmat
 */
public class PropertyUtil {

    static Properties properties;

    private void LoadProperties() throws FilePersistenceException {
        properties = new Properties();
        String propFileName = "config.properties";

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        try {
            properties.load(inputStream);
        } catch (IOException ex) {
            throw new FilePersistenceException(
                    "-_- Could not load properties file from memory.", ex);
        }
    }

    public static String getProperty(String key) {
        if (properties == null) {
            PropertyUtil util = new PropertyUtil();
            try {
                util.LoadProperties();
            } catch (FilePersistenceException ex) {
                return null;
            }
        }
        return properties.getProperty(key);
    }
}
