package com.example.soap.Entities;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import lombok.Data;

@Data
@XmlRootElement(name = "Chambre")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement
    private Long idChambre;
    private String type;
    private double prix;
    private boolean disponible;

    public Long getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(Long idChambre) {
        this.idChambre = idChambre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}

