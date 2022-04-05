package betsafe;

import betsafe.model.BettingOfficeModel;
import betsafe.model.MatchModel;
import betsafe.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {
    private final BetService officeFactory;

    @Autowired
    public Controller(BetService officeFactory) {
        this.officeFactory = officeFactory;
    }

    @GetMapping(value = "/index/search_office")
    public BettingOfficeModel getOfficeStorage(@RequestParam String searchedOffice) throws IOException {
        return officeFactory.getBettingOffice(searchedOffice);
    }

    @GetMapping(value = "/index/profit-matches")
    public List<List<MatchModel>> getProfitableMatchPairs() throws IOException {
        return officeFactory.getProfitableMatchPairs(new ArrayList<>(List.of("BetterBet", "Esport", "MegaGame", "UniBet")));
    }
}
