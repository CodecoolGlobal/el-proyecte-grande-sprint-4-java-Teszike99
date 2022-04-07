package betsafe.dto;

import betsafe.model.MatchModel;

import java.util.List;
import java.util.Map;

public class SameMatchesModelStorage {

    private final Map<String, List<MatchModel>> sameMatches;

    public SameMatchesModelStorage(Map<String, List<MatchModel>> sameMatches) {
        this.sameMatches = sameMatches;
    }

    public Map<String, List<MatchModel>> getSameMatches() {
        return sameMatches;
    }
}
