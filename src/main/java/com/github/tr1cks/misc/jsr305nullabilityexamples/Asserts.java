package com.github.tr1cks.misc.jsr305nullabilityexamples;

import javax.annotation.Nullable;

public class Asserts {

    /**
     * For situations, when we definitely know that optional value cannot be null in current context.
     */
    public static <T> T notNull(@Nullable T obj) {
        if(obj == null) {
            throw new IllegalStateException();
        }
        return obj;
    }
}