package com;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringJmsApplicationTests {

	@Autowired
	Sender sender;

	@Autowired
	MessageCreateSender sender2;
	@Test
	void testSendAndRecieve()
	{
		sender.sendMessage("Hi Shreeja");
	}
	@Test
	void testSendAndRecieve2()
	{
		sender2.sendMessage2();
	}

}
