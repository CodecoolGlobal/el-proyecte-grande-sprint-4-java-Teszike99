package betsafe.repository;

import betsafe.model.MatchModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatchDaoCsv {
    // Convert files into MatchModels array
    public List<MatchModel> convertFiles(List<String> files) throws IOException {
        List<MatchModel> matches = new ArrayList<>();
        String line = "";
        String mapping = "src/main/resources/csvData/";
        for (String path : files) {
            BufferedReader br = new BufferedReader(new java.io.FileReader(mapping + path));
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                MatchModel matchModel = new MatchModel(values[1], values[2] + " ," + values[3], values[4], values[5], values[0]);
                matches.add(matchModel);
            }
        }
        return matches;
    }
}
