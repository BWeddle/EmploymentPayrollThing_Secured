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
public abstract class Employee {

    /**
     *
     */
    protected String employeeName;

    /**
     *
     */
    protected int employeeId;

    /**
     *
     */
    protected boolean isWorking;
    
    /**
     *
     * @param name
     * @param number
     * @param employed
     */
    protected Employee(String name, int number, boolean employed){
        employeeName = name;
        employeeId = number;
        isWorking = employed;
    }

    /**
     *
     * @return Name
     */
    public String getName() {
        return employeeName;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        employeeName = name;
    }

    /**
     *
     * @return employeeId
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     *
     * @param number
     */
    public void setEmployeeId(int number) {
        employeeId = number;
    }

    /**
     *
     * @return isWorking
     */
    public boolean isWorking() {
        return isWorking;
    }

    /**
     *
     * @param employed
     */
    public void setIsWorking(boolean employed) {
        isWorking = employed;
    }
    
    /**
     *
     * @return toString
     */
    @Override
    public String toString(){
        return (employeeName + "\t" + employeeId + "\t" + isWorking);
    }
    
    /**
     *
     * @return 
     */
    public abstract double getPay();
    
    
}
