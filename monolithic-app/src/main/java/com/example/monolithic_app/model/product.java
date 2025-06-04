package com.example.monolithic_app.model;

import jakarta.persistence.*;
@Entity
@Table(name = "product") 

public class product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	
	private Long id;
	@Column(nullable = false) 
	private String name;
	@Column(nullable = false) 
	private double price;
	
	public product() {}
	
	public product(String name, double price) { 
	
		this.name = name;
	
		this.price = price;
	}
	
	public Long getId() { 
	
		return id;
	}
	
	public void setId(Long id) { 
	
		this.id = id;
	}
	
	public String getName() { 
	
		return name;
	}
	
	public void setName(String name) { 
	
		this.name = name;
	}
	
	public double getPrice() { 
	
		return price;
	}
	
	public void setPrice(double price) { 
	
		this.price = price;
	}
}
