package Dao;

import Model.BettingOfficeEnum;

import java.util.List;

public interface MatchDao {
    List<Math> getAll(BettingOfficeEnum bettingOffice);
}
