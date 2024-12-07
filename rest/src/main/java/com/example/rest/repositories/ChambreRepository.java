package com.example.rest.repositories;

import com.example.rest.entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {}
