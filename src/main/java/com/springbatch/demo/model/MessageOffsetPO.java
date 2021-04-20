package com.springbatch.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName:MessageOffsetPO
 * @author: Administrator
 * @Date: 2020/11/12 11 32
 **/
@Data
public class MessageOffsetPO {
    private String id;
    private String topic;
    private String kPartition;
    private long offset;
    public MessageOffsetPO(Builder builder) {
        this.id = builder.id;
        this.topic = builder.topic;

    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder{
        private String id;
        private String topic;
        private String kPartition;
        private long offset;
        public Builder() {
        }
        public Builder topic(String topic) {
            this.topic = topic;
            return this;
        }
        public Builder kPartition(String kPartition) {
            this.kPartition = kPartition;
            return this;
        }
        public Builder offset(long offset) {
            this.offset = offset;
            return this;
        }
        public MessageOffsetPO build() {
            return new MessageOffsetPO(this);
        }
    }
}
