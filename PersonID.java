package dev.m3s.programming2.homework3;

//import java.util.Calendar;
import java.lang.StringBuilder;

public class PersonID {

    private String birthDate = ConstantValues.NO_BIRTHDATE;

    public PersonID() {
       
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String setPersonID(final String idNumber) {
        if (checkPersonIDNumber(idNumber) == false) {
            return ConstantValues.INVALID_BIRTHDAY;
        }
        if (checkValidCharacter(idNumber) == false) {
            return ConstantValues.INCORRECT_CHECKMARK;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(idNumber.charAt(0));
        builder.append(idNumber.charAt(1));
        builder.append('.');
        builder.append(idNumber.charAt(2));
        builder.append(idNumber.charAt(3));
        builder.append('.');
        if (idNumber.charAt(6) == 'A') {
            builder.append("20");
        } else if (idNumber.charAt(6) == '-') {
            builder.append("19");
        } else {
            builder.append("18");
        }
        builder.append(idNumber.charAt(4));
        builder.append(idNumber.charAt(5));
        if (checkBirthdate(builder.toString()) == false) {
            return ConstantValues.INVALID_BIRTHDAY;
        }
        birthDate = builder.toString();
        return "Ok";
    }
    
    private boolean checkPersonIDNumber(final String s) {
        return (s.length() == 11 && "+-A".indexOf(s.charAt(6)) != -1 );
    }

    private boolean checkLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean checkValidCharacter(final String personID) {
        char c = personID.charAt(10);
        if (c == 'G' || c == 'I' || c == 'O' || c == 'Q') {
            return false;
        }
        int exp = 100000000;
        double num = 0.0;
        for (int i=0; i<6; i++) {
            num += exp * Character.getNumericValue(personID.charAt(i));
            exp = exp / 10;
        }
        for (int i=7; i<10; i++) {
            num += exp * Character.getNumericValue(personID.charAt(i));
            exp = exp / 10;
        }
        num = num / 31;
        num = num % 1;
        num = num * 31;
        int cmp = Character.getNumericValue(personID.charAt(10));
        if (cmp > 25) {
            cmp -= 4;
        } else if (cmp > 23) {
            cmp -= 3;
        } else if (cmp > 17) {
            cmp -= 2;
        } else if (cmp > 15) {
            cmp--;
        }
        if (cmp == (int) Math.round(num)) {
            return true;
        }
        return false;
    }

    private boolean checkBirthdate(final String date) {
        if (date.length() != 10) {
            return false;
        }
        for (int i = 0; i < 10; i++) {
            if (i != 2 && i != 5) {
                if (Character.getNumericValue(date.charAt(i)) > 9) {
                    return false;
                }
            }
        }
        int day = Character.getNumericValue(date.charAt(0)) * 10 + Character.getNumericValue(date.charAt(1));
        int month = Character.getNumericValue(date.charAt(3)) * 10 + Character.getNumericValue(date.charAt(4));
        int year = Character.getNumericValue(date.charAt(6)) * 1000 + Character.getNumericValue(date.charAt(7)) * 100 + 
        Character.getNumericValue(date.charAt(8)) * 10 + Character.getNumericValue(date.charAt(9));
        /*if (year > Calendar.getInstance().get(Calendar.YEAR)) {
            return false;
        } else if (year == Calendar.getInstance().get(Calendar.YEAR)) {
            if (month > Calendar.getInstance().get(Calendar.MONTH)) {
                return false;
            } else if (month == Calendar.getInstance().get(Calendar.MONTH)) {
                if (day > Calendar.getInstance().get(Calendar.DAY_OF_MONTH)) {
                    return false;
                }
            }
        }*/
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day > 0 && day <= 30) {
                return true;
            }
        } else if (month == 2) {
            if (day > 0 && day <= 28) {
                return true;
            } else if (day == 29) {
                return checkLeapYear(year);
            }
        } else {
            if (month < 1 || month > 12) {
                return false;
            }
            if (day > 0 && day <= 31) {
                return true;
            }
        }
        return false;
    }

}