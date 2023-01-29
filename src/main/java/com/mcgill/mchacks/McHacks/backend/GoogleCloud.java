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
        gcp.callGCP("Most Responsible Diagnosis: COPD Exacerbation  Active Issues Managed in Hospital:  Pulmonary edema Microcytic anemia Gout Purpuric rash NYD  Course in Hospital:  Mr. Johnson arrived in the ER from nursing home with a three-day history of worsening shortness of breath, yellow-green sputum, and increased sputum production. He was subsequently diagnosed with a COPD exacerbation and was satting at 84% on 4L O2 by nasal prongs. He was stepped up to BiPAP for 24 hours and prednisone, ciprofloxacin, and around the clock puffers were initiated. By day 2 of admission he was stepped down to oxygen by nasal prongs and QID puffers.  In terms of respiratory complications, Mr. Johnson had a sudden hypoxic resp failure on day 3 of admission. CCOT was involved, but ICU was avoided. He was found to be in pulmonary edema that responded to diuresis. Last documented echo was completed 15 years ago and a repeat echo was ordered to be completed as an outpatient.    Unfortunately on day 4 of admission Mr. Johnson also developed gout in the left MTP. This limited his mobility and contributed to deconditioning for which PT was involved. Also, by day 6 of admission a purpuric rash was noted on the upper and lower extremities, cause was unknown and punch biopsy was performed. The results are still pending. Lastly, upon admission Mr. Johnson was found to have a microcytic anemia. On history Mr. Johnson states he no longer eats much red meat or leafy greens, preferring tea and toast for most of his meals. There was no history of bleeding and previous FOBT testing was normal. Further testing revealed iron deficiency anemia and therapy with ferrous fumarate was initiated.   On day of discharge, Ms. Johnson was on room air but continued to be on Lasix.  Continued Home Medications: Albuterol 2 puffs q 4-6 hours daily Atrovent 2 puffs q 6h ASA 325 mg daily Metoprolol 25 mg BID Atorvastatin 40 mg daily Ramipril 10 mg daily Amlodipine 5 mg daily Metformin 1000 mg BID Terazosin 5 mg qhs Tylenol 325 mg qhs Lactulose 15cc qhs prn Citalopram 20 mg daily Multivitamin  Medications Changes: Ramipril was STOPPED Lasix was STARTED at 20mg PO BID Amlodipine was INCREASED to 10mg daily Ferrous fumarate 325 mg QHS was STARTED  Important Test Results:  CXR completed April 20th 2019 revealed pulmonary edema and enlarged cardiac silhouette Sputum culture collected April 18th 2019 was positive for pseudomonas aeruginosa  Pending Tests or Results: Echo ordered as outpatient Skin biopsy results pending  Follow-up Plans:  We asked the patient to make an appointment with their family MD next week. The patient will follow up in urgent resp clinic in 2-4 weeks time. Since moving to London the patient is not currently followed by a respirologist and since this is the third exacerbation this year a goals of care discussion may be warranted. The patient was also seen by our COPD Navigator Team and arrangements have been made to be seen as an outpatient.");
    }

    public HashMap map = new HashMap();

    public HashMap callGCP(String str) {
        try {
            ProcessBuilder pb = new ProcessBuilder("curl","--silent","--location","--request","POST","https://healthcare.googleapis.com/v1/projects/marine-copilot-376117/locations/us-central1/services/nlp:analyzeEntities","--header","Content-Type:application/x-www-form-urlencoded", "--header", "Authorization: Bearer " +
                    "ya29.c.b0Aaekm1KDEWUuXxMpNAXpXgrQglbTeVJPq2xQGjp7q4ecfcPMBJcN3gLUC2LZzME4M8nQttXig5sxrIB2Jyt6BjJFsq9zaBqvhXYgOm4LkhgKtLtNa2Osn8Nr_LYXNO7AdzoX9btKkHLat41H0cAOwGFo6AVd48Pbo0M2a0AkEOxoXKvLozd3YN1vB1GjVTmxa3zX7RQmWZG7dyy_P11Ep56wsB3f_1wT232Pft700iv-wofFUJYfhRex0-1n64Y1q71I7y-esMy06ug_7Jh8FcoFMiSOUoUey8ywyz7znztbpX_l7hhx6W7u9VUWVBrBl1pfuynVUaweIF6c3xQqkVqqWBzhrBkVq0kQkn_iQZztpFbn04WW58Fwvz1Qs6hzzwZ79ZBFilxe3uqh2SnniRauxxlgFceIpXu39trc-RkVkZmlm2xWMVBi1Qdgdqsxz77laSrv7j_tpQQjkFB36VMYtSR9z6y02v8atbwfMyd0qXhFocwutmVszSsymVye798Uctw7ie0XzMhFjq73g2fn4_imQvO3tsg1_zmIUF-guzq38ncOe2XsihnbQvMRO99xSQmwJm003WdX4txiu9qVhirsn49txanOQwMzYwSgj93RnjqSd8_X6-hmUn5--l0uxFUOpq6BJl8dX24S7SgYtBJh74OB0sgxzSFJJWW5IOb9vI721VBxreSRk0qfhUMI9Bjun6VUsSMegrlyFMx30bsBVJZkVhn5gYuUmlm1Xl0zwe1W4Udml0p92ofVcm0gyRheJviF6bohF9uUsaobirwbkjRYvyX010VB05pF6jr_jJOjg8o1qB76ZyppXo66ep095uSvaeU_FrivuusI60J_bpRXsdUOdxBVnniV4tmzw66W1bf7qvYhO8393QZSdadO131tkFZx8-52tIbmUxU6y0pkX1drw-t_zVegcnf9S0-2Wpv-Q3Oykdwl6mJ22htBwukzaml3yM15nhovS7i-wwcIz_B9tOkx1q54x9az2OY_SR-",
                    "--data-urlencode","documentContent=" + str);


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
            //System.out.println(json);
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
        return map;
    }

}
