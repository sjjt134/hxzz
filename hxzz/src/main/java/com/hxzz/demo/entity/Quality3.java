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
@TableName("Quality3")
public class Quality3 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;
@JsonProperty("DC")
    @TableField("DC")
    private Integer DC;
    @JsonProperty("DD")
    @TableField("DD")
    private Integer DD;
    @JsonProperty("XB")
    @TableField("XB")
    private Integer XB;
    @JsonProperty("XC")
    @TableField("XC")
    private Integer XC;

    private Integer total;
private  String shift;
    private LocalDate date;


}
