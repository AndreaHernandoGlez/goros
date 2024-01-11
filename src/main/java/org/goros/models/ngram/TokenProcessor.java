package org.goros.models.ngram;

import java.util.List;

public interface TokenProcessor {
    void processTokens(List<String> tokens);
}
