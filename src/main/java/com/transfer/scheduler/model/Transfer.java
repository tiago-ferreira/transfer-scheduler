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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destiny == null) ? 0 : destiny.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result + ((rate == null) ? 0 : rate.hashCode());
		result = prime * result + ((schedulerDate == null) ? 0 : schedulerDate.hashCode());
		result = prime * result + ((transferDate == null) ? 0 : transferDate.hashCode());
		result = prime * result + ((transferValue == null) ? 0 : transferValue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transfer other = (Transfer) obj;
		if (destiny == null) {
			if (other.destiny != null)
				return false;
		} else if (!destiny.equals(other.destiny))
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		if (rate == null) {
			if (other.rate != null)
				return false;
		} else if (!rate.equals(other.rate))
			return false;
		if (schedulerDate == null) {
			if (other.schedulerDate != null)
				return false;
		} else if (!schedulerDate.equals(other.schedulerDate))
			return false;
		if (transferDate == null) {
			if (other.transferDate != null)
				return false;
		} else if (!transferDate.equals(other.transferDate))
			return false;
		if (transferValue == null) {
			if (other.transferValue != null)
				return false;
		} else if (!transferValue.equals(other.transferValue))
			return false;
		return true;
	}
	
	

}
