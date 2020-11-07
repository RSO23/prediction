package rso.prediction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import rso.prediction.dto.PredictionDto;
import rso.prediction.service.PredictionService;

@RestController
public class PredictionController {

    private PredictionService predictionService;

    @Autowired
    public PredictionController(PredictionService predictionService){
        this.predictionService = predictionService;
    }

    @GetMapping("/ping")
    public String ping(){
        return "Pong!";
    }

    @GetMapping("/prediction/{gameId}")
    public PredictionDto getPredictionForGame(@PathVariable("gameId") String gameId){
        return predictionService.getPredictionForGame(gameId);
    }
}
