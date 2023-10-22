package ait.employee.dao;

import ait.employee.model.Employee;

import java.util.function.Predicate;

public class SalaryPredicate implements Predicate<Employee> {
    private double minSalary;
    private double maxSalary;

    public SalaryPredicate(double minSalary, double maxSalary) {
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    @Override
    public boolean test(Employee employee) {
        return employee.calcSalary() >= minSalary && employee.calcSalary() < maxSalary;
    }
}
