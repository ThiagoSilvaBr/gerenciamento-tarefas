package com.bn.tasks.controllers;

import com.bn.tasks.models.TarefaModel;
import com.bn.tasks.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;


    @GetMapping
    public ResponseEntity<List<TarefaModel>> listarTodasTarefas(){
        List<TarefaModel> request = tarefaService.listAll();
        return ResponseEntity.ok(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TarefaModel>> procurarTarefaPorId(@PathVariable Long id){
        Optional<TarefaModel> request = tarefaService.findById(id);
        return ResponseEntity.ok().body(request);
    }

    @PostMapping
    public ResponseEntity<TarefaModel> adicionarTarefa(@RequestBody TarefaModel tarefaModel){
        TarefaModel request = tarefaService.salvarTarefa(tarefaModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(request.getId()).toUri();

        return ResponseEntity.created(uri).body(request);
    }

    /*
    @PutMapping("/{id}")
    public ResponseEntity<TarefaModel> atualizarTarefa(@PathVariable Long id, @RequestBody TarefaModel tarefaModel){
        TarefaModel request = tarefaService.atualizarTarefa(id, tarefaModel);
        return ResponseEntity.status(201).body(request);
    }
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarTarefa(@PathVariable Long id){
        tarefaService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }
}
