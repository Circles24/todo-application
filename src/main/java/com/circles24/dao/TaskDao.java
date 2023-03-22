package com.circles24.dao;

import com.circles24.entity.Task;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface TaskDao {
    @SqlUpdate("INSERT INTO task (id, description, status) VALUES(:id, :description, :status)")
    int createTask(@BindBean Task task);

    @SqlUpdate("UPDATE task set id=:id, description=:description, status=:status")
    int updateTask(@BindBean Task task);

    @SqlQuery("SELECT * FROM task where id=:id")
    @RegisterBeanMapper(Task.class)
    Task getById(@Bind("id") String id);

    @SqlQuery("SELECT * FROM task WHERE status='ACTIVE'")
    @RegisterBeanMapper(Task.class)
    List<Task> getAllTasks();
}
