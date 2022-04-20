package betsafe;

import betsafe.model.BettingOfficeModel;
import betsafe.model.Match;
import betsafe.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<List<Match>> getProfitableMatchPairs() throws IOException {
        return officeFactory.getBestOddsPairs(new ArrayList<>(List.of("BetterBet.csv", "Esport.csv", "MegaGame.csv", "UniBet.csv")));
    }

    //for reading the CSV
    @PostMapping(value = "/in")
    public void createDb()  throws IOException {
        officeFactory.createDb(new ArrayList<>(List.of("BetterBet.csv", "Esport.csv", "MegaGame.csv", "UniBet.csv")));
    }
}
