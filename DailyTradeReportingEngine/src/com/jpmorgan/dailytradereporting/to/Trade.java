/**
 * 
 */
package com.jpmorgan.dailytradereporting.to;
import java.io.Serializable;
import java.util.Date;
/**
 * @author Mauro Nenci
 * 
 *         Class that acts as Transfer object of attributes for a trade.
 *
 */
public abstract class Trade implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String entity;
	/**
	 * 
	 */
	private String instruction;
	/**
	 * 
	 */
	private double agreedFx;
	/**
	 * 
	 */
	private String currency;
	/**
	 * 
	 */
	private Date instructionDate;
	/**
	 * 
	 */
	private Date originalSettlementDate;
	/**
	 * 
	 */
	private Date adjustedSettlementDate;
	/**
	 * 
	 */
	private int units;
	/**
	 * 
	 */
	private double pricePerUnit;
	/**
	 * @return the entity
	 */
	public String getEntity() {
		return entity;
	}
	/**
	 * @param entity
	 *            the entity to set
	 */
	public void setEntity(String entity) {
		this.entity = entity;
	}
	/**
	 * @return the instruction
	 */
	public String getInstruction() {
		return instruction;
	}
	/**
	 * @param instruction
	 *            the instruction to set
	 */
	public void setInstruction(String action) {
		this.instruction = action;
	}
	/**
	 * @return the agreedFx
	 */
	public double getAgreedFx() {
		return agreedFx;
	}
	/**
	 * @param agreedFx
	 *            the agreedFx to set
	 */
	public void setAgreedFx(double agreedFx) {
		this.agreedFx = agreedFx;
	}
	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	/**
	 * @return the instructionDate
	 */
	public Date getInstructionDate() {
		return instructionDate;
	}
	/**
	 * @param instructionDate
	 *            the instructionDate to set
	 */
	public void setInstructionDate(Date instructionDate) {
		this.instructionDate = instructionDate;
	}
	/**
	 * @return the originalSettlementDate
	 */
	public Date getOriginalSettlementDate() {
		return originalSettlementDate;
	}
	/**
	 * @param originalSettlementDate
	 *            the originalSettlementDate to set
	 */
	public void setOriginalSettlementDate(Date originalSettlementDate) {
		this.originalSettlementDate = originalSettlementDate;
	}
	/**
	 * @return the adjustedSettlementDate
	 */
	public Date getAdjustedSettlementDate() {
		return adjustedSettlementDate;
	}
	/**
	 * @param adjustedSettlementDate
	 *            the adjustedSettlementDate to set
	 */
	public void setAdjustedSettlementDate(Date adjustedSettlementDate) {
		this.adjustedSettlementDate = adjustedSettlementDate;
	}
	/**
	 * @return the units
	 */
	public int getUnits() {
		return units;
	}
	/**
	 * @param units
	 *            the units to set
	 */
	public void setUnits(int units) {
		this.units = units;
	}
	/**
	 * @return the pricePerUnit
	 */
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	/**
	 * @param pricePerUnit
	 *            the pricePerUnit to set
	 */
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
}
