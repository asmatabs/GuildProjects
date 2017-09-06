/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary;

import com.sg.dvdlibrary.controller.DvdLibraryController;
import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;
import com.sg.dvdlibrary.ui.DvdLibraryView;

/**
 *
 * @author asmat
 */
public class App {
    public static void main(String[] args) {
        
        //Create IO
        UserIO io = new UserIOConsoleImpl();
        
        //Create view
        DvdLibraryView view = new DvdLibraryView(io);
        
        //Create DAO
        DvdLibraryDao dao = new DvdLibraryDaoFileImpl();
        
        //Wire them together
        DvdLibraryController controller = new DvdLibraryController(view, dao);
        controller.run();
    }
}
