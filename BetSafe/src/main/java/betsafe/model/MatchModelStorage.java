package betsafe.model;

import java.util.List;

public class MatchModelStorage {

    private final List<Match> storage;

    public MatchModelStorage(List<Match> matches) {
        this.storage = matches;
    }

    public List<Match> getStorage() {
        return storage;
    }

}
