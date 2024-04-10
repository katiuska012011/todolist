package com.kgonzalez.todolist.services;

import com.kgonzalez.todolist.models.Task;

import java.util.List;

public interface ITask {

    public void add(Task task);
    public Task getById(Long id);
    public List<Task> getAll();
    public void deleteById(Long id);
}
