package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {
    
   public static void main(String[] args) throws ParseException {
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    System.out.print("Enter departments's name:");
    String departmentname= sc.nextLine();

    System.out.println("Enter worker data:");
    System.out.print("Name:");
    String workername= sc.nextLine();
    System.out.print("Level:");
    String workerlevel= sc.nextLine();
    System.out.print("Base salary:");
    double baseSalary= sc.nextDouble();

    Worker worker = new Worker(workername, WorkerLevel.valueOf(workerlevel), baseSalary, new Department(departmentname));

    System.out.println("How many contracts to this worker?");
    int n=sc.nextInt();

    for(int i=0;i<n;i++){
        System.out.println("Enter contract #"+(i+1)+" data:");
        System.out.print("Date (DD/MM/YYYY):");
        Date contractdate= sdf.parse(sc.next());
        System.out.print("Value per Hour:");
        double valueperhour = sc.nextDouble();
        System.out.print("Duration (Hours)");
        int hours = sc.nextInt();
        HourContract contract = new HourContract( contractdate, valueperhour, hours);
        worker.addContract(contract);
    }
    System.out.println();
    System.out.print("Enter month and year to calculate income(MM/YYYY):");
    String monthAndYear= sc.next();
    int month = Integer.parseInt(monthAndYear.substring(0,2));
    int year = Integer.parseInt(monthAndYear.substring(3));
    System.out.println("Name:"+worker.getName());
    System.out.println("Department:"+worker.getDepartment().getName());
    System.out.println("Income for "+monthAndYear+":"+String.format("%.2f", worker.income(year, month)));

    sc.close();
   }
}
