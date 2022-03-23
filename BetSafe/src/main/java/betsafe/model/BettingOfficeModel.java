package betsafe.model;

import java.util.List;

public class BettingOfficeModel {
    private String name;
    private List<MatchModel> matches;

    BettingOfficeModel(String name){
        this.name = name;
    }

    public void addMatch(MatchModel match){
        matches.add(match);
    }
}
