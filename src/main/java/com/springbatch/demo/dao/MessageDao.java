package com.springbatch.demo.dao;

import com.springbatch.demo.model.MessageOffsetPO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MessageDao {

    @Insert(" insert  into tb_yx_message(topic,kPartition,offset) " +
            " values(#{topic},#{kPartition},#{offset})")
    public int insertWinner(MessageOffsetPO MessageOffset);

    //获取偏移
    @Select(" select * from tb_yx_message " +
            " where topic=#{topic} and kPartition=#{kPartition} ")
    public MessageOffsetPO get(@Param("topic") String topic,
                               @Param("kPartition") String partition);

    //更新偏移
    @Update(" update tb_yx_message set offset=#{offset}" +
            " where topic=#{topic} and kPartition=#{kPartition}")
    public int update(@Param("offset") long offset,
                      @Param("topic") String topic,
                      @Param("kPartition") String partition);
}