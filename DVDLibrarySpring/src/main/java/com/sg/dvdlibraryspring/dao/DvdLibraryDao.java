/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspring.dao;

import com.sg.dvdlibraryspring.model.Dvd;
import java.util.List;

/**
 *
 * @author asmat
 */
public interface DvdLibraryDao {
    
    Dvd addDvd(Dvd dvd);

    Dvd removeDvd(String title);
    
    List<Dvd> getAllDvds();

    Dvd getDvdById(int id);

}
