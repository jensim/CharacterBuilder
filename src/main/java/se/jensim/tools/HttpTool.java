package se.jensim.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author jens
 */
public class HttpTool {

	public static String getParamString(Map<String, String> paramMap) {
		StringBuilder sb = new StringBuilder("?");
		for (String key : paramMap.keySet()) {
			if (sb.toString().length() != 1) {
				sb.append("&");
			}
			sb.append(key).append("=").append(paramMap.get(key));
		}
		return sb.toString();
	}

	private static String responseToString(HttpResponse response) throws Exception {
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		String line = "";
		StringBuilder sb = new StringBuilder();
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		String string = sb.toString();
		return string;
	}

	/**
	 *
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 * @see HttpTool.getParamString(Map<String,String>)
	 */
	public static String getRequest(String url, String params) throws Exception {

		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url + params);
		HttpResponse response = client.execute(request);

		return responseToString(response);
	}

	public static String postRequest(String url, String params) throws Exception {
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url + params);
		HttpResponse response = client.execute(post);

		return responseToString(response);
	}
}
