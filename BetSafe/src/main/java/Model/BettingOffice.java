package Model;

import java.util.List;

public class BettingOffice {
    private String name;
    private List<Match> matches;

    BettingOffice(String name){
        this.name = name;
    }

    public void addMatch(Match match){
        matches.add(match);
    }
}
