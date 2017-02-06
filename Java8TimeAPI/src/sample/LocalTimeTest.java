package sample;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalTime;

import org.junit.BeforeClass;
import org.junit.Test;

public class LocalTimeTest {

	private static final LocalTime nowTime = LocalTime.now();
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Now             : " + nowTime);
		System.out.println("Min             : " + LocalTime.MIN);
		System.out.println("Max             : " + LocalTime.MAX);
		System.out.println("Noon            : " + LocalTime.NOON);
		System.out.println("Mid Night       : " + LocalTime.MIDNIGHT);
		
		System.out.println("==========================================");
		
		System.out.println("Now Hour        : " + nowTime.getHour());
		System.out.println("Now Minute      : " + nowTime.getMinute());
		System.out.println("Now Second      : " + nowTime.getSecond());
		
		System.out.println("==========================================");
		
		System.out.println("20:00           : " + LocalTime.of(20, 0, 0));
		System.out.println("After 1 Hours   : " + nowTime.plusHours(1));
	}
	
	@Test
	public void test() {
		assertThat(nowTime.compareTo(nowTime.plusHours(1))).isLessThan(1);
	}

}
