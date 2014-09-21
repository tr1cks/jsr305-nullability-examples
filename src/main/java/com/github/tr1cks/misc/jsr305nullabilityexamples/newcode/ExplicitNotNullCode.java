package com.github.tr1cks.misc.jsr305nullabilityexamples.newcode;

import com.github.tr1cks.misc.jsr305nullabilityexamples.interfaces.ImplicitAnnotatedCode;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ExplicitNotNullCode implements ImplicitAnnotatedCode {
    protected @Nonnull String notNullField = "str";
    protected @Nullable String nullableField;
    protected String unknownField;

    public void methodWithNullableArg(@Nullable String arg) {}
    public void methodWithNotNullArg(@Nonnull String arg) {}
    public void methodWithUnknownArg(String arg) {}

    private void testMethodWithNullableArg() {
        methodWithNullableArg(notNullField);
        methodWithNullableArg(nullableField);
        methodWithNullableArg(unknownField);
    }

    private void testMethodWithNotNullArg() {
        methodWithNotNullArg(notNullField);
        methodWithNotNullArg(nullableField);
        methodWithNotNullArg(unknownField);
    }

    private void testMethodWithUnknownArg() {
        methodWithUnknownArg(notNullField);
        methodWithUnknownArg(nullableField);
        methodWithUnknownArg(unknownField);
    }

    public @Nonnull String methodWithNotNullReturn() { return "str"; }
    public @Nullable String methodWithNullableReturn() { return null; }
    public String methodWithUnknownReturn() { return "str"; }

    private void testMethodsWithDifferentReturns() {
        int length;
        length = methodWithNotNullReturn().length();
        length = methodWithNullableReturn().length();
        length = methodWithUnknownReturn().length();
    }


    private void testMethodReturnWithNullableLocalVar() {
        @Nullable String str1 = methodWithNotNullReturn();
        @Nullable String str2 = methodWithNullableReturn();
        @Nullable String str3 = methodWithUnknownReturn();
    }

    private void testMethodReturnWithNotNullLocalVar() {
        @Nonnull String str1 = methodWithNotNullReturn();
        @Nonnull String str2 = methodWithNullableReturn();
        @Nonnull String str3 = methodWithUnknownReturn();
    }

    private void testMethodReturnWithUnknownLocalVar() {
        String str1 = methodWithNotNullReturn();
        String str2 = methodWithNullableReturn();
        String str3 = methodWithUnknownReturn();
    }


    private void checkUnknownMethodReturnWithUnknownLocalVar() {
        String str = System.getProperty("prop");

        if(str == null) {
            System.out.println();
        }
    }

    private void checkUnknownMethodReturnWithNotNullLocalVar() {
        @Nonnull String str = System.getProperty("prop");

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