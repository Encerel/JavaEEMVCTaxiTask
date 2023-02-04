package by.bsac.taxi.validator;

import java.util.regex.Pattern;

public class TaxiValidator {

    private static final String MODEL_PATTER = "([A-Za-z]+[\\d]+[\\w]*|[\\d]+[A-Za-z]+[\\w]*)";


    public static boolean isValidModel(String model) {
        return Pattern.matches(MODEL_PATTER, model);
    }

    public static boolean isValidSpeed(int speed) {
        return speed > 0;
    }

    public static boolean isValidPrice(double price) {
        return price > 0;
    }

    public static boolean isValidFuelConsumption(double fuelConsumption) {
        return fuelConsumption > 0;
    }

}
