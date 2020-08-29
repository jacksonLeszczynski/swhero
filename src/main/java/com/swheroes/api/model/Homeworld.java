package com.swheroes.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.swheroes.api.RequestView;

@Entity
@Table(name = "homeworld")
public class Homeworld implements Serializable {

	private static final long serialVersionUID = -2324573435173348953L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
    private Integer id;
	
	@Column(name = "name")
	@JsonView(RequestView.SwHeroGetOne.class)
    private String name;
	
	@Column(name = "rotationperiod")
	@JsonView(RequestView.SwHeroGetOne.class)
    private Integer rotationperiod;
	
	@Column(name = "orbitalperiod")
	@JsonView(RequestView.SwHeroGetOne.class)
    private Integer orbitalperiod;
	
	@Column(name = "diameter")
	@JsonView(RequestView.SwHeroGetOne.class)
    private Integer diameter;
	
	@Column(name = "climate")
	@JsonView(RequestView.SwHeroGetOne.class)
    private String climate;
	
	@Column(name = "gravity")
	@JsonView(RequestView.SwHeroGetOne.class)
    private String gravity;
	
	@Column(name = "terrain")
	@JsonView(RequestView.SwHeroGetOne.class)
    private String terrain;
	
	@Column(name = "surfacewater")
	@JsonView(RequestView.SwHeroGetOne.class)
    private Integer surfacewater;
	
	@Column(name = "population")
	@JsonView(RequestView.SwHeroGetOne.class)
    private Integer population;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRotationperiod() {
		return rotationperiod;
	}

	public void setRotationperiod(Integer rotationperiod) {
		this.rotationperiod = rotationperiod;
	}

	public Integer getOrbitalperiod() {
		return orbitalperiod;
	}

	public void setOrbitalperiod(Integer orbitalperiod) {
		this.orbitalperiod = orbitalperiod;
	}

	public Integer getDiameter() {
		return diameter;
	}

	public void setDiameter(Integer diameter) {
		this.diameter = diameter;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public String getGravity() {
		return gravity;
	}

	public void setGravity(String gravity) {
		this.gravity = gravity;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	public Integer getSurfacewater() {
		return surfacewater;
	}

	public void setSurfacewater(Integer surfacewater) {
		this.surfacewater = surfacewater;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

}
