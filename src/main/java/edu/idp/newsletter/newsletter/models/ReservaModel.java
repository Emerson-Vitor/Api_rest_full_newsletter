package edu.idp.newsletter.newsletter.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Table(name = "RESEVA_TB")
public class ReservaModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private Integer ra;
    @Column(nullable = false)
    private LocalDateTime idExternoProd;
    @Column(nullable = false)
    private LocalDateTime dataTimeInicio;
    @Column(nullable = false)
    private LocalDateTime  dataTimeFim;
    private LocalDateTime  dataTimeDevolucao;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getRa() {
        return ra;
    }

    public void setRa(Integer ra) {
        this.ra = ra;
    }

    public LocalDateTime getIdExternoProd() {
        return idExternoProd;
    }

    public void setIdExternoProd(LocalDateTime idExternoProd) {
        this.idExternoProd = idExternoProd;
    }

    public LocalDateTime getDataTimeInicio() {
        return dataTimeInicio;
    }

    public void setDataTimeInicio(LocalDateTime dataTimeInicio) {
        this.dataTimeInicio = dataTimeInicio;
    }

    public LocalDateTime getDataTimeFim() {
        return dataTimeFim;
    }

    public void setDataTimeFim(LocalDateTime dataTimeFim) {
        this.dataTimeFim = dataTimeFim;
    }

    public LocalDateTime getDataTimeDevolucao() {
        return dataTimeDevolucao;
    }

    public void setDataTimeDevolucao(LocalDateTime dataTimeDevolucao) {
        this.dataTimeDevolucao = dataTimeDevolucao;
    }
}
