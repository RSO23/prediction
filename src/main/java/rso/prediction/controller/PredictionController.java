package rso.prediction.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import rso.prediction.config.ConfigProperties;
import rso.prediction.dto.MatchDto;
import rso.prediction.dto.PredictionDto;
import rso.prediction.dto.SummonerNamesDto;
import rso.prediction.service.PredictionService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Basic operations", produces = "application/json", consumes = "application/json")
public class PredictionController {

    private final Logger log = LoggerFactory.getLogger(PredictionController.class);

    private final ConfigProperties configProperties;

    private final PredictionService predictionService;

    private final ApplicationContext applicationContext;

    @GetMapping("/ping")
    public String ping(){
        log.info("Ping!");
        return "Pong!";
    }

    @GetMapping("/config")
    public String testConfig() {
        return configProperties.getTestConfig();
    }

    @PostMapping("/predict")
    public PredictionDto makePrediction(@RequestBody MatchDto matchDto, @RequestParam Long userId) {
        return predictionService.makePrediction(matchDto, userId);
    }

    @PostMapping("/predict/summoners")
    public PredictionDto makePredictionSummoners(@RequestBody SummonerNamesDto summonerNamesDto) {
        return predictionService.makePredictionsSummoners(summonerNamesDto);
    }

    @PostMapping("/break")
    public void breakPod() {
        AvailabilityChangeEvent.publish(applicationContext, LivenessState.BROKEN);
    }


}
