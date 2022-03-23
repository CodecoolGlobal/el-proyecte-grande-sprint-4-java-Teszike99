package Service;

import CsvDao.FileReader;
import Model.BettingOfficeModel;
import Model.MatchModel;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class OfficeFactory {
    private FileReader fileReader = new FileReader();

    public BettingOfficeModel createBettingOffice() throws IOException {
        List<MatchModel> matches = fileReader.convert("MegaGame.csv");
        return null;
    }

    public MatchModel createMatches(){
        return null;
    }
}
