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
    private String bettingOffice;
    private String matchDate;
    private String homePlayer;
    private String guestPlayer;
    private double homeOdds;
    private double guestOdds;
    private String sportCategory;
}
