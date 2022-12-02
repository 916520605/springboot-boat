-- auto Generated on 2022-11-15
-- DROP TABLE IF EXISTS t_delegation;
CREATE TABLE t_delegation
(
    id                   BIGINT(15) UNIQUE NOT NULL AUTO_INCREMENT COMMENT 'id主键',
    company_name         VARCHAR(50)       NOT NULL DEFAULT '' COMMENT '公司名称',
    code_of_organization VARCHAR(50)       NOT NULL DEFAULT '' COMMENT '组织机构代码',
    company_nature       VARCHAR(50)       NOT NULL DEFAULT '' COMMENT '公司性质',
    contact_name         VARCHAR(50)       NOT NULL DEFAULT '' COMMENT '联系人姓名',
    phone_number         VARCHAR(50)       NOT NULL DEFAULT '' COMMENT '电话号码',
    enable_state         INT(11)           NOT NULL DEFAULT 0 COMMENT '启用状态(0启用，1禁用)',
    agent_state          INT(11)           NOT NULL DEFAULT 0 COMMENT '代理状态（0启用，1禁用）',
    create_time          DATETIME          NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT '创建时间',
    update_time          TIMESTAMP         NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT 't_delegation';
