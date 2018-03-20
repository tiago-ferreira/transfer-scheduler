package com.transfer.scheduler.controller.test;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.transfer.scheduler.dao.TransferDAO;
import com.transfer.scheduler.model.Account;
import com.transfer.scheduler.model.Transfer;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TransferControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	HttpHeaders headers = new HttpHeaders();

	private LocalDate today = LocalDate.now();

	Transfer transfer = new Transfer().origin(new Account("0123456")).destiny(new Account("0123458"))
			.transferDate(today).transferValue(new BigDecimal(50));

	@Test
	void testSave() {
		TransferDAO.clear();
		HttpEntity<Transfer> entity = new HttpEntity<Transfer>(transfer, headers);
		ResponseEntity<String> response = restTemplate.exchange("/transfer", HttpMethod.POST, entity, String.class);
		String expected = "{\"origin\":{\"number\":\"0123456\"},\"destiny\":{\"number\":\"0123458\"},\"transferValue\":50,\"rate\":4.5,\"transferDate\":\""
				+ transfer.transferDate().toString() + "\",\"schedulerDate\":\"" + today.toString() + "\"}";
		Assertions.assertEquals(expected, response.getBody());
	}

	@Test
	void testGetAll() {
		String response = restTemplate.getForObject("/transfer", String.class);
		String expected = "[{\"origin\":{\"number\":\"0123456\"},\"destiny\":{\"number\":\"0123458\"},\"transferValue\":50,\"rate\":4.5,\"transferDate\":\""
				+ transfer.transferDate().toString() + "\",\"schedulerDate\":\"" + today.toString() + "\"}]";
		Assertions.assertEquals(expected, response);
	}

	@Test
	void testSaveWithOldTransferDate() {
		transfer = new Transfer().origin(new Account("0123456")).destiny(new Account("0123458"))
				.transferDate(LocalDate.now().minusDays(2)).transferValue(new BigDecimal(50));
		HttpEntity<Transfer> entity = new HttpEntity<Transfer>(transfer, headers);
		ResponseEntity<String> response = restTemplate.exchange("/transfer", HttpMethod.POST, entity, String.class);
		Assertions.assertEquals(response.getStatusCodeValue(), 500);
		Assertions.assertTrue(response.getBody().contains("The transferDate cannot less than today."));
	}

	@Test
	void testSaveWithOriginAndDestinyEquals() {
		transfer = new Transfer().origin(new Account("0123456")).destiny(new Account("0123456"))
				.transferDate(LocalDate.now()).transferValue(new BigDecimal(50));
		HttpEntity<Transfer> entity = new HttpEntity<Transfer>(transfer, headers);
		ResponseEntity<String> response = restTemplate.exchange("/transfer", HttpMethod.POST, entity, String.class);
		Assertions.assertEquals(response.getStatusCodeValue(), 500);
		Assertions.assertTrue(response.getBody().contains("The destiny account cannot be equals the origin account."));
	}

	@Test
	void testSaveWithValueAndDaysIncorrectsToCalculateRate() {
		transfer = new Transfer().origin(new Account("0123456")).destiny(new Account("0123457"))
				.transferDate(LocalDate.now().plusDays(41)).transferValue(new BigDecimal(50000));
		HttpEntity<Transfer> entity = new HttpEntity<Transfer>(transfer, headers);
		ResponseEntity<String> response = restTemplate.exchange("/transfer", HttpMethod.POST, entity, String.class);
		System.out.println(response);
		Assertions.assertEquals(response.getStatusCodeValue(), 500);
		Assertions.assertTrue(response.getBody().contains(
				"Unable to calculate the rate for the value: $ 50000, and the number of days: 41 for the transfer."));
	}
}
