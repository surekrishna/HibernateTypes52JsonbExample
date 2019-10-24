package com.krish.jsonb.HibernateTypes52JsonbExample;

import java.io.Serializable;

public class Car implements Serializable {

	/**
	 * added generated serialVersionUID
	 */
	private static final long serialVersionUID = 6761286282657724554L;
	
	private String brand;
	private String country;
	
	public Car() {
		//no-arg constructor
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
