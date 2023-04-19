package br.ueg.prog.web.ingressocinema.dto;

import lombok.Data;

public @Data class ingressoDTO {
    private Long idCodigo;
    private String nomeCliente;
    private String salaFime;
    private String assentoSala;
    private String tipoIngresso;
    private String data_horaFilme;
    private String categoriaFilme;
    private String nomeFilme;
}
