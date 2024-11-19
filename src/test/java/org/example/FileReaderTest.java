package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {
        FileReader fileReader = new FileReader();
        String filePath = new ClassPathResource("keys.csv").getFile().getPath();
        File file = new File(filePath);

    FileReaderTest() throws IOException {
    }

    @Test
        void getMapFromFile () throws IOException {
            Map<Integer, String> res = fileReader.getMapFromFile(file);
            Assertions.assertTrue(res.containsKey(5));
        }
}