package com.hxzz.demo.result;

import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.service.Quality2Service;
import com.hxzz.demo.service.QualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Configuration
@Component
public class Quality2Package {
    @Autowired
    Quality2Service quality2Service;

    public JSONObject showPackage() {
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject.put("productionLine", "合计");
        jsonObject.put("breakpoint", quality2Service.showSum().getBreakpoint());
        jsonObject.put("paa", quality2Service.showSum().getPaa());
        jsonObject.put("ptr", quality2Service.showSum().getPtr());
        jsonObject.put("craft", quality2Service.showSum().getCraft());
        jsonObject.put("tools", quality2Service.showSum().getTools());
        jsonObject.put("total", quality2Service.showSum().getTotal());
        jsonObject.put("date", quality2Service.showSum().getDate());

        return jsonObject;

    }


    public JSONObject ClientPackage(LocalDate date1, LocalDate date2) {
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject.put("productionLine", "合计");
        jsonObject.put("breakpoint", quality2Service.infoSum(date1, date2).getBreakpoint());
        jsonObject.put("paa", quality2Service.infoSum(date1, date2).getPaa());
        jsonObject.put("ptr", quality2Service.infoSum(date1, date2).getPtr());
        jsonObject.put("craft", quality2Service.infoSum(date1, date2).getCraft());
        jsonObject.put("tools", quality2Service.infoSum(date1, date2).getTools());
        jsonObject.put("total", quality2Service.infoSum(date1, date2).getTotal());
        jsonObject.put("date", quality2Service.infoSum(date1, date2).getDate());
        return jsonObject;
    }
    public List lineTotal(String date) {
        List list = new ArrayList();

        String string=date.substring(0,4);
        log.println(string);

        Integer date2=Integer.valueOf(string);
        log.println(date2);

        list.addAll(quality2Service.total(date2));
        return list;
    }

    public List line(String date, String name) {

        List list = new ArrayList();
        String string=date.substring(0,4);
        log.println(string);

        Integer date2=Integer.valueOf(string);
        log.println(date2);

        list.addAll(quality2Service.each(date2, name));
        return list;
    }

}
