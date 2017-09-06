/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.directoryapplication;

import com.sg.directoryapplication.controller.DirectoryApplicationController;
import com.sg.directoryapplication.dao.DirectoryApplicationDao;
import com.sg.directoryapplication.dao.DirectoryApplicationDaoFileImpl;
import com.sg.directoryapplication.service.DirectoryApplicationServiceLayer;
import com.sg.directoryapplication.service.DirectoryApplicationServiceLayerImpl;
import com.sg.directoryapplication.ui.DirectoryApplicationView;
import com.sg.directoryapplication.ui.UserIO;
import com.sg.directoryapplication.ui.UserIOConsoleImpl;

/**
 *
 * @author asmat
 */
public class App {

    public static void main(String[] args) {

        UserIO io = new UserIOConsoleImpl();
        //Construct View and Dao
        DirectoryApplicationView view = new DirectoryApplicationView(io);

        DirectoryApplicationDao dao = new DirectoryApplicationDaoFileImpl();

        DirectoryApplicationServiceLayer service = new DirectoryApplicationServiceLayerImpl(dao);

        DirectoryApplicationController controller = new DirectoryApplicationController(service, view);
        controller.run();
    }
}
