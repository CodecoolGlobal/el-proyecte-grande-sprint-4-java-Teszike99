package betsafe.dto;

import betsafe.model.Match;

import java.util.List;
import java.util.Map;

public class SameMatchesModelStorage {

    private final Map<String, List<Match>> sameMatches;

    public SameMatchesModelStorage(Map<String, List<Match>> sameMatches) {
        this.sameMatches = sameMatches;
    }

    public Map<String, List<Match>> getSameMatches() {
        return sameMatches;
    }
}
