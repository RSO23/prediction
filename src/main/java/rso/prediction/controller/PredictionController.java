package rso.prediction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import rso.prediction.entity.Prediction;
import rso.prediction.service.PredictionService;

@RestController
public class PredictionController {

    private final PredictionService predictionService;

    @Autowired
    public PredictionController(PredictionService predictionService){
        this.predictionService = predictionService;
    }

    @GetMapping("/ping")
    public String ping(){
        return "Pong!";
    }

    @GetMapping("/predictions/{gameId}")
    public Prediction getPredictionForGame(@PathVariable("gameId") String gameId){
        return predictionService.getPredictionForGame(gameId);
    }

    @GetMapping("/predictions")
    public List<Prediction> getPredictions(){
        return predictionService.findAll();
    }

}
