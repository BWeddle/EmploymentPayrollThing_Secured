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
public class StudentEmployee extends Employee{
    private int hoursWorked;
    private boolean isWorkStudy;
    private double payRate;

    /**
     *
     * @param name
     * @param number
     * @param working
     * @param hours
     * @param workStudy
     * @param rate
     */
    public StudentEmployee(String name, int number, boolean working, int hours, boolean workStudy, double rate) {
        super(name, number, working);
        
        hoursWorked = hours;
        isWorkStudy = workStudy;
        payRate = rate;
    }
    
    /**
     *
     * @return toString
     */
    @Override
    public String toString(){
        return super.employeeName + "\t" + super.employeeId  + "\t" + super.isWorking+ "\t" + hoursWorked + "\t" + isWorkStudy + "\t" + payRate;
    }
    
    /**
     *
     * @return bi-weekly pay
     */
    @Override
    public double getPay(){
        return Math.round(hoursWorked * payRate * 100);
    }
    
}
