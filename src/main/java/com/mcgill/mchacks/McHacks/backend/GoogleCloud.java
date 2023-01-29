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
                    "ya29.c.b0Aaekm1J0xAbEAyDGf6izbduUCnG0yYxJO-3i2ImbaXgN6zmhyEFJufOQrtVaecrtL0hEDERmuN1mL-6_adngzaH6fhnjEoN9jwb2ZjUUuNm66zqdBYyaDMrA39CIfWq0pwPSsjIukBoQ1u762w4Gf3RC5e1742jPkK1DdYw3NYo6-yQuieqrYsgZz_WM8Dl6EzNQetfmNS2PI1ibCU1Im_S9ZVbPZlUT232KZ0OIVkBWRjptwRlZrRgfXQ7Rem8FfyU1mZw1RVRlyUvROdyb5Jo2MfihrouJmkr_oq0U-9rku5hm_cFsZQ1y_wr7ru0St7qyfYr4Xv7b1MoUInVVgqr092nU3l6_9ych_gjYFRM7YnSnRklF9xkQOcWkeWBS1ZJqQvrVVZ4yO1ZY3J5mUwc52vtWoV2ncnha2o7SuUuo6Oq6O0y5ey2Ir2QRp-qV9XIoO6k4Y1iS7n5uO44OmBfq5Igvu9oc_vBsSpofISw7QuB8pRq81e6i9S838gpnO-jniJeefstq9xr3cWpFkv4i73U4MR2q-7jnsFfyfIiVkk6j79hO4zIbuRanb2dkRWJa_2msexFoxtzngIlvftqd5jda6FasfsXlI_wQbrfOO7wbptY3fjUekveZzZ6b4nuvkn2jn5Zo0itzct_zkr_0xkbnQ-9vsQ3rQWV7b8hQBp4amBI0wnrRmRr8flBMkBz2Vy7_Uuy85Qdlx5J7jf3Fe_j42lww185OssJJpsWnv6Xoy5Y6Wd6VZc3110QSi4zcFRXy8Wrtw1qfiXB8stquIskw7_ZsU_4FM8MWxBztjx-42ZvMe_e5Z-iV0ep73trWm8ZBRrJy7eRRWuJrM_4Bajdv8Oi5lcpvlqUxk0lxFf8_ScJfZYg9Y5Wtz72uh-oShpbi7O3B6i3e2bV_loUlRnetJUwrFb_009-c9SaFgyO2hqeJpoVnn2Rzt6Wo8Ml1OM9BvMugZfIBQjml5pM4muunk_uh4bZlodbfhb_mUF97oXkV0ik",
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
