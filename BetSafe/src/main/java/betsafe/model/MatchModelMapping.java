package betsafe.model;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class MatchModelMapping {

    public static Map<String, List<MatchModel>> getSameMatches(List<MatchModel> matches){
        return matches.stream()
                .collect(groupingBy(match -> match.getMatchDate() + match.getPlayers()));
    }

    public static List<List<MatchModel>> getBestPairs(Map<String, List<MatchModel>> sameMatches){
        List<List<MatchModel>> bestOddsPairs = new ArrayList<>();
        for (List<MatchModel> oneGroup : sameMatches.values()){
            List<MatchModel> matchPairs = new ArrayList<>();
             MatchModel bestHomeOdds = oneGroup.stream()
                     .max(Comparator.comparing(MatchModel::getHomeOdds))
                     .orElseThrow(NoSuchElementException::new);
                    matchPairs.add(bestHomeOdds);
             MatchModel bestGuestOdds = oneGroup.stream()
                     .max(Comparator.comparing(MatchModel::getGuestOdds))
                     .orElseThrow(NoSuchElementException::new);
                    matchPairs.add(bestGuestOdds);
            bestOddsPairs.add(matchPairs);
        }
        return bestOddsPairs;
    }
}
