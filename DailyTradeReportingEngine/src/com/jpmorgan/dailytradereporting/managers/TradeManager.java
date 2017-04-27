/**
 * 
 */
package com.jpmorgan.dailytradereporting.managers;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import com.jpmorgan.dailytradereporting.to.SettledTrade;
import com.jpmorgan.dailytradereporting.to.Trade;
/**
 * @author Mauro Nenci
 * 
 *         Class that manages trades.
 *
 */
public class TradeManager {
	/**
	 * Instance of {@link CurrencyManager}
	 */
	private CurrencyManager currencyManager;
	/**
	 * Default constructor.
	 */
	public TradeManager() {
		currencyManager = new CurrencyManager();
	}
	/**
	 * This method checks if a day is a working date according to given working date and given currency.
	 * 
	 * @param workingDate
	 *            : a trade working date to be checked
	 * @param currency
	 *            : a trade currency linked to working date
	 * @return <i>true</i> if trade working date is a working day, otherwise will be <i>false</i>
	 * @throws Exception
	 */
	public boolean isWorkingDay(Date workingDate, String currency) throws Exception {
		boolean _isWorkingDay = false;
		try {
			List<String> workingWeek = currencyManager.getWorkingWeek(currency);
			Calendar calendarWorkingDate = GregorianCalendar.getInstance();
			calendarWorkingDate.setTime(workingDate);
			String displayName = calendarWorkingDate.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.UK).toUpperCase();
			if (workingWeek.contains(displayName))
				_isWorkingDay = true;
		} catch (Exception e) {
			throw new Exception("Error occoured in isWorkingDay() method. Cause=" + e.getMessage());
		}
		return _isWorkingDay;
	}
	/**
	 * Change settlement date to next valid working date.
	 * 
	 * @param settledTrade
	 *            : the settled trade that contains settlement date to be adjusted.
	 * @return : the settled trade with adjusted date or with original date.
	 */
	public SettledTrade adjustSettlementDay(SettledTrade settledTrade) throws Exception {
		Date dateToBeChecked = settledTrade.getAdjustedSettlementDate() != null ? settledTrade.getAdjustedSettlementDate() : settledTrade.getOriginalSettlementDate();
		Calendar calendarSettledDate = GregorianCalendar.getInstance();
		calendarSettledDate.setTime(dateToBeChecked);
		if (!this.isWorkingDay(dateToBeChecked, settledTrade.getCurrency())) {
			calendarSettledDate.roll(Calendar.DAY_OF_MONTH, true);
			settledTrade.setAdjustedSettlementDate(calendarSettledDate.getTime());
			settledTrade = adjustSettlementDay(settledTrade);
		}
		return settledTrade;
	}
	/**
	 * Checks if trade istruction is set to Buy ("B") or Sell ("S").
	 * 
	 * @param trade
	 *            : a trade with instruction to be checked.
	 * @return : <i>true</i> if instruction = "B", return <i>false</i> if instruction = "S", otherwise throws exception
	 * @throws Exception
	 */
	public boolean isBuy(Trade trade) throws Exception {
		if (trade.getInstruction() == "B") {
			return true;
		} else if (trade.getInstruction() == "S") {
			return false;
		} else {
			throw new Exception("Action must be 'B' or 'S'.");
		}
	}
}
