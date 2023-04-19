package br.ueg.prog.web.ingressocinema.controller;

import br.ueg.prog.web.ingressocinema.dto.*;
import br.ueg.prog.web.ingressocinema.mapper.ingressoMapper;
import br.ueg.prog.web.ingressocinema.model.cadastroIngresso;
import br.ueg.prog.web.ingressocinema.service.ingressoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "${app.api.base}/ingresso")

public class IngressoController {

    @Autowired
    private ingressoMapper Mapper;

    @Autowired
    private ingressoService service;

    @GetMapping(path = "/listar")
    @Operation(description = "Listar Ingressos")
    public List<listaingressoDTO> listAll() {
        List<cadastroIngresso> ingressos = service.listarTodos();
        return this.Mapper.toDTO(ingressos);
    }

    @PostMapping
    @Operation(description = "Método utilizado para incluir ingresso de um cliente")
    public ingressoDTO incluir(@RequestBody ingressoDadosAlteraveisDTO ingresso) {
        // preparação para entrada
        cadastroIngresso ingressoIncluir = this.Mapper.toModelo(ingresso);
        // chama o serviço
        System.out.println(ingressoIncluir);
        ingressoIncluir = this.service.incluir(ingressoIncluir);

        return this.Mapper.toIngressoDTO(ingressoIncluir);
    }

    @PutMapping(path = "/{IdCodigo}")
    @Operation(description = "Metodo Utilizado para alterar")
    public ingressoDTO alterar(@RequestBody() ingressoDadosAlteraveisDTO ingresso, @PathVariable(name = "codigo") Long idCodigo) {
        cadastroIngresso ingressoal = Mapper.toModelo(ingresso);
        cadastroIngresso alterar = service.alterar(ingressoal);
        return Mapper.toIngressoDTO(alterar);
    }

    @DeleteMapping(path = "/{IdCodigo}")
    @Operation(description = "Metodo para remover ingresso")
    public ingressoDTO excluir(@PathVariable(name = "codigo") Long idCodigo) {
        cadastroIngresso ingressoExclui = this.service.excluir(idCodigo);
        return Mapper.toIngressoDTO(ingressoExclui);
    }
}
