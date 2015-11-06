package guildwars;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLContent {
	
	public static void main(String[] args) throws Exception {
		String webPage = "https://api.guildwars2.com/v2/commerce/listings/19684";
		URL url = new URL(webPage);
		URLConnection urlConnection = url.openConnection();
		InputStream is = urlConnection.getInputStream();
		try {
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");

			int numCharsRead;
			char[] content = new char[1024];
			StringBuffer sb = new StringBuffer();
			while ((numCharsRead = isr.read(content)) > 0) {
				sb.append(content, 0, numCharsRead);
			}
			String values = sb.toString();

			
			System.out.println(values);
			
		} finally {
			is.close();
		}
	}
}