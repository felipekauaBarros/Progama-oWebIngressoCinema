package br.ueg.prog.web.ingressocinema.dto;

import lombok.Data;

public @Data class listaingressoDTO {
    private Long idCodigo;
    private String salaFime;
    private String assentoSala;
    private String data_horaFilme;
    private String nomeFilme;
}
