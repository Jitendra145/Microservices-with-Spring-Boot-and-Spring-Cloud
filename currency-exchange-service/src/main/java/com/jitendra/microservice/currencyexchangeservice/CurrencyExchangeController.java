package com.jitendra.microservice.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment env;

	@Autowired
	private ExchangeValueRepository repository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}") // Path Param
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		/*
		 * ExchangeValue findByFromAndTo = repository.findByFromAndTo(from, to);
		 * ExchangeValue exchangeValue = new ExchangeValue(100L, from, to,
		 * BigDecimal.valueOf(65));
		 * exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port")))
		 * ;
		 */
		return exchangeValue;
	}

}
