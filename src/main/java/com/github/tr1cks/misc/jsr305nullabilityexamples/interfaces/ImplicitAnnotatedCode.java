package com.github.tr1cks.misc.jsr305nullabilityexamples.interfaces;

import com.github.tr1cks.misc.jsr305nullabilityexamples.NonNullByDefault;

import javax.annotation.Nullable;

@NonNullByDefault
public interface ImplicitAnnotatedCode {
    void methodWithNullableArg(@Nullable String arg);

    void methodWithNotNullArg(String arg);

    String methodWithNotNullReturn();

    @Nullable String methodWithNullableReturn();
}