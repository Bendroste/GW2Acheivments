package Daily;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by Ben Droste on 4/30/2017.
 */
public class Daily {
    public ArrayList<DailyAcheivments> todayPve() throws java.io.IOException{
        ArrayList<DailyAcheivments> ret = new ArrayList();
        String jsonString = callURL("https://api.guildwars2.com/v2/achievements/daily");
        int pves = jsonString.indexOf("pve\":")+5;
        int pvee = jsonString.indexOf("\"pvp\":")-4;

        String testPve = jsonString.substring(pves,pvee);
        try {
            JSONArray pve = new JSONArray(testPve);
            String ids = "";
            for(int i=0 ; i< pve.length(); i++){
                JSONObject jsonObject = pve.getJSONObject(i);
                String test = jsonObject.get("id").toString();
                ids += test + ",";
            }
            String url = "https://api.guildwars2.com/v2/achievements?ids=";
            ids = ids.substring(0,ids.length()-1);
            url = url + ids;
            String acheive = callURL(url);
            JSONArray ach = new JSONArray(acheive);
            for(int i=0 ; i< ach.length(); i++){
                JSONObject achieveobj = ach.getJSONObject(i);
                String id = achieveobj.get("id").toString();
                String name = achieveobj.get("name").toString();
                DailyAcheivments dailyAcheivments = new DailyAcheivments("PVE",Integer.parseInt(id),name);
                ret.add(dailyAcheivments);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public ArrayList<DailyAcheivments> todayPvp() throws java.io.IOException{
        ArrayList<DailyAcheivments> ret = new ArrayList();
        String jsonString = callURL("https://api.guildwars2.com/v2/achievements/daily");
        int pvps = jsonString.indexOf("pvp\":")+5;
        int pvpe = jsonString.indexOf("\"wvw\":")-4;

        String testPvp = jsonString.substring(pvps,pvpe);
        try {
            JSONArray daily = new JSONArray(testPvp);
            String ids = "";
            for(int i=0 ; i< daily.length(); i++){
                JSONObject jsonObject = daily.getJSONObject(i);
                String test = jsonObject.get("id").toString();
                ids += test + ",";
            }
            String url = "https://api.guildwars2.com/v2/achievements?ids=";
            ids = ids.substring(0,ids.length()-1);
            url = url + ids;
            String acheive = callURL(url);
            JSONArray ach = new JSONArray(acheive);
            for(int i=0 ; i< ach.length(); i++){
                JSONObject achieveobj = ach.getJSONObject(i);
                String id = achieveobj.get("id").toString();
                String name = achieveobj.get("name").toString();
                DailyAcheivments dailyAcheivments = new DailyAcheivments("PVP",Integer.parseInt(id),name);
                ret.add(dailyAcheivments);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public ArrayList<DailyAcheivments> todayWvw() throws java.io.IOException{
        ArrayList<DailyAcheivments> ret = new ArrayList();
        String jsonString = callURL("https://api.guildwars2.com/v2/achievements/daily");
        int wvws = jsonString.indexOf("wvw\":")+5;
        int wvwe = jsonString.indexOf("\"fractals\":")-4;
        String testWvw = jsonString.substring(wvws,wvwe);
        try {
            JSONArray pve = new JSONArray(testWvw);

            String ids = "";
            for(int i=0 ; i< pve.length(); i++){
                JSONObject jsonObject = pve.getJSONObject(i);
                String test = jsonObject.get("id").toString();
                ids += test + ",";
            }
            String url = "https://api.guildwars2.com/v2/achievements?ids=";
            ids = ids.substring(0,ids.length()-1);
            url = url + ids;
            String acheive = callURL(url);
            JSONArray ach = new JSONArray(acheive);
            for(int i=0 ; i< ach.length(); i++){
                JSONObject achieveobj = ach.getJSONObject(i);
                String id = achieveobj.get("id").toString();
                String name = achieveobj.get("name").toString();
                DailyAcheivments dailyAcheivments = new DailyAcheivments("WVW",Integer.parseInt(id),name);
                ret.add(dailyAcheivments);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public ArrayList<DailyAcheivments> todayFrac() throws java.io.IOException{
        ArrayList<DailyAcheivments> ret = new ArrayList();
        String jsonString = callURL("https://api.guildwars2.com/v2/achievements/daily");
        int fracts = jsonString.indexOf("fractals\":")+11;
        int fracte = jsonString.indexOf("\"special\":")-4;
        String testFrac = jsonString.substring(fracts,fracte);
        try {
            JSONArray pve = new JSONArray(testFrac);
            String ids = "";
            for(int i=0 ; i< pve.length(); i++){
                JSONObject jsonObject = pve.getJSONObject(i);
                String test = jsonObject.get("id").toString();
                ids += test + ",";
            }
            String url = "https://api.guildwars2.com/v2/achievements?ids=";
            ids = ids.substring(0,ids.length()-1);
            url = url + ids;
            String acheive = callURL(url);
            JSONArray ach = new JSONArray(acheive);
            for(int i=0 ; i< ach.length(); i++){
                JSONObject achieveobj = ach.getJSONObject(i);
                String id = achieveobj.get("id").toString();
                String name = achieveobj.get("name").toString();
                DailyAcheivments dailyAcheivments = new DailyAcheivments("FRACTAL",Integer.parseInt(id),name);
                ret.add(dailyAcheivments);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public ArrayList<DailyAcheivments> todaySpecial() throws java.io.IOException{
        ArrayList<DailyAcheivments> ret = new ArrayList();
        String jsonString = callURL("https://api.guildwars2.com/v2/achievements/daily");
        int specs = jsonString.indexOf("special\":")+10;
        int spece = jsonString.length();
        String testSpecial = jsonString.substring(specs,spece);
        try {
            JSONArray pve = new JSONArray(testSpecial);
            String ids = "";
            for(int i=0 ; i< pve.length(); i++){
                JSONObject jsonObject = pve.getJSONObject(i);
                String test = jsonObject.get("id").toString();
                ids += test + ",";
            }
            String url = "https://api.guildwars2.com/v2/achievements?ids=";
            int end = ids.length()-1;
            if(end <0){
                end = 0;
            }
            else {
                ids = ids.substring(0,end);
                url = url + ids;
                String acheive = callURL(url);
                JSONArray ach = new JSONArray(acheive);
                for(int i=0 ; i< ach.length(); i++){
                    JSONObject achieveobj = ach.getJSONObject(i);
                    String id = achieveobj.get("id").toString();
                    String name = achieveobj.get("name").toString();
                    DailyAcheivments dailyAcheivments = new DailyAcheivments("FESTIVAL",Integer.parseInt(id),name);
                    ret.add(dailyAcheivments);
                }
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public ArrayList<DailyAcheivments> tomPve() throws java.io.IOException{
        ArrayList<DailyAcheivments> ret = new ArrayList();
        String jsonString = callURL("https://api.guildwars2.com/v2/achievements/daily/tomorrow");
        int pves = jsonString.indexOf("pve\":")+5;
        int pvee = jsonString.indexOf("\"pvp\":")-4;

        String testPve = jsonString.substring(pves,pvee);
        try {
            JSONArray pve = new JSONArray(testPve);
            String ids = "";
            for(int i=0 ; i< pve.length(); i++){
                JSONObject jsonObject = pve.getJSONObject(i);
                String test = jsonObject.get("id").toString();
                ids += test + ",";
            }
            String url = "https://api.guildwars2.com/v2/achievements?ids=";
            ids = ids.substring(0,ids.length()-1);
            url = url + ids;
            String acheive = callURL(url);
            JSONArray ach = new JSONArray(acheive);
            for(int i=0 ; i< ach.length(); i++){
                JSONObject achieveobj = ach.getJSONObject(i);
                String id = achieveobj.get("id").toString();
                String name = achieveobj.get("name").toString();
                DailyAcheivments dailyAcheivments = new DailyAcheivments("PVE",Integer.parseInt(id),name);
                ret.add(dailyAcheivments);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public ArrayList<DailyAcheivments> tomPvp() throws java.io.IOException{
        ArrayList<DailyAcheivments> ret = new ArrayList();
        String jsonString = callURL("https://api.guildwars2.com/v2/achievements/daily/tomorrow");
        int pvps = jsonString.indexOf("pvp\":")+5;
        int pvpe = jsonString.indexOf("\"wvw\":")-4;

        String testPvp = jsonString.substring(pvps,pvpe);
        try {
            JSONArray daily = new JSONArray(testPvp);
            String ids = "";
            for(int i=0 ; i< daily.length(); i++){
                JSONObject jsonObject = daily.getJSONObject(i);
                String test = jsonObject.get("id").toString();
                ids += test + ",";
            }
            String url = "https://api.guildwars2.com/v2/achievements?ids=";
            ids = ids.substring(0,ids.length()-1);
            url = url + ids;
            String acheive = callURL(url);
            JSONArray ach = new JSONArray(acheive);
            for(int i=0 ; i< ach.length(); i++){
                JSONObject achieveobj = ach.getJSONObject(i);
                String id = achieveobj.get("id").toString();
                String name = achieveobj.get("name").toString();
                DailyAcheivments dailyAcheivments = new DailyAcheivments("PVP",Integer.parseInt(id),name);
                ret.add(dailyAcheivments);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public ArrayList<DailyAcheivments> tomWvw() throws java.io.IOException{
        ArrayList<DailyAcheivments> ret = new ArrayList();
        String jsonString = callURL("https://api.guildwars2.com/v2/achievements/daily/tomorrow");
        int wvws = jsonString.indexOf("wvw\":")+5;
        int wvwe = jsonString.indexOf("\"fractals\":")-4;
        String testWvw = jsonString.substring(wvws,wvwe);
        try {
            JSONArray pve = new JSONArray(testWvw);

            String ids = "";
            for(int i=0 ; i< pve.length(); i++){
                JSONObject jsonObject = pve.getJSONObject(i);
                String test = jsonObject.get("id").toString();
                ids += test + ",";
            }
            String url = "https://api.guildwars2.com/v2/achievements?ids=";
            ids = ids.substring(0,ids.length()-1);
            url = url + ids;
            String acheive = callURL(url);
            JSONArray ach = new JSONArray(acheive);
            for(int i=0 ; i< ach.length(); i++){
                JSONObject achieveobj = ach.getJSONObject(i);
                String id = achieveobj.get("id").toString();
                String name = achieveobj.get("name").toString();
                DailyAcheivments dailyAcheivments = new DailyAcheivments("WVW",Integer.parseInt(id),name);
                ret.add(dailyAcheivments);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public ArrayList<DailyAcheivments> tomFrac() throws java.io.IOException{
        ArrayList<DailyAcheivments> ret = new ArrayList();
        String jsonString = callURL("https://api.guildwars2.com/v2/achievements/daily/tomorrow");
        int fracts = jsonString.indexOf("fractals\":")+11;
        int fracte = jsonString.indexOf("\"special\":")-4;
        String testFrac = jsonString.substring(fracts,fracte);
        try {
            JSONArray pve = new JSONArray(testFrac);
            String ids = "";
            for(int i=0 ; i< pve.length(); i++){
                JSONObject jsonObject = pve.getJSONObject(i);
                String test = jsonObject.get("id").toString();
                ids += test + ",";
            }
            String url = "https://api.guildwars2.com/v2/achievements?ids=";
            ids = ids.substring(0,ids.length()-1);
            url = url + ids;
            String acheive = callURL(url);
            JSONArray ach = new JSONArray(acheive);
            for(int i=0 ; i< ach.length(); i++){
                JSONObject achieveobj = ach.getJSONObject(i);
                String id = achieveobj.get("id").toString();
                String name = achieveobj.get("name").toString();
                DailyAcheivments dailyAcheivments = new DailyAcheivments("FRACTAL",Integer.parseInt(id),name);
                ret.add(dailyAcheivments);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public ArrayList<DailyAcheivments> tomSpecial() throws java.io.IOException{
        ArrayList<DailyAcheivments> ret = new ArrayList();
        String jsonString = callURL("https://api.guildwars2.com/v2/achievements/daily/tomorrow");
        int specs = jsonString.indexOf("special\":")+10;
        int spece = jsonString.length();
        String testSpecial = jsonString.substring(specs,spece);
        try {
            JSONArray pve = new JSONArray(testSpecial);
            String ids = "";
            for(int i=0 ; i< pve.length(); i++){
                JSONObject jsonObject = pve.getJSONObject(i);
                String test = jsonObject.get("id").toString();
                ids += test + ",";
            }
            String url = "https://api.guildwars2.com/v2/achievements?ids=";
            int end = ids.length()-1;
            if(end <0){
                end = 0;
            }
            else {
                ids = ids.substring(0,end);
                url = url + ids;
                String acheive = callURL(url);
                JSONArray ach = new JSONArray(acheive);
                for(int i=0 ; i< ach.length(); i++){
                    JSONObject achieveobj = ach.getJSONObject(i);
                    String id = achieveobj.get("id").toString();
                    String name = achieveobj.get("name").toString();
                    DailyAcheivments dailyAcheivments = new DailyAcheivments("FESTIVAL",Integer.parseInt(id),name);
                    ret.add(dailyAcheivments);
                }
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ret;
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

