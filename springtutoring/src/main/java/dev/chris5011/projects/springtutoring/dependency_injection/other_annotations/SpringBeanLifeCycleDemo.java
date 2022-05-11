package dev.chris5011.projects.springtutoring.dependency_injection.other_annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SpringBeanLifeCycleDemo {

    private DemoBean demoBean;

    @Autowired
    public SpringBeanLifeCycleDemo(DemoBean demoBean) {
        this.demoBean = demoBean;
    }

    @PostConstruct
    public void init(){
        /* Hier kann dieses Spring-Bean initialisiert werden.
        *  Dabei kann hier auch schon auf das demoBean zugegriffen werden. */
    }

    @PreDestroy
    public void destroy(){
        /* Hier können Aufräumarbeiten durchgeführt werden */
    }
}
