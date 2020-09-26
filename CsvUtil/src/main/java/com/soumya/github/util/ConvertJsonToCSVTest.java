package com.soumya.github.util;

import java.util.ArrayList;
import java.util.List;

import com.soumya.github.vo.CsvVo;
import org.json.*;

public class ConvertJsonToCSVTest {
    public static void main(String[] args) throws JSONException {
        String jsonArrayString = "{\n" +
                "\t\"realtime_start\": \"2020-09-25\",\n" +
                "\t\"realtime_end\": \"2020-09-25\",\n" +
                "\t\"units\": \"Percent\",\n" +
                "\t\"seriess\": [{\n" +
                "\t\t\t\"name\": \"James\",\n" +
                "\t\t\t\"age\": 29,\n" +
                "\t\t\t\"house\": \"CA\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"name\": \"Jina\",\n" +
                "\t\t\t\"age\": 39,\n" +
                "\t\t\t\"house\": \"MA\",\n" +
                "\t\t\t\"notes\": \"Million tonne punch\"\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";
        JSONObject inJson;
            List<CsvVo> list = new ArrayList<>();
            inJson = new JSONObject(jsonArrayString);
            JSONArray inJsonSeries = inJson.getJSONArray("seriess");
            for (int i = 0, size = inJsonSeries.length(); i < size; i++){
                CsvVo line = new CsvVo();
                line.setRealtime_start(inJson.get("realtime_start").toString());
                line.setRealtime_end(inJson.get("realtime_end").toString());
                line.setUnits(inJson.get("units").toString());
                JSONObject o = (JSONObject)inJsonSeries.get(i);
                line.setName(o.get("name").toString());
                line.setAge(o.get("age").toString());
                line.setHouse(o.get("house").toString());
                try {
                    line.setNotes(o.get("notes").toString());
                }catch (JSONException e){
                    line.setNotes("");
                }
                list.add(line);
            }
            String[] cols = {"realtime_start", "realtime_end", "units", "name", "age", "house", "notes"};
            CsvUtils.csvWriterUtil(CsvVo.class, list, "in/EmpDetails.csv", cols);

        }
    }
