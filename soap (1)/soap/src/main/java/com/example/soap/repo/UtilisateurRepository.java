package com.example.soap.repo;
import com.example.soap.Entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByNomUtilisateur(String nomUtilisateur);
}
