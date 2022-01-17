package com.yuma.javaarchitect.springtaskappcore.domain.entity.repository;

import java.util.List;

import com.yuma.javaarchitect.springtaskappcore.domain.entity.Task;

public interface TaskRepo {
    
    boolean exists(String num);

    void add(Task task);

    void update(Task task);

    void remove(String num);
}
