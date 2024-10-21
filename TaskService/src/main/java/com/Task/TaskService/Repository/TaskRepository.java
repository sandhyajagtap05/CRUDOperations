package com.Task.TaskService.Repository;

import com.Task.TaskService.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {


    List<Task> findByUserId(Long userId);

    List<Task>getTasksBytitle(String title);
}
