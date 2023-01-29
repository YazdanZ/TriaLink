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
                    "ya29.c.b0Aaekm1JSq5mP9Hkuo0GaSPoQ2j_-zmAMrlOCX7HtuAtqP-OpC9gqcaiOsaeSrckMWYnJfJnZjmsEJ_xIXFveT1PumALEPoUKc9Q-osxRNF6aYHjs5N31SVKdJ2qSgWy0JSSRkeM2YCyBaqnlwZ2P_ienOGLIgcHeLxhqjTAWO1aHJHuymBVh9glCJ3jb4TtvKk-y1c728tBUmCPkYiDGRLKFZfWEQPML232K11g43Ocf4Zpt_ld16rrOabMtZUvb_lqFy7vgMaw8jria33BtM-9rhj0tMzXv5Xezdpb_p0Y4RQa_M0pb5vfcFwqO3w6gRF7muiq0UiU2RqeMcIMywvhiJS0ShX0cucfyzO9pIv6ZII6a77c-WSr8Fsp0Ij2uwdFphXrOQ0rRMSk14tiMVe43cqOFVhuVibl87iJhkrr2Vr9IWq4lkQY8yt0Srfugrs_gQkaOFt5biyl6IIIWkBpYpJgrumqyvo5oaghwiX7dfpjwinjZIIWqMz8Uk8MZnBmOsy-yMyMtrkfwY_pmvMUpFpooF-3V62pSOu8iFjQBhOvBpoXWy5duWoxXBi2F_ev1WRZh-p95R5MkSptQfxFYretX-13Ugw0bb9_-qqx_pOa-6oV709x8kjjeio0zazjcpSctvqcvsMbwQaVocb7FdyZ1gcujUQgdSjb9u-r0mS80ZQ0qzyrp9uZhdFFafqIrFV5WF1ztnIQBaulMu1BVvI9fkXd21ZwYfSyQqybyfyh9_xQ57Xr8VsOfu1OrUb8lJz5uwMI4cf9Sn0rXlbhwuk3XBis6V9MJJSet6nJ1y6igaBvUvOIV8Q2d1M4093Xf0SSJQ_xJ760Q8kw2-UwBJmW9jyfhVbn9llhwSq0m-f-w-XjlUtp_dkrYYl-Wb_Y9yxtJSop4oglbYU-RX-9fgeY29feqXoe_rWwSWup_MYwaXeph5m5r8aa1Svg5w-YWV9UsR9gBp8Q9v4mejg-Ih_1YtZ5mgZUkqu4Qyul3rdc2xob4uIO",
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
