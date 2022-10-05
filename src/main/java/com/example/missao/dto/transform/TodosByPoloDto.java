package com.example.missao.dto.transform;

import com.example.missao.model.Polo;
import com.example.missao.model.Zona;

import java.util.ArrayList;
import java.util.List;

public class TodosByPoloDto {
    private Long qntSecoes;
    private Long sede;
    private String nomeSede;
    private List<ZonaByPoloDto> zonas = new ArrayList<>();

    public Long getQntSecoes() {
        return qntSecoes;
    }

    public void setQntSecoes(Long qntSecoes) {
        this.qntSecoes = qntSecoes;
    }

    public Long getSede() {
        return sede;
    }

    public void setSede(Long sede) {
        this.sede = sede;
    }

    public String getNomeSede() {
        return nomeSede;
    }

    public void setNomeSede(String nomeSede) {
        this.nomeSede = nomeSede;
    }

    public List<ZonaByPoloDto> getZonas() {
        return zonas;
    }

    public void setZonas(List<ZonaByPoloDto> zonas) {
        this.zonas = zonas;
    }

    public TodosByPoloDto(Long qntSecoes, Polo polo, List<Zona> zonas) {
        this.qntSecoes = qntSecoes;
        this.sede = polo.getSede().getCodTse();
        this.nomeSede = polo.getSede().getNome();
        this.zonas = ZonaByPoloDto.zonaPolo(zonas);
    }

    public TodosByPoloDto(Long qntSecoes, Zona zona) {
        this.qntSecoes = qntSecoes;
        this.sede = zona.getSede().getCodTse();
        this.nomeSede = zona.getSede().getNome();
        //this.zonas = ZonaByPoloDto.zonaPolo(zonas);
    }
}
