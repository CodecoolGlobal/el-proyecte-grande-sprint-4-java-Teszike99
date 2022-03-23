package com.example.BetSafe;


import Model.BettingOfficeModel;
import Service.BettingOfficeStorage;
import Service.OfficeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {
    private final BettingOfficeStorage bettingOfficeStorage;

    @Autowired
    public Controller(BettingOfficeStorage bettingOfficeStorage) {
        this.bettingOfficeStorage = bettingOfficeStorage;
    }

    @GetMapping(value = "/index")
    public List<BettingOfficeModel> getOfficeStorage(){
        return bettingOfficeStorage.getOffices();
    }
}
