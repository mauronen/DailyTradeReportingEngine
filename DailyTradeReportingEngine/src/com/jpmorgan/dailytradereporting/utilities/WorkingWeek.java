/**
 * 
 */
package com.jpmorgan.dailytradereporting.utilities;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
/**
 * @author Mauro Nenci
 * 
 *         Singleton class that helps to load working weeks linked to currencies.
 *
 */
public class WorkingWeek {
	/**
	 * Instance of {@link WorkingWeek}
	 */
	private static WorkingWeek instance;
	/**
	 * Map of working weeks
	 */
	private static Map<String, List<String>> workingWeeks;
	/**
	 * Default private constructor
	 */
	private WorkingWeek() {
		workingWeeks = new HashMap<String, List<String>>();
		List<String> _SGPWorkingWeek = new Vector<String>();
		_SGPWorkingWeek.add("MONDAY");
		_SGPWorkingWeek.add("THURSDAY");
		_SGPWorkingWeek.add("WEDNESDAY");
		_SGPWorkingWeek.add("FRIDAY");
		workingWeeks.put("SGP", _SGPWorkingWeek);
		List<String> _EURWorkingWeek = new Vector<String>();
		_EURWorkingWeek.add("MONDAY");
		_EURWorkingWeek.add("THURSDAY");
		_EURWorkingWeek.add("WEDNESDAY");
		_EURWorkingWeek.add("FRIDAY");
		workingWeeks.put("EUR", _EURWorkingWeek);
		List<String> _GBPWorkingWeek = new Vector<String>();
		_GBPWorkingWeek.add("MONDAY");
		_GBPWorkingWeek.add("THURSDAY");
		_GBPWorkingWeek.add("WEDNESDAY");
		_GBPWorkingWeek.add("FRIDAY");
		workingWeeks.put("GBP", _GBPWorkingWeek);
		List<String> _CHFWorkingWeek = new Vector<String>();
		_CHFWorkingWeek.add("MONDAY");
		_CHFWorkingWeek.add("THURSDAY");
		_CHFWorkingWeek.add("WEDNESDAY");
		_CHFWorkingWeek.add("FRIDAY");
		workingWeeks.put("CHF", _CHFWorkingWeek);
		List<String> _AEDWorkingWeek = new Vector<String>();
		_AEDWorkingWeek.add("SUNDAY");
		_AEDWorkingWeek.add("MONDAY");
		_AEDWorkingWeek.add("THURSDAY");
		workingWeeks.put("AED", _AEDWorkingWeek);
		List<String> _SARWorkingWeek = new Vector<String>();
		_SARWorkingWeek.add("SUNDAY");
		_SARWorkingWeek.add("MONDAY");
		_SARWorkingWeek.add("THURSDAY");
		workingWeeks.put("SAR", _SARWorkingWeek);
	}
	/**
	 * Returns single instance of {@link WorkingWeek}
	 * 
	 * @return
	 */
	public static WorkingWeek getInstance() {
		if (instance == null)
			instance = new WorkingWeek();
		return instance;
	}
	/**
	 * Return a working week linked to a given currency.
	 * 
	 * @param currency
	 *            : a currency key
	 * @return a working week
	 * @throws Exception
	 */
	public List<String> loadWorkingWeek(String currency) throws Exception {
		return workingWeeks.get(currency);
	}
}
