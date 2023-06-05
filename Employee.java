package dev.m3s.programming2.homework3;

import java.util.Calendar;

public abstract class Employee extends Person implements Payment {

    private String empId;
    private int startYear;
    private Payment payment;

    public Employee(String lname, String fname) {
        super(lname, fname);
        startYear = Calendar.getInstance().get(Calendar.YEAR);
        empId = getEmployeeIdString() + super.getRandomId(2001, 3000);
    }

    public String getIdString() {
        return empId;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(final int startYear) {
        if (startYear > 2000 && startYear <= Calendar.getInstance().get(Calendar.YEAR)) {
            this.startYear = startYear;
        }
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        if (payment != null) {
            this.payment = payment;
        }
    }

    public double calculatePayment() {
        if (payment == null) {
            return 0.0;
        }
        return payment.calculatePayment();
    }

    protected abstract String getEmployeeIdString();

}