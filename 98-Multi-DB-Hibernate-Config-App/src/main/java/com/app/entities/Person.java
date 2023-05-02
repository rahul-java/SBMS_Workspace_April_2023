package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PERSON_TBL")
public class Person {

	@Id
	@GeneratedValue
	private Integer p_id;
	private String p_name;
	private String p_addres;
	private Double p_balance;
}
