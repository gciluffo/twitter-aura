package ui.twitter;

import org.auraframework.system.Annotations.Controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.auraframework.system.Annotations.AuraEnabled;
import org.auraframework.system.Annotations.Key;

import java.sql.ResultSet;
import java.sql.Statement;

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
    public static String getTweets() {
        
        try {
            
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:~/Twitter", "gciluffo", "Gooner55");
            Statement stat = conn.createStatement();
            ResultSet rs;
            rs = stat.executeQuery("SELECT * FROM TWEETS");
            stat.close();
            conn.close();

            //return rs.getString(1);
            return "Merp";
        } 
        catch (Exception e) {
            
        }
        
        return "Dummy";
    }

}