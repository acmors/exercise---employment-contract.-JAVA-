package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {
 	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter departament's name: ");
		String departamentName = scan.nextLine();
		
		System.out.println("Enter worker data: ");
		System.out.print("Name:");
		String workerName = scan.nextLine();
		System.out.print("Level:");
		String workerLevel = scan.nextLine();
		System.out.print("Base Salary:");
		double workerBaseSalary = scan.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerBaseSalary, new Departament(departamentName));
		
		System.out.println("How many contracts to this worker? ");
		int n = scan.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Enter contract number #" +i+" data:");
			System.out.print("Data (DD/MM/YYYY)");
			Date contractDate = sfd.parse(scan.next());
			System.out.print("Value per hour: ");
			double valuePerHour = scan.nextDouble();
			System.out.print("Duration: ");
			int hours = scan.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		System.out.println();
		
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = scan.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name" + worker.getName());
		System.out.println("Departament: " + worker.getDepartament().getName());
	//	System.out.println("Income for: " + monthAndYear + " " + String.format("%2.f", worker.income(year, month)));
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		
		
		
		scan.close();
	}

}
