package rso.prediction.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rso.prediction.dto.PredictionDto;

@Service
public class PredictionService {

    private final RestTemplate restTemplate;

    public PredictionService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public PredictionDto getPredictionForGame(String gameId){
        PredictionDto prediction = new PredictionDto(gameId);
        prediction.setPrediction("Victory");
        prediction.setPredictionCertainty(99.0);
        return prediction;
    }
}
