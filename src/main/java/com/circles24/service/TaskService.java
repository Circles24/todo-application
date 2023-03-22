package com.circles24.service;

import com.circles24.constant.TaskStatus;
import com.circles24.entity.Task;
import com.circles24.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public void addTask(String description) {
        try {
            Task task = Task.builder()
                    .description(description)
                    .build();
            taskRepository.create(task);
            printTask(task);
        } catch (Exception ex) {
            log.error("error while creating task", ex);
        }
    }

    public void deleteTask(String taskId) {
        try {
            Task task = taskRepository.getById(taskId);
            if (Objects.isNull(task)) {
                log.error("task not found for task id : {}", taskId);
                return;
            }

            task.setStatus(TaskStatus.INACTIVE);
            taskRepository.update(task);
            log.info("deleted task");
        } catch (Exception ex) {
            log.error("error while deleting task", ex);
        }
    }

    public void updateTask(String taskId, String description) {
        try {
            Task task = taskRepository.getById(taskId);
            if (Objects.isNull(task)) {
                log.error("task not found for task id : {}", taskId);
                return;
            }

            task.setDescription(description);
            taskRepository.update(task);
            log.info("updated task");
        } catch (Exception ex) {
            log.error("error while updating task", ex);
        }
    }

    public void getById(String taskId) {
        try{
            Task task = taskRepository.getById(taskId);
            if (Objects.isNull(task)) {
                log.error("task not found with id : {}", taskId);
                return;
            }

            printTask(task);
        } catch (Exception ex) {
            log.error("error while creating task", ex);
        }
    }

    public void getAll() {
        try {
            List<Task> tasks = taskRepository.getAll();
            printTasks(tasks);
        } catch (Exception ex) {
            log.error("error while creating task", ex);
        }
    }

    private void printTask(Task task) {
        log.info("---- task ----");
        log.info("id : {}", task.getId());
        log.info("description : {}", task.getDescription());
        log.info("status : {}", task.getStatus());
        log.info("created at : {}", task.getCreatedAt());
        log.info("updated at : {}", task.getUpdatedAt());
        log.info("\n\n");
    }

    private void printTasks(List<Task> tasks) {
        for (Task task : tasks) {
            printTask(task);
        }
    }
}
