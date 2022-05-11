package dev.chris5011.projects.springtutoring.dependency_injection.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    /* Private Member Variable */
    private Engine engine;

    /* Constructor Injection */
    @Autowired
    public Car(Engine engine) {
        this.engine = engine;
    }

//    /* Field Injection */
//    @Autowired
//    private Engine engine;

//    /* Field Injection with Qualifier */
//    @Autowired
//    @Qualifier("gasoline")
//    private Engine engine;

//    /* Constructor Injection with renamed Parameter*/
//    @Autowired
//    public Car(Engine electricEngine) {
//        this.engine = electricEngine;
//    }

//    /* Setter Injection */
//    @Autowired
//    public void setEngine(Engine engine) {
//        this.engine = engine;
//    }

    //Getter and other Boilerplate Code
    public Engine getEngine() {
        return engine;
    }


}
