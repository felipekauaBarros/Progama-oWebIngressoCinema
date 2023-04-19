package br.ueg.prog.web.ingressocinema.service.impl;

import br.ueg.prog.web.ingressocinema.model.cadastroIngresso;
import br.ueg.prog.web.ingressocinema.repository.*;
import br.ueg.prog.web.ingressocinema.service.ingressoService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@Component
public class ingressoServiceImpl implements ingressoService {

    @Autowired IngressoRepository ingressoRepository;
    @Override
    public cadastroIngresso incluir(cadastroIngresso ingresso) {
        this.validarCampoObrigatorio(ingresso);
        cadastroIngresso ingressoIncluido = this.gravarDadosIngresso(ingresso);
        return ingressoIncluido;
    }
    private cadastroIngresso gravarDadosIngresso(cadastroIngresso ingresso) {
        return ingressoRepository.save(ingresso);
    }

    private void validarCampoObrigatorio(cadastroIngresso ingresso) {
        if(Objects.isNull(ingresso)) {
            throw  new IllegalArgumentException("Entidade Ingresso Deve Ser Peenchida");
        }
        List<String> camposVazios = new ArrayList<>();
        if(Strings.isEmpty(ingresso.getAssentoSala())) {

            camposVazios.add("Escolha um assento na Sala de Cinema");
        }
        if(!camposVazios.isEmpty()) {
            throw new IllegalArgumentException("Campos Obrigatórios não preenchidos ("+
                    String.join(",",camposVazios)+")");
        }
    }

    @Override
    public cadastroIngresso alterar(cadastroIngresso ingresso) {

        return ingressoRepository.save(ingresso);
    }

    @Override
    public cadastroIngresso excluir(Long idCodigo) {
        cadastroIngresso ingressoBancoDados = this.recuperaougeraerro(idCodigo);
        ingressoRepository.deleteById(idCodigo);
        return ingressoBancoDados;
    }

    private cadastroIngresso recuperaougeraerro(Long idCodigo) {
        cadastroIngresso ingressoBancoDados = ingressoRepository
                .findCadastroIngressoByidCodigo(idCodigo)
                .orElseThrow(
                        () -> new IllegalArgumentException("Erro ao localizar ingresso")
                );
        return ingressoBancoDados;
    }

    @Override
    public List<cadastroIngresso> listarTodos() {
        return null;
    }
}
