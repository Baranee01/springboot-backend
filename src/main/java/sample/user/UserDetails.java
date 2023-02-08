package sample.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="userdetails", uniqueConstraints = @UniqueConstraint(columnNames = "name"))

public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(name = "name",nullable = false)
	String name;
	
	@Column(name = "email",nullable = false)
	String email;
	
	@Column(name = "password",nullable = false)
	String password;
	
	
	public UserDetails() {
		super();
	}


	public UserDetails(String name, String password) {
		this.name = name;
		this.password = password;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
		
}
