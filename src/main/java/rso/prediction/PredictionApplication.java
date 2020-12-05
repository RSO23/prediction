package rso.prediction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
@SpringBootApplication
@ConfigurationPropertiesScan
public class PredictionApplication {

    private static final Logger log = LoggerFactory.getLogger(PredictionApplication.class);

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args){
        SpringApplication.run(PredictionApplication.class, args);
    }

    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        String dbUrl = applicationContext.getEnvironment().getProperty("spring.datasource.url");
        log.info("Connected to postgres: " + dbUrl);
    }

//    @Bean
//    public Hibernate5Module hibernate5Module() {
//        return new Hibernate5Module();
//    }
}
