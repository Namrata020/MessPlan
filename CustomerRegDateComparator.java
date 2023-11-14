package custom_sorting;

import java.util.Comparator;

import code.Customer;

public class CustomerRegDateComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer c1, Customer c2) {
		if(!c1.getRegisterDate().equals(c2.getRegisterDate()))
			return c1.getRegisterDate().compareTo(c2.getRegisterDate());
		return 1;
	}
}
