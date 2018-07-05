package com.brownfield.pss.checkin.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import com.brownfield.pss.checkin.component.CheckinComponent;

@Component
@EnableBinding(BaggageSink.class)
public class Receiver {
	private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

	@Autowired
	CheckinComponent checkinComponent;

	public Receiver() {

	}

	@ServiceActivator(inputChannel = BaggageSink.BAGGAGEQ)
	public void accept(Map<String, Object> baggageDetails) {
		logger.info("Baggage: [BAGGAGE_ID=" + baggageDetails.get("BAGGAGE_ID") + ", CHECKIN_ID="
				+ baggageDetails.get("CHECKIN_ID") + "]");
		System.out.println("Baggage: [BAGGAGE_ID=" + baggageDetails.get("BAGGAGE_ID") + ", CHECKIN_ID="
				+ baggageDetails.get("CHECKIN_ID") + "]");
	}
}

interface BaggageSink {
	public static String BAGGAGEQ = "baggageQ";

	@Input(BaggageSink.BAGGAGEQ)
	public MessageChannel checkInQ();

}