package core.java.dates;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.junit.Test;

public class DatePractice {

	// JDK8 Clock class
	@Test
	public void clock() {
		Clock clock = Clock.systemDefaultZone();
		System.out.println(" Clock obj : " + clock);
		System.out.println("clock.instant(): " + clock.instant());
		System.out.println("clock.millis() : " + clock.millis());
		System.out.println("clock.getZone() : " + clock.getZone());
	}

	@Test
	public void localDate() {
		LocalDate localDate = LocalDate.now();
		System.out.println("localDate : " + localDate);
		Clock clock = Clock.systemUTC();
		LocalDate localDate2 = LocalDate.now(clock);
		System.out.println("localDate2 : " + localDate2);

		// TODO - create LocalDate object with now(ZoneId)
	}

	@Test
	public void localTime() {
		LocalTime localTime = LocalTime.now();
		System.out.println("localTime : " + localTime);

		// TODO - create LocalDate object with now(Clock)

		// TODO - create LocalDate object with now(ZoneId)
	}

	@Test
	public void localDateTime() {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("localDateTime : " + localDateTime);

		// TODO - create LocalDate object with now(Clock)
		Clock clock = Clock.systemUTC();
		LocalDateTime localDateTime2 = LocalDateTime.now(clock);
		System.out.println("" + localDateTime2);
		// TODO - create LocalDate object with now(ZoneId)
		LocalDateTime localDateTime3 = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("" + localDateTime3);
	}

	@Test
	public void zonedDateTime() {
		ZonedDateTime zoneDateTime = ZonedDateTime.now();
		System.out.println("zoneDateTime : " + zoneDateTime);
		ZonedDateTime zonedDateTime2 = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("zonedDateTime2 :" + zonedDateTime2);
	}

	@Test
	public void utilDate() {
		Date date = new Date();
		System.out.println("date :" + date);
	}

	@Test
	public void duration() {
		LocalDateTime fromDateTime = LocalDateTime.of(2015, Month.NOVEMBER, 8, 8, 30);
		LocalDateTime toDateTime = LocalDateTime.of(2017, Month.JANUARY, 28, 12, 35);
		Duration duration = Duration.between(fromDateTime, toDateTime);
		System.out.println("duration is : " + duration);
		System.out.println("duration days : " + duration.toDays());
		System.out.println("Months:" + duration.toDays() / 30);
		System.out.println("Years : " + (duration.toDays() / 30) / 12);
	}

	@Test
	public void period() {
		Period period1 = Period.ofDays(10);
		System.out.println("" + period1.getDays());
		Period period2 = Period.of(5, 10, 20);
		System.out.println();
		LocalDate fromLocalDate = LocalDate.of(2015, Month.DECEMBER, 15);
		LocalDate toLocalDate = LocalDate.of(2017, 5, 25);
		Period period3 = Period.between(fromLocalDate, toLocalDate);
		System.out.println(period3.getDays() + "-" + period3.getMonths() + "-" + period3.getYears());

	}

	@Test
	public void chronoUnit() {
		LocalDateTime oldDate = LocalDateTime.of(1992, Month.JANUARY, 18, 5, 30, 20);
		LocalDateTime newDate = LocalDateTime.of(2017, Month.NOVEMBER, 9, 5, 30, 30);

		long years = ChronoUnit.YEARS.between(oldDate, newDate);
		long months = ChronoUnit.MONTHS.between(oldDate, newDate);
		long weeks = ChronoUnit.WEEKS.between(oldDate, newDate);
		long days = ChronoUnit.DAYS.between(oldDate, newDate);
		long hours = ChronoUnit.HOURS.between(oldDate, newDate);
		long minutes = ChronoUnit.MINUTES.between(oldDate, newDate);
		long seconds = ChronoUnit.SECONDS.between(oldDate, newDate);
		long milis = ChronoUnit.MILLIS.between(oldDate, newDate);
		long nano = ChronoUnit.NANOS.between(oldDate, newDate);
	}

	@Test
	public void convertUtilDateToLocalDate() {
		Date date = new Date();
		Instant instant = date.toInstant();
		ZoneId zoneId = ZoneId.of("Asia/Kolkata");
		LocalDate localDate = instant.atZone(zoneId).toLocalDate();
		System.out.println(localDate);

	}

	@Test
	public void convertLocalDateToUtilDate() {
		LocalDate localDate = LocalDate.now();
		ZoneId zoneId = ZoneId.of("Asia/Kolkata");
		Date date = Date.from(localDate.atStartOfDay(zoneId).toInstant());
		System.out.println(date);
		System.out.println(localDate);
	}

	@Test
	public void convertUtilDateToLocalDateTime() {
		Date date = new Date();
		Instant instant = date.toInstant();
		ZoneId zoneId = ZoneId.of("Asia/Kolkata");
		LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
		System.out.println("" + localDateTime);

	}

	@Test
	public void convertLocalDateTimeToUtilDate() {
		LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/Chicago"));
		System.out.println(localDateTime);
		ZoneId zoneId = ZoneId.systemDefault();
		Date date = Date.from(localDateTime.atZone(zoneId).toInstant());
		System.out.println(date);
		Date date2 = new Date();
		System.out.println(date2);
	}

	@Test
	public void convertUtilToLocalTime() {
		Date date = new Date();
		Instant instant = date.toInstant();
		ZoneId zoneId = ZoneId.systemDefault();
		LocalTime localTime = instant.atZone(zoneId).toLocalTime();
		System.out.println(localTime);
	}

	@Test
	public void convertUtilDateTozonedDateTime() {
		Date date = new Date();
		Instant instant = date.toInstant();
		ZoneId zoneId = ZoneId.of("America/Chicago");
		ZonedDateTime zonedDateTime = instant.atZone(zoneId);
		System.out.println(zonedDateTime);
	}

	@Test
	public void zonedDateTimeToUtilDate() {
		ZonedDateTime dateTime = ZonedDateTime.now();
		Date date = Date.from(dateTime.toInstant());
		System.out.println(date);

	}

	@Test
	public void localDateTimeToZonedDateTime() {
		LocalDateTime dateTime = LocalDateTime.now();
		ZonedDateTime zonedDateTime = dateTime.atZone(ZoneId.of("America/Chicago"));
		System.out.println(zonedDateTime);
	}

	@Test
	public void convertDateFormats() throws ParseException {
		/* convert date from yyyy-mm-dd to mm/dd/yyyy */
		DateFormat fromFormat1 = new SimpleDateFormat("yyyy-mm-dd");
		DateFormat toFormat1 = new SimpleDateFormat("mm/dd/yyyy");
		Date date1 = fromFormat1.parse("2017-01-25");
		String convertedDate1 = toFormat1.format(date1);
		System.out.println(convertedDate1);

		/* convert Thu Apr 20 22:52:16 IST 2017 to 2017/04/20 */
		DateFormat fromFormat2 = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		DateFormat toFormat2 = new SimpleDateFormat("yyyy/MM/dd");
		Date date2 = fromFormat2.parse("Thu Apr 20 22:52:16 IST 2017");
		String convertedDate2 = toFormat2.format(date2);
		System.out.println(convertedDate2);

		/* convert utilDate to yyyy/MM/dd */
		Date date = new Date();
		DateFormat toDateFormat3 = new SimpleDateFormat("yyyy/MM/dd");
		String convertedDate3 = toDateFormat3.format(date);
		System.out.println(convertedDate3);
	}
}
