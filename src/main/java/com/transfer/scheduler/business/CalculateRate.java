package com.transfer.scheduler.business;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transfer.scheduler.exceptions.NoRateException;

@Component
public class CalculateRate {

	@Autowired
	private RateContext rateContext;

	public BigDecimal applyRate(BigDecimal value, LocalDate schedulerDate, LocalDate transferDate)
			throws NoRateException {
		Long days = daysBetween(schedulerDate, transferDate);
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

	private Long daysBetween(LocalDate schedulerDate, LocalDate transferDate) {
		return ChronoUnit.DAYS.between(schedulerDate, transferDate);
	}

}
