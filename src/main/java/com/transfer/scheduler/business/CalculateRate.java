package com.transfer.scheduler.business;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transfer.scheduler.exceptions.NoRateException;

@Component
public class CalculateRate {

	@Autowired
	private RateContext rateContext;

	public BigDecimal applyRate(BigDecimal value, LocalDate schedulerDate, LocalDate transferDate)
			throws NoRateException {
		Integer days = daysBetween(schedulerDate, transferDate);
		if (schedulerDate.equals(transferDate)) {
			rateContext.setRateContext(new RateA());
			return rateContext.calculateRate(value, new BigDecimal(days));
		} else if (days < 11) {
			rateContext.setRateContext(new RateB());
			return rateContext.calculateRate(value, new BigDecimal(days));
		} else {
			rateContext.setRateContext(new RateC());
			return rateContext.calculateRate(value, new BigDecimal(days));
		}
	}

	private Integer daysBetween(LocalDate schedulerDate, LocalDate transferDate) {
		return Period.between(schedulerDate, transferDate).getDays();
	}

}
