package com.bn.tasks.repositories;

import com.bn.tasks.models.TarefaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<TarefaModel,Long>{
}
