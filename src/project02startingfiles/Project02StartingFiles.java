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
        
        //INPUT VALIDATION!!!!!
        int security = validate(studentNum, staffNum, facultyNum, fileName);

        while(security != 0){
            System.out.println("This shit ain't safe");
            if (security == 1){
                System.out.println("Enter the name of the file: ");
                fileName = input.next();
            }
            else if(security == 2){
                System.out.println("Enter the number of students in the file: ");
                studentNum = input.nextInt();
                System.out.println("Enter the number of staff in the file: ");
                staffNum = input.nextInt();
                System.out.println("Enter the number of faculty in the file: ");
                facultyNum = input.nextInt();
            }
            security = validate(studentNum, staffNum, facultyNum, fileName);
        }
        
        //close user input scanner
        input.close();

        //Opening and read the file
        File empFile = new File(fileName);
        Scanner inputFile = new Scanner(empFile);
        
        //Initializing variables
        String line = "";
        String[] splitLine;
        
        //Calculate number of employees
        int empNumber = studentNum + staffNum + facultyNum;
        Employee[] workers = new Employee[empNumber];
        System.out.println("");
        
        //Set up employee array and splitting by using commas
        for (int i = 0; i < workers.length; i++){
            line = inputFile.nextLine();
            splitLine = line.split(",");
            workers[i] = newEmp(splitLine, i, studentNum, staffNum, facultyNum);
        }

        //Close File Scanner
        inputFile.close();
        
        //print out the contents of the array
        for (Employee i: workers) {
            System.out.println(i.toString());
        }
        System.out.println("");
        System.out.println("Pay for two-week pay period");
        System.out.println("===========================");
        
        //Printing two week pay to the screen/ Removed inactive employees
        for (Employee i: workers) {
            if (i.isWorking){
                System.out.println(i.getName() + "\t $" + i.getPay()/100);
            }
            else{
                System.out.print("");
            }
        }
    }

    private static int validate(int x, int y, int z, String file){
        int numLines = 0;
        int numLinesNeeded = x + y + z;
        //Opening and read the file
        File empFile = new File(file);
        Scanner inputFile;
        try{
            inputFile = new Scanner(empFile);
        }
        catch(Exception e){
            System.out.println("File not found, please try again");
            return 1;
        }

        for(int i = 0; i <= numLinesNeeded; i++){
            if(!inputFile.hasNextLine()){
                return 2;
            }
        }

        inputFile.close();

        return 0;
    }   

    private static Employee newEmp(String[] line, int num, int stu, int sta, int fac){
        String name = line[0];
        int idNum = Integer.parseInt(line[1]);
        boolean working = Boolean.parseBoolean(line[2]);
        int time;
        boolean workStudy;
        double rate;
        String dep;
        Employee worker = new StudentEmployee("Empty", 0, false, 0, false, 0);
        if(num<=(stu - 1)){
            time = Integer.parseInt(line[3]);
            workStudy = Boolean.parseBoolean(line[4]);
            rate = Double.parseDouble(line[5]);
            worker = new StudentEmployee(name, idNum, working, time, workStudy, rate);
        }
        else if(num<=(sta + stu - 1)){
            rate = Double.parseDouble(line[3]);
            dep = line[4];
            worker = new ClassifiedStaff(name, idNum, working, rate, dep);
        }
        else if(num<=(fac + sta + stu - 1)){
            rate = Double.parseDouble(line[3]);
            time = Integer.parseInt(line[4]);
            dep = line[5];
            worker = new Faculty(name, idNum, working, rate, time, dep);
        }
        
        return worker;
        

    }
}
