package by.bsac.taxi.model.dao.impl;

import by.bsac.taxi.entity.Taxi;
import by.bsac.taxi.model.connection.ConnectionCreator;
import by.bsac.taxi.model.dao.TaxiDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static by.bsac.taxi.model.dao.ColumnName.*;

public class TaxiDaoImpl implements TaxiDao {

    private static final String SQL_FIND_ALL_TAXIS = "SELECT * FROM taxi";
    private static final String SQL_ADD_TAXI = "INSERT INTO taxi(model, speed, fuel_consumption,price) VALUES(?, ?, ?, ?)";
    private static final String SQL_CHANGE_TAXI_INFO = "UPDATE taxi SET model=?, speed=? , fuel_consumption=?, price=? WHERE taxi_id=?";


    @Override
    public List<Taxi> findAll() {
        List<Taxi> taxis = new ArrayList<>();

        try (Connection connection = ConnectionCreator.getInstance()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL_TAXIS);
            while (resultSet.next()) {
                taxis.add(buildTaxi(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taxis;
    }

    @Override
    public boolean addTaxi(Taxi taxi) {

        boolean isAdded = false;

        try (Connection connection = ConnectionCreator.getInstance()) {
            PreparedStatement statement = connection.prepareStatement(SQL_ADD_TAXI);
            statement.setString(1, taxi.getModel());
            statement.setInt(2, taxi.getSpeed());
            statement.setDouble(3, taxi.getFuelConsumption());
            statement.setDouble(4, taxi.getPrice());
            int countRow = statement.executeUpdate();
            if (countRow != 0) {
                isAdded = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
    }

    @Override
    public boolean changeTaxiInfo(Taxi taxi) {
        boolean isChanged = false;

        try (Connection connection = ConnectionCreator.getInstance()) {
            PreparedStatement statement = connection.prepareStatement(SQL_CHANGE_TAXI_INFO);
            statement.setString(1, taxi.getModel());
            statement.setInt(2, taxi.getSpeed());
            statement.setDouble(3, taxi.getFuelConsumption());
            statement.setDouble(4, taxi.getPrice());
            statement.setLong(5, taxi.getTaxiId());
            int rowCount = statement.executeUpdate();

            if (rowCount != 0) {
                isChanged = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isChanged;
    }

    private Taxi buildTaxi(ResultSet resultSet) throws SQLException {
        long taxiId = resultSet.getLong(ID_TAXI);
        String model = resultSet.getString(TAXI_MODEL);
        int speed = resultSet.getInt(TAXI_SPEED);
        double fuelConsumption = resultSet.getDouble(FUEL_CONSUMPTION);
        double price = resultSet.getDouble(TAXI_PRICE);
        Taxi taxi = new Taxi.Builder()
                .setId(taxiId)
                .setModel(model)
                .setFuelConsumption(fuelConsumption)
                .setPrice(price)
                .setSpeed(speed)
                .build();
        return taxi;
    }
}
