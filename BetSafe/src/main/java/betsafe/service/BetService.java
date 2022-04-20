package betsafe.service;

import betsafe.model.MatchModelMapping;
import betsafe.model.MatchModelStorage;
import betsafe.repository.MatchDaoCsv;
import betsafe.model.BettingOfficeModel;
import betsafe.model.Match;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BetService {
    private final MatchDaoCsv matchDaoCsv;

    public BetService(MatchDaoCsv matchDaoCsv) {
        this.matchDaoCsv = matchDaoCsv;
    }

    public List<Match> getMatches(List<String> offices) throws IOException {
        return matchDaoCsv.convertFiles(offices);
    }

    public BettingOfficeModel getBettingOffice(String office) throws IOException {
        List<Match> matches = getMatches(new ArrayList<>(List.of(office)));
        return new BettingOfficeModel(matches.get(0).getBettingOffice(), matches);
    }

    public List<List<Match>> getBestOddsPairs(List<String> offices) throws IOException {
        MatchModelStorage matches = new MatchModelStorage(getMatches(offices));
        Map<String, List<Match>> sameMatches = MatchModelMapping.getSameMatches(matches.getStorage());
        return MatchModelMapping.getBestPairs(sameMatches);
    }

    public void createDb(List<String> offices) throws IOException  {
        matchDaoCsv.convertFiles(offices);
    }
}

