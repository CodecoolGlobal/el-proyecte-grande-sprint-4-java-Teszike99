package betsafe.model;

import java.util.List;

public class BettingOfficeModel {
    private final String name;
    private final List<MatchModel> matches;

    public BettingOfficeModel(String name, List<MatchModel> matches){
        this.name = name;
        this.matches = matches;
    }

    public String getName() {
        return name;
    }

    public List<MatchModel> getMatches() {
        return matches;
    }
}
