package br.ueg.prog.web.ingressocinema.service;

import br.ueg.prog.web.ingressocinema.model.cadastroIngresso;

import java.util.List;

public interface ingressoService {
    public cadastroIngresso incluir(cadastroIngresso ingresso);
    public cadastroIngresso alterar(cadastroIngresso ingresso, Long idCodigo);
    public cadastroIngresso excluir(Long idCodigo);
    public List<cadastroIngresso> listarTodos();

    public cadastroIngresso obteringressopelocodigo(Long idCodigo);

    public  List<cadastroIngresso> localizar(cadastroIngresso ingresso);
}
