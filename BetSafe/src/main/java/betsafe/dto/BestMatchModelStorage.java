package betsafe.dto;

import betsafe.model.Match;

import java.util.List;

public class BestMatchModelStorage {

    private final List<List<Match>> bestOddsPairs;

    public BestMatchModelStorage(List<List<Match>> bestOddsPairs) {
        this.bestOddsPairs = bestOddsPairs;
    }

    public List<List<Match>> getBestOddsPairs() {
        return bestOddsPairs;
    }
}
