# Prediction microservice
![Prediction](https://github.com/RSO23/prediction/workflows/Prediction/badge.svg)

Exposed on `localhost:8083`

#### Endpoints
Request: `http://localhost:8083/prediction/new_game_id`

Response:
```
{
    gameId: "new_game_id",
    prediction: "Victory",
    predictionCertainty: 99
}
```

Request: `http://localhost:8083/predictions`

Response (data from database):
```
[
    {
        predictionId: 1,
        gameId: "test_game_id",
        prediction: "Victory",
        predictionCertainty: 87.3000031,
        timestamp: "2020-11-15T15:46:30.395+00:00"
    }
]
```

#### Health checks
Request: `http://localhost:8083/actuator/health`. <br> It is also possible to check only `liveness` and `readines` on endpoint `/actuator/health/livenesss` and `/actuator/health/readiness`.

Response:
```
{
    status: "UP",
    components: {
        diskSpace: {
            status: "UP",
            details: {
                total: 499963174912,
                free: 236836245504,
                threshold: 10485760,
                exists: true
            }
        },
        livenessState: {
            status: "UP"
        },
        ping: {
            status: "UP"
        },
        readinessState: {
            status: "UP"
        }
    },
    groups: [
        "liveness",
        "readiness"
    ]
}
```
