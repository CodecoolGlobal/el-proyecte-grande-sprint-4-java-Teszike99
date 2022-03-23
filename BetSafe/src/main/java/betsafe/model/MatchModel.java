package betsafe.model;

public class MatchModel {
    private String matchDate;
    private String players;
    private double winnerOdds;
    private double loseOdds;
    private String bettingOffice;

    public MatchModel(String matchDate, String players, String winnerOdds, String loseOdds) {
        this.matchDate = matchDate;
        this.players = players;
        this.winnerOdds = Double.parseDouble(winnerOdds);
        this.loseOdds = Double.parseDouble(loseOdds);
        this.bettingOffice = bettingOffice;
    }

    public String getMatchDate() {
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

    public String getBettingOffice() {
        return bettingOffice;
    }
}
