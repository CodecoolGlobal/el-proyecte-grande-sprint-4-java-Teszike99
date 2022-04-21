package betsafe.service;

import betsafe.dto.BestMatchModelStorage;
import betsafe.dto.SameMatchesModelStorage;
import betsafe.model.MatchModelMapping;
import betsafe.model.MatchModelStorage;
import betsafe.repository.MatchDaoCsv;
import betsafe.model.Match;
import betsafe.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BetService {
    private final MatchDaoCsv matchDaoCsv = new MatchDaoCsv();

    public BetService(MatchDaoCsv matchDaoCsv, MatchRepository matchRepository) {
        this.matchDaoCsv = matchDaoCsv;
        this.matchRepository = matchRepository;
    }

    public void createDbFromCSV(List<String> offices) throws IOException  {
        matchDaoCsv.convertFiles(offices);
    }

    public List<Match> getByBettingOffice(String office) {
        return matchRepository.findMatchesByBettingOffice(office);
    }

    public List<Match> getBySport(String searchedSport) {
        return matchRepository.findMatchesBySportType(searchedSport);
    }

    public List<List<Match>> getBestOddsPairs() {
        List<Match> allMatches = matchRepository.findAll();
        Map<String, List<Match>> sameMatches = MatchModelMapping.getSameMatches(allMatches);
        return MatchModelMapping.getBestPairs(sameMatches);
    }

}

