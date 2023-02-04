package by.bsac.taxi.model.service.impl;

import by.bsac.taxi.command.ParametersAndAttribute;
import by.bsac.taxi.entity.Taxi;
import by.bsac.taxi.model.dao.TaxiDao;
import by.bsac.taxi.model.service.TaxiService;
import by.bsac.taxi.validator.TaxiValidator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaxiServiceImpl implements TaxiService {

    private TaxiDao taxiDao;

    public TaxiServiceImpl(TaxiDao taxiDao) {
        this.taxiDao = taxiDao;
    }


    @Override
    public List<Taxi> sortByFuelConsumption() {
        List<Taxi> sortedTaxiList = taxiDao.findAll().stream()
                .sorted(Comparator.comparingDouble(Taxi::getFuelConsumption))
                .collect(Collectors.toList());
        return sortedTaxiList;
    }

    @Override
    public double calculateCostTaxis() {
        List<Taxi> taxis = taxiDao.findAll();
        double costTaxis = 0;

        for (Taxi taxi : taxis) {
            costTaxis += taxi.getPrice();
        }

        return costTaxis;
    }

    @Override
    public boolean addTaxi(Map<String, String> taxiData) {

        boolean isAdded = false;

        String model = taxiData.get(ParametersAndAttribute.TAXI_MODEL);
        double price = Double.parseDouble(taxiData.get(ParametersAndAttribute.TAXI_PRICE));
        double fuelConsumption = Double.parseDouble(taxiData.get(ParametersAndAttribute.FUEL_CONSUMPTION));
        int speed = Integer.parseInt(taxiData.get(ParametersAndAttribute.TAXI_SPEED));

        if (TaxiValidator.isValidModel(model)
            && TaxiValidator.isValidPrice(price)
            && TaxiValidator.isValidSpeed(speed)
            && TaxiValidator.isValidFuelConsumption(fuelConsumption)) {

            Taxi taxi = new Taxi.Builder()
                    .setModel(model)
                    .setSpeed(speed)
                    .setFuelConsumption(fuelConsumption)
                    .setPrice(price)
                    .build();

            isAdded = taxiDao.addTaxi(taxi);
        }

        return isAdded;
    }

    @Override
    public boolean changeTaxiInfo(Taxi taxi, Map<String, String> taxiData) {

        boolean isChanged = false;

        String model = taxiData.get(ParametersAndAttribute.TAXI_MODEL);
        double price = Double.parseDouble(taxiData.get(ParametersAndAttribute.TAXI_PRICE));
        double fuelConsumption = Double.parseDouble(taxiData.get(ParametersAndAttribute.FUEL_CONSUMPTION));
        int speed = Integer.parseInt(taxiData.get(ParametersAndAttribute.TAXI_SPEED));

        if (TaxiValidator.isValidModel(model)
                && TaxiValidator.isValidPrice(price)
                && TaxiValidator.isValidSpeed(speed)
                && TaxiValidator.isValidFuelConsumption(fuelConsumption)) {

            taxi.setModel(model);
            taxi.setFuelConsumption(fuelConsumption);
            taxi.setPrice(price);
            taxi.setSpeed(speed);

            isChanged = taxiDao.addTaxi(taxi);
        }

        return isChanged;
    }

    @Override
    public List<Taxi> findAll() {
        return taxiDao.findAll();
    }
}
