package by.bsac.taxi.model.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionCreator {

    private static final Properties properties = new Properties();
    private static final String DATABASE_PROPERTIES = "db.properties";
    private static final String PROPERTY_URL = "db.url";
    private static final String PROPERTY_PASSWORD = "db.password";
    private static final String PROPERTY_USER = "db.user";
    private static final String PROPERTY_DRIVER = "db.driver";
    private static String DATABASE_URL;
    private static String DATABASE_PASSWORD;
    private static String DATABASE_USER;
    private static String DATABASE_DRIVER;

    static {
        try (InputStream inputStream = ConnectionCreator.class.getClassLoader().
                getResourceAsStream(DATABASE_PROPERTIES)) {

            properties.load(inputStream);

            DATABASE_URL = properties.getProperty(PROPERTY_URL);
            DATABASE_PASSWORD = properties.getProperty(PROPERTY_PASSWORD);
            DATABASE_USER = properties.getProperty(PROPERTY_USER);
            DATABASE_DRIVER = properties.getProperty(PROPERTY_DRIVER);
            Class.forName(DATABASE_DRIVER);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private ConnectionCreator(){}

    public static Connection getInstance() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
    }
}
