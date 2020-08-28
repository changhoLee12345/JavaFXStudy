package hr.enums;

import java.util.Calendar;

enum Week {
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
}

enum Humans {
	MEN, WOMEN;
}

enum HumanRaces {
	YELLOW, BLACK, WHITE;
}

public class EnumExample {
	public static void main(String[] args) {
		Week today = getToday();
		System.out.println(today.name());

		setDay(Week.WEDNESDAY);
	}

	public static void setDay(Week today) {
		if (today.name().equals("WEDNESDAY")) {
			System.out.println("today is WednesDay");
		} else {
			System.out.println("today is not WednesDay");
		}
	}

	public static Week getToday() {
		Calendar now = Calendar.getInstance();
		Week today = null;
		if (now.get(Calendar.DAY_OF_WEEK) == 1) {
			today = Week.SUNDAY;
		} else if (now.get(Calendar.DAY_OF_WEEK) == 2) {
			today = Week.MONDAY;
		} else if (now.get(Calendar.DAY_OF_WEEK) == 3) {
			today = Week.TUESDAY;
		} else if (now.get(Calendar.DAY_OF_WEEK) == 4) {
			today = Week.WEDNESDAY;
		} else if (now.get(Calendar.DAY_OF_WEEK) == 5) {
			today = Week.THURSDAY;
		} else if (now.get(Calendar.DAY_OF_WEEK) == 6) {
			today = Week.FRIDAY;
		} else {
			today = Week.SATURDAY;
		}
		return today;
	}
}
