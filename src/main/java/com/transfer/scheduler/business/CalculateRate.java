package com.transfer.scheduler.business;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class CalculateRate {
	
	public BigDecimal applyRate(BigDecimal value, LocalDate schedulerDate, LocalDate transferDate) {
		Long days = daysBetween(schedulerDate, transferDate);
		return null;
	}
	
	private Long daysBetween(LocalDate schedulerDate, LocalDate transferDate) {
		return Duration.between(schedulerDate, transferDate).toDays();
	}
	 
}
