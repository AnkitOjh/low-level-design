package Appender;

import LogMessager.LogMessage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseAppender implements LogAppender{
    private final String jdbc_password;
    private final String DB_Url;
    private final String DB_username;
    public DatabaseAppender(String password, String username, String url){
        this.jdbc_password = password;
        this.DB_Url = url;
        this.DB_username = username;
    }

    @Override
    public void logMessage(LogMessage message) {
        System.out.println("Database log");
        String insertQuery = "Insert into log (level,createdDate,message) values (?,?,?)";
        //try with resource
        try(Connection conn = DriverManager.getConnection(DB_Url,DB_username,jdbc_password) ){
            PreparedStatement pr = conn.prepareStatement(insertQuery);
            pr.setString(1,message.getLevel().toString());
            pr.setString(2,message.getTimeStamp().toString());
            pr.setString(3,message.getMessage().toString());
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
