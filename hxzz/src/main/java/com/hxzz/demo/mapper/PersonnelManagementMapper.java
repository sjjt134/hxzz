package com.hxzz.demo.mapper;

import com.hxzz.demo.bean.PersonnelManagementClient;
import com.hxzz.demo.bean.View;
import com.hxzz.demo.entity.PersonnelManagement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxzz.demo.entity.PersonnelManagement;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author hql
 * @since 2020-09-16
 */
@Component
public interface PersonnelManagementMapper extends BaseMapper<PersonnelManagement> {
    List<PersonnelManagement> show();

    List<PersonnelManagement> showClient();

    List<PersonnelManagement> info(LocalDate date1, LocalDate date2);

    List<PersonnelManagement> infoClient(LocalDate date1, LocalDate date2);

    //最新数据集合
    PersonnelManagement showSum();

    PersonnelManagement infoSum(LocalDate date1, LocalDate date2);
    List<View> each(Integer date, String name);

    View eachYear(Integer date, String name);

    List<View> total(Integer date);

    View totalYear(Integer date);

    void add(String name, Integer establishment, Integer actualNumber, Integer availableNumber,
             Integer shouldArrive, Float actualArrive,String shift, LocalDate date);

    void del(Integer id);

    void change(Integer id, String name, Integer establishment, Integer actualNumber, Integer availableNumber,

                Integer shouldArrive, Float actualArrive,String shift, LocalDate date);


}
