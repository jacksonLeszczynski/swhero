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
@Table(name = "starships")
public class Starship implements Serializable {

	private static final long serialVersionUID = -4293221208973827911L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
    private Integer id;
	
	@Column(name = "name")
	@JsonView({RequestView.SwHeroGetOne.class, RequestView.SwHeroGetList.class})
    private String name;
	
	@Column(name = "model")
	@JsonView({RequestView.SwHeroGetOne.class, RequestView.SwHeroGetList.class})
    private String model;
	
	@Column(name = "manufacturer")
	@JsonView({RequestView.SwHeroGetOne.class, RequestView.SwHeroGetList.class})
    private String manufacturer;
	
	@Column(name = "costincredits")
	@JsonView({RequestView.SwHeroGetOne.class, RequestView.SwHeroGetList.class})
    private Long costincredits;
	
	@Column(name = "lengthship")
	@JsonView({RequestView.SwHeroGetOne.class, RequestView.SwHeroGetList.class})
    private Integer lengthship;
	
	@Column(name = "maxatmosphericspeed")
	@JsonView({RequestView.SwHeroGetOne.class, RequestView.SwHeroGetList.class})
    private Integer maxatmosphericspeed;
	
	@Column(name = "crew")
	@JsonView({RequestView.SwHeroGetOne.class, RequestView.SwHeroGetList.class})
    private String crew;
	
	@Column(name = "passengers")
	@JsonView({RequestView.SwHeroGetOne.class, RequestView.SwHeroGetList.class})
    private Integer passengers;
	
	@Column(name = "cargocapacity")
	@JsonView({RequestView.SwHeroGetOne.class, RequestView.SwHeroGetList.class})
    private Long cargocapacity;
	
	@Column(name = "consumables")
	@JsonView({RequestView.SwHeroGetOne.class, RequestView.SwHeroGetList.class})
    private String consumables;
	
	@Column(name = "hyperdriverating")
	@JsonView({RequestView.SwHeroGetOne.class, RequestView.SwHeroGetList.class})
    private String hyperdriverating;
	
	@Column(name = "mglt")
	@JsonView({RequestView.SwHeroGetOne.class, RequestView.SwHeroGetList.class})
    private Integer mglt;
	
	@Column(name = "starshipclass")
	@JsonView({RequestView.SwHeroGetOne.class, RequestView.SwHeroGetList.class})
    private String starshipclass;

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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Long getCostincredits() {
		return costincredits;
	}

	public void setCostincredits(Long costincredits) {
		this.costincredits = costincredits;
	}

	public Integer getLengthship() {
		return lengthship;
	}

	public void setLengthship(Integer lengthship) {
		this.lengthship = lengthship;
	}

	public Integer getMaxatmosphericspeed() {
		return maxatmosphericspeed;
	}

	public void setMaxatmosphericspeed(Integer maxatmosphericspeed) {
		this.maxatmosphericspeed = maxatmosphericspeed;
	}

	public String getCrew() {
		return crew;
	}

	public void setCrew(String crew) {
		this.crew = crew;
	}

	public Integer getPassengers() {
		return passengers;
	}

	public void setPassengers(Integer passengers) {
		this.passengers = passengers;
	}

	public Long getCargocapacity() {
		return cargocapacity;
	}

	public void setCargocapacity(Long cargocapacity) {
		this.cargocapacity = cargocapacity;
	}

	public String getConsumables() {
		return consumables;
	}

	public void setConsumables(String consumables) {
		this.consumables = consumables;
	}

	public String getHyperdriverating() {
		return hyperdriverating;
	}

	public void setHyperdriverating(String hyperdriverating) {
		this.hyperdriverating = hyperdriverating;
	}

	public Integer getMglt() {
		return mglt;
	}

	public void setMglt(Integer mglt) {
		this.mglt = mglt;
	}

	public String getStarshipclass() {
		return starshipclass;
	}

	public void setStarshipclass(String starshipclass) {
		this.starshipclass = starshipclass;
	}
}
