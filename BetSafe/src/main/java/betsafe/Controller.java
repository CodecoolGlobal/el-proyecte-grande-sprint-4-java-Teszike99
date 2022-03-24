package betsafe;

import betsafe.model.BettingOfficeModel;
import betsafe.model.MatchModel;
import betsafe.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {
    private final Service officeFactory;

    @Autowired
    public Controller(Service officeFactory) {
        this.officeFactory = officeFactory;
    }

    @GetMapping(value = "/index")
    public BettingOfficeModel getOfficeStorage() throws IOException {
        return officeFactory.getBettingOffice();
    }

    @GetMapping(value = "/index/same-matches")
    public List<List<MatchModel>> getSameMatches() throws IOException {
        return officeFactory.getSameMatches();
    }
}
