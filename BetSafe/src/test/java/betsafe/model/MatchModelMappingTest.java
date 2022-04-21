package betsafe.model;

import betsafe.dto.BestMatchModelStorage;
import betsafe.dto.SameMatchesModelStorage;
import betsafe.service.BetService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*
class MatchModelMappingTest {

    static BetService service;
    static SameMatchesModelStorage sameMatches;
    static BestMatchModelStorage bestMatchOddsPairsStorage;

    @BeforeAll
    static void createSameMatchStorage() throws IOException {
        MatchModelStorage storage = new MatchModelStorage(service.getMatches
                (new ArrayList<>(List.of("BetterBet.csv", "Esport.csv", "MegaGame.csv", "UniBet.csv"))));
        sameMatches = new SameMatchesModelStorage
                (MatchModelMapping.getSameMatches(storage.getStorage()));
    }

    @BeforeAll
    static void getBestOddsPairs(){
        bestMatchOddsPairsStorage =  new BestMatchModelStorage
                (MatchModelMapping.getBestPairs(sameMatches.getSameMatches()));
    }

    @Test
    void testGetSameMatches_containsRightKey_givesBackRightMap()  {
        assertTrue(sameMatches.getSameMatches().containsKey("today 22:30Abraham ,Mateus"));
    }

    @Test
    void testGetSameMatches_containsFourSameMatches_givesBackRightMap(){
        assertEquals(4,sameMatches.getSameMatches().get("tomorrow 3:00Abelito ,Borser").size());
    }

    @Test
    void testGetSameMatches_tenTimeFourSameMatches_containTenList() {
        assertEquals(10,sameMatches.getSameMatches().size());
    }

    @Test
    void testGetBestPairs_containsTwoSameMatches_givesBackInPairs(){
        assertEquals(2, bestMatchOddsPairsStorage.getBestOddsPairs().get(0).size());
    }

    @Test
    void testGetBestPairs_containsTenMatchPairs_givesBackTenMatchPairs(){
        assertEquals(10, bestMatchOddsPairsStorage.getBestOddsPairs().size());
    }


    @Test
    void testGetBestPairs_highestOddsPairs_fillWithHighestOdds(){
        assertEquals(2.83, bestMatchOddsPairsStorage.getBestOddsPairs().get(0).get(0).getHomeOdds());
        assertEquals(1.73, bestMatchOddsPairsStorage.getBestOddsPairs().get(0).get(1).getGuestOdds());
    }

}

 */