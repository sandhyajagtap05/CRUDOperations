package com.Task.TaskService.Service;


import aj.org.objectweb.asm.commons.Remapper;
import com.Task.TaskService.Entity.Task;
import com.Task.TaskService.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {


    @Autowired
    TaskRepository taskRepository;
    public Task updateTask(Long id, Task task) {
        return taskRepository.findById(id).map(task1-> {
            task1.setTitle(task.getTitle());
            task1.setDescription(task.getDescription());
            task1.setCompleted(task.isCompleted());
            return taskRepository.save(task1);
        }).orElseThrow(()->new RuntimeException("task not found"));
    }

    public void deleteTask(Long id) {
         taskRepository.deleteById(id);
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public List<Task> getTasksByUserId(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    public List<Task> getTasksBytitle(String title) {
        return  taskRepository.getTasksBytitle(title);
    }
}
