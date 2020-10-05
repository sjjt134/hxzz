package com.hxzz.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.common.lang.Result;
import com.hxzz.demo.entity.PersonX;
import com.hxzz.demo.service.PersonXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hql
 * @since 2020-09-23
 */
@Async
@Component
@Configuration
@EnableScheduling
@RestController
@CrossOrigin
@RequestMapping("/person-x")
public class PersonXController {
    @Autowired
    PersonXService personXService;
    @RequestMapping("/show")
    public Result show(){
        List<JSONObject> list=new ArrayList<>();
        return Result.succ(list);
    }
    @RequestMapping("/info")
    public Result info(@RequestParam(value="time1",required =false) LocalDate time1, @RequestParam(value="time2",
            required = false) LocalDate time2){
        List<JSONObject> list=new ArrayList<>();
        return Result.succ(list);
    }
    @RequestMapping("/delete")
    public Result delete(@RequestParam(value="id",required =false)Integer id){
        personXService.del(id);
        return Result.succ("success");
    }
    @RequestMapping("/add")
    public Result add(@RequestBody PersonX personX){
        personXService.add(personX.getRegion(),personX.getPersonalLeave(),personX.getSickLeave(),
                personX.getAnnualLeave(),personX.getNursingLeave(),personX.getBereavementLeave());
        return Result.succ("success");
    }
    @RequestMapping("/change")
    public Result change(@RequestBody PersonX personX){
        personXService.change(personX.getId(),personX.getRegion(),personX.getPersonalLeave(),personX.getSickLeave(),
                personX.getAnnualLeave(),personX.getNursingLeave(),personX.getBereavementLeave());

        return Result.succ("success");
    }
}
