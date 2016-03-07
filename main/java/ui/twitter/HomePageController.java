package ui.twitter;

import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.auraframework.system.Annotations.AuraEnabled;
import org.auraframework.system.Annotations.Controller;
import org.auraframework.system.Annotations.Key;

@Controller
public class HomePageController {

    // Ping the server
    @AuraEnabled
    public static String getAppName(@Key("appKey") String importantInfo) {
        
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:~/Twitter", "gciluffo", "Gooner55");
            System.out.println(conn.getSchema());
            conn.close();
        } catch (Exception e) {
            
        }
         throw new NullPointerException();
    }

    // Get all tweets from the database
    @AuraEnabled
    public static ArrayList<Tweet> getAllTweets() throws Exception {

        ArrayList<Tweet> returnedStuff = new ArrayList<Tweet>();
        try {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:~/Twitter", "gciluffo", "Gooner55");

        ResultSet rs = conn.prepareStatement("SELECT * FROM TWEETS").executeQuery();


        while (rs.next()) {
            // Get each column and put them into new objects into the list
            returnedStuff.add(new Tweet(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        }
        //return "Merp"
        conn.close();
        
        return returnedStuff;
       }
       catch(Exception e) {
        return returnedStuff;
       }
  }


    // Add a tweet to the database
    @AuraEnabled
    public static void insertTweet(@Key("message") String message,
                                  @Key("date") String date,
                                  @Key("username") String username,
                                  @Key("imgPath") String imgPath) throws Exception {

        
        try {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:~/Twitter", "gciluffo", "Gooner55");

        String insert = "insert into tweets values('" + username + "', '" + message + "', '" + date + "', '" + imgPath + "')";
        boolean insertResult = conn.prepareStatement(insert).execute();

        conn.close();
        
       }
       catch(Exception e) {
        
       }
  }
}