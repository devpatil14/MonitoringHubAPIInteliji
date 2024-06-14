package Old;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientUtils {

        public static HttpResponse sendGetRequest(String url) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        return httpClient.execute(httpGet);
        }

        public static HttpResponse sendPostRequest(String url, String requestBody) throws IOException {
            HttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new StringEntity(requestBody));
            return httpClient.execute(httpPost);
        }

        public static HttpResponse sendPutRequest(String url, String requestBody) throws IOException {
            HttpClient httpClient = HttpClients.createDefault();
            HttpPut httpPut = new HttpPut(url);
            httpPut.setEntity(new StringEntity(requestBody));
            return httpClient.execute(httpPut);
        }

        public static HttpResponse sendDeleteRequest(String url) throws IOException {
            HttpClient httpClient = HttpClients.createDefault();
            HttpDelete httpDelete = new HttpDelete(url);
            return httpClient.execute(httpDelete);
        }

        public static String getResponseBody(HttpResponse response) throws IOException {
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity);
        }

}
