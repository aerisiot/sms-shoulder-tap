package com.aeris.piDay.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class ConnectionUtil {

	public static boolean getConnection() {
		// TODO Auto-generated method stub
		
		boolean connection = false;
		
		URL obj;
		try {
			obj = new URL("http://yahoo.com");
			URLConnection conn = obj.openConnection();
			conn.getContent();
			connection = true;
			return true;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

}
