package com.yuma.javaarchitect.springtaskappspring.repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.yuma.javaarchitect.springtaskappcore.domain.entity.Task;
import com.yuma.javaarchitect.springtaskappcore.domain.entity.repository.TaskRepo;
import com.yuma.javaarchitect.springtaskappspring.repository.dao.TaskDao;
import com.yuma.javaarchitect.springtaskappspring.repository.dao.TaskDaoEntity;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@Repository
public class SpringTaskRepo implements TaskRepo{

    @NonNull
    private final TaskDao repository;

    private TaskDaoEntity buildEntity(@NonNull Task task, boolean isNew){
        return TaskDaoEntity.builder()
                .num(task.getNum())
                .name(task.getName())
                .content(task.getContent())
                .deadline(task.getDeadline())
                .client(task.getClient())
                .isNew(isNew)
                .build();
    }

    @Override
    public boolean exists(String id) {
        return repository.existsById(id);
    }

    @Override
    public void add(@NonNull Task task) {
        repository.save(buildEntity(task, true));
        
    }

    @Override
    public void update(Task task) {
        repository.deleteById(task.getNum());
        repository.save(buildEntity(task, true));
        
    }

    @Override
    public void remove(String id) {
        repository.deleteById(id);
        
    }
    
}
