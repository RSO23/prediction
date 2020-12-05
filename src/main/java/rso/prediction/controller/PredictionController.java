package rso.prediction.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import rso.prediction.config.ConfigProperties;
import rso.prediction.entity.Prediction;
import rso.prediction.service.PredictionService;

@RestController
@RequiredArgsConstructor
public class PredictionController {

    private final ConfigProperties configProperties;

    private final PredictionService predictionService;

    @GetMapping("/ping")
    public String ping(){
        return "Pong!";
    }

    @GetMapping("/config")
    public String testConfig() {
        return configProperties.getTestConfig();
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
