package de.lex.time;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeCalc {
	private static final BigDecimal SECOND_DIVISOR = new BigDecimal(1000);
	private static final BigDecimal MINUTE_DIVISOR = new BigDecimal(60000);

	public static void main(String[] args) {
		int timeInMs = 160400;
		
		String formatted = new SimpleDateFormat("mm:ss").format(new Date(timeInMs));
		System.out.println("With date = " + formatted);
		
		BigDecimal time = new BigDecimal(timeInMs);
		BigDecimal minutes = time.divide(MINUTE_DIVISOR, BigDecimal.ROUND_FLOOR);
		BigDecimal remainingAfterMinutes = time.remainder(MINUTE_DIVISOR);
		BigDecimal seconds = remainingAfterMinutes.divide(SECOND_DIVISOR, BigDecimal.ROUND_FLOOR);
		
		System.out.println("With BigDecimal = " + String.format("%02d:%02d", minutes.intValue(), seconds.intValue()));
		
	}
}
