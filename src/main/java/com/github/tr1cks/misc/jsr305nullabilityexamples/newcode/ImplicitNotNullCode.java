package com.github.tr1cks.misc.jsr305nullabilityexamples.newcode;

import com.github.tr1cks.misc.jsr305nullabilityexamples.NonNullByDefault;
import com.github.tr1cks.misc.jsr305nullabilityexamples.interfaces.ImplicitAnnotatedCode;

import javax.annotation.Nullable;

@NonNullByDefault
public class ImplicitNotNullCode {
    protected String notNullField = "str";
    protected @Nullable String nullableField;

    public void methodWithNullableArg(@Nullable String arg) {}
    public void methodWithNotNullArg(String arg) {}

    private void testMethodWithNullableArg() {
        methodWithNullableArg(notNullField);
        methodWithNullableArg(nullableField);
    }

    private void testMethodWithNotNullArg() {
        methodWithNotNullArg(notNullField);
        methodWithNotNullArg(nullableField);
    }

    public String methodWithNotNullReturn() { return "str"; }
    public @Nullable String methodWithNullableReturn() { return null; }

    private void testMethodsWithDifferentReturns() {
        int length;
        length = methodWithNotNullReturn().length();
        length = methodWithNullableReturn().length();
    }


    private void testMethodWithNullableReturn() {
        @Nullable String str1 = methodWithNotNullReturn();
        @Nullable String str2 = methodWithNullableReturn();
    }

    private void testMethodWithNullableReturn3() {
        String str1 = methodWithNotNullReturn();
        String str2 = methodWithNullableReturn();
    }


    private void checkUnknownMethodReturnWithNotNullLocalVar() {
        String str = System.getProperty("prop");

        if(str == null) {
            System.out.println();
        }
    }

    private void checkNotNullMethodReturnWithUnknownLocalVar() {
        String str = methodWithNotNullReturn();

        if(str == null) {
            System.out.println();
        }
    }
}