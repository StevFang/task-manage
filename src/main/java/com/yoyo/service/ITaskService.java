package com.yoyo.service;

import com.sun.tools.javac.util.List;
import com.yoyo.form.TaskForm;
import com.yoyo.model.Task;

/**
 * 任务管理服务
 *
 * Created by fbin on 2018/3/25.
 */
public interface ITaskService {

    /**
     * 保存任务
     * @param taskForm
     * @throws Exception
     */
    int saveTask(TaskForm taskForm) throws Exception;

    int queryCount(TaskForm taskForm);

    List<Task> findAll(TaskForm taskForm);

    Task findSingle(TaskForm taskForm);
}
