package rso.prediction.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PredictionController {

    @GetMapping("/ping")
    public String ping(){
        return "Pong!";
    }
}
