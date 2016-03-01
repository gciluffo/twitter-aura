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

    @AuraEnabled
    public static ArrayList<Tweet> getTweets() throws Exception {

        ArrayList<Tweet> returnedStuff = new ArrayList<Tweet>();
        try {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:~/Twitter", "gciluffo", "Gooner55");
        boolean dropResult = conn.prepareStatement("DROP TABLE IF EXISTS TWEETS").execute();
        boolean createResult = conn.prepareStatement("CREATE TABLE TWEETS (ID INT PRIMARY KEY, NAME VARCHAR(255) )").execute();
        boolean insertResult = conn.prepareStatement("INSERT INTO TWEETS VALUES (1, 'A tweet from the database')").execute();

        ResultSet rs = conn.prepareStatement("SELECT * FROM TWEETS").executeQuery();

        while (rs.next()) {
            // Get each column and put them into new objects into the list
            returnedStuff.add(new Tweet(rs.getString(1), rs.getString(2), "Image", "Today"));
        }
        //return "Merp"
        conn.close();
        
        return returnedStuff;
       }
       catch(Exception e) {
        return returnedStuff;
       }
  }
}