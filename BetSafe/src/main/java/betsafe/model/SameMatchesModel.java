package betsafe.model;

import betsafe.model.MatchModel;

import java.util.ArrayList;
import java.util.List;

public class SameMatchesModel {

    MatchModel firstMatch;
    String MatchDate;
    String MatchPlayers;
    List<MatchModel> sameMatches = new ArrayList<>();

    public SameMatchesModel(MatchModel firstMatch) {
        this.firstMatch = firstMatch;
        this.MatchDate = firstMatch.getMatchDate();
        this.MatchPlayers = firstMatch.getPlayers();
    }

    public void checkSameMatches(List<MatchModel> matches) {
        for (MatchModel match : matches) {
            if (match != this.firstMatch) {
                if (match.getMatchDate().equals(MatchDate) && match.getPlayers().equals(MatchPlayers)) {
                    sameMatches.add(match);
                    if (!sameMatches.contains(firstMatch)) {
                        sameMatches.add(firstMatch);
                    }
                }
            }
        }
    }

    public List<MatchModel> getSameMatches() {
        return sameMatches;
    }
}
