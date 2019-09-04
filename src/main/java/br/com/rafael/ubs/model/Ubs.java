package br.com.rafael.ubs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Ubs {

	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	private double vlr_latitude;
	
	private double vlr_longitude;
	private Long cod_munic;
	private Long cod_cnes;
	private String nom_estab;
	private String dsc_endereco;
	private String dsc_bairro;
	private String dsc_cidade;
	private String dsc_telefone;
	private String dsc_estrut_fisic_ambiencia; 
	private String dsc_adap_defic_fisic_idosos;
	private String dsc_equipamentos;
	private String dsc_medicamentos;
	

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
		Ubs other = (Ubs) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getVlr_latitude() {
		return vlr_latitude;
	}

	public void setVlr_latitude(double vlr_latitude) {
		this.vlr_latitude = vlr_latitude;
	}

	public double getVlr_longitude() {
		return vlr_longitude;
	}

	public void setVlr_longitude(double vlr_longitude) {
		this.vlr_longitude = vlr_longitude;
	}

	public Long getCod_munic() {
		return cod_munic;
	}

	public void setCod_munic(Long cod_munic) {
		this.cod_munic = cod_munic;
	}

	public Long getCod_cnes() {
		return cod_cnes;
	}

	public void setCod_cnes(Long cod_cnes) {
		this.cod_cnes = cod_cnes;
	}

	public String getNom_estab() {
		return nom_estab;
	}

	public void setNom_estab(String nom_estab) {
		this.nom_estab = nom_estab;
	}

	public String getDsc_endereco() {
		return dsc_endereco;
	}

	public void setDsc_endereco(String dsc_endereco) {
		this.dsc_endereco = dsc_endereco;
	}

	public String getDsc_bairro() {
		return dsc_bairro;
	}

	public void setDsc_bairro(String dsc_bairro) {
		this.dsc_bairro = dsc_bairro;
	}

	public String getDsc_cidade() {
		return dsc_cidade;
	}

	public void setDsc_cidade(String dsc_cidade) {
		this.dsc_cidade = dsc_cidade;
	}

	public String getDsc_telefone() {
		return dsc_telefone;
	}

	public void setDsc_telefone(String dsc_telefone) {
		this.dsc_telefone = dsc_telefone;
	}

	public String getDsc_estrut_fisic_ambiencia() {
		return dsc_estrut_fisic_ambiencia;
	}

	public void setDsc_estrut_fisic_ambiencia(String dsc_estrut_fisic_ambiencia) {
		this.dsc_estrut_fisic_ambiencia = dsc_estrut_fisic_ambiencia;
	}

	public String getDsc_adap_defic_fisic_idosos() {
		return dsc_adap_defic_fisic_idosos;
	}

	public void setDsc_adap_defic_fisic_idosos(String dsc_adap_defic_fisic_idosos) {
		this.dsc_adap_defic_fisic_idosos = dsc_adap_defic_fisic_idosos;
	}

	public String getDsc_equipamentos() {
		return dsc_equipamentos;
	}

	public void setDsc_equipamentos(String dsc_equipamentos) {
		this.dsc_equipamentos = dsc_equipamentos;
	}

	public String getDsc_medicamentos() {
		return dsc_medicamentos;
	}

	public void setDsc_medicamentos(String dsc_medicamentos) {
		this.dsc_medicamentos = dsc_medicamentos;
	}
}
