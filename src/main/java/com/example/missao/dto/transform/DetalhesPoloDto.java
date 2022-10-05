package com.example.missao.dto.transform;

import com.example.missao.model.Municipio;
import com.example.missao.model.Polo;

import java.util.ArrayList;
import java.util.List;

public class DetalhesPoloDto {
    private Long numero;
    private List<Long> municipios = new ArrayList<>();
    private Long sede;

    private Long qntSecoes;

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

    public DetalhesPoloDto(Polo polo, Long qnt){

        this.numero = polo.getNumero();
        this.sede = polo.getSede().getCodTse();
        this.qntSecoes = qnt;
        polo.getMunicipios().forEach(municipio -> this.municipios.add(municipio.getCodTse()));
    }
}
