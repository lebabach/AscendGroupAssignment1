package assignment.domain.entity;

import java.time.LocalDateTime;
import java.time.format.*;

import assignment.domain.generic.GenericEntity;

public class Order extends GenericEntity {

	public String name;
	public double price;
	public LocalDateTime datetime;
 
     
	public Order(int id, boolean isDeletedFlag, String name, double price, LocalDateTime datetime) {
		super(id, isDeletedFlag);
		this.name = name;
		this.price = price;
		this.datetime = datetime;
	}

}
