package dev.chris5011.projects.springtutoring.dependency_injection.other_annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class TestValueAnnotation {

    @Value("springtutoring/src/main/resources/test.txt")
    private File textFile;

    public void run(){
        try(BufferedReader br = new BufferedReader(new FileReader(textFile))){
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
