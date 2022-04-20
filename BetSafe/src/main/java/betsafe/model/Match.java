package betsafe.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matchDate;
    private String players;
    private double homeOdds;
    private double guestOdds;
    private String sportType;
    private String bettingOffice;

    public Match(String matchDate, String players, String homeOdds, String guestOdds, String bettingOffice, String sportType) {
        this.matchDate = matchDate;
        this.players = players;
        this.homeOdds = Double.parseDouble(homeOdds);
        this.guestOdds = Double.parseDouble(guestOdds);
        this.bettingOffice = bettingOffice;
        this.sportType = sportType;
    }

}
