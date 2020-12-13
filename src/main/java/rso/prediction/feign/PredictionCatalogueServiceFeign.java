package rso.prediction.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import rso.prediction.dto.PredictionDto;

@FeignClient(name = "prediction-catalogue")
public interface PredictionCatalogueServiceFeign
{
    @PostMapping("/predictions/save")
    PredictionDto savePrediction(@RequestBody PredictionDto predictionDto);
}
