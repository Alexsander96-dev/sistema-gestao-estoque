package com.br.estoque_Gold_Pan;
// Guardar o historico de entrada e saida.


import java.time.LocalDateTime;

public class MovimentacaoEstoque {
    //Atributos
    private MateriaPrima materiaPrima;
    private TipoMovimentacao tipoMovimentacao;
    private double quantidade;
    private LocalDateTime data;

    //Construtor

    public MovimentacaoEstoque(MateriaPrima materiaPrima, LocalDateTime data, double quantidade, TipoMovimentacao tipoMovimentacao) {
        this.materiaPrima = materiaPrima;
        this.data = LocalDateTime.now();
        this.quantidade = quantidade;
        this.tipoMovimentacao = tipoMovimentacao;
    }

    //Getters

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public LocalDateTime getData() {
        return data;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }
}
