/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project02startingfiles;

/**
 *
 * @author S530058
 */
public class Faculty extends Employee{
    private double annualSalary;
    private int weeksPerYear;
    private String department;
    
    /**
     *
     * @param name
     * @param number
     * @param working
     * @param salary
     * @param weeks
     * @param dept
     */
    public Faculty(String name, int number, boolean working, double salary, int weeks, String dept){
        super(name, number, working);
        annualSalary = salary;
        weeksPerYear = weeks;
        department = dept;
    }
    
    /**
     *
     * @return toString
     */
    @Override
    public String toString(){
        return super.employeeName + "\t" + super.employeeId  + "\t" + super.isWorking + "\t" + annualSalary + "\t" + weeksPerYear + "\t" + department;
    }
    
    /**
     *
     * @return bi-weekly pay
     */
    @Override
    public double getPay(){
        return Math.round((annualSalary * 200) / weeksPerYear);
    }
}
