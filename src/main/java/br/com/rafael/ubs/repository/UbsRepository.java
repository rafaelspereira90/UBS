package br.com.rafael.ubs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.rafael.ubs.model.Ubs;

public interface UbsRepository extends JpaRepository<Ubs, Long> {

	@Query("SELECT u from Ubs u WHERE u.vlr_latitude > 10")
	List<Ubs> findByRange(@Param ("range") Long range);
}
