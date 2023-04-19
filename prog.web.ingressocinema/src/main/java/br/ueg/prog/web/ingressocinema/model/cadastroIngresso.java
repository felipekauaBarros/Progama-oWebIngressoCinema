package br.ueg.prog.web.ingressocinema.model;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "cadastro_ingresso")
public class cadastroIngresso {
    @Id
    @Column(name = "codigo")
    private Long idCodigo;

    @Column(name = "nome_do_cliente", length = 200, nullable = false)
    private String nomeCliente;

    @Column(name = "sala_do_filme", length = 20, nullable = false)
    private String salaFime;

    @Column(name = "assento_da_sala", length = 6, nullable = false)
private String assentoSala;

    @Column(name = "tipo_do_ingresso", length = 10, nullable = false)
    private String tipoIngresso;

    @Column(name = "data_hora_do_filme", length = 20, nullable = false)
    private String data_horaFilme;

    @Column(name = "categoria_do_filme", length = 50, nullable = false)
    private String categoriaFilme;

    @Column(name = "nome_do_filme", length = 200, nullable = false)
    private String nomeFilme;
}
