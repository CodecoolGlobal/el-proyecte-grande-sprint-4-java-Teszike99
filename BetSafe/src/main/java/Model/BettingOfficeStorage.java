package Model;

import java.util.List;

public class BettingOfficeStorage {
    private List<BettingOffice> offices;

    public void addOffice(BettingOffice office){
        offices.add(office);
    }
}
