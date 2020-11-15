package rso.prediction.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "PREDICTIONS")
public class Prediction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long predictionId;

    @Column(name = "GAME_ID")
    private String gameId;

    @Column(name = "PREDICTION")
    private String prediction;

    @Column(name = "PREDICTION_CERTAINTY")
    private double predictionCertainty;

    @Column(name = "TIMESTAMP")
    private Timestamp timestamp;

    public Long getPredictionId() {
        return predictionId;
    }

    public void setPredictionId(Long predictionId) {
        this.predictionId = predictionId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }

    public double getPredictionCertainty() {
        return predictionCertainty;
    }

    public void setPredictionCertainty(double predictionCertainty) {
        this.predictionCertainty = predictionCertainty;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
