package dev.m3s.programming2.homework3;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Person {

    private String firstName = ConstantValues.NO_NAME;
    private String lastName = ConstantValues.NO_NAME;
    private String birthDate = ConstantValues.NOT_AVAILABLE;

    public Person(String lname, String fname) {
        setLastName(lname);
        setFirstName(fname);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName != null) {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName != null) {
            this.lastName = lastName;
        }
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String setBirthDate(String personId) {
        if (personId == null) {
            return "No change";
        }
        PersonID person = new PersonID();
        String result = person.setPersonID(personId);
        if (result == ConstantValues.INCORRECT_CHECKMARK || result == ConstantValues.INVALID_BIRTHDAY) {
            return "No change";
        }
        birthDate = person.getBirthDate();
        return birthDate;
    }

    protected int getRandomId(final int min, final int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public abstract String getIdString();

}
