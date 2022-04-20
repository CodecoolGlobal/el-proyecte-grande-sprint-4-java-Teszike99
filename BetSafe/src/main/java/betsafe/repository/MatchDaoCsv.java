package betsafe.repository;

import betsafe.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MatchDaoCsv {
    // Convert files into MatchModels array
    private MatchRepository matchRepository;
    @Autowired
    public MatchDaoCsv(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> convertFiles(List<String> files) throws IOException {
        List<Match> matches = new ArrayList<>();
        String line = "";
        String mapping = "src/main/resources/csvData/";
        for (String path : files) {
            BufferedReader br = new BufferedReader(new java.io.FileReader(mapping + path));
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Match matchModel = new Match(values[1], values[2] + " ," + values[3], values[4], values[5], values[0], values[6]);
                matches.add(matchModel);
                matchRepository.save(matchModel);
            }
        }
        return matches;
    }
}
