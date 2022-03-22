package Dao;

import Model.BettingOffice;

import java.util.List;

public interface MatchDao {
    List<Math> getAll(BettingOffice bettingOffice);
}
