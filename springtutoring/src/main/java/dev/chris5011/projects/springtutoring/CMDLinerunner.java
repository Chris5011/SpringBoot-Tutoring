package dev.chris5011.projects.springtutoring;

import dev.chris5011.projects.springtutoring.dependency_injection.car.TestCar;
import dev.chris5011.projects.springtutoring.dependency_injection.other_annotations.TestValueAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CMDLinerunner implements CommandLineRunner {

    private TestCar testCar;

    private TestValueAnnotation testValueAnnotation;


    @Override
    public void run(String... args) {
        testCar.run();
        testValueAnnotation.run();
    }

    @Autowired
    public void setTestCar(TestCar testCar) {
        this.testCar = testCar;
    }

    @Autowired
    public void setTestValueAnnotation(TestValueAnnotation testValueAnnotation) {
        this.testValueAnnotation = testValueAnnotation;
    }
}
