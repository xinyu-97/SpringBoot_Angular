package com.demo.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class HomeController {

    @RequestMapping(value="/getCombination", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<String>> getCombinations(@RequestParam String input){
        demoTest.run(input);
        ArrayList<String> list = demoTest.getResultSet();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
