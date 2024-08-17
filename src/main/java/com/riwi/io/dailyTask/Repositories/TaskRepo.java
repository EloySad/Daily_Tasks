package com.riwi.io.dailyTask.Repositories;

import com.riwi.io.dailyTask.Models.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<TaskModel, Long> {
}
