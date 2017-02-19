package sample;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

import org.junit.BeforeClass;
import org.junit.Test;

public class LocalDateTimeTest {

	private static final LocalDateTime nowDateTime = LocalDateTime.now();
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Now                 : " + nowDateTime);
		System.out.println("Min                 : " + LocalDateTime.MIN);
		System.out.println("Max                 : " + LocalDateTime.MAX);
		
		System.out.println("==========================================");
		
		System.out.println("Now to Date         : " + nowDateTime.toLocalDate());
		System.out.println("Now to Time         : " + nowDateTime.toLocalTime());
		
		System.out.println("==========================================");
		
		System.out.println("1992-07-08T00:00    : " + LocalDateTime.of(LocalDate.of(1992, 7, 8), LocalTime.of(0, 0, 0)));
		System.out.println("Set 1 Year          : " + nowDateTime.withYear(2016));
		
		System.out.println("==========================================");
		
		LocalDateTime standardDate = getStandardDateTime();
		DateTimeFormatter formatter = getSimpleDateTimeFormatter();
		System.out.println(standardDate.format(formatter) + " 기준");
		System.out.println(
				"- 기준일 01월 01일"                                                  + "\n" +
				standardDate.with(TemporalAdjusters.firstDayOfYear())                + "\n" +
						
				"- 기준일 12월 31일"                                                  + "\n" +
				standardDate.with(TemporalAdjusters.lastDayOfYear())                 + "\n" +
				
				"- 기준일 다음 해 01월 01일"                                           + "\n" +
				standardDate.with(TemporalAdjusters.firstDayOfNextYear())            + "\n" +
				
				"- 기준일 해당 달 01일"                                                + "\n" +
				standardDate.with(TemporalAdjusters.firstDayOfMonth())               + "\n" +
				
				"- 기준일 해당 달 마지막일"                                             + "\n" +
				standardDate.with(TemporalAdjusters.lastDayOfMonth())                + "\n" +
				
				"- 기준일 다음 달 01일"                                                + "\n" +
				standardDate.with(TemporalAdjusters.firstDayOfNextMonth())           + "\n" +
				
				"- 기준일 해당 달 첫번째 월요일"                                        + "\n" +
				standardDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY))  + "\n" +
				
				"- 기준일 해당 달 마지막 금요일"                                        + "\n" +
				standardDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY))   + "\n" +
				
				"- 기준일 다음 금요일"                                                 + "\n" +
				standardDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY))          + "\n" +
				
				"- 기준일 다음 금요일(당일 포함)"                                       + "\n" +
				standardDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY))    + "\n" +
				
				"- 기준일 이전 금요일"                                                 + "\n" +
				standardDate.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY))      + "\n" +
				
				"- 기준일 이전 금요일(당일 포함)"                                       + "\n" +
				standardDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.FRIDAY))
		);
	}
	
	private static LocalDateTime getStandardDateTime() {
		return LocalDate.of(2017, 2, 6).atStartOfDay();
	}
	
	private static DateTimeFormatter getSimpleDateTimeFormatter() {
		return DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
	}
	
	@Test
	public void test_isAfter() {
		// isAfter, isBefore, isEqual ...
		assertThat(nowDateTime.isAfter(nowDateTime.minusDays(1))).isEqualTo(true);
	}
	
	@Test
	public void test_Period1() {
		LocalDate standardDate = LocalDate.of(2017, 2, 7);
		LocalDate compareDate = LocalDate.of(2017, 2, 8);
		
		Period period = standardDate.until(compareDate);
		
		assertThat(period.getDays()).isEqualTo(1);
	}
	
	@Test
	public void test_Period2() {
		LocalDate standardDate = LocalDate.of(2017, 2, 8);
		LocalDate compareDate = LocalDate.of(2017, 2, 7);
		
		Period period = Period.between(standardDate, compareDate);
		assertThat(period.getDays()).isEqualTo(-1);
		
		Duration duration = Duration.between(standardDate.atTime(0,0),compareDate.atTime(0,0));
		assertThat(duration.toMinutes()).isEqualTo(-1 * (24 * 60));
	}
	
	@Test
	public void test_Duration() {
		LocalDate standardDate = LocalDate.of(2017, 2, 8);
		LocalDate compareDate = LocalDate.of(2017, 2, 7);
		
		Duration duration = Duration.between(standardDate.atTime(0,0),compareDate.atTime(0,0));
		assertThat(duration.toMinutes()).isEqualTo(-1 * (24 * 60));
	}
	
	@Test
	public void test_query() {
		LocalDate date = LocalDate.of(2017, 2, 7);
		
		TemporalQuery<Boolean> query = t -> {
			if(t.get(ChronoField.MONTH_OF_YEAR) == Month.FEBRUARY.getValue()) {
				return true;
			} else {
				return false;
			}
		};
		
		assertThat(date.query(query)).isEqualTo(true);
	}
}
