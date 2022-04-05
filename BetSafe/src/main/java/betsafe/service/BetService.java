package betsafe.service;

import betsafe.dao.MatchDaoCsv;
import betsafe.model.BettingOfficeModel;
import betsafe.model.MatchModel;
import betsafe.model.SameMatchesModel;
import betsafe.model.ProfitableMatchesModel;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BetService {
    private final MatchDaoCsv matchDaoCsv = new MatchDaoCsv();
    private final ProfitableMatchesModel profitableMatches = new ProfitableMatchesModel();

    public List<MatchModel> getMatches(List<String> offices) throws IOException {
        return matchDaoCsv.convertFiles(offices);
    }

    public BettingOfficeModel getBettingOffice(String office) throws IOException {
        List<MatchModel> matches = getMatches(new ArrayList<>(List.of(office)));
        return new BettingOfficeModel(matches.get(0).getBettingOffice(), matches);
    }


    public List<SameMatchesModel> getSameMatches(List<String> offices) throws IOException {
        List<SameMatchesModel> sameMatchesList = new ArrayList<>();
        List<MatchModel> matches = getMatches(offices);
        while (matches.size() != 0) {
            SameMatchesModel sameMatches = new SameMatchesModel(matches.get(0));
            sameMatches.checkSameMatches(matches);
            sameMatchesList.add(sameMatches);
            if (sameMatches.getSameMatches().size() != 0) {
                for (MatchModel match : sameMatches.getSameMatches()) {
                    matches.remove(match);
                }
            }
        }
        return sameMatchesList;
    }


    public List<List<MatchModel>> getProfitableMatchPairs(List<String> offices) throws IOException {
        List<SameMatchesModel> sameMatchesList =  getSameMatches(offices);
        while (sameMatchesList.size() != 0){
            profitableMatches.setSameMatches(sameMatchesList.get(0));
            profitableMatches.checkProfitability();
            sameMatchesList.remove(sameMatchesList.get(0));
        }
        return profitableMatches.getProfitableMatches();
    }
}

