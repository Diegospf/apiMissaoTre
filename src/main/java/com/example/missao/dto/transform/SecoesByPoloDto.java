package com.example.missao.dto.transform;

public class SecoesByPoloDto {
    private long qntSecoes;

    public long getQntSecoes() {
        return qntSecoes;
    }

    public void setQntSecoes(long qntSecoes) {
        this.qntSecoes = qntSecoes;
    }

    public SecoesByPoloDto(long qntSecoes) {
        this.qntSecoes = qntSecoes;
    }
}
