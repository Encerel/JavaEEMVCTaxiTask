package by.bsac.taxi.entity;

import java.util.Objects;

public class Taxi {

    private long taxiId;
    private String model;
    private int speed;
    private double fuelConsumption;
    private double price;

    private Taxi() {}

    public long getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(long taxiId) {
        this.taxiId = taxiId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Taxi taxi = (Taxi) o;
        return taxiId == taxi.taxiId && speed == taxi.speed && Double.compare(taxi.fuelConsumption, fuelConsumption) == 0 && Double.compare(taxi.price, price) == 0 && Objects.equals(model, taxi.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taxiId, model, speed, fuelConsumption, price);
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "taxiId=" + taxiId +
                ", model='" + model + '\'' +
                ", speed=" + speed +
                ", fuelConsumption=" + fuelConsumption +
                ", price=" + price +
                '}';
    }

    public static class Builder {
        private Taxi newTaxi;

        public Builder() {
            newTaxi = new Taxi();
        }

        public Builder setId(long id) {
            newTaxi.taxiId = id;
            return this;
        }

        public Builder setModel(String model) {
            newTaxi.model = model;
            return this;
        }

        public Builder setSpeed(int speed) {
            newTaxi.speed = speed;
            return this;
        }

        public Builder setFuelConsumption(double fuelConsumption) {
            newTaxi.fuelConsumption = fuelConsumption;
            return this;
        }

        public Builder setPrice(double price) {
            newTaxi.price = price;
            return this;
        }

        public Taxi build() {
            return newTaxi;
        }
    }

}
