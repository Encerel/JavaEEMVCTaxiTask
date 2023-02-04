package by.bsac.taxi.model.service;

import by.bsac.taxi.entity.Taxi;

import java.util.List;
import java.util.Map;

public interface TaxiService {

    List<Taxi> sortByFuelConsumption();
    double calculateCostTaxis();
    boolean addTaxi(Map<String, String> taxiData);
    boolean changeTaxiInfo(Taxi taxi, Map<String, String> taxiData);

    List<Taxi> findAll();
}
