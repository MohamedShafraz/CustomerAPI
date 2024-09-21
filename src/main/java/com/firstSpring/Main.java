package com.firstSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @GetMapping("/")
    public String home(){
        return "<center><h1>API Initiated Successfully</h1></center>";
    }
//    //For Json  output
//    @GetMapping("/")
//    public HomeResponse home(){
//        return new HomeResponse("<center><h1>API Initiated Successfully</h1></center>");
//    }
//    //like final class but record classes have more constraints compared to regular final classes
//    record HomeResponse(String message){}
}
