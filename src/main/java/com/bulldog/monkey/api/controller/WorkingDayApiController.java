package com.bulldog.monkey.api.controller;

import com.bulldog.monkey.annotations.PassToken;
import com.bulldog.monkey.annotations.UserLoginToken;
import com.bulldog.monkey.api.model.WorkingDayEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lijian
 * @ClassName WorkingDayApiController
 * @description TODO
 * @date 2019-11-07
 */

@RestController
// @RequestMapping("/api/v1/working_day/")
// @Api(tags = {"工作日相关接口"}, value = "工作日模块")
public class WorkingDayApiController {

    // // 模拟数据库
    // public static List<WorkingDayEntity> workingDayList = new ArrayList<>();
    //
    // static {
    //     WorkingDayEntity workingDays1 = new WorkingDayEntity(1, "michael");
    //     WorkingDayEntity workingDays2 = new WorkingDayEntity(2, "qq");
    //     workingDayList.add(workingDays1);
    //     workingDayList.add(workingDays2);
    // }
    //
    // @PassToken
    // @ApiOperation(value = "工作日列表", notes = "获取全部工作日信息")
    // @RequestMapping(value = "/", method = RequestMethod.GET)
    // public List<WorkingDayEntity> getList() {
    //     return workingDayList;
    // }
    //
    //
    // @ApiOperation(value = "存储工作日", notes = "存储工作日详细信息")
    // @RequestMapping(value = "/", method = RequestMethod.POST)
    // @UserLoginToken
    // public WorkingDayEntity save(@ApiParam(value = "用户信息", required = true)
    //                            @RequestBody WorkingDayEntity workingDay) {
    //     workingDayList.add(workingDay);
    //     return workingDay;
    // }
}
