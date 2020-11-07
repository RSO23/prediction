package rso.prediction.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class PredictionDto {

    private String gameId;
    private String prediction;
    private double predictionCertainty;

    public PredictionDto(String gameId){
        this.gameId = gameId;
    }

    public String getGameId(){
        return gameId;
    }

    public void setGameId(String gameId){
        this.gameId = gameId;
    }

    public String getPrediction(){
        return prediction;
    }

    public void setPrediction(String prediction){
        this.prediction = prediction;
    }

    public double getPredictionCertainty(){
        return predictionCertainty;
    }

    public void setPredictionCertainty(Double predictionCertainty){
        this.predictionCertainty = predictionCertainty;
    }
}
