package com.circles24.repository;

import com.circles24.dao.TaskDao;
import com.circles24.entity.Task;
import lombok.RequiredArgsConstructor;
import org.jdbi.v3.core.Jdbi;

import java.util.List;

@RequiredArgsConstructor()
public class TaskRepository {
    private final Jdbi jdbi;

    public int create(Task task) {
        task.prePersist();
        return jdbi.withExtension(TaskDao.class, dao -> dao.createTask(task));
    }

    public int update(Task task) {
        task.preUpdate();
        return jdbi.withExtension(TaskDao.class, dao -> dao.updateTask(task));
    }

    public Task getById(String taskId) {
        return jdbi.withExtension(TaskDao.class, dao -> dao.getById(taskId));
    }

    public List<Task> getAll() {
        return jdbi.withExtension(TaskDao.class, TaskDao::getAllTasks);
    }
}
