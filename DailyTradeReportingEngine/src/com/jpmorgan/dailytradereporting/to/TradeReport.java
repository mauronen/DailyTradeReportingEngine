/**
 * 
 */
package com.jpmorgan.dailytradereporting.to;
import java.io.Serializable;
import java.util.TreeMap;
/**
 * @author Mauro Nenci
 * 
 *         Class that acts as Transfer Object for trade reports.
 *
 */
public class TradeReport implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private float dailyIncoming;
	/**
	 * 
	 */
	private float dailyOutcoming;
	/**
	 * 
	 */
	private TreeMap<Double, SettledTrade> dailyRankingIncoming;
	/**
	 * 
	 */
	private TreeMap<Double, SettledTrade> dailyRankingOutcoming;
	/**
	 * @return the dailyIncoming
	 */
	public float getDailyIncoming() {
		return dailyIncoming;
	}
	/**
	 * @param dailyIncoming
	 *            the dailyIncoming to set
	 */
	public void setDailyIncoming(float dailyIncoming) {
		this.dailyIncoming = dailyIncoming;
	}
	/**
	 * @return the dailyOutcoming
	 */
	public float getDailyOutcoming() {
		return dailyOutcoming;
	}
	/**
	 * @param dailyOutcoming
	 *            the dailyOutcoming to set
	 */
	public void setDailyOutcoming(float dailyOutcoming) {
		this.dailyOutcoming = dailyOutcoming;
	}
	/**
	 * @return the dailyRankingIncoming
	 */
	public TreeMap<Double, SettledTrade> getDailyRankingIncoming() {
		return dailyRankingIncoming;
	}
	/**
	 * @param dailyRankingIncoming
	 *            the dailyRankingIncoming to set
	 */
	public void setDailyRankingIncoming(TreeMap<Double, SettledTrade> dailyRankingIncoming) {
		this.dailyRankingIncoming = dailyRankingIncoming;
	}
	/**
	 * @return the dailyRankingOutcoming
	 */
	public TreeMap<Double, SettledTrade> getDailyRankingOutcoming() {
		return dailyRankingOutcoming;
	}
	/**
	 * @param dailyRankingOutcoming
	 *            the dailyRankingOutcoming to set
	 */
	public void setDailyRankingOutcoming(TreeMap<Double, SettledTrade> dailyRankingOutcoming) {
		this.dailyRankingOutcoming = dailyRankingOutcoming;
	}
}
