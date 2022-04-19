package betsafe.model;

import java.util.ArrayList;
import java.util.List;

public class MatchModelStorage {

    private final List<MatchModel> storage;

    public MatchModelStorage(List<MatchModel> matches) {
        this.storage = matches;
    }

    public List<MatchModel> getStorage() {
        return storage;
    }

}
