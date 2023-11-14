package utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import code.Customer;
import code.Plan;

public class CustUtils {
	public static List<Customer> populateCustomerList() {
		List<Customer> cust = new ArrayList<>();
		
		/*String fname, String lname, String email, String pwd,String rDate, String phoneNo,
		 * String plan, String address, double fAmount,List<Customer> custList*/
		
		cust.add(new Customer("kanchi","agrawal","k@gmail.com","asdf",LocalDate.parse("2001-06-22"),
				"1234",Plan.MONTHLY,"siddhi hostel"));
		cust.add(new Customer("namrata","pandey","n@gmail.com","ghjkl",LocalDate.parse("2000-12-20"),
						"2233",Plan.HALFYEAR,"siddhi hostel"));
		cust.add(new Customer("anshika","vishwakarma","A@gmail.com","rish",LocalDate.parse("2005-10-22"),
				"8877",Plan.YEARLY,"siddhi hostel"));
		cust.add(new Customer("jyoti","sahu","jy@gmail.com","bbhj",LocalDate.parse("2015-11-22"),
				"8877",Plan.QUARTERLY,"krishnayi hostel"));
		return cust;
		}
	}



