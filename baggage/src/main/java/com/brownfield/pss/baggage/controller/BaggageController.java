package com.brownfield.pss.baggage.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brownfield.pss.baggage.component.BaggageComponent;
import com.brownfield.pss.baggage.entity.BaggageRecord;

@RestController
@CrossOrigin
@RequestMapping("/baggage")
public class BaggageController {
    private static final Logger LOG = LoggerFactory.getLogger(BaggageController.class.getName());

    BaggageComponent baggageComponent;

    @Autowired
    BaggageController (BaggageComponent bookingComponent) {
        this.baggageComponent = bookingComponent;
    }

    @RequestMapping(method = RequestMethod.POST)
    long book (@RequestBody BaggageRecord record) {
        LOG.info("Baggage : " + record);
        return baggageComponent.receive(record);
    }

    @RequestMapping(method = RequestMethod.GET)
    List<BaggageRecord> getBaggage (@RequestParam("checkin-id") Integer checkinId) {
        LOG.info("GetBaggage : " + checkinId);
		System.out.println("checkinId: " + checkinId);
        return baggageComponent.getBaggageOfCheckin(checkinId);
    }
}
