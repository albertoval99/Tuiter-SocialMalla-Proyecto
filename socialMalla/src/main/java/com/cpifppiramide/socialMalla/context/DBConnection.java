package com.cpifppiramide.socialMalla.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    private DBConnection(){
    }

    public static Connection getInstance() {
        if(connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://database-proyecto.cqlixsr06r5b.us-east-1.rds.amazonaws.com:3306/SocialMalla", "admin", "malladeta99");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return DBConnection.connection;
    }

}
