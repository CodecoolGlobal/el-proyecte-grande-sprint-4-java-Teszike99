package betsafe.repository;

import betsafe.model.MatchModel;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MatchDaoCsvTest {

    @Test
    void convertFiles() throws IOException {
        MatchDaoCsv reader = new MatchDaoCsv();
        List<MatchModel> matches =  reader.convertFiles(new ArrayList<>(List.of("MegaGame.csv")));
        assertEquals(10, matches.size());
        assertEquals(1.55, matches.get(6).getHomeOdds());
    }
}
