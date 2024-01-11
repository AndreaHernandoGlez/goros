package org.goros.models.ngram;

import java.util.*;
import java.util.stream.Collectors;

public class NGramModel {
    private final int n;
    private final Map<String, Map<String, Integer>> nGrams;

    public NGramModel(int n) {
        this.n = n;
        this.nGrams = new HashMap<>();
    }

    public void train(List<String> tokens) {
        for (int i = 0; i <= tokens.size() - n; i++) {
            String key = String.join(" ", tokens.subList(i, i + n - 1));
            String nextToken = tokens.get(i + n - 1);

            nGrams.putIfAbsent(key, new HashMap<>());
            nGrams.get(key).merge(nextToken, 1, Integer::sum);
        }
    }

    public List<String> suggestNextTokens(String context) {
        Map<String, Integer> possibleNextTokens = nGrams.getOrDefault(context, Collections.emptyMap());
        return possibleNextTokens.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}

