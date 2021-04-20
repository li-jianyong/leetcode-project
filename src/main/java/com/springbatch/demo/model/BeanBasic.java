package com.springbatch.demo.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ClassName:BeanBasic
 * @author: Administrator
 * @Date: 2020/12/14 10 27
 **/
@Data
@Accessors(chain = true)
public class BeanBasic {
    private Integer id;
    private Long createTime;
    private Long updateTime;

}
