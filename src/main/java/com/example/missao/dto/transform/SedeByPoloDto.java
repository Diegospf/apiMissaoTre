package com.example.missao.dto.transform;

import com.example.missao.model.Municipio;
import com.example.missao.model.Polo;
import com.example.missao.model.Zona;

public class SedeByPoloDto {
    private String nomeSede;
    private Long sede;

    public String getNomeSede() {
        return nomeSede;
    }

    public void setNomeSede(String nomeSede) {
        this.nomeSede = nomeSede;
    }

    public Long getSede() {
        return sede;
    }

    public void setSede(Long sede) {
        this.sede = sede;
    }

    public SedeByPoloDto(Polo polo) {
        this.nomeSede = polo.getSede().getNome();
        this.sede = polo.getSede().getCodTse();
    }

    public SedeByPoloDto(Zona zona) {
        this.nomeSede = zona.getSede().getNome();
        this.sede = zona.getSede().getCodTse();
    }
}
