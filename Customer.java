package code;

import java.time.LocalDate;

public class Customer {
		/*Customer id(int) , first name(String), 
		 * last name (String), email(String), password(String), 
		 * Address String, RegisterDate(LocalDate), 
		 * planEndDate(LocalDate), Address(String), 
		 * Phone No(String),plan Enum, final_amount double*/
		private int id;
		private String fname;
		private String lname;
		private String email;
		private String pwd;
		private LocalDate RegisterDate;
		private LocalDate planEndDate;
		private String phoneNo;
		private Plan pln;
		private String address;
		private double final_amount;
		private static int idGenerator;
		static {
			idGenerator = 1;
		}
		
		
		public Customer(String fname, String lname, String email, String pwd, LocalDate registerDate,
				String phoneNo, Plan pln, String address) {
			super();
			this.id = idGenerator++;
			this.fname = fname;
			this.lname = lname;
			this.email = email;
			this.pwd = pwd;
			RegisterDate = registerDate;
			//this.planEndDate = planEndDate;
			this.phoneNo = phoneNo;
			this.pln = pln;
			this.address = address;
		}
		
		public Customer(String email) {
			super();
			this.email=email;
		}

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getLname() {
			return lname;
		}
		public void setLname(String lname) {
			this.lname = lname;
		}
		public String getFname() {
			return fname;
		}
		public void setFname(String fname) {
			this.fname = fname;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public LocalDate getRegisterDate() {
			return RegisterDate;
		}
		public void setRegisterDate(LocalDate registerDate) {
			RegisterDate = registerDate;
		}
		public LocalDate getPlanEndDate() {
			return planEndDate;
		}
		public void setPlanEndDate(LocalDate planEndDate) {
			this.planEndDate = planEndDate;
		}
		public String getPhoneNo() {
			return phoneNo;
		}
		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}
		public Plan getPln() {
			return pln;
		}
		public void setPln(Plan pln) {
			this.pln = pln;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		
		@Override
		public boolean equals(Object anotherObj)
		{
			if(anotherObj instanceof Customer)
				return this.email.contentEquals(((Customer) anotherObj).email);
			return false;
		}

		public double getFinal_amount() {
			return final_amount;
		}

		public double setFinal_amount(double final_amount) {
			return this.final_amount = getPln().getMonthCost();
		}

		@Override
		public String toString() {
			return "Customer [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", pwd=" + pwd
					+ ", RegisterDate=" + RegisterDate + ", planEndDate=" + planEndDate + ", phoneNo=" + phoneNo
					+ ", pln=" + pln + ", address=" + address + ", final_amount=" + final_amount + "]";
		}
		
		
}

