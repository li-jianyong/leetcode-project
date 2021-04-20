package com.springbatch.demo.designpattern.delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * leader需要去完成dosomething这个事情，但是委托给员工去做，内部维护map来去做这些事情
 *  核心在于 leader通过将任务委托给其他类来做，自己维护了一系列员工列表
 */
public class Leader implements Target {
    //领导委派员工做具体的事情
    private Map<String,Target> target = new HashMap<String, Target>();
    public Leader(){
        //领导委派员工A和员工B分别做不同的事情
        target.put("打印文件", new ATarget());
        target.put("测试项目", new BTarget());
    }
    @Override
    public void dosomething(String commond) {
        target.get(commond).dosomething(commond);
    }
}