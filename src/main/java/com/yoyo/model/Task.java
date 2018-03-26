package com.yoyo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by fbin on 2018/3/25.
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    private String taskID;// 任务ID

    private String taskNo;// 任务标号

    private String taskTitle;// 任务标题

    private String taskSketch;// 任务简述

    private String taskContent;// 任务详情

    private String taskStartTime;// 任务开始时间

    private String taskEndTime;// 任务结束日期

    private String taskLevel;// 任务紧急程度

    private String taskCreatorID;// 任务创建人ID

    private String taskCreateTime;// 任务创建时间

    private String taskUpdaterID;// 任务修改人ID

    private String taskUpdateTime;// 任务修改时间

    private String validFlag;// 有效标识

    private String modifyCount;// 编辑次数

}
