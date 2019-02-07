package com.library.management.Manager;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.management.Model.UserModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class JsonManager {

    private static String fileName="fileData";

        public static void addToJson (UserModel userModel) throws IOException, ParseException {
            JSONParser jsonParser = new JSONParser();

            File fileCheck = new File(fileName);
            if(fileCheck.length() > 0) {

                Object obj = jsonParser.parse(new FileReader(fileName));
                JSONArray jsonArray = new JSONArray();
                JSONObject jsonObject = new JSONObject();
                if (obj instanceof JSONArray)
                    jsonArray = (JSONArray) obj;
                if (obj instanceof JSONObject) {
                    jsonObject = (JSONObject) obj;
                    jsonArray.add(jsonObject);
                }

                jsonObject.put("id", userModel.getId());
                jsonObject.put("name", userModel.getName());
                jsonObject.put("mobile", userModel.getMobile());
                jsonObject.put("cnic", userModel.getCnic());
                jsonObject.put("address", userModel.getAddress());

                jsonArray.add(jsonObject);
                FileWriter file = new FileWriter("fileData");
                file.write(jsonArray.toJSONString());
                file.flush();
                file.close();
            }else{
                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(new File(fileName), userModel);

            }

        }

}