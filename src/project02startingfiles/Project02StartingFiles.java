package project02startingfiles;
import java.io.*;
import java.util.*;

/**
 *
 * @author S530058
 */
public class Project02StartingFiles {

    /**
     *
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(System.in);
        //Set up user input
        System.out.println("Enter the number of students in the file: ");
        int studentNum = input.nextInt();
        System.out.println("Enter the number of staff in the file: ");
        int staffNum = input.nextInt();
        System.out.println("Enter the number of faculty in the file: ");
        int facultyNum = input.nextInt();
        System.out.println("Enter the name of the file: ");
        String fileName = input.next();
        
        //Opening and read the file
        File empFile = new File(fileName);
        Scanner inputFile = new Scanner(empFile);
        
        //Initializing variables
        String line = "";
        String[] splitLine;
        String name = "";
        int idNum = 0;
        boolean working = false;
        int time = 0;
        boolean workStudy = false;
        double rate = 0;
        String dep = "";
        
        //Calculate number of employees
        int empNumber = studentNum + staffNum + facultyNum;
        Employee[] workers = new Employee[empNumber];
        System.out.println("");
        
        //Set up employee array and splitting by using commas
        for (int i = 0; i < workers.length; i++){
            line = inputFile.nextLine();
            splitLine = line.split(",");
            name = splitLine[0];
            idNum = Integer.parseInt(splitLine[1]);
            
            if (splitLine[2].equals("TRUE")){
                working = true;
            }
            else if (splitLine[2].equals("FALSE")){
                working = false;
            }
            if (i <= (studentNum - 1)){
                time = Integer.parseInt(splitLine[3]);
                if(splitLine[4].equals("TRUE")){
                    workStudy = true;
                }
                rate = Double.parseDouble(splitLine[5]);
                workers[i] = new StudentEmployee(name, idNum, working, time, workStudy, rate);
            }
            else if (i <= (staffNum + studentNum - 1)) {
                rate = Double.parseDouble(splitLine[3]);
                dep = splitLine[4];
                workers[i] = new ClassifiedStaff(name, idNum, working, rate, dep);
            }
            else if (i <= (staffNum + studentNum + facultyNum - 1)) {
                rate = Double.parseDouble(splitLine[3]);
                time = Integer.parseInt(splitLine[4]);
                dep = splitLine[5];
                workers[i] = new Faculty(name, idNum, working, rate, time, dep);
            }
        }
        
        //print out the contents of the array
        for (Employee i: workers) {
            System.out.println(i.toString());
        }
        System.out.println("");
        System.out.println("Pay for two-week pay period");
        System.out.println("===========================");
        
        //Printing two week pay to the screen/ Removed inactive employees
        for (Employee i: workers) {
            if (i.isWorking == true){
                System.out.println(i.getName() + "\t $" + i.getPay()/100);
            }
            else{
                System.out.print("");
            }
        }
        
    }
    
}
