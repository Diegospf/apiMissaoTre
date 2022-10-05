package com.example.missao.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Polo {
    @Id
    private Long numero;
    @OneToMany(mappedBy = "polo")
    private List<Municipio> municipios = new ArrayList<>();
    @OneToOne
    private Municipio sede;

    public Municipio getSede() {
        return sede;
    }

    public void setSede(Municipio sede) {
        this.sede = sede;
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }
}
