package br.com.rafael.ubs.vo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.rafael.ubs.model.Geocode;
import br.com.rafael.ubs.model.Scores;
import br.com.rafael.ubs.model.ScoresEnum;
import br.com.rafael.ubs.model.Ubs;

public class UbsVO {

	private Long id;
	@Autowired
	private Geocode geocode;
	private String name;
	private String address;
	private String city;
	private String phone;
	@Autowired
	private Scores scores;
	
	public UbsVO(Ubs ubs) {
		this.id = ubs.getId();
		this.geocode = new Geocode();
		this.geocode.setLat(ubs.getVlr_latitude());
		this.geocode.setLon(ubs.getVlr_longitude());
		this.name = ubs.getNom_estab();
		this.address = ubs.getDsc_endereco();
		this.city = ubs.getDsc_cidade();
		this.phone = ubs.getDsc_telefone();
		this.scores = new Scores();
		
		if(ubs.getDsc_estrut_fisic_ambiencia().equals(ScoresEnum.DesempenhoMedianoOuUmPoucoAbaixoDaMedia.descricaoScore)){
			this.scores.setSize(ScoresEnum.DesempenhoMedianoOuUmPoucoAbaixoDaMedia.codigoScore);
		}else if(ubs.getDsc_estrut_fisic_ambiencia().equals(ScoresEnum.DesempenhoAcimaDaMédia.descricaoScore)) {
			this.scores.setSize(ScoresEnum.DesempenhoAcimaDaMédia.codigoScore);
		}else{
			this.scores.setSize(ScoresEnum.DesempenhoMuitoAcimaDaMédia.codigoScore);
		}
		
		if(ubs.getDsc_adap_defic_fisic_idosos().equals(ScoresEnum.DesempenhoMedianoOuUmPoucoAbaixoDaMedia.descricaoScore)){
			this.scores.setAdaptation_for_seniors(ScoresEnum.DesempenhoMedianoOuUmPoucoAbaixoDaMedia.codigoScore);
		}else if(ubs.getDsc_adap_defic_fisic_idosos().equals(ScoresEnum.DesempenhoAcimaDaMédia.descricaoScore)) {
			this.scores.setAdaptation_for_seniors(ScoresEnum.DesempenhoAcimaDaMédia.codigoScore);
		}else{
			this.scores.setAdaptation_for_seniors(ScoresEnum.DesempenhoMuitoAcimaDaMédia.codigoScore);
		}
		
		if(ubs.getDsc_equipamentos().equals(ScoresEnum.DesempenhoMedianoOuUmPoucoAbaixoDaMedia.descricaoScore)){
			this.scores.setMedical_equipment(ScoresEnum.DesempenhoMedianoOuUmPoucoAbaixoDaMedia.codigoScore);
		}else if(ubs.getDsc_equipamentos().equals(ScoresEnum.DesempenhoAcimaDaMédia.descricaoScore)){
			this.scores.setMedical_equipment(ScoresEnum.DesempenhoAcimaDaMédia.codigoScore);
		}else{
			this.scores.setMedical_equipment(ScoresEnum.DesempenhoMuitoAcimaDaMédia.codigoScore);
		}
		
		if(ubs.getDsc_medicamentos().equals(ScoresEnum.DesempenhoMedianoOuUmPoucoAbaixoDaMedia.descricaoScore)){
			this.scores.setMedicine(ScoresEnum.DesempenhoMedianoOuUmPoucoAbaixoDaMedia.codigoScore);
		}else if(ubs.getDsc_medicamentos().equals(ScoresEnum.DesempenhoAcimaDaMédia.descricaoScore)){
			this.scores.setMedicine(ScoresEnum.DesempenhoAcimaDaMédia.codigoScore);
		}else{
			this.scores.setMedicine(ScoresEnum.DesempenhoMuitoAcimaDaMédia.codigoScore);
		}
		
	}
	
	public Long getId() {
		return id;
	}

	public Geocode getGeocode() {
		return geocode;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getPhone() {
		return phone;
	}

	public Scores getScores() {
		return scores;
	}
	
	public static List<UbsVO> converter(List<Ubs> listaUbs) {
		return listaUbs.stream().map(UbsVO::new).collect(Collectors.toList());
	}
}
