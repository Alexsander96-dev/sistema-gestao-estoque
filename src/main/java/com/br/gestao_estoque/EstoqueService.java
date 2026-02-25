package com.br.gestao_estoque;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Cerebro do estoque, onde ele guarda materia prima adicionada, retirada, historico das movimentaçoes
public class EstoqueService {
    private List<MateriaPrima> materiasprimas;
    private List<MovimentacaoEstoque> movimentacoes;

    //Construtor
    public EstoqueService(){
        this.materiasprimas = new ArrayList<>();
        this.movimentacoes = new ArrayList<>();
    }

    public void adicionarMateriaPrima(MateriaPrima mp){
        materiasprimas.add(mp);
    }

    public void registraEntrada(MateriaPrima mp, double quantidade){
        mp.adicionarEstoque(quantidade);

        MovimentacaoEstoque mov = new MovimentacaoEstoque(
                mp,
                LocalDateTime.now(),
                quantidade,
                TipoMovimentacao.Entrada
        );
        movimentacoes.add(mov);
    }

    public void registrarSaida(MateriaPrima mp, double quantidade) {
        mp.removerEstoque(quantidade);

        MovimentacaoEstoque mov = new MovimentacaoEstoque(
                mp,
                LocalDateTime.now(),
                quantidade,
                TipoMovimentacao.Saida
        );

        movimentacoes.add(mov);
    }

    public List<MateriaPrima> listarMateriasPrimas() {
        return materiasprimas;
    }

}
