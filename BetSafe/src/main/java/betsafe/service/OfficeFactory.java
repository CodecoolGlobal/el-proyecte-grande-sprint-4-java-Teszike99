package betsafe.service;

import betsafe.dao.MatchDaoCsv;
import betsafe.model.BettingOfficeModel;
import betsafe.model.MatchModel;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class OfficeFactory {
    private MatchDaoCsv matchDaoCsv = new MatchDaoCsv();

    public BettingOfficeModel createBettingOffice() throws IOException {
        List<MatchModel> matches = matchDaoCsv.convert("MegaGame.csv");
        return null;
    }

    public MatchModel createMatches(){
        return null;
    }
}
