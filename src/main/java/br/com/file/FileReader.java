package br.com.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {

    public List<String> read(List<File> files) {
        List<String> lines = files.stream().map(f -> {
            try {
                return Files.readAllLines(f.toPath());
            } catch (IOException e) {
                System.out.println("Error to read file: " + e.getMessage());
                return null;
            }
        }).flatMap(l -> l.stream()).collect(Collectors.toList());
        return lines;
    }
}
