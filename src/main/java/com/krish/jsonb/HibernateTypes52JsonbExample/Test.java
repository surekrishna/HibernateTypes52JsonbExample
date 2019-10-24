package com.krish.jsonb.HibernateTypes52JsonbExample;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "test")
public class Test extends BaseTest {
	/**
	 * added generated serialVersionUID
	 */
	private static final long serialVersionUID = 2814199495304573251L;
	@Type(type = "jsonb")
	@Column(columnDefinition = "jsonb", nullable = true)
	@Basic(fetch = FetchType.LAZY)
	private List<Car> cars;
	
	/*
	 * @Type(type = "json")
	 * 
	 * @Column(columnDefinition = "json", nullable = true) private String wheels;
	 */
	
	/*
	 * @Type(type = "jsonb")
	 * 
	 * @Column(name="no_of_seats", columnDefinition = "jsonb", nullable = true)
	 * private Integer noOfSeats;
	 */
	
	public Test() {
		
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	/*
	 * public String getWheels() { return wheels; }
	 * 
	 * public void setWheels(String wheels) { this.wheels = wheels; }
	 */

	/*
	 * public Integer getNoOfSeats() { return noOfSeats; }
	 * 
	 * public void setNoOfSeats(Integer noOfSeats) { this.noOfSeats = noOfSeats; }
	 */
	
}
