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
public class ClassifiedStaff extends Employee{
    private double weeklySalary;
    private String division;

    /**
     *
     * @param name
     * @param number
     * @param working
     * @param salary
     * @param div
     */
    public ClassifiedStaff(String name, int number, boolean working, double salary, String div) {
        super(name, number, working);
        
        weeklySalary = salary;
        division = div;
    }
    
    /**
     *
     * @return toString
     */
    @Override
    public String toString(){
        return super.employeeName + "\t" + super.employeeId  + "\t" + super.isWorking + "\t" + weeklySalary + "\t" + division;
    }
    
    /**
     *
     * @return bi-weekly pay
     */
    @Override
    public double getPay(){
        return Math.round(weeklySalary * 200);
    }
    
    
}
