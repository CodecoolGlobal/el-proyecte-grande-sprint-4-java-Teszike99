package betsafe.model;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class MatchModelMapping {

    public static Map<String, List<Match>> getSameMatches(List<Match> matches){
        return matches.stream()
                .collect(groupingBy(match -> match.getMatchDate() + match.getPlayers()));
    }

    public static List<List<Match>> getBestPairs(Map<String, List<Match>> sameMatches){

        List<List<Match>> bestOddsPairs = new ArrayList<>();
        for (List<Match> oneGroup : sameMatches.values()){
            List<Match> matchPairs = new ArrayList<>();
             Match bestHomeOdds = oneGroup.stream()
                     .max(Comparator.comparing(Match::getHomeOdds))
                     .orElseThrow(NoSuchElementException::new);
                    matchPairs.add(bestHomeOdds);
             Match bestGuestOdds = oneGroup.stream()
                     .max(Comparator.comparing(Match::getGuestOdds))
                     .orElseThrow(NoSuchElementException::new);
                    matchPairs.add(bestGuestOdds);
            bestOddsPairs.add(matchPairs);
        }
        return bestOddsPairs;
    }

    public static List<List<Match>> getFixMatches(Map<String, List<Match>> sameMatches){
        List<List<Match>> bestOddsPairs = new ArrayList<>();
        return null;
    }


}