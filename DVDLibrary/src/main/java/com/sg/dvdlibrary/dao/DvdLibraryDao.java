/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author asmat
 */
public interface DvdLibraryDao {
    
    Dvd addDvd(String title, Dvd dvd);

    Dvd removeDvd(String title);
    
    List<Dvd> getAllDvds();

    Dvd getDvd(String title);

    boolean checkDVDExists(String title);

    public void loadDvdData() throws DvdLibraryDaoException;

    public void writeDvdData()throws DvdLibraryDaoException;


}
