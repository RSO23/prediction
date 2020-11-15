package rso.prediction.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rso.prediction.entity.Prediction;

@Repository
public interface PredictionRepository extends CrudRepository<Prediction, Long> {
}
