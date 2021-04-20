package com.springbatch.demo.service;

import com.springbatch.demo.dao.MessageDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName:ProcessService
 * @author: Administrator
 * @Date: 2020/11/12 11 24
 **/
@Service
@Slf4j
public class ProcessService {

    @Autowired
    MessageDao messageDao;

    @Transactional(rollbackFor = Exception.class)
    public void process(ConsumerRecord<String, String> record){
        log.info(" record:{}",record);
        //对消息进行处理，这里只是简单的打印了一下
        System.out.println(">>>>>>>>>"+Thread.currentThread().getName()+"_"+record);
        //更新偏移量
        messageDao.update(record.offset(),record.topic(),record.partition()+"");
    }
}
