package com.hxzz.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author hql
 * @since 2020-09-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("Quality")
public class Quality implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;


    private Float offLine;
    private Float acoffLine;
@JsonProperty("dLine")
    private Float dLine;
    private Float acdLine;


    private Float lingYu;
    private Float aclingYu;


    private Float careLine;
    private Float accareLine;


    private Float roadTest;
    private Float acroadTest;

    @JsonProperty("DR")
    private Float DR;
    private  String shift;

    private LocalDate date;


}
