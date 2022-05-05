package betsafe.service;

import betsafe.model.Match;
import betsafe.repository.MatchDaoCsv;
import betsafe.repository.MatchRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class BetServiceTest {

    private List<Match> matches = new ArrayList<>();
    private List<Match> bestMatchPair1 = new ArrayList<>();
    private List<Match> bestMatchPair2 = new ArrayList<>();
    private List<List<Match>> bestMatchPairs = new ArrayList<>();
    private List<Match> pingpong = new ArrayList<>();
    private List<Match> betmen = new ArrayList<>();



    @Autowired
    private BetService betService;

    @MockBean
    private MatchRepository matchRepository;

    @BeforeEach
    public void setUp() {
        Match match = Match.builder()
                        .matchDate("today 12:30")
                        .players("Dani, Janó")
                        .guestOdds(2.3)
                        .homeOdds(2.1)
                        .bettingOffice("Betmen")
                        .sportType("tennis")
                        .build();
        matches.add(match);
        betmen.add(match);
        Match match1 = Match.builder()
                            .matchDate("today 12:30")
                            .players("Dani, Janó")
                            .guestOdds(2.2)
                            .homeOdds(2.2)
                            .bettingOffice("Bwin")
                            .sportType("tennis")
                            .build();
        matches.add(match1);
        bestMatchPair1.add(match1);
        Match match2 = Match.builder()
                            .matchDate("today 12:30")
                            .players("Dani, Janó")
                            .guestOdds(2.4)
                            .homeOdds(1.9)
                            .bettingOffice("BetterBet")
                            .sportType("tennis")
                            .build();
        matches.add(match2);
        bestMatchPair1.add(match2);

        Match match3 = Match.builder()
                .matchDate("today 13:30")
                .players("Akos, Rolad")
                .guestOdds(1.2)
                .homeOdds(3.1)
                .bettingOffice("Bwin")
                .sportType("pingpong")
                .build();
        matches.add(match3);
        bestMatchPair2.add(match3);
        pingpong.add(match3);

        Match match4 = Match.builder()
                .matchDate("today 13:30")
                .players("Akos, Rolad")
                .guestOdds(1.3)
                .homeOdds(2.8)
                .bettingOffice("Betmen")
                .sportType("pingpong")
                .build();
        matches.add(match4);
        bestMatchPair2.add(match4);
        pingpong.add(match4);
        betmen.add(match4);

        Match match5 = Match.builder()
                .matchDate("today 13:30")
                .players("Akos, Rolad")
                .guestOdds(1.24)
                .homeOdds(2.94)
                .bettingOffice("BetterBet")
                .sportType("pingpong")
                .build();
        matches.add(match5);
        pingpong.add(match5);
        bestMatchPairs.add(bestMatchPair1);
        bestMatchPairs.add(bestMatchPair2);
    }


    @Test
    public void getBestOddsPair_GivesBackTwoMatchWithTheHighestOdds(){
        when(matchRepository.findAll()).thenReturn(matches);
        assertEquals(bestMatchPairs, betService.getBestOddsPairs());
    }

    @Test
    public void getMatchBySport_giveBackPingPongMatches(){
        when(matchRepository.findMatchesBySportType("pingpong")).thenReturn(pingpong);
        assertEquals(pingpong, betService.getBySport("pingpong"));
    }


}