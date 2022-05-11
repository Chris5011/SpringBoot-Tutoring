package dev.chris5011.projects.springtutoring.dependency_injection.car;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("electric")
public class ElectricEngine implements Engine {
    @Override
    public String start() {
        return "Starting Electric Engine";
    }

    @Override
    public String accelerate() {
        return "Accelerating Electric Engine";
    }

    @Override
    public String stop() {
        return "Stopping Electric Engine";
    }
}
