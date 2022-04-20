package betsafe.model;

import java.util.List;

public class BettingOfficeModel {
    private final String name;
    private final List<Match> matches;

    public BettingOfficeModel(String name, List<Match> matches){
        this.name = name;
        this.matches = matches;
    }

    public String getName() {
        return name;
    }

    public List<Match> getMatches() {
        return matches;
    }
}
