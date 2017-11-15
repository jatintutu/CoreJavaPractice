package core.java.dates;

import java.sql.Timestamp;
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
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

/**
 * 
java.util.Date to String conversion	java.text.DateFormat.format
String to java.util.Date conversion	java.text.DateFormat.parse
String to java.time.LocalDate conversion	java.time.LocalDate.parse(stringDate, java.time.format.DateTimeFormatter.ofPattern(input-date-format))
MM	Month in Number format
MMM	Month in English in short form
MMMM	Month in English in full form
dd	Date in 2 digits
d	Date in single digit
E (or) EEE	Day in shot form
EEEE	Day in full form
yyyy	Four digit year
HH	24 hours timeline
hh	12 hours timeline
mm	Minutes
ss	Seconds
a	AM/PM
Z	Time Zone
 *
 */
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
		LocalDate localDate3 = LocalDate.now(ZoneId.of("Aisa/Kolkata"));
	}

	@Test
	public void localTime() {
		LocalTime localTime = LocalTime.now();
		System.out.println("localTime : " + localTime);

		// TODO - create LocalDate object with now(Clock)
		Clock clock = Clock.systemUTC();
		LocalTime localTime2 = LocalTime.now(clock);
		// TODO - create LocalDate object with now(ZoneId)
		LocalTime localTime3 = LocalTime.now(ZoneId.of("Aisa/Kolkata"));
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

	@Test
	public void convertStringToUtilDate() throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		String inputDate1 = "25-Jan-2016";
		Date convertedDate1 = dateFormat.parse(inputDate1);
		System.out.println(convertedDate1);

		// Thursday, July 10 2017 12:10:08 PM
		String inputDate2 = "Thursday, July 10 2017 12:10:08 PM";
		DateFormat dateFormat2 = new SimpleDateFormat("EEEE, MMMM dd yyyy HH:mm:ss a");
		Date convertedDate2 = dateFormat2.parse(inputDate2);
		System.out.println(convertedDate2);

	}

	@Test
	public void convertStringToLocalDate() {
		// 10/07/2017
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate1 = LocalDate.parse("10/07/2017", formatter1);
		System.out.println(localDate1);

		// Thu, Jul 20 2017
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
		LocalDate localDate2 = LocalDate.parse("Thu, Jul 20 2017", formatter2);
		System.out.println(localDate2);

	}

	@Test
	public void convertStringToLocalDateTime() {
		// Thursday, Jul 10 2017 12:10:08 PM
		String date5 = "Thursday, Jul 20 2017 12:10:08 PM";
		DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("EEEE, MMM d yyyy HH:mm:ss a");
		LocalDateTime localDate5 = LocalDateTime.parse(date5, formatter4);
		System.out.println(localDate5);
	}

	@Test
	public void printDayFromDate() {
		int year = 2017;
		int month = 9;
		int date = 11;
		Calendar calender = Calendar.getInstance();
		calender.set(year, month, date);
		Date date1 = calender.getTime();
		DateFormat dateFormat1 = new SimpleDateFormat("EEEE");
		String dayName = dateFormat1.format(date1);
		System.out.println(dayName);

		DateFormat dateFormat2 = new SimpleDateFormat("E");
		String dayName2 = dateFormat2.format(date1);
		System.out.println(dayName2);

		LocalDate localDate = LocalDate.of(2017, 11, 25);
		String dayName3 = localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		System.out.println(dayName3);
	}

	@Test
	public void localDateTimeToTimeStamp() {
		LocalDateTime localDateTime = LocalDateTime.now();
		Timestamp timeStamp = Timestamp.from(localDateTime.toInstant(ZoneOffset.ofHours(0)));
		System.out.println(timeStamp);
	}

	@Test
	public void addMonthDayYearToUtilDate() {
		Calendar calendar = Calendar.getInstance();

		// Date date = new Date();
		// calendar.setTime(date);

		System.out.println(calendar.getTime());

		calendar.add(Calendar.DAY_OF_MONTH, 10);
		System.out.println(calendar.getTime());

		calendar.add(Calendar.MONTH, -2);
		System.out.println(calendar.getTime());

		calendar.add(Calendar.YEAR, 10);
		System.out.println(calendar.getTime());

		calendar.add(Calendar.MONTH, -2);
		System.out.println(calendar.getTime());

		calendar.add(Calendar.YEAR, -10);
		System.out.println(calendar.getTime());
	}

	@Test
	public void checkDate() throws ParseException {
		// method 1
		String inputDate = "20180710";
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = dateFormat.parse(inputDate);

		Instant instant = date.toInstant();
		ZoneId zoneId = ZoneId.of("Asia/Kolkata");
		LocalDate localDate = instant.atZone(zoneId).toLocalDate();

		LocalDate localDateToday = LocalDate.now();
		boolean isPastDate = localDate.isBefore(localDateToday);
		boolean isFutureDate = localDate.isAfter(localDateToday);
		System.out.println(isPastDate);
		System.out.println(isFutureDate);

		// method 2
		String inputDate2 = "20190814";
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDate localDate2 = LocalDate.parse(inputDate2, dateTimeFormatter);
		LocalDate today2 = LocalDate.now(Clock.systemDefaultZone());
		boolean isPast2 = localDate2.isBefore(today2);
		boolean isFuture2 = localDate2.isAfter(today2);
		System.out.println("inputDate2: " + localDate2 + ", today2: " + today2 + ", isPast2: " + isPast2
				+ ", isFuture: " + isFuture2);
	}

	@Test
	public void validateUtilDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		dateFormat.setLenient(false);
		String inputDate = "20170999";
		Date date;
		try {
			date = dateFormat.parse(inputDate);
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void validateUsingLocalDate() {
		// 20170999 - using java.time.LocalDate
		try {
			String date1 = "20170999";
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyyMMdd");
			LocalDate localDate1 = LocalDate.parse(date1, formatter1);
			System.out.println("localDate1: " + localDate1);
			System.out.println("formatter1.format(localDate1): " + formatter1.format(localDate1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void lengthOfTheMonth() {

	}

	/**
	 * year == 2017
	 * month == 7
	 * day == monday
	 * 
	 * Print date of all mondays in July-2017
	 */
	@Test
	public void getDatesOfDayOfWeekOfMonth() {

	}

	@Test
	public void convert12HoursDateTimeTo24Hours() throws ParseException {
		// JDK 7
		String date = "10-Aug-2017 07:56:12 PM";
		System.out.println("String: inputDate: " + date);
		SimpleDateFormat fromFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
		SimpleDateFormat toFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

		Date inputDate = fromFormat.parse(date);
		System.out.println("Date: inputDate: " + inputDate);

		String outputDate = toFormat.format(inputDate);
		System.out.println("JDK7: outputDate: " + outputDate);

		// Java 8
		String outputDate2 = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm:ss a"))
				.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss"));
		System.out.println("JDK8: outputDate: " + outputDate2);

	}
}
