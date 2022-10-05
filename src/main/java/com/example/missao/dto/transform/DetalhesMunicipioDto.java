package com.example.missao.dto.transform;

import com.example.missao.model.Municipio;
import com.example.missao.model.Zona;

import java.util.ArrayList;
import java.util.List;

public class DetalhesMunicipioDto {
    private Long id;

    private String nome;
    private Long poloId;

    private Long qntSecoes;

    private List<Long> zonasId = new ArrayList<>();

    private List<Long> secoesId = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getQntSecoes() {
        return qntSecoes;
    }

    public void setQntSecoes(Long qntSecoes) {
        this.qntSecoes = qntSecoes;
    }

    public List<Long> getZonasId() {
        return zonasId;
    }

    public void setZonasId(List<Long> zonasId) {
        this.zonasId = zonasId;
    }

    public List<Long> getSecoesId() {
        return secoesId;
    }

    public void setSecoesId(List<Long> secoesId) {
        this.secoesId = secoesId;
    }

    public Long getPoloId() {
        return poloId;
    }

    public void setPoloId(Long poloId) {
        this.poloId = poloId;
    }

    public DetalhesMunicipioDto(Municipio municipio, Long qnt){
        this.id = municipio.getCodTse();
        this.nome = municipio.getNome();
        this.poloId = municipio.getPolo().getNumero();
        this.qntSecoes = qnt;
        municipio.getZonas().forEach(zona -> this.zonasId.add(zona.getNumero()));
        municipio.getSecoes().forEach(secao -> this.secoesId.add(secao.getId()));
    }
    public DetalhesMunicipioDto(Municipio municipio){
        this.id = municipio.getCodTse();
        this.nome = municipio.getNome();
        this.poloId = municipio.getPolo().getNumero();
        municipio.getZonas().forEach(zona -> this.zonasId.add(zona.getNumero()));
        municipio.getSecoes().forEach(secao -> this.secoesId.add(secao.getId()));
    }
}
