package utils;

import java.time.LocalDate;
import java.util.List;

import code.Customer;
import code.Plan;
import custom_exceptions.InvalidInputException;
import custom_exceptions.AmountMismatchException;
import custom_exceptions.DuplicateEntryException;
import custom_exceptions.InvalidEmailException;

public class ValidationRules {

	public static void checkDup(String email,List<Customer> cust) throws DuplicateEntryException{
		Customer newCust = new Customer(email);
		if(cust.contains(newCust))
			throw new DuplicateEntryException("Duplicate entry Detected!!");
	}
	
	public static void validateEmail(String email,List<Customer> cust)throws InvalidEmailException{
		String pattern = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";
		if (!email.matches(pattern))
			throw new InvalidEmailException("Invalid email");
		}
	
	public static Plan parseAndValidatePlan(String plan)throws IllegalArgumentException {
		return Plan.valueOf(plan.toUpperCase());
	}
	
	public static void validatePlanAmount(Plan pln,double amount)throws AmountMismatchException{
		pln.setMonthCost(amount);
		if(pln.getMonthCost() != amount)
			throw new AmountMismatchException("Amount not matched with the plan amount!!");
	}
	
	public static LocalDate parseDate(String date) {
		return LocalDate.parse(date);
	}
	
	/*Validation and parsing are on:
registration date can be only todays date or after todays date and end date must be depend on plan selected
e.g if user reg date is 11/10/2023 and selected plan is of 1 year then end date set automatically as 11/12/2024
*/
	
	public static void validateDates(LocalDate regDate) throws IllegalArgumentException{
		if(!(regDate.isAfter(LocalDate.now())||regDate.isEqual(LocalDate.now())))
			throw new IllegalArgumentException("Invalid Date!!");
	}
	
	public static LocalDate assignEndDate(LocalDate regDate,Plan pln,Customer c)throws InvalidInputException{
		if(pln.HALFYEAR == c.getPln())
			c.setPlanEndDate(regDate.plusMonths(6));
		if(pln.MONTHLY == c.getPln())
			c.setPlanEndDate(regDate.plusMonths(1));
		if(pln.QUARTERLY == c.getPln())
			c.setPlanEndDate(regDate.plusMonths(9));
		if(pln.YEARLY == c.getPln())
			c.setPlanEndDate(regDate.plusMonths(12));
		
		return c.getPlanEndDate();
	}
	
	public static void validateNumber(String mobile) throws InvalidInputException{
		String phone="\\d{3,10}";
		if(!mobile.matches(phone))
			throw new InvalidInputException("Invalid Phone number!!");
	}
	
	public static Customer validateAllInputs(String fname, String lname, String email, String pwd, 
			String rDate, String phoneNo, String plan, String address, 
			List<Customer> custList)throws IllegalArgumentException,DuplicateEntryException,InvalidInputException,AmountMismatchException,InvalidEmailException{
		checkDup(email,custList);
		validateEmail(email,custList);
		Plan pln=parseAndValidatePlan(plan);
		LocalDate regDate = parseDate(rDate);
		validateDates(regDate);
		//assignEndDate(regDate,pln,newC);
		validateNumber(phoneNo);
		return new Customer(fname,lname,email,pwd,regDate,phoneNo,pln,address);
		}
		
	public static Customer authenticateCustomer(String email,String password,List<Customer> custList)
			throws InvalidEmailException{
		int index = custList.indexOf(new Customer(email));
		if(index == -1)
			throw new InvalidEmailException("Incorrect Email ID");
		Customer c=custList.get(index);
		if(!c.getPwd().equals(password))
			throw new InvalidEmailException("Incorrect Password");
		return c;
	}
	
	public static int validateIndex(String email,List<Customer> custList)throws InvalidInputException {
		int index = custList.indexOf(new Customer(email));
		if(index==-1)
			throw new InvalidInputException("Incorrect credentials!!");
		return index;
	}
	
}
