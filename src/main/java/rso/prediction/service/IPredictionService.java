package rso.prediction.service;

import rso.prediction.entity.Prediction;

import java.util.List;

public interface IPredictionService {

    List<Prediction> findAll();
}
