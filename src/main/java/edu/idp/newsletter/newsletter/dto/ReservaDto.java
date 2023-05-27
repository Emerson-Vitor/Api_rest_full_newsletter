package edu.idp.newsletter.newsletter.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class ReservaDto {
    @NotBlank
    private String ra;
    @NotBlank
    private String idExternoProd;
    @NotBlank
    private String dataTimeInicio;
    @NotBlank
    private String  dataTimeFim;

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getIdExternoProd() {
        return idExternoProd;
    }

    public void setIdExternoProd(String idExternoProd) {
        this.idExternoProd = idExternoProd;
    }

    public String getDataTimeInicio() {
        return dataTimeInicio;
    }

    public void setDataTimeInicio(String dataTimeInicio) {
        this.dataTimeInicio = dataTimeInicio;
    }

    public String getDataTimeFim() {
        return dataTimeFim;
    }

    public void setDataTimeFim(String dataTimeFim) {
        this.dataTimeFim = dataTimeFim;
    }
}
