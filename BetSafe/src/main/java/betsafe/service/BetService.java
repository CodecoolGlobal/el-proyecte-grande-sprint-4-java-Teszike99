package betsafe.service;

import betsafe.dto.BestMatchModelStorage;
import betsafe.dto.SameMatchesModelStorage;
import betsafe.model.BettingOffice;
import betsafe.model.Match;
import betsafe.model.MatchModelMapping;
import betsafe.repository.BettingOfficeRepository;
import betsafe.repository.MatchDaoCsv;
import betsafe.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BetService {

    private final MatchDaoCsv matchDaoCsv;
    private MatchRepository matchRepository;
    private BettingOfficeRepository bettingOfficeRepository;

    public BetService(MatchDaoCsv matchDaoCsv,
                      MatchRepository matchRepository,
                      BettingOfficeRepository bettingOfficeRepository) {
        this.matchDaoCsv = matchDaoCsv;
        this.matchRepository = matchRepository;
        this.bettingOfficeRepository = bettingOfficeRepository;
    }

    public void createDbFromCSV(List<String> offices) throws IOException  {
        matchDaoCsv.convertFiles(offices);
    }

    public List<List<Match>> getByBettingOffice(String office) {
        List<List<Match>> allMatches = this.getBestOddsPairs();
        return MatchModelMapping.getBestMatchPairsByOffice(allMatches, office);
    }

    public List<List<Match>> getBySport(String searchedSport) {
        List<Match> allMatches = matchRepository.findMatchesBySportType(searchedSport);
        Map<String, List<Match>> sameMatches = MatchModelMapping.getSameMatches(allMatches);
        return MatchModelMapping.getBestPairs(sameMatches);
    }

    public List<List<Match>> getBestOddsPairs() {
        List<Match> allMatches = matchRepository.findAll();
        Map<String, List<Match>> sameMatches = MatchModelMapping.getSameMatches(allMatches);
        return MatchModelMapping.getBestPairs(sameMatches);
    }

    public List<List<Match>> getFixMatches() {
        List<List<Match>> allMatches = this.getBestOddsPairs();
        return MatchModelMapping.getFixMatches(allMatches);
    }

    public List<BettingOffice> getAllOffice() {
        return bettingOfficeRepository.findAll();
    }
}

