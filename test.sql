/*
 Navicat Premium Data Transfer

 Source Server         : LYP
 Source Server Type    : MySQL
 Source Server Version : 80028 (8.0.28)
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80028 (8.0.28)
 File Encoding         : 65001

 Date: 05/03/2023 19:12:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pilot_station
-- ----------------------------
DROP TABLE IF EXISTS `pilot_station`;
CREATE TABLE `pilot_station`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '引航站名字',
  `help_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '助记码',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'pilot_station' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pilot_station
-- ----------------------------
INSERT INTO `pilot_station` VALUES (2, '上海引航站', 'SHYHZ');
INSERT INTO `pilot_station` VALUES (4, '靖江引航站', 'JJYHZ');
INSERT INTO `pilot_station` VALUES (23, '长江引航站', 'CCYHZ');
INSERT INTO `pilot_station` VALUES (24, '江阴引航站', 'JYYHZ');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dict_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `status` int NULL DEFAULT 0 COMMENT '0正常1停用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '字典类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES (13, '来港目的', '来港目的列表', 0, '2022-11-14 11:46:55', '2022-12-04 13:08:11', 'sys_arrival_destination');
INSERT INTO `sys_dict` VALUES (16, '船舶性质', '船舶性质列表', 0, '2023-01-31 18:05:26', NULL, 'sys_ship_nature');

-- ----------------------------
-- Table structure for sys_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dict_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典id',
  `item_text` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典项文本',
  `item_value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典项值',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `sort_order` int NULL DEFAULT NULL COMMENT '排序',
  `status` int NULL DEFAULT 0 COMMENT '状态（0启用 1不启用）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典类型',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_table_dict_id`(`dict_id` ASC) USING BTREE,
  INDEX `index_table_sort_order`(`sort_order` ASC) USING BTREE,
  INDEX `index_table_dict_status`(`status` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典项表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_dict_item
-- ----------------------------
INSERT INTO `sys_dict_item` VALUES (9, '13', '卸货', '0', '来港卸货', 1, 0, '2022-11-14 11:47:53', '2022-12-12 21:16:10', 'sys_arrival_destination');
INSERT INTO `sys_dict_item` VALUES (10, '13', '装货', '1', '来港装货', 2, 0, '2022-11-14 11:48:12', '2022-12-04 13:08:11', 'sys_arrival_destination');
INSERT INTO `sys_dict_item` VALUES (11, '13', '其他', '2', '来港其他', 3, 0, '2022-11-14 11:48:26', '2022-12-04 13:08:11', 'sys_arrival_destination');
INSERT INTO `sys_dict_item` VALUES (13, '13', '修船', '3', '来港修船', 4, 0, '2022-11-30 12:21:39', '2023-02-20 02:36:28', 'sys_arrival_destination');
INSERT INTO `sys_dict_item` VALUES (18, '16', '散货船', '0', '散货船', 0, 1, '2023-01-31 18:05:46', '2023-02-25 20:29:56', 'sys_ship_nature');
INSERT INTO `sys_dict_item` VALUES (19, '16', '危险品船', '1', '危险品船', 1, 0, '2023-01-31 18:06:31', NULL, 'sys_ship_nature');
INSERT INTO `sys_dict_item` VALUES (20, '16', '件杂货船', '2', '件杂货船', 2, 0, '2023-01-31 18:07:26', NULL, 'sys_ship_nature');
INSERT INTO `sys_dict_item` VALUES (21, '16', '集装箱船', '3', '集装箱船', 3, 0, '2023-01-31 18:07:48', NULL, 'sys_ship_nature');
INSERT INTO `sys_dict_item` VALUES (22, '16', '特种船', '4', '特种船舶', 4, 0, '2023-01-31 18:09:50', NULL, 'sys_ship_nature');
INSERT INTO `sys_dict_item` VALUES (23, '16', '油轮', '5', '油轮', 5, 0, '2023-01-31 18:10:30', NULL, 'sys_ship_nature');

-- ----------------------------
-- Table structure for t_baseship
-- ----------------------------
DROP TABLE IF EXISTS `t_baseship`;
CREATE TABLE `t_baseship`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `shipName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `builtDate` date NULL DEFAULT NULL,
  `imo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nationality` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `grossTonnage` decimal(10, 2) NULL DEFAULT NULL,
  `netTons` decimal(10, 2) NULL DEFAULT NULL,
  `DWT` decimal(10, 2) NULL DEFAULT NULL,
  `homePort` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shipOwner` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `callNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phoneNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `length` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `width` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '1',
  `creatTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `email_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ship_nature` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '基本信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_baseship
-- ----------------------------
INSERT INTO `t_baseship` VALUES (1, '神华538', '2022-09-15', '96325', 'USA', 46538.00, 36423.00, 68975.00, '连云港', '神华中海航运有限公司', NULL, NULL, '199.99', NULL, '1', '2022-09-22 20:24:10', NULL, NULL);
INSERT INTO `t_baseship` VALUES (3, '安诚山', '2007-02-22', '78956', 'CHN', 46538.00, 36423.00, 56565.00, '湛江', '中远海运散货运输有限公司', '5T6F', NULL, '155.23', NULL, '1', '2022-09-23 04:00:57', NULL, NULL);
INSERT INTO `t_baseship` VALUES (4, '艾丽莎', NULL, '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '0', '2022-09-24 19:10:27', NULL, NULL);
INSERT INTO `t_baseship` VALUES (5, '波塞冬', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', '2022-09-24 19:14:35', NULL, NULL);
INSERT INTO `t_baseship` VALUES (6, '阿波罗', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', '2022-09-24 19:15:11', NULL, NULL);
INSERT INTO `t_baseship` VALUES (7, '雅典娜', '2022-09-13', '1234', NULL, 456.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', '2022-09-24 19:16:04', NULL, NULL);
INSERT INTO `t_baseship` VALUES (8, '阿尔泰斯', NULL, NULL, NULL, NULL, NULL, NULL, 'CNTP', NULL, NULL, NULL, NULL, NULL, '1', '2022-09-24 19:58:26', NULL, NULL);
INSERT INTO `t_baseship` VALUES (9, '奥丁', NULL, NULL, 'ARM', NULL, NULL, NULL, 'CNTP', NULL, NULL, NULL, NULL, NULL, '1', '2022-09-24 20:18:01', NULL, NULL);
INSERT INTO `t_baseship` VALUES (10, '芙蕾雅', '2022-11-08', '4567890', 'AND', NULL, NULL, NULL, 'TWSUO', NULL, NULL, NULL, NULL, NULL, '1', '2022-09-24 22:08:53', NULL, NULL);
INSERT INTO `t_baseship` VALUES (11, '洒点水', NULL, '111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', '2022-09-24 23:03:28', NULL, NULL);
INSERT INTO `t_baseship` VALUES (17, '1231245设施', NULL, '2223', 'AIA', 55566.00, 456565.00, NULL, 'CNTP', '这个是测试的船东名字', NULL, NULL, NULL, NULL, '0', '2022-09-29 00:40:54', NULL, NULL);
INSERT INTO `t_baseship` VALUES (18, '艾丽莎', NULL, NULL, NULL, 456.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', '2022-09-29 00:40:54', NULL, NULL);
INSERT INTO `t_baseship` VALUES (19, '测试船舶', '2000-04-07', '9966665', 'CHE', 567890.00, 12345.00, 45678.00, 'CNTP', 'test.company.com', 'R6794', '1888888888', '188.88', '54.12', '1', '2022-11-22 08:20:14', 'zzzxlyp@qq.com', '2');
INSERT INTO `t_baseship` VALUES (22, 'wwww1', NULL, '7845', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', '2023-01-30 22:23:23', NULL, '1');
INSERT INTO `t_baseship` VALUES (23, 'wwww2', NULL, '45', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', '2023-01-30 22:23:23', NULL, NULL);

-- ----------------------------
-- Table structure for t_delegation
-- ----------------------------
DROP TABLE IF EXISTS `t_delegation`;
CREATE TABLE `t_delegation`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `company_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '公司名称',
  `code_of_organization` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '组织机构代码',
  `company_nature` int NOT NULL DEFAULT 0 COMMENT '公司性质',
  `contact_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '联系人姓名',
  `phone_number` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '电话号码',
  `enable_state` int NOT NULL DEFAULT 0 COMMENT '启用状态(0启用，1禁用)',
  `agent_state` int NOT NULL DEFAULT 0 COMMENT '代理状态（0启用，1禁用）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ship_owner_state` int NOT NULL DEFAULT 0 COMMENT '船东状态',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 't_delegation' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_delegation
-- ----------------------------
INSERT INTO `t_delegation` VALUES (1, '鑫佳船舶代理有限公司', '11111111', 1, '测试名称', '1888888888', 1, 0, '2022-11-16 11:24:35', '2023-01-30 16:58:25', 1, 'zzzxlyp@qq.com');
INSERT INTO `t_delegation` VALUES (2, '神华中海航运有限公司', '2222', 1, '是的是的', '223334', 0, 1, '2022-11-17 14:24:15', '2023-01-30 17:06:02', 0, 'shenhua11@shenhua.cn');

-- ----------------------------
-- Table structure for t_dock
-- ----------------------------
DROP TABLE IF EXISTS `t_dock`;
CREATE TABLE `t_dock`  (
  `dock_id` bigint NOT NULL AUTO_INCREMENT,
  `dock_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dock_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`dock_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '码头表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_dock
-- ----------------------------
INSERT INTO `t_dock` VALUES (1, '通常码头', '001');
INSERT INTO `t_dock` VALUES (6, '新增', '003');
INSERT INTO `t_dock` VALUES (14, '测试', '002');
INSERT INTO `t_dock` VALUES (17, '靖江扬子江码头', '004');

-- ----------------------------
-- Table structure for t_forecast
-- ----------------------------
DROP TABLE IF EXISTS `t_forecast`;
CREATE TABLE `t_forecast`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ship_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '船名',
  `imo` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT 'imo号',
  `depart_port` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '始发港',
  `last_port` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '上一港',
  `next_port` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '下一港',
  `pore_arrive_time` datetime NULL DEFAULT NULL COMMENT '预抵时间',
  `pore_leave_time` datetime NULL DEFAULT NULL COMMENT '预离时间',
  `dock` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '靠泊码头',
  `port` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '靠泊泊位',
  `purpose` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '来港目的',
  `goods_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '货物名称',
  `quantity` decimal(13, 4) NULL DEFAULT NULL COMMENT '货物数量',
  `draft_water` decimal(13, 2) NULL DEFAULT NULL COMMENT '吃水',
  `pilot_station` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '引航站',
  `tug_company` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '拖轮公司',
  `remarks` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '备注',
  `voyage` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '航次',
  `base_ship_id` bigint NOT NULL COMMENT '基础船舶id',
  `delegation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '代理',
  `tug` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '拖轮',
  PRIMARY KEY (`id`, `base_ship_id`) USING BTREE,
  UNIQUE INDEX `id`(`id` ASC) USING BTREE,
  INDEX `base_ship_id`(`base_ship_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'forecast' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_forecast
-- ----------------------------
INSERT INTO `t_forecast` VALUES (3, '测试船舶', '9966665', '', '', '', '2022-12-10 13:32:32', '2022-12-21 13:32:37', '', '', '0', '', 123456.7890, NULL, '', '', '', '2022', 19, NULL, NULL);
INSERT INTO `t_forecast` VALUES (5, '芙蕾雅', '4567890', '', '', '', NULL, NULL, '', '', '2', '', NULL, NULL, '', '', '', '2022112901', 10, NULL, NULL);
INSERT INTO `t_forecast` VALUES (6, '阿尔泰斯', '', '', '', '', NULL, NULL, '', '', '0', '', NULL, NULL, '', '', '', NULL, 8, NULL, NULL);
INSERT INTO `t_forecast` VALUES (7, 'wwww1', '7845', '', '', '', NULL, NULL, '', '', '0', '', NULL, NULL, '', '', '', '222', 22, NULL, NULL);
INSERT INTO `t_forecast` VALUES (8, '阿波罗', '', '', '', '', NULL, NULL, '', '', NULL, '', NULL, NULL, '', '', '', '202333', 6, NULL, NULL);

-- ----------------------------
-- Table structure for t_nationality
-- ----------------------------
DROP TABLE IF EXISTS `t_nationality`;
CREATE TABLE `t_nationality`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `number_code` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `letter_code` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `country_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `letter_code`(`letter_code` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 250 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '国籍信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_nationality
-- ----------------------------
INSERT INTO `t_nationality` VALUES (1, '020', 'AND', '安道尔');
INSERT INTO `t_nationality` VALUES (2, '784', 'ARE', '阿联酋');
INSERT INTO `t_nationality` VALUES (3, '004', 'AFG', '阿富汗');
INSERT INTO `t_nationality` VALUES (4, '028', 'ATG', '安提瓜和巴布达');
INSERT INTO `t_nationality` VALUES (5, '660', 'AIA', '安圭拉');
INSERT INTO `t_nationality` VALUES (6, '008', 'ALB', '阿尔巴尼亚');
INSERT INTO `t_nationality` VALUES (7, '051', 'ARM', '亚美尼亚');
INSERT INTO `t_nationality` VALUES (8, '024', 'AGO', '安哥拉');
INSERT INTO `t_nationality` VALUES (9, '010', 'ATA', '南极洲');
INSERT INTO `t_nationality` VALUES (10, '032', 'ARG', '阿根廷');
INSERT INTO `t_nationality` VALUES (11, '016', 'ASM', '美属萨摩亚');
INSERT INTO `t_nationality` VALUES (12, '040', 'AUT', '奥地利');
INSERT INTO `t_nationality` VALUES (13, '036', 'AUS', '澳大利亚');
INSERT INTO `t_nationality` VALUES (14, '533', 'ABW', '阿鲁巴');
INSERT INTO `t_nationality` VALUES (15, '248', 'ALA', '奥兰群岛');
INSERT INTO `t_nationality` VALUES (16, '031', 'AZE', '阿塞拜疆');
INSERT INTO `t_nationality` VALUES (17, '070', 'BIH', '波黑');
INSERT INTO `t_nationality` VALUES (18, '052', 'BRB', '巴巴多斯');
INSERT INTO `t_nationality` VALUES (19, '050', 'BGD', '孟加拉');
INSERT INTO `t_nationality` VALUES (20, '056', 'BEL', '比利时');
INSERT INTO `t_nationality` VALUES (21, '854', 'BFA', '布基纳法索');
INSERT INTO `t_nationality` VALUES (22, '100', 'BGR', '保加利亚');
INSERT INTO `t_nationality` VALUES (23, '048', 'BHR', '巴林');
INSERT INTO `t_nationality` VALUES (24, '108', 'BDI', '布隆迪');
INSERT INTO `t_nationality` VALUES (25, '204', 'BEN', '贝宁');
INSERT INTO `t_nationality` VALUES (26, '652', 'BLM', '圣巴泰勒米岛');
INSERT INTO `t_nationality` VALUES (27, '060', 'BMU', '百慕大');
INSERT INTO `t_nationality` VALUES (28, '096', 'BRN', '文莱');
INSERT INTO `t_nationality` VALUES (29, '068', 'BOL', '玻利维亚');
INSERT INTO `t_nationality` VALUES (30, '535', 'BES', '荷兰加勒比区');
INSERT INTO `t_nationality` VALUES (31, '076', 'BRA', '巴西');
INSERT INTO `t_nationality` VALUES (32, '044', 'BHS', '巴哈马');
INSERT INTO `t_nationality` VALUES (33, '064', 'BTN', '不丹');
INSERT INTO `t_nationality` VALUES (34, '074', 'BVT', '布韦岛');
INSERT INTO `t_nationality` VALUES (35, '072', 'BWA', '博茨瓦纳');
INSERT INTO `t_nationality` VALUES (36, '112', 'BLR', '白俄罗斯');
INSERT INTO `t_nationality` VALUES (37, '084', 'BLZ', '伯利兹');
INSERT INTO `t_nationality` VALUES (38, '124', 'CAN', '加拿大');
INSERT INTO `t_nationality` VALUES (39, '166', 'CCK', '科科斯群岛');
INSERT INTO `t_nationality` VALUES (40, '140', 'CAF', '中非');
INSERT INTO `t_nationality` VALUES (41, '756', 'CHE', '瑞士');
INSERT INTO `t_nationality` VALUES (42, '152', 'CHL', '智利');
INSERT INTO `t_nationality` VALUES (43, '120', 'CMR', '喀麦隆');
INSERT INTO `t_nationality` VALUES (44, '170', 'COL', '哥伦比亚');
INSERT INTO `t_nationality` VALUES (45, '188', 'CRI', '哥斯达黎加');
INSERT INTO `t_nationality` VALUES (46, '192', 'CUB', '古巴');
INSERT INTO `t_nationality` VALUES (47, '132', 'CPV', '佛得角');
INSERT INTO `t_nationality` VALUES (48, '162', 'CXR', '圣诞岛');
INSERT INTO `t_nationality` VALUES (49, '196', 'CYP', '塞浦路斯');
INSERT INTO `t_nationality` VALUES (50, '203', 'CZE', '捷克');
INSERT INTO `t_nationality` VALUES (51, '276', 'DEU', '德国');
INSERT INTO `t_nationality` VALUES (52, '262', 'DJI', '吉布提');
INSERT INTO `t_nationality` VALUES (53, '208', 'DNK', '丹麦');
INSERT INTO `t_nationality` VALUES (54, '212', 'DMA', '多米尼克');
INSERT INTO `t_nationality` VALUES (55, '214', 'DOM', '多米尼加');
INSERT INTO `t_nationality` VALUES (56, '012', 'DZA', '阿尔及利亚');
INSERT INTO `t_nationality` VALUES (57, '218', 'ECU', '厄瓜多尔');
INSERT INTO `t_nationality` VALUES (58, '233', 'EST', '爱沙尼亚');
INSERT INTO `t_nationality` VALUES (59, '818', 'EGY', '埃及');
INSERT INTO `t_nationality` VALUES (60, '732', 'ESH', '西撒哈拉');
INSERT INTO `t_nationality` VALUES (61, '232', 'ERI', '厄立特里亚');
INSERT INTO `t_nationality` VALUES (62, '724', 'ESP', '西班牙');
INSERT INTO `t_nationality` VALUES (63, '246', 'FIN', '芬兰');
INSERT INTO `t_nationality` VALUES (64, '242', 'FJI', '斐济群岛');
INSERT INTO `t_nationality` VALUES (65, '238', 'FLK', '马尔维纳斯群岛（ 福克兰）');
INSERT INTO `t_nationality` VALUES (66, '583', 'FSM', '密克罗尼西亚联邦');
INSERT INTO `t_nationality` VALUES (67, '234', 'FRO', '法罗群岛');
INSERT INTO `t_nationality` VALUES (68, '250', 'FRA', '法国');
INSERT INTO `t_nationality` VALUES (69, '266', 'GAB', '加蓬');
INSERT INTO `t_nationality` VALUES (70, '308', 'GRD', '格林纳达');
INSERT INTO `t_nationality` VALUES (71, '268', 'GEO', '格鲁吉亚');
INSERT INTO `t_nationality` VALUES (72, '254', 'GUF', '法属圭亚那');
INSERT INTO `t_nationality` VALUES (73, '288', 'GHA', '加纳');
INSERT INTO `t_nationality` VALUES (74, '292', 'GIB', '直布罗陀');
INSERT INTO `t_nationality` VALUES (75, '304', 'GRL', '格陵兰');
INSERT INTO `t_nationality` VALUES (76, '324', 'GIN', '几内亚');
INSERT INTO `t_nationality` VALUES (77, '312', 'GLP', '瓜德罗普');
INSERT INTO `t_nationality` VALUES (78, '226', 'GNQ', '赤道几内亚');
INSERT INTO `t_nationality` VALUES (79, '300', 'GRC', '希腊');
INSERT INTO `t_nationality` VALUES (80, '239', 'SGS', '南乔治亚岛和南桑威奇群岛');
INSERT INTO `t_nationality` VALUES (81, '320', 'GTM', '危地马拉');
INSERT INTO `t_nationality` VALUES (82, '316', 'GUM', '关岛');
INSERT INTO `t_nationality` VALUES (83, '624', 'GNB', '几内亚比绍');
INSERT INTO `t_nationality` VALUES (84, '328', 'GUY', '圭亚那');
INSERT INTO `t_nationality` VALUES (85, '344', 'HKG', '香港');
INSERT INTO `t_nationality` VALUES (86, '334', 'HMD', '赫德岛和麦克唐纳群岛');
INSERT INTO `t_nationality` VALUES (87, '340', 'HND', '洪都拉斯');
INSERT INTO `t_nationality` VALUES (88, '191', 'HRV', '克罗地亚');
INSERT INTO `t_nationality` VALUES (89, '332', 'HTI', '海地');
INSERT INTO `t_nationality` VALUES (90, '348', 'HUN', '匈牙利');
INSERT INTO `t_nationality` VALUES (91, '360', 'IDN', '印尼');
INSERT INTO `t_nationality` VALUES (92, '372', 'IRL', '爱尔兰');
INSERT INTO `t_nationality` VALUES (93, '376', 'ISR', '以色列');
INSERT INTO `t_nationality` VALUES (94, '833', 'IMN', '马恩岛');
INSERT INTO `t_nationality` VALUES (95, '356', 'IND', '印度');
INSERT INTO `t_nationality` VALUES (96, '086', 'IOT', '英属印度洋领地');
INSERT INTO `t_nationality` VALUES (97, '368', 'IRQ', '伊拉克');
INSERT INTO `t_nationality` VALUES (98, '364', 'IRN', '伊朗');
INSERT INTO `t_nationality` VALUES (99, '352', 'ISL', '冰岛');
INSERT INTO `t_nationality` VALUES (100, '380', 'ITA', '意大利');
INSERT INTO `t_nationality` VALUES (101, '832', 'JEY', '泽西岛');
INSERT INTO `t_nationality` VALUES (102, '388', 'JAM', '牙买加');
INSERT INTO `t_nationality` VALUES (103, '400', 'JOR', '约旦');
INSERT INTO `t_nationality` VALUES (104, '392', 'JPN', '日本');
INSERT INTO `t_nationality` VALUES (105, '116', 'KHM', '柬埔寨');
INSERT INTO `t_nationality` VALUES (106, '296', 'KIR', '基里巴斯');
INSERT INTO `t_nationality` VALUES (107, '174', 'COM', '科摩罗');
INSERT INTO `t_nationality` VALUES (108, '414', 'KWT', '科威特');
INSERT INTO `t_nationality` VALUES (109, '136', 'CYM', '开曼群岛');
INSERT INTO `t_nationality` VALUES (110, '422', 'LBN', '黎巴嫩');
INSERT INTO `t_nationality` VALUES (111, '438', 'LIE', '列支敦士登');
INSERT INTO `t_nationality` VALUES (112, '144', 'LKA', '斯里兰卡');
INSERT INTO `t_nationality` VALUES (113, '430', 'LBR', '利比里亚');
INSERT INTO `t_nationality` VALUES (114, '426', 'LSO', '莱索托');
INSERT INTO `t_nationality` VALUES (115, '440', 'LTU', '立陶宛');
INSERT INTO `t_nationality` VALUES (116, '442', 'LUX', '卢森堡');
INSERT INTO `t_nationality` VALUES (117, '428', 'LVA', '拉脱维亚');
INSERT INTO `t_nationality` VALUES (118, '434', 'LBY', '利比亚');
INSERT INTO `t_nationality` VALUES (119, '504', 'MAR', '摩洛哥');
INSERT INTO `t_nationality` VALUES (120, '492', 'MCO', '摩纳哥');
INSERT INTO `t_nationality` VALUES (121, '498', 'MDA', '摩尔多瓦');
INSERT INTO `t_nationality` VALUES (122, '499', 'MNE', '黑山');
INSERT INTO `t_nationality` VALUES (123, '663', 'MAF', '法属圣马丁');
INSERT INTO `t_nationality` VALUES (124, '450', 'MDG', '马达加斯加');
INSERT INTO `t_nationality` VALUES (125, '584', 'MHL', '马绍尔群岛');
INSERT INTO `t_nationality` VALUES (126, '807', 'MKD', '马其顿');
INSERT INTO `t_nationality` VALUES (127, '466', 'MLI', '马里');
INSERT INTO `t_nationality` VALUES (128, '104', 'MMR', '缅甸');
INSERT INTO `t_nationality` VALUES (129, '446', 'MAC', '澳门');
INSERT INTO `t_nationality` VALUES (130, '474', 'MTQ', '马提尼克');
INSERT INTO `t_nationality` VALUES (131, '478', 'MRT', '毛里塔尼亚');
INSERT INTO `t_nationality` VALUES (132, '500', 'MSR', '蒙塞拉特岛');
INSERT INTO `t_nationality` VALUES (133, '470', 'MLT', '马耳他');
INSERT INTO `t_nationality` VALUES (134, '462', 'MDV', '马尔代夫');
INSERT INTO `t_nationality` VALUES (135, '454', 'MWI', '马拉维');
INSERT INTO `t_nationality` VALUES (136, '484', 'MEX', '墨西哥');
INSERT INTO `t_nationality` VALUES (137, '458', 'MYS', '马来西亚');
INSERT INTO `t_nationality` VALUES (138, '516', 'NAM', '纳米比亚');
INSERT INTO `t_nationality` VALUES (139, '562', 'NER', '尼日尔');
INSERT INTO `t_nationality` VALUES (140, '574', 'NFK', '诺福克岛');
INSERT INTO `t_nationality` VALUES (141, '566', 'NGA', '尼日利亚');
INSERT INTO `t_nationality` VALUES (142, '558', 'NIC', '尼加拉瓜');
INSERT INTO `t_nationality` VALUES (143, '528', 'NLD', '荷兰');
INSERT INTO `t_nationality` VALUES (144, '578', 'NOR', '挪威');
INSERT INTO `t_nationality` VALUES (145, '524', 'NPL', '尼泊尔');
INSERT INTO `t_nationality` VALUES (146, '520', 'NRU', '瑙鲁');
INSERT INTO `t_nationality` VALUES (147, '512', 'OMN', '阿曼');
INSERT INTO `t_nationality` VALUES (148, '591', 'PAN', '巴拿马');
INSERT INTO `t_nationality` VALUES (149, '604', 'PER', '秘鲁');
INSERT INTO `t_nationality` VALUES (150, '258', 'PYF', '法属波利尼西亚');
INSERT INTO `t_nationality` VALUES (151, '598', 'PNG', '巴布亚新几内亚');
INSERT INTO `t_nationality` VALUES (152, '608', 'PHL', '菲律宾');
INSERT INTO `t_nationality` VALUES (153, '586', 'PAK', '巴基斯坦');
INSERT INTO `t_nationality` VALUES (154, '616', 'POL', '波兰');
INSERT INTO `t_nationality` VALUES (155, '612', 'PCN', '皮特凯恩群岛');
INSERT INTO `t_nationality` VALUES (156, '630', 'PRI', '波多黎各');
INSERT INTO `t_nationality` VALUES (157, '275', 'PSE', '巴勒斯坦');
INSERT INTO `t_nationality` VALUES (158, '585', 'PLW', '帕劳');
INSERT INTO `t_nationality` VALUES (159, '600', 'PRY', '巴拉圭');
INSERT INTO `t_nationality` VALUES (160, '634', 'QAT', '卡塔尔');
INSERT INTO `t_nationality` VALUES (161, '638', 'REU', '留尼汪');
INSERT INTO `t_nationality` VALUES (162, '642', 'ROU', '罗马尼亚');
INSERT INTO `t_nationality` VALUES (163, '688', 'SRB', '塞尔维亚');
INSERT INTO `t_nationality` VALUES (164, '643', 'RUS', '俄罗斯');
INSERT INTO `t_nationality` VALUES (165, '646', 'RWA', '卢旺达');
INSERT INTO `t_nationality` VALUES (166, '090', 'SLB', '所罗门群岛');
INSERT INTO `t_nationality` VALUES (167, '690', 'SYC', '塞舌尔');
INSERT INTO `t_nationality` VALUES (168, '729', 'SDN', '苏丹');
INSERT INTO `t_nationality` VALUES (169, '752', 'SWE', '瑞典');
INSERT INTO `t_nationality` VALUES (170, '702', 'SGP', '新加坡');
INSERT INTO `t_nationality` VALUES (171, '705', 'SVN', '斯洛文尼亚');
INSERT INTO `t_nationality` VALUES (172, '744', 'SJM', '斯瓦尔巴群岛和 扬马延岛');
INSERT INTO `t_nationality` VALUES (173, '703', 'SVK', '斯洛伐克');
INSERT INTO `t_nationality` VALUES (174, '694', 'SLE', '塞拉利昂');
INSERT INTO `t_nationality` VALUES (175, '674', 'SMR', '圣马力诺');
INSERT INTO `t_nationality` VALUES (176, '686', 'SEN', '塞内加尔');
INSERT INTO `t_nationality` VALUES (177, '706', 'SOM', '索马里');
INSERT INTO `t_nationality` VALUES (178, '740', 'SUR', '苏里南');
INSERT INTO `t_nationality` VALUES (179, '728', 'SSD', '南苏丹');
INSERT INTO `t_nationality` VALUES (180, '678', 'STP', '圣多美和普林西比');
INSERT INTO `t_nationality` VALUES (181, '222', 'SLV', '萨尔瓦多');
INSERT INTO `t_nationality` VALUES (182, '760', 'SYR', '叙利亚');
INSERT INTO `t_nationality` VALUES (183, '748', 'SWZ', '斯威士兰');
INSERT INTO `t_nationality` VALUES (184, '796', 'TCA', '特克斯和凯科斯群岛');
INSERT INTO `t_nationality` VALUES (185, '148', 'TCD', '乍得');
INSERT INTO `t_nationality` VALUES (186, '768', 'TGO', '多哥');
INSERT INTO `t_nationality` VALUES (187, '764', 'THA', '泰国');
INSERT INTO `t_nationality` VALUES (188, '772', 'TKL', '托克劳');
INSERT INTO `t_nationality` VALUES (189, '626', 'TLS', '东帝汶');
INSERT INTO `t_nationality` VALUES (190, '788', 'TUN', '突尼斯');
INSERT INTO `t_nationality` VALUES (191, '776', 'TON', '汤加');
INSERT INTO `t_nationality` VALUES (192, '792', 'TUR', '土耳其');
INSERT INTO `t_nationality` VALUES (193, '798', 'TUV', '图瓦卢');
INSERT INTO `t_nationality` VALUES (194, '834', 'TZA', '坦桑尼亚');
INSERT INTO `t_nationality` VALUES (195, '804', 'UKR', '乌克兰');
INSERT INTO `t_nationality` VALUES (196, '800', 'UGA', '乌干达');
INSERT INTO `t_nationality` VALUES (197, '840', 'USA', '美国');
INSERT INTO `t_nationality` VALUES (198, '858', 'URY', '乌拉圭');
INSERT INTO `t_nationality` VALUES (199, '336', 'VAT', '梵蒂冈');
INSERT INTO `t_nationality` VALUES (200, '862', 'VEN', '委内瑞拉');
INSERT INTO `t_nationality` VALUES (201, '092', 'VGB', '英属维尔京群岛');
INSERT INTO `t_nationality` VALUES (202, '850', 'VIR', '美属维尔京群岛');
INSERT INTO `t_nationality` VALUES (203, '704', 'VNM', '越南');
INSERT INTO `t_nationality` VALUES (204, '876', 'WLF', '瓦利斯和富图纳');
INSERT INTO `t_nationality` VALUES (205, '882', 'WSM', '萨摩亚');
INSERT INTO `t_nationality` VALUES (206, '887', 'YEM', '也门');
INSERT INTO `t_nationality` VALUES (207, '175', 'MYT', '马约特');
INSERT INTO `t_nationality` VALUES (208, '710', 'ZAF', '南非');
INSERT INTO `t_nationality` VALUES (209, '894', 'ZMB', '赞比亚');
INSERT INTO `t_nationality` VALUES (210, '716', 'ZWE', '津巴布韦');
INSERT INTO `t_nationality` VALUES (211, '156', 'CHN', '中国 内地');
INSERT INTO `t_nationality` VALUES (212, '178', 'COG', '刚果（布）');
INSERT INTO `t_nationality` VALUES (213, '180', 'COD', '刚果（金）');
INSERT INTO `t_nationality` VALUES (214, '508', 'MOZ', '莫桑比克');
INSERT INTO `t_nationality` VALUES (215, '831', 'GGY', '根西岛');
INSERT INTO `t_nationality` VALUES (216, '270', 'GMB', '冈比亚');
INSERT INTO `t_nationality` VALUES (217, '580', 'MNP', '北马里亚纳群岛');
INSERT INTO `t_nationality` VALUES (218, '231', 'ETH', '埃塞俄比亚');
INSERT INTO `t_nationality` VALUES (219, '540', 'NCL', '新喀里多尼亚');
INSERT INTO `t_nationality` VALUES (220, '548', 'VUT', '瓦努阿图');
INSERT INTO `t_nationality` VALUES (221, '260', 'ATF', '法属南部领地');
INSERT INTO `t_nationality` VALUES (222, '570', 'NIU', '纽埃');
INSERT INTO `t_nationality` VALUES (223, '581', 'UMI', '美国本土外小岛屿');
INSERT INTO `t_nationality` VALUES (224, '184', 'COK', '库克群岛');
INSERT INTO `t_nationality` VALUES (225, '826', 'GBR', '英国');
INSERT INTO `t_nationality` VALUES (226, '780', 'TTO', '特立尼达和多巴哥');
INSERT INTO `t_nationality` VALUES (227, '670', 'VCT', '圣文森特和格林纳丁斯');
INSERT INTO `t_nationality` VALUES (228, '158', 'TWN', '台湾地区/台湾省');
INSERT INTO `t_nationality` VALUES (229, '554', 'NZL', '新西兰');
INSERT INTO `t_nationality` VALUES (230, '682', 'SAU', '沙特阿拉伯');
INSERT INTO `t_nationality` VALUES (231, '418', 'LAO', '老挝');
INSERT INTO `t_nationality` VALUES (232, '408', 'PRK', '朝鲜 北朝鲜');
INSERT INTO `t_nationality` VALUES (233, '410', 'KOR', '韩国 南朝鲜');
INSERT INTO `t_nationality` VALUES (234, '620', 'PRT', '葡萄牙');
INSERT INTO `t_nationality` VALUES (235, '417', 'KGZ', '吉尔吉斯斯坦');
INSERT INTO `t_nationality` VALUES (236, '398', 'KAZ', '哈萨克斯坦');
INSERT INTO `t_nationality` VALUES (237, '762', 'TJK', '塔吉克斯坦');
INSERT INTO `t_nationality` VALUES (238, '795', 'TKM', '土库曼斯坦');
INSERT INTO `t_nationality` VALUES (239, '860', 'UZB', '乌兹别克斯坦');
INSERT INTO `t_nationality` VALUES (240, '659', 'KNA', '圣基茨和尼维斯');
INSERT INTO `t_nationality` VALUES (241, '666', 'SPM', '圣皮埃尔和密克隆');
INSERT INTO `t_nationality` VALUES (242, '654', 'SHN', '圣赫勒拿');
INSERT INTO `t_nationality` VALUES (243, '662', 'LCA', '圣卢西亚');
INSERT INTO `t_nationality` VALUES (244, '480', 'MUS', '毛里求斯');
INSERT INTO `t_nationality` VALUES (245, '384', 'CIV', '科特迪瓦');
INSERT INTO `t_nationality` VALUES (246, '404', 'KEN', '肯尼亚');
INSERT INTO `t_nationality` VALUES (247, '496', 'MNG', '蒙古国 蒙古');

-- ----------------------------
-- Table structure for t_port
-- ----------------------------
DROP TABLE IF EXISTS `t_port`;
CREATE TABLE `t_port`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `dock_id` bigint NULL DEFAULT NULL,
  `port_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `port_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `port_draft` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '泊位表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_port
-- ----------------------------
INSERT INTO `t_port` VALUES (1, 1, '1号泊位', '001', '6.60');
INSERT INTO `t_port` VALUES (15, 1, '1231', '898', '123.00');
INSERT INTO `t_port` VALUES (16, 1, '1231323', '1232313123', '9999.00');
INSERT INTO `t_port` VALUES (17, 1, '111', '32323', '11.00');
INSERT INTO `t_port` VALUES (18, 1, '111', '2332', '1.00');
INSERT INTO `t_port` VALUES (19, 1, '111', '444', '3.00');
INSERT INTO `t_port` VALUES (27, 6, '4号泊位', '7788', '');
INSERT INTO `t_port` VALUES (31, 6, '2号泊位', '7878', '');
INSERT INTO `t_port` VALUES (32, 6, '1号泊位', '333', '5');
INSERT INTO `t_port` VALUES (33, 6, '3号泊位', '2222222222', '7.9');
INSERT INTO `t_port` VALUES (38, 14, '1号测试泊位', '1', '6.9');
INSERT INTO `t_port` VALUES (39, 14, '2号测试泊位', '2', '6.6');
INSERT INTO `t_port` VALUES (40, 14, '3号测试泊位', '3', '6.8');
INSERT INTO `t_port` VALUES (43, 1, '5号泊位', '5', '6.9');
INSERT INTO `t_port` VALUES (44, 14, '4号测试泊位', '4', '6.6');
INSERT INTO `t_port` VALUES (45, 14, '5号测试泊位', '7', '3.6');
INSERT INTO `t_port` VALUES (48, 6, '5号泊位', '23453424', '5.6');
INSERT INTO `t_port` VALUES (50, 17, '2号泊位', '003', '6.9');
INSERT INTO `t_port` VALUES (51, 17, '3号泊位', '004', '5.5');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '111', '222');

-- ----------------------------
-- Table structure for t_wordport
-- ----------------------------
DROP TABLE IF EXISTS `t_wordport`;
CREATE TABLE `t_wordport`  (
  `port_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `port_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '世界港口信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_wordport
-- ----------------------------
INSERT INTO `t_wordport` VALUES ('CNTP', '台北', 1);
INSERT INTO `t_wordport` VALUES ('TWKAO', '高雄', 2);
INSERT INTO `t_wordport` VALUES ('TWSUO', '苏澳', 3);
INSERT INTO `t_wordport` VALUES ('CNHLN', '花莲', 4);
INSERT INTO `t_wordport` VALUES ('TWTAO', '桃园', 5);

-- ----------------------------
-- Table structure for tug
-- ----------------------------
DROP TABLE IF EXISTS `tug`;
CREATE TABLE `tug`  (
  `tug_id` bigint NOT NULL AUTO_INCREMENT COMMENT '拖船id',
  `tug_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '拖轮名字',
  `tug_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '拖船代码',
  `tug_company_id` bigint NOT NULL COMMENT '拖轮公司id',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `creat_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创造时间',
  PRIMARY KEY (`tug_id`) USING BTREE,
  UNIQUE INDEX `tug_id`(`tug_id` ASC) USING BTREE,
  INDEX `tug_company_id`(`tug_company_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'tug' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tug
-- ----------------------------
INSERT INTO `tug` VALUES (1, '锦江拖', 'JJT', 2, '2022-11-03 20:19:31', '2022-10-30 05:01:44');
INSERT INTO `tug` VALUES (8, '拖轮测试1', 'TLCS1', 3, '2022-11-05 08:13:13', '2022-11-04 09:32:29');
INSERT INTO `tug` VALUES (10, '拖轮测试1', 'TLCS1', 9, '2022-11-05 08:13:19', '2022-11-04 09:32:36');
INSERT INTO `tug` VALUES (11, 'sdfsdf ', 'SDFSDFSDFSD', 2, '2022-11-05 08:10:12', '2022-11-04 09:33:31');
INSERT INTO `tug` VALUES (14, 'dsdfsw', 'SDSF', 2, '2022-11-05 09:18:17', '2022-11-05 09:18:09');
INSERT INTO `tug` VALUES (18, 'zxzzz', 'XCXZ', 19, '2022-11-05 09:19:36', '2022-11-05 09:19:24');

-- ----------------------------
-- Table structure for tug_company
-- ----------------------------
DROP TABLE IF EXISTS `tug_company`;
CREATE TABLE `tug_company`  (
  `tug_company_id` bigint NOT NULL AUTO_INCREMENT COMMENT '名字标识',
  `company_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '公司名称',
  `company_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '公司代码',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `creat_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创造时间',
  PRIMARY KEY (`tug_company_id`) USING BTREE,
  UNIQUE INDEX `tug_company_id`(`tug_company_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'tug_company' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tug_company
-- ----------------------------
INSERT INTO `tug_company` VALUES (2, '靖江港盛12', 'JJGSS', '2022-11-02 22:39:43', '2022-10-31 07:29:23');
INSERT INTO `tug_company` VALUES (3, '泰州拖轮1', 'TZTL', '2022-11-02 22:39:50', '2022-10-31 07:29:42');
INSERT INTO `tug_company` VALUES (8, '公司测试', 'GSCS', NULL, '2022-11-02 06:03:03');
INSERT INTO `tug_company` VALUES (9, '公司测试2', 'GSXRY', NULL, '2022-11-02 06:04:14');
INSERT INTO `tug_company` VALUES (19, '测试1', 'CSDFDS', '2022-11-02 22:40:29', '2022-11-02 22:40:22');
INSERT INTO `tug_company` VALUES (20, '公司测试3', 'GSCS', NULL, '2022-11-05 08:14:04');

SET FOREIGN_KEY_CHECKS = 1;
