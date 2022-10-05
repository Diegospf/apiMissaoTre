package com.example.missao.dto.transform;

import com.example.missao.model.Municipio;
import com.example.missao.model.Polo;
import com.example.missao.model.Zona;

import java.util.ArrayList;
import java.util.List;

public class MunicipiosByPoloDto {

    private Long codTse;
    private String nomeMun;

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

    public MunicipiosByPoloDto(String nome, Long codTse) {
        this.codTse = codTse;
        this.nomeMun = nome;
    }

    public static List<MunicipiosByPoloDto> munPolo(Polo polo){
        List<MunicipiosByPoloDto> munByPolo = new ArrayList<>();
        for (Municipio m : polo.getMunicipios()){
            munByPolo.add(new MunicipiosByPoloDto(m.getNome(), m.getCodTse()));
        }

        return munByPolo;
    }

    public static List<MunicipiosByPoloDto> munPolo(Zona zona){
        List<MunicipiosByPoloDto> munByPolo = new ArrayList<>();
        for (Municipio m : zona.getMunicipios()){
            munByPolo.add(new MunicipiosByPoloDto(m.getNome(), m.getCodTse()));
        }

        return munByPolo;
    }
}
