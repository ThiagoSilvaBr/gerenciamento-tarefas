package com.bn.tasks.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_tarefa")
public class TarefaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TarefaDescricao")
    private String descricao;
    @Column(name = "TarefaDataVencimento")
    private LocalDate dataVencimento;
    @Column(name = "TarefaConcluida")
    private Boolean concluida;

    public TarefaModel() {
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public Boolean getConcluida() {
        return concluida;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public void setConcluida(Boolean concluida) {
        this.concluida = concluida;
    }
}
