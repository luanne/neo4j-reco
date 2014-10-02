package com.graphaware.reco.transform;

import java.util.HashMap;
import java.util.Map;

/**
 * Base class for {@link ScoreTransformer} implementations.
 */
public abstract class BaseScoreTransformer implements ScoreTransformer {

    /**
     * {@inheritDoc}
     */
    @Override
    public <OUT> Map<OUT, Integer> transform(Map<OUT, Integer> scored) {
        Map<OUT, Integer> result = new HashMap<>();

        for (Map.Entry<OUT, Integer> pair : scored.entrySet()) {
            result.put(pair.getKey(), transform(pair.getValue()));
        }

        return result;
    }

    /**
     * Transform a single score value.
     *
     * @param score to transform.
     * @return transformedv value.
     */
    protected abstract int transform(int score);
}