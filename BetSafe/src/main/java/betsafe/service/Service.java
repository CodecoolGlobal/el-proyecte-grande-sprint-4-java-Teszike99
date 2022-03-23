package betsafe.service;

import betsafe.dao.MatchDaoCsv;
import betsafe.model.BettingOfficeModel;
import betsafe.model.MatchModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private MatchDaoCsv matchDaoCsv = new MatchDaoCsv();

    public BettingOfficeModel getBettingOffice() throws IOException {
        List<MatchModel> matches = matchDaoCsv.convertFile("MegaGame.csv");
        BettingOfficeModel office = new BettingOfficeModel(matches.get(0).getBettingOffice(), matches);
        return office;
    }

    //We can use later sport type argument
    public List<MatchModel> getSameMatches() throws IOException {
        List<MatchModel> matches = matchDaoCsv.convertFiles(new ArrayList<>(List.of("BetterBet.csv", "MegaGame.csv")));

        return null;
    }
}
