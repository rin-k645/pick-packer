package com.pickpack.itemservice.controller;

import com.pickpack.itemservice.api.ListRes;
import com.pickpack.itemservice.entity.City;
import com.pickpack.itemservice.exception.CityListEmptyException;
import com.pickpack.itemservice.service.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/item")
public class CityController {
    private final CityService cityService;

    @GetMapping()
    public ResponseEntity<?> getCityList(){
        List<City> cityList = cityService.getCityList();

        if(cityList.isEmpty()){
            String errMsg = "도시 목록이 없습니다.";
            exceptionHandling(new CityListEmptyException(errMsg));
            return new ResponseEntity<String>("Error : " + errMsg, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new ListRes(cityList), HttpStatus.OK);
    }

    private void exceptionHandling(Exception e) {
        e.printStackTrace();
    }

}
