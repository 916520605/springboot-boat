-- auto Generated on 2022-10-26
-- DROP TABLE IF EXISTS pilot_station;
CREATE TABLE pilot_station(
	id BIGINT (15) UNIQUE NOT NULL AUTO_INCREMENT COMMENT '主键',
	`name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '引航站名字',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'pilot_station';
