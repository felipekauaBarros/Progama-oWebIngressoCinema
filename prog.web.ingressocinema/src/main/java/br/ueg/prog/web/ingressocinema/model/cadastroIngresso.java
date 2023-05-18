package br.ueg.prog.web.ingressocinema.model;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "cadastro_ingresso")
public class cadastroIngresso {
    @SequenceGenerator(
            name="ingresso_sequence",
            sequenceName = "ingresso_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "ingresso_sequence"
    )

    @Id
    @Column(name = "IdCodigo")
    private Long idCodigo;

    @Column(name = "nome_do_cliente", length = 200, nullable = false)
    private String nomeCliente;

    @Column(name = "sala_do_filme", length = 20)
    private String salaFime;

    @Column(name = "assento_da_sala", length = 6, nullable = false)
private String assentoSala;

    @Column(name = "tipo_do_ingresso", length = 10)
    private String tipoIngresso;

    @Column(name = "data_hora_do_filme", length = 20)
    private String data_horaFilme;

    @Column(name = "categoria_do_filme", length = 50)
    private String categoriaFilme;

    @Column(name = "nome_do_filme", length = 200)
    private String nomeFilme;
}
