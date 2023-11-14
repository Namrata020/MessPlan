package custom_sorting;

import java.util.Comparator;

import code.Customer;

public class CustomerPlanComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer c1, Customer c2) {
		if(!c1.getPln().equals((c2.getPln())))
			return c1.getPln().compareTo(c2.getPln());
		return 1;
	}
}
