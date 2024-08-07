package com.example.someapi.controller;

import com.example.someapi.model.MyData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping()
public class SomeController {

    @GetMapping("/json")
    public ResponseEntity<?> jsonGen() {
        MyData myData = new MyData();
        myData.setField1("start");
        myData.setField2(0);
        System.out.println("json genereated    " +  myData);
        return new ResponseEntity<>(myData, HttpStatus.OK);
    }

    @PostMapping("/data1")
    public ResponseEntity<?> postData1(@RequestBody MyData data) {
        data.setField1("first_post");
        data.setField2(data.getField2() + 1);
        System.out.println(data);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping("/data2")
    public ResponseEntity<?> postData2(@RequestBody MyData data) {
        long delay = ThreadLocalRandom.current().nextLong(10000, 20000);

        data.setField1("second_post");
        data.setField2(data.getField2() + 1);
        System.out.println(data);

        try {
            TimeUnit.MILLISECONDS.sleep(delay); // simulate delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return new ResponseEntity<>(data, HttpStatus.OK);
    }

//    @PostMapping("/data2")
//    public ResponseEntity<?> postData2(@RequestBody MyData data) {
//        data.setField1("second_post");
//        data.setField2(data.getField2() + 1);
//        System.out.println(data);
//        return new ResponseEntity<>(data, HttpStatus.OK);
//    }


}

