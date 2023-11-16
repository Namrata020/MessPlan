package utils;

import java.io.IOException;
import java.io.*;
import java.util.*;

import code.Customer;

public class IOUtils_mess {
	public static void storeCustomerDetails(List<Customer> cList, String fileName)throws IOException{
		try(PrintWriter pw = new PrintWriter(new FileWriter(fileName))){
		cList.stream()
		.forEach(p -> pw.println(p));
		}
	}
}
