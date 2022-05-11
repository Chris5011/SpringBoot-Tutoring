package dev.chris5011.projects.springtutoring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello-world2")
public class ExampleController {

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public @ResponseBody String hello() {
        return "Hello BIS-20!";
    }

    @RequestMapping(path = "/hello2", method = RequestMethod.GET)
    public String hello2() {
        return "Hello BIS-20, again!";
    }

    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET)
    public @ResponseBody String helloName(@PathVariable(name = "name") String name) {
        return "Hello " + name;
    }


}
