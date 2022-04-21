package betsafe.service;

import betsafe.model.Match;
import betsafe.repository.MatchRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;


@SpringBootTest
class ServiceTest {

    @Autowired
    private MatchRepository matchRepository;

    @Test
    void getAllMatchesFromSql(){
        List<Match> matches = matchRepository.findAll();
        assertEquals(40, matches.size());

   }

//    @Test
//    void getProfitableMatchPairs() throws IOException {
//        List<List<MatchModel>> profitable = service.getBestOddsPairs(new ArrayList<>(List.of("BetterBet.csv", "Esport.csv", "MegaGame.csv", "UniBet.csv")));
//        assertEquals(2.83, profitable.get(0).get(0).getHomeOdds());
//        assertEquals(1.73, profitable.get(0).get(1).getGuestOdds());
//    }


}