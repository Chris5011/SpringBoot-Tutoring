package dev.chris5011.projects.springtutoring.dependency_injection.car;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarConfig {

    @Bean
    public Engine createGasolineEngine(){
        return new GasolineEngine();
    }

    @Bean
    public Engine createElectricEngine(){
        return new ElectricEngine();
    }


}
