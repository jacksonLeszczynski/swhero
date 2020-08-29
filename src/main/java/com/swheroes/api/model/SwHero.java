package com.swheroes.api.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.swheroes.api.RequestView;

@Entity
@Table(name = "swhero")
public class SwHero implements Serializable {
	
	private static final long serialVersionUID = -3870761552066184699L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView({RequestView.SwHeroGetOne.class, RequestView.SwHeroGetList.class})
    private Long id;

    @Column(name = "name")
    @JsonView({RequestView.SwHeroGetOne.class, RequestView.SwHeroGetList.class})
    private String name;
    
    @Column(name = "height")
    @JsonView({RequestView.SwHeroGetOne.class, RequestView.SwHeroGetList.class})
    private Integer height;
    
    @Column(name = "mass")
    @JsonView({RequestView.SwHeroGetOne.class, RequestView.SwHeroGetList.class})
    private Integer mass;
    
    @Column(name = "haircolor")
    @JsonView({RequestView.SwHeroGetOne.class, RequestView.SwHeroGetList.class})
    private String haircolor;
    
    @Column(name = "skincolor")
    @JsonView({RequestView.SwHeroGetOne.class, RequestView.SwHeroGetList.class})
    private String skincolor;
    
    @Column(name = "eyecolor")
    @JsonView({RequestView.SwHeroGetOne.class, RequestView.SwHeroGetList.class})
    private String eyecolor;
    
    @Column(name = "birthyear")
    @JsonView({RequestView.SwHeroGetOne.class, RequestView.SwHeroGetList.class})
    private String birthyear;
    
    @Column(name = "gender")
    @JsonView({RequestView.SwHeroGetOne.class, RequestView.SwHeroGetList.class})
    private String gender;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "swhero_id")
    @JsonView({RequestView.SwHeroGetOne.class, RequestView.SwHeroGetList.class})
    private Set<Starship> starships = new HashSet<Starship>();;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="homeworld_id")
    @JsonView(RequestView.SwHeroGetOne.class)
    private Homeworld homeworld;

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

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getMass() {
		return mass;
	}

	public void setMass(Integer mass) {
		this.mass = mass;
	}

	public String getHaircolor() {
		return haircolor;
	}

	public void setHaircolor(String haircolor) {
		this.haircolor = haircolor;
	}

	public String getSkincolor() {
		return skincolor;
	}

	public void setSkincolor(String skincolor) {
		this.skincolor = skincolor;
	}

	public String getEyecolor() {
		return eyecolor;
	}

	public void setEyecolor(String eyecolor) {
		this.eyecolor = eyecolor;
	}

	public String getBirthyear() {
		return birthyear;
	}

	public void setBirthyear(String birthyear) {
		this.birthyear = birthyear;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Set<Starship> getStarships() {
		return starships;
	}

	public void setStarships(Set<Starship> starships) {
		this.starships = starships;
	}

	public Homeworld getHomeworld() {
		return homeworld;
	}

	public void setHomeworld(Homeworld homeworld) {
		this.homeworld = homeworld;
	}

}
