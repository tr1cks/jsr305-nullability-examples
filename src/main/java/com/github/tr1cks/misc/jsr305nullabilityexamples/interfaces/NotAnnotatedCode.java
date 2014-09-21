package com.github.tr1cks.misc.jsr305nullabilityexamples.interfaces;

public interface NotAnnotatedCode {
    void methodWithNullableArg(String arg);

    void methodWithNotNullArg(String arg);

    String methodWithNotNullReturn();

    String methodWithNullableReturn();
}