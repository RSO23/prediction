package rso.prediction.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import rso.prediction.dto.MatchDto;
import rso.prediction.dto.PredictionDto;
import rso.prediction.dto.SummonerNamesDto;
import rso.prediction.feign.PredictionCatalogueServiceFeign;

@Service
@RequiredArgsConstructor
public class PredictionService {

    private final Logger log = LoggerFactory.getLogger(PredictionService.class);


    private final PredictionCatalogueServiceFeign predictionCatalogueServiceFeign;

    public PredictionDto makePrediction(MatchDto matchDto, Long userId) {
        log.info("makePrediction called for gameId: " + matchDto.getGameId());
        PredictionDto predictionDto = new PredictionDto();
        predictionDto.setTeam(100);
        predictionDto.setPredictionCertainty(50.0);
        predictionDto.setPredictionResult(true);
        predictionDto.setTimestamp(System.currentTimeMillis());
        predictionDto.setUserId(userId);
        predictionDto.setGameId(matchDto.getGameId());

        savePredictionAsync(predictionDto);

        return predictionDto;
    }

    public PredictionDto makePredictionsSummoners(SummonerNamesDto summonerNamesDto) {
        log.info("makePredictionsSummoners called");
        PredictionDto predictionDto = new PredictionDto();
        predictionDto.setTeam(summonerNamesDto.getTeam());
        predictionDto.setPredictionCertainty(50.0);
        predictionDto.setPredictionResult(true);
        predictionDto.setTimestamp(System.currentTimeMillis());
        predictionDto.setUserId(summonerNamesDto.getUserId());
        predictionDto.setGameId(summonerNamesDto.getGameId());
        predictionDto.setWinner(summonerNamesDto.getWinner());

        savePredictionAsync(predictionDto);

        return predictionDto;
    }

    @Async
    public void savePredictionAsync(PredictionDto predictionDto) {
        log.info("PredictionService.savePredictionAsync called on thread: " + Thread.currentThread().getName());
        predictionCatalogueServiceFeign.savePrediction(predictionDto);
    }
}
