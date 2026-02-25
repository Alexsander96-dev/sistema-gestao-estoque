package com.br.estoque_Gold_Pan;

public class MateriaPrima {
    //Atributos
    private String nome;
    private UnidadeMedida unidadeMedida;
    private double quantidadeAtual;
    private double estoqueMinimo = 0;
    private String fornecedor;

    //Construtor


    public MateriaPrima(String nome, UnidadeMedida unidadeMedida, String fornecedor) {
        this.nome = nome;
        this.unidadeMedida = unidadeMedida;
        this.fornecedor = fornecedor;
        this.quantidadeAtual = 0;
    }

    //Getters


    public String getNome() {
        return nome;
    }

    //Métodos
    public void adicionarEstoque(double quantidadeAtual){
        validarQuantidade(quantidadeAtual);
        this.quantidadeAtual += quantidadeAtual;
    }

    private void validarQuantidade(double quantidadeAtual){
        if (quantidadeAtual <= 0) {
            throw new IllegalArgumentException("Quantidade inválida");
        }

        if (unidadeMedida == UnidadeMedida.Unidade && quantidadeAtual % 1 != 0) {
            throw new IllegalArgumentException("UNIDADE não pode ter valor quebrado");
        }
    }

    public String exibirEstoque() {
        return nome + " - " + quantidadeAtual + " " + unidadeMedida + "|" + fornecedor;
    }

    public void removerEstoque(double quantidade){
        validarQuantidade(quantidade);

        if (quantidade > this.quantidadeAtual){
            throw new IllegalArgumentException("Estoque insuficiente");
        }

        this.quantidadeAtual -= quantidade;
    }

}
