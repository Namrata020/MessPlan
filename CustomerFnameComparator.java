package custom_sorting;

import java.util.Comparator;

import code.Customer;

public class CustomerFnameComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer c1, Customer c2) {
		if(!c1.getFname().equals(c2.getFname()))
			return c1.getFname().compareTo(c2.getFname());
		return 1;
	}
}
