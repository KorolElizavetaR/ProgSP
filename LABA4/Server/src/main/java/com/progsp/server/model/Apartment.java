package com.progsp.server.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name = "apartments")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Apartment {
	@Id
	@Column (name = "id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column (name = "address")
	private String address;
	
	@Column (name = "price")
	private BigDecimal price;
	
	@Column (name = "currency")
	private String currency;
}
