package betsafe;

import betsafe.model.BettingOffice;
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
    public List<Match> getMatchesByOffice(@PathVariable("office") String searchedOffice){
        return betService.getByBettingOffice(searchedOffice);
    }

    @GetMapping("match-pairs")
    public List<List<Match>> getProfitableMatchPairs(){
        return betService.getBestOddsPairs();
    }

    @GetMapping("offices")
    public List<BettingOffice> getAllOffices(){
        return betService.getAllOffice();
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

    @GetMapping("fix-match-pairs")
    public List<List<Match>> getFixMatches(){
        return betService.getFixMatches();
    }
}
