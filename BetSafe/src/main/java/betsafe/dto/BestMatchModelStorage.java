package betsafe.dto;

import betsafe.model.MatchModel;

import java.util.List;

public class BestMatchModelStorage {

    private final List<List<MatchModel>> bestOddsPairs;

    public BestMatchModelStorage(List<List<MatchModel>> bestOddsPairs) {
        this.bestOddsPairs = bestOddsPairs;
    }

    public List<List<MatchModel>> getBestOddsPairs() {
        return bestOddsPairs;
    }
}
