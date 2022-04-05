package betsafe.model;

import java.util.ArrayList;
import java.util.List;

public class ProfitableMatchesModel {

    SameMatchesModel sameMatches;
    List<List<MatchModel>> profitableMatches = new ArrayList<>();


    public ProfitableMatchesModel() {
    }

    public void setSameMatches(SameMatchesModel sameMatches) {
        this.sameMatches = sameMatches;
    }

    public void checkProfitability () {
        List<MatchModel> listOfSameMatches = sameMatches.getSameMatches();
        while (listOfSameMatches.size() != 0) {
            List<MatchModel> profitableMatchPair = new ArrayList<>();
            MatchModel firstMatch = listOfSameMatches.get(0);
            for (MatchModel match : listOfSameMatches) {
                if (match != firstMatch) {
                    boolean profitability = this.checkIfProfitableMatchPair(firstMatch, match);
                    if (profitability) {
                        profitableMatchPair.add(firstMatch);
                        profitableMatchPair.add(match);
                        profitableMatches.add(profitableMatchPair);

                    }
                }
            }
            listOfSameMatches.remove(firstMatch);
        }
    }

    public boolean checkIfProfitableMatchPair(MatchModel firstMatch, MatchModel secondMatch){
        boolean firstCase = (secondMatch.getWinnerOdds() * firstMatch.getLoseOdds()) >= secondMatch.getWinnerOdds() + firstMatch.getLoseOdds();
        boolean secondCase = (secondMatch.getLoseOdds() * firstMatch.getWinnerOdds()) >= secondMatch.getLoseOdds() + firstMatch.getWinnerOdds();
        if( firstCase || secondCase ){
            return true;
        }
        else {
            return false;
        }
    }

    public List<List<MatchModel>> getProfitableMatches() {
        return profitableMatches;
    }
}
