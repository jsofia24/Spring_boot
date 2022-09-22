package com.personalproject.tasks1.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.personalproject.tasks1.exceptions.Tasks1Exceptions;
import com.personalproject.tasks1.mapper.TaskInDTOToTask;
import com.personalproject.tasks1.persistence.entity.Task;
import com.personalproject.tasks1.persistence.entity.TaskStatus;
import com.personalproject.tasks1.persistence.repository.TaskRepository;
import com.personalproject.tasks1.service.dto.TaskInDTO;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDTO taskInDTO) {
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task); 
    }

    public List<Task> findAll() {
        return this.repository.findAll();
    }

    public List<Task> findAllByTaskStatus (TaskStatus status){
        return this.repository.findAllByTaskStatus(status);
    }

    @Transactional
    public void updateTaskFinished(Long id){
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()){
            throw new Tasks1Exceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.markTaskAsFinished(id);
    }

    public void deleteById(Long id) {
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()){
            throw new Tasks1Exceptions("Task not found", HttpStatus.NOT_FOUND);
        }

        this.repository.deleteById(id);
    }
}