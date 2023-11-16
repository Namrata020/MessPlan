package tester;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.*;

import code.Customer;
import static utils.ValidationRules.*;
import static utils.CustUtils.*;
import static utils.IOUtils_mess.*;
import code.Plan;
import custom_exceptions.*;
import custom_sorting.*;
import utils.CustUtils;
import utils.ValidationRules;

public class TestMessPlan {	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		try(Scanner sc=new Scanner(System.in)){
		List<Customer> custList=populateCustomerList();
		boolean exit=false;
		while(!exit) {
			System.out.println();
			System.out.println("Options: ");
			System.out.println("1.Display All\n"+"2.Sign Up\n"+"3.Sign in\n"+"4.Change Password\n"+
			"5.Sort as per first name\n"+"6.Sort based on Plan\n"+"7.Sort based on registration date\n"+
			"8.Unsubscribe customer\n"+"9. Store Customer details\n"+"10. Read customer details from file\n"+"0.Exit\n");
			try {
				switch(sc.nextInt()) {
				case 1:
					for(Customer c:custList) {
						c.setPlanEndDate(assignEndDate(c.getRegisterDate(),c.getPln(),c));
						c.setFinal_amount(c.getPln().getMonthCost());
						validatePlanAmount(c.getPln(),c.getFinal_amount());
						System.out.println(c);
					}
					break;
					
				case 2:
					System.out.println("Available mess plans---");
					System.out.println("MONTHLY\n"+"QUARTERLY\n"+"HALFYEAR\n"+"YEARLY");
					System.out.println("Enter customer details: fname, lname, email, pwd, registerDate, phoneNo, pln, address");
					
					/*String fname, String lname, String email, String pwd, String rDate, String phoneNo,
					 * String plan, String address, List<Customer> custList*/
					
					Customer newC = validateAllInputs(sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),
							sc.next(),sc.next(),sc.next(),custList);	
					newC.setPlanEndDate(assignEndDate(newC.getRegisterDate(),newC.getPln(),newC));
					newC.setFinal_amount(newC.getPln().getMonthCost());
					validatePlanAmount(newC.getPln(),newC.getFinal_amount());
					custList.add(newC);
					System.out.println("Customer Signed Up successfully!!\n"+"Account Created...");
					System.out.println(newC);
					break;
					
				case 3:
					System.out.println("Enter email and password for sign in: ");
					newC=authenticateCustomer(sc.next(),sc.next(),custList);
					System.out.println("Successfully Signed inn!!"+newC);
					break;
					
				case 4:
					System.out.println("ENter email and password ");
					newC = authenticateCustomer(sc.next(),sc.next(),custList);
					System.out.println("Successfully Signed inn!!");
					System.out.print("Enter new password: ");
					//String newPass = sc.next();
					newC.setPwd(sc.next());
					System.out.println("Password changed successfully!!");
					break;
					
				case 5:
					Collections.sort(custList,new CustomerFnameComparator());
					System.out.println("---------------Sorted details based on First Name---------------");
					for(Customer li:custList)
						System.out.println(li);
					System.out.println("------------------------------------------------------------");
					break;
					
				case 6:
					Collections.sort(custList,new CustomerPlanComparator());
					System.out.println("---------------Sorted details based on Plan---------------");
					for(Customer i:custList)
						System.out.println(i);
					System.out.println("------------------------------------------------------------");
					break;
					
				case 7:
					Collections.sort(custList,new CustomerRegDateComparator());
					System.out.println("---------------Sorted details based on Registration Date---------------");
					for(Customer i:custList)
						System.out.println(i);
					System.out.println("------------------------------------------------------------");
					break;
					
				case 8:
					System.out.println("ENter mail to unsubscribe");
					int ind = validateIndex(sc.next(),custList);
					custList.remove(ind);
						System.out.println("----Successfully Unsubscribed from Plan----");
					break;
					
				case 9:
					System.out.println("Enter file name");
					sc.nextLine();
					String fileName = sc.nextLine();
					storeCustomerDetails(custList,fileName);
					System.out.println("Customer details stored successfully!!");
					break;
					
				case 10:
					System.out.println("Enter file name");
					sc.nextLine();
					BufferedReader br = new BufferedReader(new FileReader(sc.nextLine()));
					System.out.println("File data---");
					br.lines()
					.forEach(p -> System.out.println(p));
					System.out.println("---Data read over---");
					break;
				
				case 0:
					exit = true;
					System.out.println("Exiting the program");
					break;
				}
			}catch(Exception e) {
				e.printStackTrace();
				}
			}
		}

	}

}
