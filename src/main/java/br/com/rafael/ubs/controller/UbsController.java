package br.com.rafael.ubs.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.rafael.ubs.controller.form.UbsForm;
import br.com.rafael.ubs.model.Ubs;
import br.com.rafael.ubs.repository.UbsRepository;
import br.com.rafael.ubs.vo.UbsVO;

@RestController
@RequestMapping("/ubs")
public class UbsController {

	@Autowired
	private UbsRepository ubsRepository;
	
	//distance range 2km
	private static final double range = 2;
	
	@GetMapping
	@ResponseBody
	public List<UbsVO> findUbs() {

		List<Ubs> ubsList = ubsRepository.findAll();
		
		return UbsVO.converter(ubsList);
	}
	
	@PostMapping
	@ResponseBody
	public List<UbsVO> findNearbyUbs(@RequestBody @Valid UbsForm form, UriComponentsBuilder uriBuilder){
		
		List<Ubs> listaUbs = ubsRepository.findAll();
		List<Ubs> listaNearbyUbs = new ArrayList<Ubs>();
		listaUbs.forEach(ubs -> calculateDistance(form.getLatitude(), form.getLongitude(), 
												range, ubs, listaNearbyUbs));
		
		return UbsVO.converter(listaNearbyUbs);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UbsVO> details(@PathVariable Long id) {
		
		Optional<Ubs> optional = ubsRepository.findById(id);
		
		if(optional.isPresent()){
			return ResponseEntity.ok(new UbsVO(optional.get()));
		}
		
		return ResponseEntity.notFound().build();
	}

	private void calculateDistance(double latitude, double longitude, 
								double range, Ubs ubs, List<Ubs> listaNearbyUbs) {
		
		final int R = 6371; // Radious of the earth
		 Double lat1 = latitude;
		 Double lon1 = longitude;
		 Double lat2 = ubs.getVlr_latitude();
		 Double lon2 = ubs.getVlr_longitude();
		 Double latDistance = toRad(lat2-lat1);
		 Double lonDistance = toRad(lon2-lon1);
		 Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + 
		 Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) * 
		 Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		 Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		 Double distance = R * c;
		 
		 if(distance <= range){
			 listaNearbyUbs.add(ubs);
		 }
	}
	
	private static Double toRad(Double value) {
		return value * Math.PI / 180;
	}
}
