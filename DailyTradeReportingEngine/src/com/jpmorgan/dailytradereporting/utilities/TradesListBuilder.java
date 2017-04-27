/**
 * 
 */
package com.jpmorgan.dailytradereporting.utilities;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Locale;
import java.util.Vector;
import com.jpmorgan.dailytradereporting.to.SettledTrade;
/**
 * @author Mauro Nenci
 * 
 *         Utility class that helps to load settled trades.
 */
public class TradesListBuilder {
	/**
	 * Load settled trades.
	 * 
	 * @return a collection of settled trades
	 * @throws Exception
	 */
	public Collection<SettledTrade> loadSettledTrades() throws Exception {
		SimpleDateFormat _format = new SimpleDateFormat("dd MMM yyyy", Locale.UK);
		Collection<SettledTrade> tradesList = new Vector<SettledTrade>();
		SettledTrade _settledTrade;
		_settledTrade = new SettledTrade();
		_settledTrade.setEntity("foo1");
		_settledTrade.setInstruction("B");
		_settledTrade.setAgreedFx(0.50);
		_settledTrade.setCurrency("SGP");
		_settledTrade.setInstructionDate(_format.parse("01 Jan 2016"));
		_settledTrade.setOriginalSettlementDate(_format.parse("02 Jan 2016"));
		_settledTrade.setUnits(200);
		_settledTrade.setPricePerUnit(100.25);
		tradesList.add(_settledTrade);
		_settledTrade = new SettledTrade();
		_settledTrade.setEntity("foo2");
		_settledTrade.setInstruction("B");
		_settledTrade.setAgreedFx(0.75);
		_settledTrade.setCurrency("EUR");
		_settledTrade.setInstructionDate(_format.parse("24 Feb 2016"));
		_settledTrade.setOriginalSettlementDate(_format.parse("27 Feb 2016"));
		_settledTrade.setUnits(10);
		_settledTrade.setPricePerUnit(230.25);
		tradesList.add(_settledTrade);
		_settledTrade = new SettledTrade();
		_settledTrade.setEntity("foo3");
		_settledTrade.setInstruction("B");
		_settledTrade.setAgreedFx(1.25);
		_settledTrade.setCurrency("SAR");
		_settledTrade.setInstructionDate(_format.parse("13 Mar 2016"));
		_settledTrade.setOriginalSettlementDate(_format.parse("15 Mar 2016"));
		_settledTrade.setUnits(250);
		_settledTrade.setPricePerUnit(30.00);
		tradesList.add(_settledTrade);
		_settledTrade = new SettledTrade();
		_settledTrade.setEntity("bar1");
		_settledTrade.setInstruction("S");
		_settledTrade.setAgreedFx(0.22);
		_settledTrade.setCurrency("AED");
		_settledTrade.setInstructionDate(_format.parse("05 Jan 2016"));
		_settledTrade.setOriginalSettlementDate(_format.parse("07 Jan 2016"));
		_settledTrade.setUnits(450);
		_settledTrade.setPricePerUnit(150.5);
		tradesList.add(_settledTrade);
		_settledTrade = new SettledTrade();
		_settledTrade.setEntity("bar2");
		_settledTrade.setInstruction("S");
		_settledTrade.setAgreedFx(0.44);
		_settledTrade.setCurrency("GBP");
		_settledTrade.setInstructionDate(_format.parse("01 Apr 2016"));
		_settledTrade.setOriginalSettlementDate(_format.parse("04 Apr 2016"));
		_settledTrade.setUnits(1000);
		_settledTrade.setPricePerUnit(15.25);
		tradesList.add(_settledTrade);
		_settledTrade = new SettledTrade();
		_settledTrade.setEntity("bar3");
		_settledTrade.setInstruction("S");
		_settledTrade.setAgreedFx(2.35);
		_settledTrade.setCurrency("CHF");
		_settledTrade.setInstructionDate(_format.parse("23 Jun 2016"));
		_settledTrade.setOriginalSettlementDate(_format.parse("25 Jun 2016"));
		_settledTrade.setUnits(10);
		_settledTrade.setPricePerUnit(4500.50);
		tradesList.add(_settledTrade);
		return tradesList;
	}
}
