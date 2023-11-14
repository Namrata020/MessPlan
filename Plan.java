package code;

public enum Plan {
		 MONTHLY(3000), QUARTERLY(11700), HALFYEAR(17500), YEARLY(32000);
		private double monthCost;
		private Plan(double monthCost) {
			this.monthCost = monthCost;
		}
		public double getMonthCost() {
			return monthCost;
	    }
		public void setMonthCost(double monthCost) {
			this.monthCost = monthCost;
		}
		
}

