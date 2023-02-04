package by.bsac.taxi.model.dao;

import by.bsac.taxi.entity.Taxi;

import java.util.List;

public interface TaxiDao {

    List<Taxi> findAll();

    boolean addTaxi(Taxi taxi);

    boolean changeTaxiInfo(Taxi taxi);


}
