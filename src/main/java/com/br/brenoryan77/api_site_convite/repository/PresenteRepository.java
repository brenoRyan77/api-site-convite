package com.br.brenoryan77.api_site_convite.repository;

import com.br.brenoryan77.api_site_convite.model.Presente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresenteRepository extends JpaRepository<Presente, Long>{
}
