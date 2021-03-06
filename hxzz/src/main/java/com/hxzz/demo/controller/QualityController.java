package com.hxzz.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.hxzz.demo.bean.Date;
import com.hxzz.demo.bean.EquipmentDate;
import com.hxzz.demo.bean.Info;
import com.hxzz.demo.common.lang.Result;
import com.hxzz.demo.entity.Quality;
import com.hxzz.demo.entity.Quality2;
import com.hxzz.demo.result.QualityPackage;
import com.hxzz.demo.service.QualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static java.lang.Integer.parseInt;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hql
 * @since 2020-09-24
 */

@Component
@Configuration
@EnableScheduling
@RestController
@CrossOrigin
@RequestMapping("/Quality")
public class QualityController {
    @Autowired
    QualityService qualityService;
    @Autowired
    QualityPackage qualityPackage;

    @RequestMapping("/show")
    public Result show() {
        List list = new ArrayList<>();
        list = qualityService.show();
        log.println(list);
        return Result.succ(list);
    }

    @RequestMapping("/showClient")
    public Result showClient() {
        List list = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject = qualityPackage.showPackage();
        list = qualityService.showClient();
        list.add(jsonObject);
        return Result.succ(list);
    }

    @RequestMapping("/info")
    public Result info(@RequestBody Info info) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(info.getTime1(), dateTimeFormatter);

        LocalDate date2 = LocalDate.parse(info.getTime2(), dateTimeFormatter);

        PageInfo<Quality> pageInfo = qualityService.findAll(info.getPageNum(), info.getPageSize(), date1, date2);
        log.println(pageInfo);
        return Result.succ(pageInfo);

    }

    @RequestMapping("/infoClient")
    public Result infoClient(@RequestBody Date date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(date.getTime1(), dateTimeFormatter);

        LocalDate date2 = LocalDate.parse(date.getTime2(), dateTimeFormatter);
        List list = new ArrayList();
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject = qualityPackage.ClientPackage(date1, date2);
        list = qualityService.infoClient(date1, date2);
        list.add(jsonObject);


        return Result.succ(list);

    }//质量DR柱状图
    @RequestMapping("/total")
    public Result total(@RequestBody EquipmentDate date) {

        List list = new ArrayList();
        list = qualityPackage.lineTotal(date.getTime());

        return Result.succ(list);

    }

    @RequestMapping("/delete")
    public Result delete(@RequestBody List<JSONObject> list) {

        int size = list.size();
        for (int i = 0; i < size; i++) {
            JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
            jsonObject = list.get(i);
            String Id = jsonObject.getString("id");
            Integer id = parseInt(Id, 10);
            qualityService.del(id);
        }
        return Result.succ("success");
    }

    @RequestMapping("/add")
    public Result add(@RequestBody List<JSONObject> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {

            JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
            jsonObject = list.get(i);
            DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date=LocalDate.parse(jsonObject.getString("date"),dateTimeFormatter);
            log.println(jsonObject);
            qualityService.add(jsonObject.getString("name"),jsonObject.getFloat("offLine"),jsonObject.getFloat(
                    "acoffLine"),jsonObject.getFloat("dLine"),jsonObject.getFloat("acdLine"),jsonObject.getFloat(
                            "lingYu"),jsonObject.getFloat("aclingYu"),jsonObject.getFloat("careLine"),
                    jsonObject.getFloat("accareLine"),jsonObject.getFloat("roadTest"),jsonObject.getFloat("acroadTest"),jsonObject.getString("shift"),date);
        }
        return Result.succ("success");
    }

    @RequestMapping("/change")
    public Result change(@RequestBody List<JSONObject> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {

            JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
            jsonObject = list.get(i);
            DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date=LocalDate.parse(jsonObject.getString("date"),dateTimeFormatter);
            qualityService.change(jsonObject.getInteger("id"),jsonObject.getString("name"),jsonObject.getFloat(
                    "offLine"),
                    jsonObject.getFloat(
                    "acoffLine"),jsonObject.getFloat("dLine"),jsonObject.getFloat("acdLine"),jsonObject.getFloat(
                    "lingYu"),jsonObject.getFloat("aclingYu"),jsonObject.getFloat("careLine"),
                    jsonObject.getFloat("accareLine"),jsonObject.getFloat("roadTest"),jsonObject.getFloat("acroadTest"),jsonObject.getString("shift"),date);
        }
        return Result.succ("success");
    }
}
