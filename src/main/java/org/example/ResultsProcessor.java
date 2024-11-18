package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSOutput;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@Component
public class ResultsProcessor {

    @Value("${group1.points}")
    private int group1Points;
    @Value("${group2.points}")
    private int group2Points;
    @Value("${group3.points}")
    private int group3Points;


    final FileReader fileReader;

    @Autowired
    public ResultsProcessor(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public void result(File keysFile, File answersFile) throws IOException {
        Map<Integer, String> mapKey = fileReader.getMapFromFile(keysFile);
        Map<Integer, String> mapAnswers = fileReader.getMapFromFile(answersFile);
        int res = 0;

        for (int i = 1; i <= 10; i++) {
            if (mapKey.containsKey(i)) {
                if (!mapAnswers.containsKey(i)) {
                    continue;
                }  if (i >= 1 && i <= 4 && mapKey.get(i).equals(mapAnswers.get(i))) {
                        res += group1Points;
                    }
                    if (i >= 5 && i <= 8 && mapKey.get(i).equals(mapAnswers.get(i))) {
                        res += group2Points;
                    }
                    if (i >= 9 && i <= 10 && mapKey.get(i).equals(mapAnswers.get(i))) {
                        res += group3Points;
                    }
            }
        }
        System.out.println("Total result: " + res);
    }
}