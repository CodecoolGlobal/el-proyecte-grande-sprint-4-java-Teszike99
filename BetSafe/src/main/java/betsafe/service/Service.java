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

    public List<List<MatchModel>> getProfitableMatchPairs(){
        List<List<MatchModel>> profitableMatchPairs = new ArrayList<List<MatchModel>>();
        return null;
    }

    //We can use later sport type argument to filter same matches
    public List<List<MatchModel>> getSameMatches() throws IOException {
        List<List<MatchModel>> differentOfficesSameMatches = new ArrayList<List<MatchModel>>();
        List<MatchModel> matches = matchDaoCsv.convertFiles(new ArrayList<>(List.of("BetterBet.csv", "MegaGame.csv")));

        while(matches.size() != 0){
            List<MatchModel> sameMatches = new ArrayList<>();

            MatchModel firstMatch = matches.get(0);
            String firstMatchDate = firstMatch.getMatchDate();
            String firstMatchPlayers = firstMatch.getPlayers();

                for (MatchModel match : matches){
                    if (match != firstMatch){
                       if(match.getMatchDate().equals(firstMatchDate) && match.getPlayers().equals(firstMatchPlayers)){
                           sameMatches.add(match);
                           if(!sameMatches.contains(firstMatch)){
                               sameMatches.add(firstMatch);
                           }
                       }
                    }
                }

                if(sameMatches.size() != 0){
                    for(MatchModel match : sameMatches){
                        matches.remove(match);
                    }
                }
            differentOfficesSameMatches.add(sameMatches);
        }
        return differentOfficesSameMatches;
    }


}
