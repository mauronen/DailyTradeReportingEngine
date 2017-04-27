/**
 * 
 */
package com.jpmorgan.dailytradereporting;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import com.jpmorgan.dailytradereporting.controllers.DailyTradeReportingController;
import com.jpmorgan.dailytradereporting.utilities.TradesListBuilder;
/**
 * @author Mauro Nenci
 * 
 *         Main class used to produce daily report. It runs in a single thread.
 *
 */
public class DailyTradeReportingEngine {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Executor executor = Executors.newSingleThreadExecutor();
		executor.execute(new Runnable() {
			public void run() {
				try {
					DailyTradeReportingController engineReport = new DailyTradeReportingController();
					TradesListBuilder tradesListBuilder = new TradesListBuilder();
					engineReport.createReport(tradesListBuilder.loadSettledTrades());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
