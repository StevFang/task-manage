package com.yoyo.service.impl;

import com.sun.tools.javac.util.List;
import com.yoyo.dao.TaskMapper;
import com.yoyo.form.TaskForm;
import com.yoyo.model.Task;
import com.yoyo.service.ITaskService;
import com.yoyo.utils.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 任务管理服务
 *
 * Created by fbin on 2018/3/25.
 */
@Service("taskService")
@Transactional(rollbackFor = Exception.class)
public class TaskServiceImpl implements ITaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public int saveTask(TaskForm taskForm) throws Exception {
        Task task = taskForm.transferToTask();
        taskMapper.saveTask(task);
        return ConvertUtil.getInt(task.getTaskID());
    }

    @Override
    public int queryCount(TaskForm taskForm) {
        return taskMapper.queryCount(taskForm);
    }

    @Override
    public List<Task> findAll(TaskForm taskForm) {
        return taskMapper.findAll(taskForm);
    }

    @Override
    public Task findSingle(TaskForm taskForm) {
        return taskMapper.findSingle(taskForm);
    }
}
