package com.mcgill.mchacks.McHacks.backend;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GoogleCloud {

    public StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        GoogleCloud gcp = new GoogleCloud();
        //gcp.callGCP();
    }

    public HashMap map = new HashMap();

    public List callGCP(String str) {
        try {
            ProcessBuilder pb = new ProcessBuilder("curl","--silent","--location","--request","POST","https://healthcare.googleapis.com/v1/projects/marine-copilot-376117/locations/us-central1/services/nlp:analyzeEntities","--header","Content-Type:application/x-www-form-urlencoded", "--header", "Authorization: Bearer ya29.c.b0Aaekm1JBvlOJd9hpxUJyXTllzoEPh4ZF1S_ouL7iSbQ-FYdSfC4onvyhqR2d76NYi-3vzsCdTICSeCrFFEzhll8SsYes1hfYmvdNvCsggDYFKwmZuSfOFb5fHUjBIc-LuD0036LbzaucfF6LzHD1sXcDZNEfvDn6BwjT5cCayuaQksBmUBopNhglF38OPiOE9y8RV55IdX3uaktCIdCVCy7JUJfOtKYG232Psw93dJBmoel0WokMmOXdFeIykoej1w3pZVj8IwtOB3sQZsxBBhw7wnXhb1g3I4pXmMbntbezZO5mut5M_JfaOkt8WjcdXFzjxiZ8pSw0wxV0Qfo93QZzVwzQOXn5ug2h1d9hst3JuMwrIQbaJJS8x3Zl_UtpoV1u3oB45XabccpcVR9B__nFz0V-w_UwFBsR09-1VuQc09hSkIVFo8SdrOj6aufa_RUd5yI6j4yO4nY1Mx-SIvBdxgkvj62xvQBZl51V2J63XZqacjjrIxd7sgUx-WQWfSFnroU0pnI5W48lt-mi4MnwfnRzhVoIm7ikBs4mXgQesO9UUiwFsMuvenodjv2V0oxWm7l_xXqJ4w5V6md07j8Bjqb8qaZd0BjfRMOjeqIkVnxexYOdRR1J7-6k4xqkoO1Ou1p9d7mevnoQY2nl2-3wk2dsqZOWQiQuIjd3jl2JZzjXUmuueURM6ot7w-rcBrS8XB-ZpjoBbvry0BvS67rvFbW4otQglyycFcxhomvBoZI60xmlfXBSO0s8st748jFxhVn8SYFZctimVkkFx07UnlI7OQod6JjtgrfhMd19j_2Ob4QeFx_kx9snIV-SVsJ81_xXayuMxi2O2V2xlopb7m5WyqqIWBY_54vmgbFkhUzVhkSuBBc-Wd9e0qqUFwz5fffjXlymtgOYQYMt8ggRqr1anlIof6Fh09a6-v7kMYIMl6dV-s4uissiZSr3x7VnBuMZMe8XvjuzaeBfjB4zbiu4SBpX2Oy3f1Jv9uWxcOol_g1zS", "--data-urlencode","documentContent=" + str);


            pb.redirectErrorStream(true);// start the process
            Process proc = pb.start();

            InputStream ins = proc.getInputStream();// creating a buffered reader
            BufferedReader read = new BufferedReader(new InputStreamReader(ins));

            read
                    .lines()
                    .forEach(line -> {
                        //logger.debug("line>"+line);
                        sb.append(line);
                    });// close the buffered reader
            read.close();
            proc.waitFor();

            int exitCode = proc.exitValue();
            //logger.debug("exit code::"+exitCode);// finally destroy the process
            proc.destroy();
        } catch (UnsupportedOperationException | IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // System.out.println(sb.toString());
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(sb.toString());
            JSONArray entities = (JSONArray) json.get("entityMentions");
            for(Object obj : entities) {
                JSONObject jsonObject = (JSONObject) obj;
                if(!map.containsKey(jsonObject.get("type"))) {
                    List<String> list = new ArrayList();
                    list.add((String) ((JSONObject)jsonObject.get("text")).get("content"));
                    map.put((String) jsonObject.get("type"), list);
                }
                else {
                    List temp = (List) map.get(jsonObject.get("type"));
                    if(!temp.contains(((JSONObject)jsonObject.get("text")).get("content"))) {
                        temp.add(((JSONObject)jsonObject.get("text")).get("content"));
                        map.put((String) jsonObject.get("type"), temp);
                    }

                }
                // System.out.println(((JSONObject)jsonObject.get("text")).get("content"));
            }

        } catch (ParseException e){
            e.printStackTrace();
        }

        System.out.println(map);
        return null;
    }

}
