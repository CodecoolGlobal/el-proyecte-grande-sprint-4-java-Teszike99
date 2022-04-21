package betsafe.service;
/*
import betsafe.model.BettingOfficeModel;
import betsafe.model.MatchModel;
import betsafe.repository.MatchDaoCsv;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServiceTest {
    private BetService service;


    private MatchDaoCsv matchDaoCsv;

    @BeforeEach
    void setUp() {
        service = new BetService(matchDaoCsv);
    }

    @Test
    void getBettingOffice() throws IOException {
        when(matchDaoCsv.convertFiles(List.of("BetterBet.csv")))
                .thenReturn(List.of(new MatchModel("44", "33", "44.44", "11", "BetterBet")));
        BettingOfficeModel office = service.getBettingOffice("BetterBet.csv");
        assertEquals("BetterBet", office.getName());
        assertEquals(1, office.getMatches().size());
    }

    @Test
    void getProfitableMatchPairs() throws IOException {
        List<List<MatchModel>> profitable = service.getBestOddsPairs(new ArrayList<>(List.of("BetterBet.csv", "Esport.csv", "MegaGame.csv", "UniBet.csv")));
        assertEquals(2.83, profitable.get(0).get(0).getHomeOdds());
        assertEquals(1.73, profitable.get(0).get(1).getGuestOdds());
    }


}*/