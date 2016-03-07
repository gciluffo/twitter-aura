package ui.twitter;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;

import org.auraframework.util.json.Json;
import org.auraframework.util.json.JsonSerializable;

public class Tweet implements JsonSerializable {
	public String message;
	public String username;
	public String imgPath;
	public String date;
	
	Tweet(String username, String message, String date, String imgPath) {
		this.message = message;
		this.username = username;
		this.imgPath = imgPath;
		this.date = date;
	}

	@Override
	public void serialize(Json arg0) throws IOException {
		arg0.writeMapBegin();
		arg0.writeMapEntry("username", username);
		arg0.writeMapEntry("message", message);
		arg0.writeMapEntry("imgPath", imgPath);
		arg0.writeMapEntry("date", date);
		arg0.writeMapEnd();
	}
	
	@Override
	public String toString() {
		return "username=" + username + ", message=" + message + ", imgPath=" + imgPath + ", date= " + date;
	}
}