package br.ueg.prog.web.ingressocinema.mapper;

import br.ueg.prog.web.ingressocinema.dto.*;
import br.ueg.prog.web.ingressocinema.model.cadastroIngresso;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ingressoMapper {
    /**
     * Converte a Entidade {@link cadastroIngresso} em {@link listaingressoDTO}
     * @param ingresso
     * @return
     */
    public listaingressoDTO toDTO(cadastroIngresso ingresso);

    public List <listaingressoDTO> toDTO(List<cadastroIngresso> ingressos);

    public ingressoDadosAlteraveisDTO toIngressosIncluiDTO(cadastroIngresso ingresso);

    public cadastroIngresso toModelo(ingressoDadosAlteraveisDTO ingresso);

    public ingressoDTO toIngressoDTO(cadastroIngresso ingresso);

    public cadastroIngresso toModelo(ingressoDTO ingresso);
}

