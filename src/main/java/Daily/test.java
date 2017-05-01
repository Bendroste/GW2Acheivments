package Daily;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Ben Droste on 4/30/2017.
 */
public class test {
    public static void main(String[] args) {
        String jsonString = callURL("https://api.guildwars2.com/v2/achievements/daily");
//        System.out.println("\n\njsonString: " + jsonString);
        int pves = jsonString.indexOf("pve\":")+5;
        int pvee = jsonString.indexOf("\"pvp\":")-4;
        int pvps = jsonString.indexOf("pvp\":")+5;
        int pvpe = jsonString.indexOf("\"wvw\":")-4;
        int wvws = jsonString.indexOf("wvw\":")+5;
        int wvwe = jsonString.indexOf("\"fractals\":")-4;
        int fracts = jsonString.indexOf("fractals\":")+11;
        int fracte = jsonString.indexOf("\"special\":")-4;
        int specs = jsonString.indexOf("special\":")+10;
        int spece = jsonString.length();

        String testPve = jsonString.substring(pves,pvee);
        String testPvp = jsonString.substring(pvps,pvpe);
        String testWvw = jsonString.substring(wvws,wvwe);
        String testFrac = jsonString.substring(fracts,fracte);
        String testSpecial = jsonString.substring(specs,spece);

// Replace this try catch block for all below subsequent examples
        try {
            JSONArray pve = new JSONArray(testPve);
            JSONArray pvp = new JSONArray(testPvp);
            JSONArray wvw = new JSONArray(testWvw);
            JSONArray frac = new JSONArray(testFrac);
            JSONArray spec = new JSONArray(testSpecial);
            String ids = "";
            for(int i=0 ; i< pve.length(); i++){
                // iterate through jsonArray
                JSONObject jsonObject = pve.getJSONObject(i);
                // get jsonObject @ i position
                String test = jsonObject.get("id").toString();
                ids += test + ",";
//                System.out.println(test);
            }
            String url = "https://api.guildwars2.com/v2/achievements?ids=";
            ids = ids.substring(0,ids.length()-1);
            url = url + ids;
            String acheive = callURL(url);
            JSONArray ach = new JSONArray(acheive);
//            System.out.println(ach);
            for(int i=0 ; i< ach.length(); i++){
                // iterate through jsonArray
                JSONObject achieveobj = ach.getJSONObject(i);
//                System.out.println(achieveobj);
                // get jsonObject @ i position
                String id = achieveobj.get("id").toString();
                String name = achieveobj.get("name").toString();
                System.out.println(id+" " +name);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static String callURL(String myURL) {
        System.out.println("Requested URL:" + myURL);
        StringBuilder sb = new StringBuilder();
        URLConnection urlConn = null;
        InputStreamReader in = null;
        try {
            URL url = new URL(myURL);
            urlConn = url.openConnection();
            if (urlConn != null)
                urlConn.setReadTimeout(60 * 1000);
            if (urlConn != null && urlConn.getInputStream() != null) {
                in = new InputStreamReader(urlConn.getInputStream(),
                        Charset.defaultCharset());
                BufferedReader bufferedReader = new BufferedReader(in);
                if (bufferedReader != null) {
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
                        sb.append((char) cp);
                    }
                    bufferedReader.close();
                }
            }
            in.close();
        } catch (Exception e) {
            throw new RuntimeException("Exception while calling URL:"+ myURL, e);
        }

        return sb.toString();
    }

}

