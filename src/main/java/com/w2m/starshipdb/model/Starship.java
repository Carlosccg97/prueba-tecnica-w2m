package com.w2m.starshipdb.model;

import org.springframework.boot.context.properties.bind.ConstructorBinding;

import jakarta.persistence.*;

@Entity
@Table(name = "Starships")
public class Starship {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "saga")
	private String saga;
	
	public Starship(){}
	
	public Starship(Long id, String name, String saga) {
		this.id = id;
		this.name = name;
		this.saga = saga;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSaga() {
		return saga;
	}

	public void setSaga(String saga) {
		this.saga = saga;
	}

	@Override
	public String toString() {
		return "Starship [id=" + id + ", name=" + name + ", saga=" + saga + "]";
	}

	
}
