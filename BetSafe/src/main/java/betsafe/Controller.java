package betsafe;

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

    private final BetService betService;

    @Autowired
    public Controller(BetService betService) {
        this.betService = betService;
    }

    @GetMapping("/search-office/{office}")
    public List<Match> getOfficeStorage(@PathVariable("office") String searchedOffice){
        return betService.getByBettingOffice(searchedOffice);
    }

    @GetMapping("match-pairs")
    public List<List<Match>> getProfitableMatchPairs(){
        System.out.println(betService.getBestOddsPairs());
        return betService.getBestOddsPairs();
    }

    @GetMapping("search-sport/{sport}")
    public List<List<Match>> getMatchesBySport(@PathVariable("sport") String searchedSport){
        return betService.getBySport(searchedSport);
    }

    //for reading the CSV
    @PostMapping(value = "/in")
    public void createDb()  throws IOException {
        betService.createDbFromCSV(new ArrayList<>(List.of("BetterBet.csv", "Esport.csv", "MegaGame.csv", "UniBet.csv")));
    }
}
