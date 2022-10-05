package com.example.missao.dto.transform;

import com.example.missao.model.Municipio;
import com.example.missao.model.Polo;
import com.example.missao.model.Zona;

import java.util.ArrayList;
import java.util.List;

public class DetalhesZonaDto {

    private Long numero;

    private List<Long> municipios = new ArrayList<>();

    private Long qntSecoes;

    private Long sede;

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public List<Long> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Long> municipios) {
        this.municipios = municipios;
    }

    public Long getSede() {
        return sede;
    }

    public void setSede(Long sede) {
        this.sede = sede;
    }

    public Long getQntSecoes() {
        return qntSecoes;
    }

    public void setQntSecoes(Long qntSecoes) {
        this.qntSecoes = qntSecoes;
    }

    public DetalhesZonaDto(Zona zona, Long qntSecoes){
        this.numero = zona.getNumero();
        this.sede = zona.getSede().getCodTse();
        this.qntSecoes = qntSecoes;
        zona.getMunicipios().forEach(municipio -> municipios.add(municipio.getCodTse()));
    }
}
