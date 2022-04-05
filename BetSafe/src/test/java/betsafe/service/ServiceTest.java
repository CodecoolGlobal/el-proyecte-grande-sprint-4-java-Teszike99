package betsafe.service;

import betsafe.model.BettingOfficeModel;
import betsafe.model.MatchModel;
import betsafe.model.ProfitableMatchesModel;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    BetService service = new BetService();

    @Test
    void getBettingOffice() throws IOException {
        BettingOfficeModel office = service.getBettingOffice("BetterBet.csv");
        assertEquals("BetterBet", office.getName());
        assertEquals(10, office.getMatches().size());
    }

    @Test
    void getProfitableMatchPairs() throws IOException {
        List<List<MatchModel>> profitable = service.getProfitableMatchPairs(new ArrayList<>(List.of("BetterBet.csv", "MegaGame.csv")));
        assertEquals("Abraham ,Mateus", profitable.get(0).get(0).getPlayers());
    }

    @Test
    void getSameMatches() {

    }


    @Test
    void checkIfProfitableMatchPair() {
        ProfitableMatchesModel profitCheck = new ProfitableMatchesModel();

        MatchModel matchModelOne = new MatchModel("match date", "players", "1.6", "5.5", "test office");
        MatchModel matchModelTwo = new MatchModel("match date", "players", "1.8", "5.1", "test office");

        Boolean profitability = profitCheck.checkIfProfitableMatchPair(matchModelOne, matchModelTwo);
        assertEquals(true, profitability);
    }
}