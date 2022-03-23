package betsafe.dao;

import betsafe.model.MatchModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatchDaoCsv {

    public List<MatchModel> convert(String path) throws IOException {
        String line = "";
        List<MatchModel> matches = new ArrayList<>();
        BufferedReader br = new BufferedReader(new java.io.FileReader(path));
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            MatchModel matchModel = new MatchModel(values[1], values[2] + " ," + values[3], values[4], values[5]);
            matches.add(matchModel);
            System.out.println(matchModel);
        }
        System.out.println(matches);
        return matches;
    }
}
