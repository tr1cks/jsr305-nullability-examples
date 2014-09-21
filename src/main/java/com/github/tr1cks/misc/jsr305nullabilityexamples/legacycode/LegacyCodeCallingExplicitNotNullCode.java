package com.github.tr1cks.misc.jsr305nullabilityexamples.legacycode;

import com.github.tr1cks.misc.jsr305nullabilityexamples.newcode.ExplicitNotNullCode;

import javax.annotation.Nullable;
import java.util.Random;

public class LegacyCodeCallingExplicitNotNullCode {
    private ExplicitNotNullCode newCode;

    private void passNullableArg() {
        @Nullable String unknownString = null;
        if(new Random().nextBoolean()) {
            unknownString = "str";
        }

        newCode.methodWithNotNullArg(unknownString);
        newCode.methodWithNullableArg(unknownString);
        newCode.methodWithUnknownArg(unknownString);
    }

    private void checkNotNullReturn() {
        String str = newCode.methodWithNotNullReturn();

        if(str == null) {
            throw new RuntimeException();
        }
    }

    private void checkNullableReturn() {
        String str = newCode.methodWithNullableReturn();

        int length = str.length();
    }
}