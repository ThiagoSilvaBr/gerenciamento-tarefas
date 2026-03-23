package com.bn.tasks.services;

import com.bn.tasks.models.TarefaModel;
import com.bn.tasks.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<TarefaModel> listAll(){
        return tarefaRepository.findAll();
    }

    public Optional<TarefaModel> findById(Long id){
        return tarefaRepository.findById(id);
    }

    public TarefaModel salvarTarefa(TarefaModel tarefaModel){
        return tarefaRepository.save(tarefaModel);
    }

    /*
    public TarefaModel atualizarTarefa(Long id, TarefaModel tarefaModel){
        TarefaModel tarefa = tarefaRepository.findById(id).get();
        tarefa.setDescricao(tarefaModel.getDescricao());

        return tarefaRepository.save(tarefa);
    }
     */

    public void deletarTarefa(Long id){
        tarefaRepository.deleteById(id);
    }
}
