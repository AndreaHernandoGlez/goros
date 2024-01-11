package org.goros.models.ngram;

import java.util.List;

public interface NGramModel {
    List<String> suggestNextTokens(String context);
}

