package betsafe.repository;

import betsafe.model.BettingOfficeEnum;

import java.util.List;

public interface MatchDao {
    List<Math> getAll(BettingOfficeEnum bettingOffice);
}
