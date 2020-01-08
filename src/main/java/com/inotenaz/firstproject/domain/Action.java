package com.inotenaz.firstproject.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Action implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="idSocialAction")
	private SocialAction idSocialAction;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="idVolunteer")
	private Volunteer idVolunteer;
	
	public Action() {
		
	}

	public Action(Integer id, SocialAction idSocialAction, Volunteer idVolunteer) {
		super();
		this.id = id;
		this.idSocialAction = idSocialAction;
		this.idVolunteer = idVolunteer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SocialAction getIdSocialAction() {
		return idSocialAction;
	}

	public void setIdSocialAction(SocialAction idSocialAction) {
		this.idSocialAction = idSocialAction;
	}

	public Volunteer getIdVolunteer() {
		return idVolunteer;
	}

	public void setIdVolunteer(Volunteer idVolunteer) {
		this.idVolunteer = idVolunteer;
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
		Action other = (Action) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
