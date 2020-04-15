package com.demo.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
public class HomeController {

    @RequestMapping(value="/getCombination", method = RequestMethod.GET)
    public ArrayList<String> getCombinations(@RequestParam String input){
        demoTest.run(input);
        ArrayList<String> list = demoTest.getResultSet();
        return list;
    }
}
