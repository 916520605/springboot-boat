-- auto Generated on 2022-11-22
-- DROP TABLE IF EXISTS forecast;
CREATE TABLE t_forecast
(
    id               BIGINT(15) UNIQUE NOT NULL AUTO_INCREMENT COMMENT '主键',
    ship_name        VARCHAR(50)       NOT NULL DEFAULT '' COMMENT '船名',
    imo              VARCHAR(50)       NOT NULL DEFAULT '' COMMENT 'imo号',
    depart_port      VARCHAR(50)       NOT NULL DEFAULT '' COMMENT '始发港',
    last_port        VARCHAR(50)       NOT NULL DEFAULT '' COMMENT '上一港',
    next_port        VARCHAR(50)       NOT NULL DEFAULT '' COMMENT '下一港',
    pore_arrive_time VARCHAR(50)       NOT NULL DEFAULT '' COMMENT '预抵时间',
    pore_leave_time  VARCHAR(50)       NOT NULL DEFAULT '' COMMENT '预离时间',
    dock             VARCHAR(50)       NOT NULL DEFAULT '' COMMENT '靠泊码头',
    port             VARCHAR(50)       NOT NULL DEFAULT '' COMMENT '靠泊泊位',
    purpose          INT(11)           NOT NULL DEFAULT 0 COMMENT '来港目的',
    goods_name       VARCHAR(50)       NOT NULL DEFAULT '' COMMENT '货物名称',
    quantity         DECIMAL(13, 4)    NOT NULL COMMENT '货物数量',
    draft_water      DECIMAL(13, 4) COMMENT '吃水',
    pilot_station    VARCHAR(50)       NOT NULL DEFAULT '' COMMENT '引航站',
    tug_company      VARCHAR(50)       NOT NULL DEFAULT '' COMMENT '拖轮公司',
    remarks          VARCHAR(50)       NOT NULL DEFAULT '' COMMENT '备注',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT 'forecast';
