package org.goros;

import org.goros.tokenizers.TokenizerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            File javaFile = new File("C:\\Users\\andre\\Desktop\\Andre Uni\\Tercero\\BD\\kmlkf.java");
            String javaCode = new String(Files.readAllBytes(Paths.get(javaFile.getPath())));
            TokenizerFactory factory = new TokenizerFactory();
            Tokenizer javaTokenizer = factory.getTokenizer(javaFile);
            List<String> javaTokens = javaTokenizer.tokenize(javaCode);
            System.out.println("Java Tokens: " + javaTokens);

            File pythonFile = new File("C:\\Users\\andre\\Desktop\\Andre Uni\\Cuarto\\PLN\\Ejercicios_PLN.py");
            String pythonCode = new String(Files.readAllBytes(Paths.get(pythonFile.getPath())));
            Tokenizer pythonTokenizer = factory.getTokenizer(pythonFile);
            List<String> pythonTokens = pythonTokenizer.tokenize(pythonCode);
            System.out.println("Python Tokens: " + pythonTokens);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
