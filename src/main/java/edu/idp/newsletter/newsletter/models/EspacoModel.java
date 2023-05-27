package edu.idp.newsletter.newsletter.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;
@Entity
@Table(name = "ESPACO_TB")
public class EspacoModel implements Serializable {
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID id;
        @Column(nullable = false)
        private String nome;
        @Column(nullable = false)
        private Boolean disponivel;

        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Boolean getDisponivel() {
            return disponivel;
        }

        public void setDisponivel(Boolean disponivel) {
            this.disponivel = disponivel;
        }
}
