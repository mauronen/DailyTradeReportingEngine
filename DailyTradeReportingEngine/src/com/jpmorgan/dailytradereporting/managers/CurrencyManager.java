/**
 * 
 */
package com.jpmorgan.dailytradereporting.managers;
import java.util.List;
import java.util.Vector;
import com.jpmorgan.dailytradereporting.utilities.WorkingWeek;
/**
 * @author Mauro Nenci
 * 
 *         Class that manages currencies.
 *
 */
public class CurrencyManager {
	/**
	 * List of available currencies.
	 */
	private List<String> availableCurrencies;
	/**
	 * Default constructor.
	 */
	public CurrencyManager() {
		this.availableCurrencies = new Vector<String>();
		availableCurrencies.add("SGP");
		availableCurrencies.add("AED");
	}
	/**
	 * Returns a working week list according to given currency.
	 * 
	 * @param currency
	 *            : the currency key need to search working week
	 * @return : the working week linked to currency key
	 * @throws Exception
	 */
	public List<String> getWorkingWeek(String currency) throws Exception {
		List<String> _workingWeek = WorkingWeek.getInstance().loadWorkingWeek(currency);
		if (_workingWeek == null)
			throw new Exception("Unable to find a working week with given currency '" + currency + "'");
		return _workingWeek;
	}
}
