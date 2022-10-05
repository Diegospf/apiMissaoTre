package com.example.missao.dto.transform;

import com.example.missao.model.Municipio;
import com.example.missao.model.Polo;
import com.example.missao.model.Zona;

import java.util.ArrayList;
import java.util.List;

public class ZonaByPoloDto {
    private Long zona;
    private Long codTse;
    private String nomeMun;

    public Long getZona() {
        return zona;
    }

    public void setZona(Long zona) {
        this.zona = zona;
    }

    public Long getCodTse() {
        return codTse;
    }

    public void setCodTse(Long codTse) {
        this.codTse = codTse;
    }

    public String getNomeMun() {
        return nomeMun;
    }

    public void setNomeMun(String nomeMun) {
        this.nomeMun = nomeMun;
    }

    public ZonaByPoloDto(Long zona, Long codTse, String nomeMun) {
        this.zona = zona;
        this.codTse = codTse;
        this.nomeMun = nomeMun;
    }

    public static List<ZonaByPoloDto> zonaPolo(List<Zona> zonas){
        List<ZonaByPoloDto> zonaByPolo = new ArrayList<>();
        for (Zona z : zonas){
            for (Municipio m : z.getMunicipios()){
                zonaByPolo.add(new ZonaByPoloDto(z.getNumero(), m.getCodTse(), m.getNome()));
            }
        }

        return zonaByPolo;
    }
}
