package com.brownfield.pss.baggage.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BaggageRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	Integer id;

	private String description;
	private Integer checkinId;

	public String getFlightNumber() {
		return description;
	}

	public void setFlightNumber(String flightNumber) {
		this.description = flightNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCheckinId() {
		return checkinId;
	}

	public void setCheckinId(Integer checkinId) {
		this.checkinId = checkinId;
	}

	@Override
	public String toString() {
		return "BaggageRecord [id=" + id + ", description=" + description + ", checkinId=" + checkinId + "]";
	}

}
