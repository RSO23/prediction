package rso.prediction.service;

import org.apache.tomcat.jni.Time;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import rso.prediction.dto.MatchDto;
import rso.prediction.dto.PredictionDto;
import rso.prediction.feign.PredictionCatalogueServiceFeign;

@Service
@RequiredArgsConstructor
public class PredictionService {

    private final Logger log = LoggerFactory.getLogger(PredictionService.class);


    private final PredictionCatalogueServiceFeign predictionCatalogueServiceFeign;

    public PredictionDto makePrediction(MatchDto matchDto) {
        log.info("PredictionService.makePrediction called for gameId: " + matchDto.getGameId());
        PredictionDto predictionDto = new PredictionDto();
        predictionDto.setGameId(matchDto.getGameId());
        predictionDto.setPredictionCertainty(50.0);
        predictionDto.setPredictionResult("blue");
        predictionDto.setTimestamp(Time.now());

        savePredictionAsync(predictionDto);

        return predictionDto;
    }

    @Async
    public void savePredictionAsync(PredictionDto predictionDto) {
        log.info("PredictionService.savePredictionAsync called on thread: " + Thread.currentThread().getName());
        predictionCatalogueServiceFeign.savePrediction(predictionDto);
    }
}
