package dev.chris5011.projects.springtutoring.dependency_injection.car;

import org.springframework.stereotype.Component;

@Component("gasoline")
public class GasolineEngine implements Engine {
    @Override
    public String start() {
        return "Starting Gasoline Engine";
    }

    @Override
    public String accelerate() {
        return "Accelerating Gasoline Engine";
    }

    @Override
    public String stop() {
        return "Stopping Gasoline Engine";
    }
}
