package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {
    private Connection dbConnection;

    public Connection getDbConnection() throws  ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName+"?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }
    public void saveRecords(ListOfRecords records){
        String insert = "INSERT INTO " + "records" + "(" +"countDocs"+","+"countDocsFound"+
                ","+"countRelevantDocs"+","+"countRelevantDocsFound"+")"+
                "VALUES(?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1,String.valueOf(records.getCountDocs()));
            prSt.setString(2,String.valueOf(records.getCountDocsFound()));
            prSt.setString(3,String.valueOf(records.getCountRelevantDocs()));
            prSt.setString(4,String.valueOf(records.getCountRelevantDocsFound()));
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
