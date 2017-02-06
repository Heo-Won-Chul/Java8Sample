package sample;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;

public class LocalDateTest {

	private static final LocalDate nowDate = LocalDate.now();
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Now             : " + nowDate);
		System.out.println("Min             : " + LocalDate.MIN);
		System.out.println("Max             : " + LocalDate.MAX);
		
		System.out.println("==========================================");
		
		System.out.println("Day of Month    : " + nowDate.getDayOfMonth());
		System.out.println("Day of Year     : " + nowDate.getDayOfYear());
		System.out.println("Day of Week     : " + nowDate.getDayOfWeek());
		System.out.println("Month Value     : " + nowDate.getMonth());
		System.out.println("Month           : " + nowDate.getMonthValue());
		System.out.println("Year            : " + nowDate.getYear());
		System.out.println("BCE or CE       : " + nowDate.getEra());
		System.out.println("IS Leap Year    : " + nowDate.isLeapYear());
		
		System.out.println("==========================================");
		
		System.out.println("1992-07-08      : " + LocalDate.of(1992, 7, 8));
		System.out.println("Before 1 Day    : " + nowDate.minusDays(1));
	}
	
	@Test
	public void test() {
		assertThat(nowDate.isLeapYear()).isEqualTo(false);
	}

}
