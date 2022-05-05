package betsafe.model;

import java.util.*;
import java.util.stream.Collectors;

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

    public static List<List<Match>> getFixMatches(List<List<Match>> allMatch){
        return allMatch.stream()
                .filter(matchPair -> chechkIfProfitableMatchPair(matchPair.get(0), matchPair.get(1)))
                .collect(Collectors.toList());
    }

    public static List<List<Match>> getBestMatchPairsByOffice(List<List<Match>> allMatch, String office){
        return allMatch.stream()
                .filter(matchPair -> checkIfOffice(matchPair, office))
                .collect(Collectors.toList());
    }

    private static boolean checkIfOffice(List<Match> matchPair, String office) {
        return matchPair.get(0).getBettingOffice().equals(office) || matchPair.get(1).getBettingOffice().equals(office);
    }

    public static boolean chechkIfProfitableMatchPair(Match firstMatch, Match secondMatch){
        boolean firstCase = (secondMatch.getHomeOdds() * firstMatch.getGuestOdds()) >= secondMatch.getHomeOdds() + firstMatch.getGuestOdds();
        boolean secondCase = (secondMatch.getGuestOdds() * firstMatch.getHomeOdds()) >= secondMatch.getGuestOdds() + firstMatch.getHomeOdds();
        if( firstCase || secondCase ){
            return true;
        }
        else {
            return false;
        }
    }


}