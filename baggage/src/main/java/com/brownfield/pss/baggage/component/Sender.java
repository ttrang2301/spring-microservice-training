package com.brownfield.pss.baggage.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.cloud.stream.annotation.Output;

@EnableBinding(BaggageSource.class)
@RefreshScope
@Component
public class Sender {
	private static final Logger logger = LoggerFactory.getLogger(Sender.class);

	public Sender() {

	}

	@Output(BaggageSource.BAGGAGEQ)
	@Autowired
	private MessageChannel messageChannel;

	public void send(Object message) {
		logger.info("Output BaggageQ:" + message.toString());
		boolean result = messageChannel.send(MessageBuilder.withPayload(message).build());
		logger.info("Result:" + result);
	}
}

interface BaggageSource {
	public static String BAGGAGEQ = "baggageQ";

	@Output(BaggageSource.BAGGAGEQ)
	public MessageChannel bagaggeQ();

}
