package guildwars;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlContent {
	
	
	// opens Connection on server in the background, reads data from web page
	// into a StringBuffer and closes connection
	public static String loadUrl(String url) throws Exception {
		URL urlObj = new URL(url);
		URLConnection urlConnection = urlObj.openConnection();
		InputStream is = urlConnection.getInputStream();
		try {
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			int numCharsRead;
			char[] content = new char[1024];
			StringBuffer sb = new StringBuffer();
			while ((numCharsRead = isr.read(content)) > 0) {
				sb.append(content, 0, numCharsRead);
			}
			return sb.toString();
		} finally {
			is.close();
		}
	}
	
}
