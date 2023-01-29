package com.mcgill.mchacks.McHacks.WebController;

import com.mcgill.mchacks.McHacks.backend.GoogleCloud;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class WebController {


    @GetMapping(value = "/test")
    public String test() {
        return "Works";
    }

    @RequestMapping(value = "/{value1}")
    public String getMax(@PathVariable(name = "value1", required = true) String value1) {

        return value1;
    }

    @CrossOrigin
    @PostMapping(value = {"/health", "/health/"})
    public ResponseEntity<?> health(@RequestBody String longString) {
        GoogleCloud gcp = new GoogleCloud();
        //HashMap map = gcp.callGCP(longString);

        try{
            return new ResponseEntity<>(gcp.callGCP(longString), HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }

    }
}