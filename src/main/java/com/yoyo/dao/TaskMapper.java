package com.yoyo.dao;

import com.sun.tools.javac.util.List;
import com.yoyo.form.TaskForm;
import com.yoyo.model.Task;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by fbin on 2018/3/25.
 */
@Repository(value="taskMapper")
public interface TaskMapper {

    void saveTask(@Param("task") Task task);

    List<Task> findAll(@Param("taskForm") TaskForm taskForm);

    int queryCount(@Param("taskForm") TaskForm taskForm);

    Task findSingle(@Param("taskForm") TaskForm taskForm);

}
