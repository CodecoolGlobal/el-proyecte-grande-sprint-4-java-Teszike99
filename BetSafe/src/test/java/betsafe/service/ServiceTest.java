package betsafe.service;

import betsafe.model.BettingOfficeModel;
import betsafe.model.MatchModel;
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
        List<List<MatchModel>> profitable = service.getBestOddsPairs(new ArrayList<>(List.of("BetterBet.csv", "Esport.csv", "MegaGame.csv", "UniBet.csv")));
        assertEquals(3.4, profitable.get(0).get(0).getHomeOdds());
        assertEquals(2.45, profitable.get(0).get(1).getGuestOdds());
    }

}