package rso.prediction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rso.prediction.dto.PredictionDto;
import rso.prediction.entity.Prediction;
import rso.prediction.repository.PredictionRepository;

import java.util.List;

@Service
public class PredictionService implements IPredictionService {

    private final RestTemplate restTemplate;

    @Autowired
    private PredictionRepository predictionRepository;

    public PredictionService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public PredictionDto getPredictionForGame(String gameId){
        PredictionDto prediction = new PredictionDto(gameId);
        prediction.setPrediction("Victory");
        prediction.setPredictionCertainty(99.0);
        return prediction;
    }

    @Override
    public List<Prediction> findAll(){
        return (List<Prediction>) predictionRepository.findAll();
    }
}
