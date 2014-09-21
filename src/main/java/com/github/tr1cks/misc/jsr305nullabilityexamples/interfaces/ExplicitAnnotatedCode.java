package com.github.tr1cks.misc.jsr305nullabilityexamples.interfaces;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface ExplicitAnnotatedCode {
    void methodWithNullableArg(@Nullable String arg);

    void methodWithNotNullArg(@Nonnull String arg);

    @Nonnull String methodWithNotNullReturn();

    @Nullable String methodWithNullableReturn();
}