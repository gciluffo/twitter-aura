package ui.twitter;

import java.sql.PreparedStatement;
import java.util.Arrays;
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
    public static String getTweets() throws Exception {

        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:~/Twitter", "gciluffo", "Gooner55");
        ResultSet rs = conn.prepareStatement("SELECT * FROM TWEETS").executeQuery();

        // Just return the first entry from query
        String something = rs.getString(1);
        //return "Merp"
        conn.close();
   
        return something;
    }
}