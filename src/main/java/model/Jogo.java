package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "jogo")
public class Jogo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jogo_id")
	private Long id;
	
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "fk_jogo_time_casa")
	private Time timeCasa;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "fk_jogo_time_contra")
	private Time timeContra;
	
	
	@Column(name = "jogo_data_hora", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date jogoDataHora;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Time getTimeCasa() {
		return timeCasa;
	}


	public void setTimeCasa(Time timeCasa) {
		this.timeCasa = timeCasa;
	}


	public Time getTimeContra() {
		return timeContra;
	}


	public void setTimeContra(Time timeContra) {
		this.timeContra = timeContra;
	}


	public Date getJogoDataHora() {
		return jogoDataHora;
	}


	public void setJogoDataHora(Date jogoDataHora) {
		this.jogoDataHora = jogoDataHora;
	}
	

}
