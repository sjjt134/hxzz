package com.hxzz.demo.mapper;

import com.baomidou.mybatisplus.annotation.TableField;
import com.hxzz.demo.bean.PersonDShow;
import com.hxzz.demo.bean.View;
import com.hxzz.demo.entity.PersonD;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author hql
 * @since 2020-09-23
 */
@Component

public interface PersonDMapper extends BaseMapper<PersonD> {
    List<PersonD> show();

    List<PersonDShow> showClient();

    PersonDShow Sum();

    List<PersonD> getData(LocalDate date1, LocalDate date2);

    List<PersonDShow> getClient(LocalDate date1, LocalDate date2);

    PersonDShow sumClient(LocalDate date1, LocalDate date2);
    List<View> each(Integer date, String name);

    View eachYear(Integer date, String name);

    List<View> total(Integer date);

    View totalYear(Integer date);

    void add(String region, Integer personalLeave, Integer sickLeave, Integer annualLeave, Integer nursingLeave,
             Integer bereavementLeave, String shift,LocalDate date);

    void del(Integer id);

    void change(Integer id, String region, Integer personalLeave, Integer sickLeave, Integer annualLeave,
                Integer nursingLeave,
                Integer bereavementLeave, String shift,LocalDate date);
}
