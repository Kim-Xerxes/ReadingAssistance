package com.demo.api;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.tomcat.util.json.JSONParser;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.net.URI;

public class GetBookFromISBN {
    private static final String apiKey = "12795.17cdaf3c33dbc81a9b6bd6e8b817b015.312e31a1974f8f355865ad3d03dee30e";
    private static String url = "";
    public static JSONObject getBookFromISBN(String ISBN){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String resultString = "";
        JSONObject jsonResult = null;
        CloseableHttpResponse response = null;
        url = "https://api.jike.xyz/situ/book/isbn/" + ISBN + "?apikey=" + apiKey;
        try{
            URIBuilder builder = new URIBuilder(url);
            URI uri = builder.build();
            HttpGet httpGet = new HttpGet(uri);
            response = httpClient.execute(httpGet);
            if(response.getStatusLine().getStatusCode() == 200){
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
                jsonResult = JSONObject.parseObject(resultString);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (response != null){
                    response.close();
                }
                httpClient.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return jsonResult;
    }
}
