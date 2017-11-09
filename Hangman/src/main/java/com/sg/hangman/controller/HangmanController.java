/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hangman.controller;

import com.sg.hangman.dao.HangmanDao;

/**
 *
 * @author asmat
 */
@CrossOrigin
@Controller
public class HangmanController {

    HangmanDao hangmanDao;

    @Inject
    public HangmanController(HangmanDao hangmanDao) {
        this.hangmanDao = hangmanDao;
    }
    
    @RequestMapping(value = "/word/{size}", method = RequestMethod.GET)
    @ResponseBody
    public String getWord(int size)
    {
        
    }

}
