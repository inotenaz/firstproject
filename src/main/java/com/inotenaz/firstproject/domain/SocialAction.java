package com.inotenaz.firstproject.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class SocialAction implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String  name;
	private String  description;
	private Date 	date;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="pho_id")
	private PhilanthropicOrganization pho;
	
	@OneToMany(mappedBy="idSocialAction")
	private List<Action> actions = new ArrayList<>();
	
	public SocialAction() {
		
	}

	public SocialAction(Integer id, String name, String description, Date date, PhilanthropicOrganization pho) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.date = date;
		this.pho = pho;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public PhilanthropicOrganization getPho() {
		return pho;
	}

	public void setPho(PhilanthropicOrganization pho) {
		this.pho = pho;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SocialAction other = (SocialAction) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
