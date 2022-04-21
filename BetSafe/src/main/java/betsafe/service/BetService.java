package betsafe.service;

import betsafe.dto.BestMatchModelStorage;
import betsafe.dto.SameMatchesModelStorage;
import betsafe.model.MatchModelMapping;
import betsafe.model.MatchModelStorage;
import betsafe.repository.MatchDaoCsv;
import betsafe.model.BettingOfficeModel;
import betsafe.model.MatchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BetService {

    private final MatchDaoCsv matchDaoCsv;
    BetService(MatchDaoCsv matchDaoCsv){
        this.matchDaoCsv = matchDaoCsv;
    }

    public List<MatchModel> getMatches(List<String> offices) throws IOException {
        return matchDaoCsv.convertFiles(offices);
    }

    public BettingOfficeModel getBettingOffice(String office) throws IOException {
        List<MatchModel> matches = getMatches(new ArrayList<>(List.of(office)));
        return new BettingOfficeModel(matches.get(0).getBettingOffice(), matches);
    }

    public List<List<MatchModel>> getBestOddsPairs(List<String> offices) throws IOException {
        MatchModelStorage matches = new MatchModelStorage(getMatches(offices));
        Map<String, List<MatchModel>> sameMatches = MatchModelMapping.getSameMatches(matches.getStorage());
        return MatchModelMapping.getBestPairs(sameMatches);
    }
}

