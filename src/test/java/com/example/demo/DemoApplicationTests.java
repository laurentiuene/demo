package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		String url = "ANAAREMEREMARE";
		byte[] urlBytes = url.getBytes();
		UUID urlUuid = UUID.nameUUIDFromBytes(urlBytes);
		assertEquals(UUID.nameUUIDFromBytes(urlBytes), urlUuid);
	}

}
