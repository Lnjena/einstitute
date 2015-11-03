package com.einstitute.core.domain.schedule;

import org.springframework.data.mongodb.core.mapping.Field;


public enum FrequencyType {
	
	
	WEEKLY {
		
	}, 
	FORTNIGHTLY {
		
	}, 
	MONTHLY {
		
	}, 
	QUARTERLY {
		
	}, 
	HALF_YEARLY {
		
	}, 
	ANNUALLY {
		
	},
	ON_DATES {
		@Field("on_dates")
		private int[] onDays;
	}, 
	ON_DAYS {
		@Field("on_days")
		private int[] onDays;
	},
	ON_MONTHS {
		@Field("on_days")
		private int[] onDays;
	},
	EVERY_N_DAYS {
		@Field("no_of_months")
		private int frequencyOfDays = 20;
	}, 
	EVERY_N_MONTHS {
			
		@Field("no_of_months")
		private int frequencyOfMonths = 4;	
	};	
	
	
	
	public enum DaysOfWeek {
		SUNDAY(0), MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6);
		
		private int intVal;
		
		private DaysOfWeek(){};
		
		private DaysOfWeek(int intVal) {
			this.setIntVal(intVal);
		}

		public int getIntVal() {
			return intVal;
		}

		public void setIntVal(int intVal) {
			this.intVal = intVal;
		}
	};
	
	public static enum MonthsOfYear {
		JAN(0), FEB(1), MAR(2), APR(3), MAY(4), JUN(5), JUL(6), AUG(7), SEP(8), OCT(9), NOV(10), DEC(11);
		
		private int intVal;
		
		private MonthsOfYear(){};
		
		private MonthsOfYear(int intVal){
			this.setIntVal(intVal);			
		}

		public int getIntVal() {
			return intVal;
		}

		public void setIntVal(int intVal) {
			this.intVal = intVal;
		};
	};
}
