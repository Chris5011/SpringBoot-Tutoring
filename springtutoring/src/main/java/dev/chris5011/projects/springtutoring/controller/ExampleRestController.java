package dev.chris5011.projects.springtutoring.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello-world")
public class ExampleRestController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello BIS-20!";
    }

    /* Das obige Beispiel hätte auch wie folgt geschrieben werden können: */
    @RequestMapping(path = "/hello2", method = RequestMethod.GET)
    public String hello2(){
        return "Hello BIS-20, again!";
    }

    /* Hier wird der name über die Resource-Location in der URL (/URI) erfasst */
    /* Dabei wäre es in diesem Beispiel nicht notwendig, den namen des Parameters anzugeben, da sie im Mapping und in Java genau gleich heißen */
    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable(name = "name") String name){
        return "Hello " + name;
    }
}
