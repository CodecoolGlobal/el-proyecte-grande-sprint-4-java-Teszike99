package Model;

import java.time.LocalDate;

public class Match {
    private LocalDate matchDate;
    private String players;
    private double winnerOdds;
    private double loseOdds;
    private BettingOfficeEnum bettingOffice;

    public Match(LocalDate matchDate, String players, double winnerOdds, double loseOdds, BettingOfficeEnum bettingOffice) {
        this.matchDate = matchDate;
        this.players = players;
        this.winnerOdds = winnerOdds;
        this.loseOdds = loseOdds;
        this.bettingOffice = bettingOffice;
    }

    public LocalDate getMatchDate() {
        return matchDate;
    }

    public String getPlayers() {
        return players;
    }

    public double getWinnerOdds() {
        return winnerOdds;
    }

    public double getLoseOdds() {
        return loseOdds;
    }

    public BettingOfficeEnum getBettingOffice() {
        return bettingOffice;
    }
}
