package betsafe.repository;

import betsafe.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchRepository extends JpaRepository <Match, Long> {

    List<Match> findMatchesByBettingOffice(String office);

    List<Match> findMatchesBySportType(String sport);
}
