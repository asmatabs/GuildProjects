/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine;

import com.sg.vendingmachine.controller.VendingMachineController;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.sg.vendingmachine.service.VendingMachineServiceImpl;
import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIOConsoleImpl;
import com.sg.vendingmachine.ui.VendingMachineView;
import com.sg.vendingmachine.service.VendingMachineService;

/**
 *
 * @author asmat
 */
public class App {

    public static void main(String[] args) {

        //Create io
        UserIO io = new UserIOConsoleImpl();

        //Create view
        VendingMachineView view = new VendingMachineView(io);
        
        //Create DAO
        VendingMachineDao dao = new VendingMachineDaoFileImpl();
        
        //Create service
        VendingMachineService service = new VendingMachineServiceImpl(dao);

        //Wire them together
        VendingMachineController controller = new VendingMachineController(view, service);
        controller.start();
    }
}
