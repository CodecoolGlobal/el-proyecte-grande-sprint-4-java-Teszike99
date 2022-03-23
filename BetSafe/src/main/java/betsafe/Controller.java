package betsafe;


import betsafe.model.BettingOfficeModel;
import betsafe.service.OfficeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {
    private final OfficeFactory officeFactory;

    @Autowired
    public Controller(OfficeFactory officeFactory) {
        this.officeFactory = officeFactory;
    }

    @GetMapping(value = "/index")
    public BettingOfficeModel getOfficeStorage() throws IOException {
        return officeFactory.getBettingOffice();
    }
}
