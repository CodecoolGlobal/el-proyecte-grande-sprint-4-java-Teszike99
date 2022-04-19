package betsafe.model;

public class MatchModel {
    private final String matchDate;
    private final String players;
    private final double homeOdds;
    private final double guestOdds;
    private final String bettingOffice;

    public MatchModel(String matchDate, String players, String homeOdds, String guestOdds, String bettingOffice) {
        this.matchDate = matchDate;
        this.players = players;
        this.homeOdds = Double.parseDouble(homeOdds);
        this.guestOdds = Double.parseDouble(guestOdds);
        this.bettingOffice = bettingOffice;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public String getPlayers() {
        return players;
    }

    public double getHomeOdds() {
        return homeOdds;
    }

    public double getGuestOdds() {
        return guestOdds;
    }

    public String getBettingOffice() {
        return bettingOffice;
    }

}
