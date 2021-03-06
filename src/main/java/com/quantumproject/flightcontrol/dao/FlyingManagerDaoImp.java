package com.quantumproject.flightcontrol.dao;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@Component
public class FlyingManagerDaoImp implements FlyingManagerDao {

    @Override
    public boolean isAvailableTicket(long id) {

        Gson gson = new Gson();

        ClassLoader classLoader = gson.getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("database/ticket_to_owner.json");
        String jsonString = null;
        try {
            jsonString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Map> list = gson.fromJson(jsonString, List.class);


        for (Map item : list) {
            if (item.get("ticket_id").equals((double) id) && item.get("owner_id") == null) {
                return true;
            }
        }

        return false;
    }
}
