package betsafe.service;

import betsafe.model.BettingOfficeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BettingOfficeStorage {
    private List<BettingOfficeModel> offices;
    private OfficeFactory officeFactory;

    @Autowired
    public BettingOfficeStorage( OfficeFactory officeFactory) {
        this.offices = new ArrayList<>();
        this.officeFactory = officeFactory;
    }

    public void addOffice() throws IOException {
        BettingOfficeModel office = officeFactory.createBettingOffice();
        offices.add(office);
    }

    public List<BettingOfficeModel>getOffices() {
        return offices;
    }
}
