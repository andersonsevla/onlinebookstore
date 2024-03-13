package com.brascode.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.brascode.constant.ResponseCode;
import com.brascode.model.StoreException;

public class DBUtil {

    private static Connection connection;

    static {

        try {

            Class.forName(DatabaseConfig.DRIVER_NAME);
            
            connection = DriverManager.getConnection(DatabaseConfig.CONNECTION_STRING, DatabaseConfig.DB_USER_NAME,
                    DatabaseConfig.DB_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {

            e.printStackTrace();

        }

    }// End of static block

    public static Connection getConnection() throws StoreException {

        if (connection == null) {
            throw new StoreException(ResponseCode.DATABASE_CONNECTION_FAILURE);
        }

        return connection;
    }

}
