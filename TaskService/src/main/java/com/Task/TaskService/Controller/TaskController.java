package com.Task.TaskService.Controller;

import com.Task.TaskService.Entity.Task;
import com.Task.TaskService.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;


    @PostMapping

    public ResponseEntity<Task> addTask(@RequestBody Task task){

        Task taskAdd=taskService.addTask(task);
        return new ResponseEntity<>(taskAdd, HttpStatus.OK);
    }

    @GetMapping("/{id}")

    public ResponseEntity<Task> getTaskById(@PathVariable Long id){

       return taskService.getTaskById(id)
               .map(task->ResponseEntity.ok(task))
               .orElse(ResponseEntity.notFound().build()); //build used to send back response back to client

    }

    @PutMapping("/{id}")

    public ResponseEntity<Task> updateTask(@PathVariable Long id,@RequestBody Task task){
          Task task1= taskService.updateTask(id,task);
          return new ResponseEntity<>(task1,HttpStatus.OK);
    }


    @DeleteMapping("/{id}")

    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Task>> getTasksByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(taskService.getTasksByUserId(userId));
    }




    @GetMapping("title/{title}")
    public ResponseEntity<List<Task>> getTasksBytitle(@PathVariable String title) {
        return ResponseEntity.ok(taskService.getTasksBytitle(title));
    }
}
