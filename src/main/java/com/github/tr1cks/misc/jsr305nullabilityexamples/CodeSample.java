package com.github.tr1cks.misc.jsr305nullabilityexamples;

import javax.annotation.Nullable;

public abstract class CodeSample {

    public void correctCode() {
        @Nullable User foundUser = findUserByName("vasya");

        if(foundUser == null) {
            System.out.println("User not found");
            return;
        }

        String fullName = Asserts.notNull(foundUser.getFullName());
        System.out.println(fullName.length());
    }

    public void incorrectCode() {
        User foundUser = findUserByName("vasya");

        String fullName = foundUser.getFullName();
        System.out.println(fullName.length());
    }

    public abstract @Nullable User findUserByName(String userName);

    private static class User {
        private String name;
        private @Nullable String fullName;

        public User(String name, @Nullable String fullName) {
            this.name = name;
            this.fullName = fullName;
        }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        @Nullable public String getFullName() { return fullName; }
        public void setFullName(@Nullable String fullName) { this.fullName = fullName; }
    }
}