package libs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;

public class RestUtils {

    public static Response sendRequest(String url, String key) throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);
        get.setHeader("Content-Type", "application/x-zip");
        get.setHeader("X-Api-Key", key);
        HttpResponse responseGet = client.execute(get);
        HttpEntity resEntityGet = responseGet.getEntity();

        Assert.assertEquals(responseGet.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        String json = EntityUtils.toString(responseGet.getEntity(), "UTF-8");
        com.google.gson.Gson gson = new com.google.gson.Gson();

        return gson.fromJson(json, Response.class);

    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
