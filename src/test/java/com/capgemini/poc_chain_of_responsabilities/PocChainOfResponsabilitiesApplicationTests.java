package com.capgemini.poc_chain_of_responsabilities;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.poc_chain_of_responsabilities.domain.RuleRegistry;

@SpringBootTest
class PocChainOfResponsabilitiesApplicationTests {

	@Test
	void contextLoads() {
		RuleRegistry rr = new RuleRegistry();
		System.out.println("TEST");
		for (String key : rr.getRules().keySet()) System.out.println(key);

		System.out.println("END");
	}

}
