package com.safonov_iv.roelredit.Repo.Data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safonov_iv.roelredit.Repo.MapData;
import com.safonov_iv.roelredit.Repo.ModelDto.MapPrototypeDto;


public class MapDataGet implements Runnable{
    private MapPrototypeDto mapDataDto;

    public MapPrototypeDto getMap(){
        return mapDataDto;
    }

    @Override
    public void run() {
        MapData mapData = new MapData();
        String response = mapData.getData("http://192.168.1.129:8080/map/editMap/19");
        ObjectMapper objectMapper = new ObjectMapper();
        if(response==null)
            return;
        try {
            mapDataDto = objectMapper.readValue(response, MapPrototypeDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
