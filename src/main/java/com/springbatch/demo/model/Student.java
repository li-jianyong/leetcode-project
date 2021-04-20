package com.springbatch.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @ClassName:Student
 * @author: Administrator
 * @Date: 2020/12/14 10 28
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
public class Student extends BeanBasic {
    private String name;
    private String address;
}
