package rso.prediction.entity;

import javax.persistence.*;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "predictions")
public class Prediction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long predictionId;

    @Column(name = "game_id")
    private String gameId;

    @Column(name = "prediction_result")
    private String predictionResult;

    @Column(name = "prediction_certainty")
    private double predictionCertainty;

    @Column(name = "timestamp")
    private Timestamp timestamp;
}

