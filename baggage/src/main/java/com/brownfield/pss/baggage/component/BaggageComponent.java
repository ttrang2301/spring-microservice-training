package com.brownfield.pss.baggage.component;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.Component;

import com.brownfield.pss.baggage.entity.BaggageRecord;
import com.brownfield.pss.baggage.repository.BaggageRepository;

@EnableFeignClients
@RefreshScope
@Component
public class BaggageComponent {
	private static final Logger logger = LoggerFactory.getLogger(BaggageComponent.class);
   
	BaggageRepository baggageRepository;
	
	Sender sender;

	public BaggageComponent(){
		
	}
	
	@Autowired
	public BaggageComponent (BaggageRepository bookingRepository,
					  Sender sender){
		this.baggageRepository = bookingRepository;
 		this.sender = sender;
	}
	public long receive(BaggageRecord record) {
		//
		//return id;
		return 0;
	}

	public List<BaggageRecord> getBaggageOfCheckin(long checkinId) {
		return baggageRepository.findByCheckinId(checkinId);
	}
	
}

