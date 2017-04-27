/**
 * 
 */
package com.jpmorgan.dailytradereporting.to;
/**
 * @author Mauro Nenci
 * 
 *         Class that extends {@link Trade}. It contains attributes and methods for settled trade.
 *
 */
public class SettledTrade extends Trade {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private double amount;
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * Set the calculated amount of a settled trade according to formula: pricePerUnit * units * agreedFx
	 * 
	 * @return
	 * @throws Exception
	 */
	public double setAmount() throws Exception {
		/*
		 * Parameters validation
		 */
		if (super.getPricePerUnit() <= 0)
			throw new Exception("Price per unit not set. It can't be null or zero");
		if (super.getUnits() <= 0)
			throw new Exception("Units not set. It can't be null or zero");
		if (super.getAgreedFx() <= 0)
			throw new Exception("Agreed FX not set. It can't be null or zero");
		this.amount = super.getPricePerUnit() * super.getUnits() * super.getAgreedFx();
		return this.amount;
	}
}
