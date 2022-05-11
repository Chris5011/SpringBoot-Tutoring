package dev.chris5011.projects.springtutoring.dependency_injection.car;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
//@Scope("prototype")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DieselEngine implements Engine{
    @Override
    public String start() {
        return "Starting Diesel Engine";
    }

    @Override
    public String accelerate() {
        return "Accelerating Diesel Engine";
    }

    @Override
    public String stop() {
        return "Stopping Diesel Engine";
    }
}
