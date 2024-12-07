package com.example.rest.entities;

import jakarta.persistence.*;
import lombok.Data;


    @Data
    @Entity
    public class Chambre {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String type;

        @Column(nullable = false)
        private Double prix;

        @Column(nullable = false)
        private Boolean disponible;

        public Long getId() {
            return id;
        }

        public String getType() {
            return type;
        }

        public Double getPrix() {
            return prix;
        }

        public Boolean getDisponible() {
            return disponible;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setPrix(Double prix) {
            this.prix = prix;
        }

        public void setDisponible(Boolean disponible) {
            this.disponible = disponible;
        }
    }
