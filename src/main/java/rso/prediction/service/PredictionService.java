package rso.prediction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rso.prediction.entity.Prediction;
import rso.prediction.repository.PredictionRepository;

@Service
public class PredictionService {

    private final PredictionRepository predictionRepository;

    @Autowired
    public PredictionService(PredictionRepository predictionRepository){
        this.predictionRepository = predictionRepository;
    }

    public Prediction getPredictionForGame(String gameId){
        return predictionRepository.findByGameId(gameId);
    }

    public List<Prediction> findAll(){
        return (List<Prediction>) predictionRepository.findAll();
    }
}
