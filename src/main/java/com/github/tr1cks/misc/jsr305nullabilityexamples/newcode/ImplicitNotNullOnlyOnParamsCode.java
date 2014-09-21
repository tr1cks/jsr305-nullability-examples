package com.github.tr1cks.misc.jsr305nullabilityexamples.newcode;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class ImplicitNotNullOnlyOnParamsCode {
    protected String notNullField = "str";
    protected @Nullable String nullableField;

    public void methodWithNullableArg(@Nullable String arg) {}
    public void methodWithNotNullArg(String arg) {}

    protected void testMethodWithNullableArg() {
        methodWithNullableArg(notNullField);
        methodWithNullableArg(nullableField);
    }

    protected void testMethodWithNotNullArg() {
        methodWithNotNullArg(notNullField);
        methodWithNotNullArg(nullableField);
    }

    public String methodWithNotNullReturn() { return "str"; }
    public @Nullable String methodWithNullableReturn() { return null; }

    protected void testMethodReturnWithNullableLocalVar() {
        int length;
        length = methodWithNotNullReturn().length();
        length = methodWithNullableReturn().length();
    }


    protected void testMethodReturnWithUnknownLocalVar() {
        @Nullable String str1 = methodWithNotNullReturn();
        @Nullable String str2 = methodWithNullableReturn();
    }

    protected void testMethodReturnWithNotNullLocalVar() {
        String str1 = methodWithNotNullReturn();
        String str2 = methodWithNullableReturn();
    }


    protected void checkUnknownMethodReturnWithNotNullLocalVar() {
        String str = System.getProperty("prop");

        if(str == null) {
            System.out.println();
        }
    }

    protected void checkNotNullMethodReturnWithUnknownLocalVar() {
        String str = methodWithNotNullReturn();

        if(str == null) {
            System.out.println();
        }
    }
}