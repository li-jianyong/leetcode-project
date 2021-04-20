记录kafka exactly once的demo过程
-- 首先需要建立存储topic，partition中的offset记录，建表如下
DROP TABLE IF EXISTS `tb_yx_message`;
CREATE TABLE `tb_yx_message` (
	`id` bigInt(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
	`topic` varchar(128) NOT NULL DEFAULT '' COMMENT '主题' ,
	`kPartition` varchar(128) NOT NULL DEFAULT '0' COMMENT '分区' ,
	`offset` bigInt(20) NOT NULL DEFAULT '' COMMENT '偏移' ,
	PRIMARY KEY (`id`),
	UNIQUE KEY `UNIQ_KEY`(topic,kPartition)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='分区消息表';