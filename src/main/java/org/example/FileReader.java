package org.example;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class FileReader {

    public Map<Integer, String> getMapFromFile(File file) throws IOException {
        Map<Integer, String> result = new HashMap<>();
        try(BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))){
            String line;
            while((line = bufferedReader.readLine()) != null){
                String[] arrayLine = line.split("-");
                int key = Integer.parseInt(arrayLine[0]);
                result.put(key, arrayLine[1]);
            }
        }catch (IOException o){
            System.out.println("Something goes wrong in getMapFromFile method");
        }
        return result;
    }
}
