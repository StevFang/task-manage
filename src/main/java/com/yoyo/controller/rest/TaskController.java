package com.yoyo.controller.rest;

import com.alibaba.druid.support.json.JSONUtils;
import com.sun.tools.javac.util.List;
import com.yoyo.common.RespInfo;
import com.yoyo.common.SessionInfo;
import com.yoyo.common.SysEnum;
import com.yoyo.controller.BaseController;
import com.yoyo.form.TaskForm;
import com.yoyo.model.SysUser;
import com.yoyo.model.Task;
import com.yoyo.service.ITaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 任务统一管理类
 *
 * Created by fbin on 2018/3/25.
 */
@RestController
@Scope("prototype")
@RequestMapping("/task")
public class TaskController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(TaskController.class);

    /**返回信息*/
    RespInfo respInfo = new RespInfo();

    @Resource(name="taskService")
    private ITaskService taskService;

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public RespInfo saveTask(HttpServletRequest request,
                             HttpServletResponse response,
                             @RequestParam TaskForm taskForm){
        try{
            if(!validSave(taskForm, respInfo)){
                SysUser sysUser = getSysUser(request, redisService);
                taskService.saveTask(taskForm);
            }
            respInfo.setBySysEnum(SysEnum.OPERATE_SUCCESS);
            return respInfo;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            return respInfo.setBySysEnum(SysEnum.SYS_ERROR);
        }
    }

    @ResponseBody
    @RequestMapping(value="/all", method = RequestMethod.GET)
    public RespInfo getAll(HttpServletRequest request,
                            HttpServletResponse response,
                            @RequestParam TaskForm taskForm){
        try{
            Map<String, Object> gridMap = new HashMap<>();
            int count = taskService.queryCount(taskForm);
            if(count > 0){
                List<Task> tasks = taskService.findAll(taskForm);
                gridMap.put("datas", tasks);
            }
            gridMap.put("total", count);
            respInfo = respInfo.setBySysEnum(SysEnum.QUERY_SUCCESS);
            respInfo.setJson(JSONUtils.toJSONString(gridMap));
            return respInfo;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            return respInfo.setBySysEnum(SysEnum.SYS_ERROR);
        }
    }

    @ResponseBody
    @RequestMapping(value="/{taskID}", method = RequestMethod.GET)
    public RespInfo getSingle(HttpServletRequest request,
                              HttpServletResponse response,
                              @PathVariable("taskID") String taskID,
                              @RequestParam TaskForm taskForm){
        try{
            taskForm.setTaskID(taskID);
            Task task = taskService.findSingle(taskForm);
            respInfo = respInfo.setBySysEnum(SysEnum.QUERY_SUCCESS);
            respInfo.setJson(JSONUtils.toJSONString(task));
            return respInfo;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            return respInfo.setBySysEnum(SysEnum.SYS_ERROR);
        }
    }

    /**
     * 保存参数校验
     * @return
     */
    private boolean validSave(TaskForm taskForm, RespInfo respInfo) {
        if(taskForm == null){
            respInfo.setBySysEnum(SysEnum.PARAMS_VALID_FAILED);
            respInfo.setMsg("待创建的任务数据未获取到!");
            return false;
        }
        return true;
    }

}
