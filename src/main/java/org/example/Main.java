package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    public static void main(String[] args) throws IOException {
        var keysPath = new ClassPathResource("keys.csv").getFile().getPath();
        var answersPath = new ClassPathResource("answers.csv").getFile().getPath();
        File keys = new File(keysPath);
        File answers = new File(answersPath);
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ResultsProcessorConfig.class);
        ResultsProcessor result = applicationContext.getBean(ResultsProcessor.class);
        result.result(keys, answers);

    }
}