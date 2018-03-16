package com.transfer.scheduler.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers.BigDecimalDeserializer;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Transfer {
	private Account origin;
	private Account destiny;
	@JsonDeserialize(using=BigDecimalDeserializer.class)
	private BigDecimal transferValue;
	@JsonDeserialize(using=BigDecimalDeserializer.class)
	private BigDecimal rate;
	private LocalDate transferDate;
	private LocalDate schedulerDate;
	
	public Transfer() {
	}
	
	public Transfer(Account origin, Account destiny, BigDecimal transferValue, BigDecimal rate, LocalDate transferDate,
			LocalDate schedulerDate) {
		super();
		this.origin = origin;
		this.destiny = destiny;
		this.transferValue = transferValue;
		this.rate = rate;
		this.transferDate = transferDate;
		this.schedulerDate = schedulerDate;
	}

	public Account origin() {
		return origin;
	}

	public Transfer origin(Account origin) {
		this.origin = origin;
		return this;
	}

	public Account destiny() {
		return destiny;
	}

	public Transfer destiny(Account destiny) {
		this.destiny = destiny;
		return this;
	}

	public BigDecimal transferValue() {
		return transferValue;
	}

	public Transfer transferValue(BigDecimal transferValue) {
		this.transferValue = transferValue;
		return this;
	}

	public BigDecimal rate() {
		return rate;
	}

	public Transfer rate(BigDecimal rate) {
		this.rate = rate;
		return this;
	}

	public LocalDate transferDate() {
		return transferDate;
	}

	public Transfer transferDate(LocalDate transferDate) {
		this.transferDate = transferDate;
		return this;
	}

	public LocalDate schedulerDate() {
		return schedulerDate;
	}

	public Transfer schedulerDate(LocalDate schedulerDate) {
		this.schedulerDate = schedulerDate;
		return this;
	}
	
	

}
