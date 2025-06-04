package com.example.monolithic_app.model;
import jakarta.persistence.*;
@Entity
@Table(name = "user") 
public class user {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	
	private Long id;
	@Column(nullable = false) 
	
	private String name;
	@Column(nullable = false, unique = true) 
	
	private String email;
	
	public user() {}
	
	public user(String name, String email) { 
	
		this.name = name;
	
		this.email = email;
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
	
	public String getEmail() { 
	
		return email;

	}
	public void setEmail(String email) { 
		this.email = email;
	}
}

