/**
 * 
 */
package com.jpmorgan.dailytradereporting.junit;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import com.jpmorgan.dailytradereporting.controllers.DailyTradeReportingController;
import com.jpmorgan.dailytradereporting.utilities.TradesListBuilder;
/**
 * @author Mauro Nenci
 * 
 *         JUnit test class that tests {@link DailyTradeReportingController} class
 *
 */
public class DailyTradeReportingTestUnit {
	/**
	 * Instance of {@link DailyTradeReportingController}
	 */
	private DailyTradeReportingController reportController;
	/**
	 * Instance of TradesListBuilder
	 */
	private TradesListBuilder tradesListBuilder;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.reportController = new DailyTradeReportingController();
		this.tradesListBuilder = new TradesListBuilder();
	}
	/**
	 * Test method for {@link com.jpmorgan.dailytradereporting.controllers.DailyTradeReportingController#createReport(java.util.Collection)}.
	 */
	@Test
	public void testCreateReport() {
		try {
			this.reportController.createReport(this.tradesListBuilder.loadSettledTrades());
		} catch (Exception e) {
			fail("Test failed. Details are:" + e.getLocalizedMessage());
		}
	}
}
