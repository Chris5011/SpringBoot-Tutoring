package dev.chris5011.projects.springtutoring.dependency_injection.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestCar {

    private final Car car;

    @Autowired
    public TestCar(Car car) {
        this.car = car;
    }

    public void run() {
        System.out.println(car.getEngine().start());
        System.out.println(car.getEngine().accelerate());
        System.out.println(car.getEngine().stop());
    }

}
