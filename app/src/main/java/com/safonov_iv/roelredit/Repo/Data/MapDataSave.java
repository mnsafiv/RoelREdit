package com.safonov_iv.roelredit.Repo.Data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safonov_iv.roelredit.Repo.MapData;
import com.safonov_iv.roelredit.Repo.ModelDto.MapPrototypeDto;

public class MapDataSave implements Runnable{

    private MapPrototypeDto query;
    private String responseStatus;

    public MapDataSave(MapPrototypeDto mapPrototype) {
        query = mapPrototype;
    }


    public MapPrototypeDto getQuery() {
        return query;
    }

    public void setQuery(MapPrototypeDto query) {
        this.query = query;
    }

    @Override
    public void run() {
        MapData mapData = new MapData();
        ObjectMapper objectMapper = new ObjectMapper();
        String json;
        try {
            json = objectMapper.writeValueAsString(query);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        String responseStatus = mapData.sendData("http://192.168.1.129:8080/map/editMap/19",json);


//        if(response==null)
//            return;
//        try {
//            query = objectMapper.readValue(response, MapDataDto.class);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
    }
}
