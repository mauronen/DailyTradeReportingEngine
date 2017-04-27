/**
 * 
 */
package com.jpmorgan.dailytradereporting.controllers;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import com.jpmorgan.dailytradereporting.managers.TradeManager;
import com.jpmorgan.dailytradereporting.to.SettledTrade;
import com.jpmorgan.dailytradereporting.to.TradeReport;
/**
 * @author Mauro Nenci
 * 
 *         Class that acts as controller for building daily reports of settled trades.
 *
 */
public class DailyTradeReportingController {
	/**
	 * Instance of {@link TradeManager}
	 */
	private TradeManager tradeManager;
	/**
	 * Default constructor.
	 */
	public DailyTradeReportingController() {
		this.tradeManager = new TradeManager();
	}
	/**
	 * Main method for creation of daily report.
	 * 
	 * @param tradesList
	 *            : the collection of settled trades
	 * @throws Exception
	 */
	public void createReport(Collection<SettledTrade> tradesList) throws Exception {
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("--- DAILY REPORT STARTED AT " + Calendar.getInstance().getTime().toString() + " ---");
		System.out.println("------------------------------------------------------------------------------");
		TradeReport report = generateTradeReport(tradesList);
		System.out.println("Amount of incoming settled everyday = " + NumberFormat.getInstance(Locale.US).format(report.getDailyIncoming()) + " USD");
		System.out.println("Amount of outgoing settled everyday = " + NumberFormat.getInstance(Locale.US).format(report.getDailyOutcoming()) + " USD");
		System.out.println("\nIncoming amount ranking:");
		printRanking(report.getDailyRankingIncoming().descendingMap().entrySet());
		System.out.println("Outcoming amount ranking:");
		printRanking(report.getDailyRankingOutcoming().descendingMap().entrySet());
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("--- DAILY REPORT ENDED AT " + Calendar.getInstance().getTime().toString() + " ---");
		System.out.println("------------------------------------------------------------------------------");
	}
	/**
	 * Method that interacts with model layer so to build a {@link TradeReport}
	 * 
	 * @param tradesList
	 *            : the collection of settled trades
	 * @return a {@link TradeReport} instance
	 * @throws Exception
	 */
	private TradeReport generateTradeReport(Collection<SettledTrade> tradesList) throws Exception {
		TradeReport _tradeReport = new TradeReport();
		_tradeReport.setDailyRankingIncoming(new TreeMap<Double, SettledTrade>());
		_tradeReport.setDailyRankingOutcoming(new TreeMap<Double, SettledTrade>());
		for (Iterator<SettledTrade> iterator = tradesList.iterator(); iterator.hasNext();) {
			SettledTrade trade = (SettledTrade) iterator.next();
			float amount = 0;
			trade = this.tradeManager.adjustSettlementDay(trade);
			if (this.tradeManager.isBuy(trade)) {
				amount = _tradeReport.getDailyIncoming();
				_tradeReport.setDailyIncoming(amount += trade.setAmount());
				_tradeReport.getDailyRankingIncoming().put(trade.getAmount(), trade);
			} else {
				amount = _tradeReport.getDailyOutcoming();
				_tradeReport.setDailyOutcoming(amount += trade.setAmount());
				_tradeReport.getDailyRankingOutcoming().put(trade.getAmount(), trade);
			}
		}
		return _tradeReport;
	}
	/**
	 * Utility method that produces rankings for incomings and outgoing entities.
	 * 
	 * @param ranking
	 *            : a set of rankings to be printed in standard output
	 */
	private void printRanking(Set<Entry<Double, SettledTrade>> ranking) throws Exception {
		if (ranking.isEmpty()) {
			System.out.println("There aren't any settled trades to rank.");
		} else {
			int rank = 0;
			for (Iterator<Entry<Double, SettledTrade>> iterator = ranking.iterator(); iterator.hasNext();) {
				rank++;
				Entry<Double, SettledTrade> rankedTrade = (Entry<Double, SettledTrade>) iterator.next();
				SimpleDateFormat _format = new SimpleDateFormat("dd MMM yyyy", Locale.UK);
				StringBuffer rankingString = new StringBuffer();
				rankingString.append("Rank = ");
				rankingString.append(rank);
				rankingString.append(" ; Entity = ");
				rankingString.append(rankedTrade.getValue().getEntity());
				rankingString.append(" ; Amount = ");
				rankingString.append(NumberFormat.getInstance(Locale.US).format(rankedTrade.getValue().getAmount()));
				rankingString.append(" USD");
				rankingString.append(" ; Original Settlement Date = ");
				rankingString.append(_format.format(rankedTrade.getValue().getOriginalSettlementDate()));
				Date adjustedSettlementDate = rankedTrade.getValue().getAdjustedSettlementDate();
				if (adjustedSettlementDate != null) {
					rankingString.append(" ; Adjusted Settlement Date = ");
					rankingString.append(_format.format(rankedTrade.getValue().getAdjustedSettlementDate()));
				}
				System.out.println(rankingString);
			}
		}
	}
}
