package com.circles24.entity;

import com.circles24.constant.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private String id;

    private String description;

    private TaskStatus status;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    public void merge(Task task) {
        if (StringUtils.isNotBlank(description)) {
            this.setDescription(task.getDescription());
        }

        if (Objects.nonNull(task.status)) {
            this.setStatus(task.status);
        }
    }

    public void prePersist() {
        id = UUID.randomUUID().toString();
        status = TaskStatus.ACTIVE;
        Timestamp now = new Timestamp(System.currentTimeMillis());
        createdAt = now;
        updatedAt = now;
    }

    public void preUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }
}
