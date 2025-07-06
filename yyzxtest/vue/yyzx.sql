/*
 Navicat Premium Data Transfer

 Source Server         : mybatis
 Source Server Type    : MySQL
 Source Server Version : 80041
 Source Host           : localhost:3306
 Source Schema         : yyzx

 Target Server Type    : MySQL
 Target Server Version : 80041
 File Encoding         : 65001

 Date: 05/07/2025 10:25:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bed
-- ----------------------------
DROP TABLE IF EXISTS `bed`;
CREATE TABLE `bed`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `room_no` int NOT NULL COMMENT '房间编号',
  `bed_status` int NOT NULL COMMENT '房间状态 1：空闲  2：有人  3：外出',
  `remarks` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  `bed_no` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '床位编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bed
-- ----------------------------
INSERT INTO `bed` VALUES (6, 1001, 2, NULL, '1001-1');
INSERT INTO `bed` VALUES (7, 1001, 2, NULL, '1001-2');
INSERT INTO `bed` VALUES (8, 1002, 2, NULL, '1002-1');
INSERT INTO `bed` VALUES (9, 1002, 2, NULL, '1002-2');
INSERT INTO `bed` VALUES (10, 1003, 1, NULL, '1003-1');
INSERT INTO `bed` VALUES (11, 1004, 2, NULL, '1004-1');
INSERT INTO `bed` VALUES (12, 1005, 1, NULL, '1005-1');
INSERT INTO `bed` VALUES (13, 1005, 1, NULL, '1005-2');
INSERT INTO `bed` VALUES (14, 1006, 1, NULL, '1006-1');
INSERT INTO `bed` VALUES (15, 1006, 2, NULL, '1006-2');
INSERT INTO `bed` VALUES (16, 1007, 1, NULL, '1007-1');
INSERT INTO `bed` VALUES (17, 1007, 1, NULL, '1007-2');
INSERT INTO `bed` VALUES (18, 1008, 1, NULL, '1008-1');
INSERT INTO `bed` VALUES (19, 1009, 1, NULL, '1009-1');
INSERT INTO `bed` VALUES (21, 1009, 1, NULL, '1009-2');
INSERT INTO `bed` VALUES (22, 1010, 2, NULL, '1010-1');
INSERT INTO `bed` VALUES (23, 1010, 1, NULL, '1010-2');
INSERT INTO `bed` VALUES (24, 1011, 1, NULL, '1011-1');
INSERT INTO `bed` VALUES (25, 1012, 1, NULL, '1012-1');
INSERT INTO `bed` VALUES (26, 1012, 2, NULL, '1012-2');
INSERT INTO `bed` VALUES (27, 1013, 1, NULL, '1013-1');
INSERT INTO `bed` VALUES (28, 1014, 1, NULL, '1014-1');
INSERT INTO `bed` VALUES (29, 1015, 1, NULL, '1015-1');
INSERT INTO `bed` VALUES (30, 1015, 1, NULL, '1015-2');
INSERT INTO `bed` VALUES (31, 1016, 1, NULL, '1016-1');
INSERT INTO `bed` VALUES (32, 1017, 2, NULL, '1017-1');
INSERT INTO `bed` VALUES (33, 1018, 1, NULL, '1018-1');
INSERT INTO `bed` VALUES (34, 2001, 1, NULL, '2001-1');
INSERT INTO `bed` VALUES (35, 2002, 2, NULL, '2002-1');
INSERT INTO `bed` VALUES (36, 2003, 1, NULL, '2003-1');
INSERT INTO `bed` VALUES (37, 2004, 1, NULL, '2004-1');
INSERT INTO `bed` VALUES (38, 2005, 2, NULL, '2005-1');
INSERT INTO `bed` VALUES (39, 2006, 1, NULL, '2006-1');
INSERT INTO `bed` VALUES (40, 2007, 1, NULL, '2007-1');
INSERT INTO `bed` VALUES (41, 2008, 1, NULL, '2008-1');
INSERT INTO `bed` VALUES (42, 2009, 1, NULL, '2009-1');
INSERT INTO `bed` VALUES (43, 2009, 1, NULL, '2009-2');
INSERT INTO `bed` VALUES (44, 2010, 1, NULL, '2010-1');
INSERT INTO `bed` VALUES (45, 2011, 1, NULL, '2011-1');
INSERT INTO `bed` VALUES (46, 2012, 1, NULL, '2012-1');
INSERT INTO `bed` VALUES (47, 2013, 1, NULL, '2013-1');
INSERT INTO `bed` VALUES (48, 2014, 2, NULL, '2014-1');
INSERT INTO `bed` VALUES (49, 2015, 1, NULL, '2015-1');
INSERT INTO `bed` VALUES (50, 2016, 1, NULL, '2016-1');
INSERT INTO `bed` VALUES (51, 2017, 2, NULL, '2017-1');
INSERT INTO `bed` VALUES (52, 2018, 2, NULL, '2018-1');

-- ----------------------------
-- Table structure for beddetails
-- ----------------------------
DROP TABLE IF EXISTS `beddetails`;
CREATE TABLE `beddetails`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `start_date` date NULL DEFAULT NULL COMMENT '床位起始日期',
  `end_date` date NULL DEFAULT NULL COMMENT '床位结束日期',
  `bed_details` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '床位详情信息',
  `customer_id` int NULL DEFAULT NULL COMMENT '顾客ID',
  `bed_id` int NULL DEFAULT NULL COMMENT '床位ID',
  `is_deleted` int NULL DEFAULT NULL COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 70 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of beddetails
-- ----------------------------
INSERT INTO `beddetails` VALUES (45, '2023-11-17', '2025-06-25', '606#1001-1', 27, 6, 1);
INSERT INTO `beddetails` VALUES (46, '2023-11-17', '2024-11-30', '606#1002-2', 28, 9, 0);
INSERT INTO `beddetails` VALUES (49, '2023-11-17', '2023-11-23', '606#2001-1', 30, 34, 1);
INSERT INTO `beddetails` VALUES (50, '2023-11-17', '2025-11-27', '606#2002-1', 29, 35, 0);
INSERT INTO `beddetails` VALUES (51, '2023-11-17', '2025-11-29', '606#2017-1', 31, 51, 0);
INSERT INTO `beddetails` VALUES (52, '2023-11-17', '2023-11-21', '606#2015-1', 32, 49, 1);
INSERT INTO `beddetails` VALUES (53, '2023-11-17', '2024-11-29', '606#2014-1', 33, 48, 0);
INSERT INTO `beddetails` VALUES (54, '2023-11-17', '2025-01-30', '606#1006-2', 34, 15, 0);
INSERT INTO `beddetails` VALUES (55, '2023-11-17', '2024-11-30', '606#1017-1', 35, 32, 0);
INSERT INTO `beddetails` VALUES (56, '2023-11-17', '2025-11-26', '606#1010-1', 36, 22, 0);
INSERT INTO `beddetails` VALUES (57, '2023-11-17', '2025-11-20', '606#1012-2', 37, 26, 0);
INSERT INTO `beddetails` VALUES (58, '2023-11-17', '2025-11-29', '606#2005-1', 38, 38, 0);
INSERT INTO `beddetails` VALUES (59, '2023-11-17', '2025-07-03', '606#1014-1', 39, 28, 1);
INSERT INTO `beddetails` VALUES (60, '2023-11-17', '2025-11-29', '606#2012-1', 40, 46, 0);
INSERT INTO `beddetails` VALUES (61, '2023-11-21', '2024-01-15', '606#2016-1', 32, 50, 1);
INSERT INTO `beddetails` VALUES (62, '2023-11-23', '2025-12-26', '606#2018-1', 30, 52, 0);
INSERT INTO `beddetails` VALUES (63, '2024-01-03', '2024-02-03', '606#1004-1', 41, 11, 0);
INSERT INTO `beddetails` VALUES (64, '2024-01-03', '2024-02-16', '606#1005-1', 41, 12, 0);
INSERT INTO `beddetails` VALUES (65, '2024-01-15', '2025-06-16', '606#1005-2', 32, 13, 1);
INSERT INTO `beddetails` VALUES (66, '2025-06-16', '2025-06-25', '606#1002-1', 32, 8, 1);
INSERT INTO `beddetails` VALUES (67, '2025-06-25', '2025-11-24', '606#1001-2', 27, 7, 0);
INSERT INTO `beddetails` VALUES (68, '2025-06-25', '2027-11-12', '606#1001-1', 32, 6, 0);
INSERT INTO `beddetails` VALUES (69, '2025-07-03', '2024-11-30', '606#1002-1', 39, 8, 0);

-- ----------------------------
-- Table structure for checkout
-- ----------------------------
DROP TABLE IF EXISTS `checkout`;
CREATE TABLE `checkout`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `is_deleted` int NOT NULL COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  `customer_id` int NOT NULL COMMENT '客户id',
  `checkout_type` int NOT NULL COMMENT '退住原因（0：死亡；1：正常；2：保留）',
  `checkout_time` date NOT NULL COMMENT '退住时间',
  `audit_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '审批状态 0-已提交 1-同意  2-拒绝',
  `audit_person` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '审批人',
  `audit_time` date NULL DEFAULT NULL COMMENT '审批时间',
  `checkout_reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '退住原因',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of checkout
-- ----------------------------
INSERT INTO `checkout` VALUES (1, '1', 0, 40, 1, '2025-06-28', '1', '', NULL, '我');
INSERT INTO `checkout` VALUES (2, '1', 1, 40, 1, '2025-06-28', '0', NULL, NULL, '2');
INSERT INTO `checkout` VALUES (3, NULL, 1, 28, 2, '2025-06-30', '0', NULL, NULL, '1');
INSERT INTO `checkout` VALUES (4, NULL, 1, 28, 2, '2025-06-28', '0', NULL, NULL, '1');
INSERT INTO `checkout` VALUES (5, NULL, 0, 30, 0, '2025-06-28', '2', NULL, NULL, '1');
INSERT INTO `checkout` VALUES (6, NULL, 0, 33, 1, '2025-06-28', '1', NULL, NULL, '你好我叫派大星');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `is_deleted` int NOT NULL COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  `customer_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '客户姓名',
  `customer_age` int NOT NULL COMMENT '年龄',
  `customer_sex` int NOT NULL COMMENT '性别  0：男  1：女',
  `idcard` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '身份证号',
  `room_no` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '房间号',
  `building_no` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '所属楼房',
  `checkin_date` date NOT NULL COMMENT '入住时间',
  `expiration_date` date NOT NULL COMMENT '合同到期时间',
  `contact_tel` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '联系电话',
  `bed_id` int NULL DEFAULT NULL COMMENT '床号',
  `psychosomatic_state` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '身心状况',
  `attention` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '注意事项',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `height` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '身高',
  `weight` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '体重',
  `blood_type` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '血型',
  `filepath` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '头像路径',
  `user_id` int NULL DEFAULT NULL COMMENT '关联系统健康管家(护工)  无管家设置  -1',
  `level_id` int NULL DEFAULT NULL COMMENT '护理等级',
  `family_member` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '家属',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `nurselevel_customer_fk`(`level_id` ASC) USING BTREE,
  INDEX `user_customer_fk`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21313 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (23, 0, 'w', 2, 0, '324342', '22', '22', '2025-07-02', '2025-07-02', '12312', 2, NULL, NULL, NULL, NULL, NULL, 'A', '@', 4, 1, NULL);
INSERT INTO `customer` VALUES (24, 1, '高廉武', 84, 0, '610404194103010017', '1002', '606', '2023-11-17', '2024-11-30', '13767675481', 9, '', '', '1941-03-01', '', '', 'A', '@/assets/tou.png', 6, 1, '高校蓝');
INSERT INTO `customer` VALUES (28, 1, '高廉武', 84, 0, '610404194103010017', '1002', '606', '2023-11-17', '2024-11-30', '13767675481', 9, '', '', '1941-03-01', '', '', 'A', '@/assets/tou.png', 5, NULL, '高校蓝');
INSERT INTO `customer` VALUES (29, 0, '刘玉珍', 72, 1, '610402194112240335', '2002', '606', '2023-11-17', '2025-11-27', '13534786754', 35, '', NULL, '1951-12-24', NULL, NULL, 'B', '@/assets/tou.png', 6, NULL, '刘宇');
INSERT INTO `customer` VALUES (30, 0, '石秀英', 73, 1, '610422195102220029', '2018', '606', '2023-11-17', '2025-12-31', '13867541321', 52, '', NULL, '1951-02-22', NULL, NULL, 'O', '@/assets/tou.png', 6, NULL, '石杰颖');
INSERT INTO `customer` VALUES (31, 0, '何风云', 62, 1, '610402196111166507', '2017', '606', '2023-11-17', '2025-11-29', '18765652312', 51, '', NULL, '1961-11-16', NULL, NULL, 'O', '@/assets/tou.png', -1, NULL, '何方');
INSERT INTO `customer` VALUES (32, 0, '毛兰香', 73, 1, '61040419501227002x', '1001', '606', '2023-11-17', '2027-11-12', '15816164587', 6, '', NULL, '1950-12-27', NULL, NULL, 'O', '@/assets/tou.png', -1, NULL, '毛参');
INSERT INTO `customer` VALUES (33, 0, '李艾青', 83, 1, '622801194104150240', '2014', '606', '2023-11-17', '2024-11-29', '18176572345', 48, '', NULL, '1941-04-14', NULL, NULL, 'B', '@/assets/tou.png', -1, NULL, '李天');
INSERT INTO `customer` VALUES (34, 0, '刘海云', 64, 0, '510522196005042710', '1006', '606', '2023-11-17', '2025-01-30', '18798986545', 15, '', NULL, '1960-05-04', NULL, NULL, 'O', '@/assets/tou.png', 3, NULL, '刘高');
INSERT INTO `customer` VALUES (35, 0, '王金堂', 58, 0, '610402196511056517', '1017', '606', '2023-11-17', '2024-11-30', '13423786754', 32, '', NULL, '1965-11-05', NULL, NULL, 'AB', '@/assets/tou.png', 6, NULL, '王田雨');
INSERT INTO `customer` VALUES (36, 0, '刘玉亭', 72, 0, '610123195204158510', '1010', '606', '2023-11-17', '2025-11-26', '18767560987', 22, '', NULL, '1952-04-15', NULL, NULL, 'O', '@/assets/tou.png', 5, NULL, '刘晓');
INSERT INTO `customer` VALUES (37, 0, '陈泉', 68, 0, '61040219560313030x', '1012', '606', '2023-11-17', '2025-11-20', '18567546712', 26, '', NULL, '1956-03-13', NULL, NULL, 'O', '@/assets/tou.png', 3, NULL, '陈荣光');
INSERT INTO `customer` VALUES (38, 0, '苗月兰', 67, 1, '622725195701081429', '2005', '606', '2023-11-17', '2025-11-29', '18367541987', 38, '', NULL, '1957-01-08', NULL, NULL, 'A', '@/assets/tou.png', NULL, NULL, '苗存义');
INSERT INTO `customer` VALUES (39, 0, '张帆', 77, 0, '610402194701286518', '1002', '606', '2023-11-17', '2024-11-30', '17745189064', 8, '', NULL, '1947-01-28', NULL, NULL, 'O', '@/assets/tou.png', 2, NULL, '张明');
INSERT INTO `customer` VALUES (40, 0, '孙瑞英', 68, 1, '610404195603010027', '2012', '606', '2023-11-17', '2025-11-29', '18167564213', 46, '', NULL, '1956-03-01', NULL, NULL, 'O', '@/assets/tou.png', 2, NULL, '孙石');
INSERT INTO `customer` VALUES (41, 0, '许三多', 0, 0, '210330198902011510', '1004', '606', '2024-01-03', '2024-02-03', '13398760987', 11, '过敏', NULL, '2024-01-03', NULL, NULL, 'O', '@/assets/tou.png', 2, NULL, '许多');
INSERT INTO `customer` VALUES (232, 0, '23', 23, 0, '23122', '12', '12', '2025-07-02', '2025-07-02', '12312312312', 2, NULL, NULL, NULL, NULL, NULL, 'A', '@', NULL, NULL, NULL);
INSERT INTO `customer` VALUES (21312, 0, '23', 1231, 0, '12312312', '12', '12', '2025-07-02', '2025-07-02', '12131231', 2, NULL, NULL, '2025-07-02', NULL, NULL, 'A', '@', 4, NULL, NULL);

-- ----------------------------
-- Table structure for customernurseitem
-- ----------------------------
DROP TABLE IF EXISTS `customernurseitem`;
CREATE TABLE `customernurseitem`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `item_id` int NOT NULL COMMENT '护理项目编号，关联 nursing_service(id)',
  `customer_id` int NOT NULL COMMENT '客户编号',
  `level_id` int NULL DEFAULT NULL COMMENT '护理级别编号，关联 nursing_level(id)',
  `nurse_number` int NOT NULL COMMENT '购买数量',
  `is_deleted` int NULL DEFAULT NULL COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  `buy_time` date NOT NULL COMMENT '服务购买日期',
  `maturity_time` date NOT NULL COMMENT '服务到期日',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_cni_item`(`item_id` ASC) USING BTREE,
  INDEX `idx_cni_level`(`level_id` ASC) USING BTREE,
  INDEX `fk_cni_customer`(`customer_id` ASC) USING BTREE,
  CONSTRAINT `fk_cni_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_cni_level` FOREIGN KEY (`level_id`) REFERENCES `nursing_level` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_cni_service` FOREIGN KEY (`item_id`) REFERENCES `nursing_service` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 102 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '客户—护理项目购买记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customernurseitem
-- ----------------------------
INSERT INTO `customernurseitem` VALUES (46, 2, 23, 2, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (47, 3, 23, 2, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (48, 2, 23, 2, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (49, 3, 23, 2, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (50, 2, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (51, 6, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (52, 5, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (53, 4, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (54, 3, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (55, 2, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (56, 6, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (57, 5, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (58, 4, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (59, 3, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (60, 2, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (61, 6, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (62, 5, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (63, 4, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (64, 3, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (65, 2, 23, 2, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (66, 3, 23, 2, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (67, 2, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (68, 6, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (69, 5, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (70, 4, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (71, 3, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (72, 2, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (73, 6, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (74, 5, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (75, 4, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (76, 3, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (77, 2, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (78, 6, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (79, 5, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (80, 4, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (81, 3, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (82, 2, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (83, 6, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (84, 5, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (85, 4, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (86, 3, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (87, 2, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (88, 6, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (89, 5, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (90, 4, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (91, 3, 23, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (92, 2, 23, 1, 1, 0, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (93, 6, 23, 1, 1, 0, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (94, 5, 23, 1, 1, 0, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (95, 4, 23, 1, 1, 0, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (96, 3, 23, 1, 1, 0, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (97, 2, 24, 1, 0, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (98, 6, 24, 1, 0, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (99, 5, 24, 1, 0, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (100, 4, 24, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (101, 3, 24, 1, 1, 1, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (102, 2, 24, 1, 1, 0, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (103, 6, 24, 1, 0, 0, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (104, 5, 24, 1, 0, 0, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (105, 4, 24, 1, 1, 0, '2025-07-04', '2025-10-04');
INSERT INTO `customernurseitem` VALUES (106, 3, 24, 1, 1, 0, '2025-07-04', '2025-10-04');

-- ----------------------------
-- Table structure for level_item
-- ----------------------------
DROP TABLE IF EXISTS `level_item`;
CREATE TABLE `level_item`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `level_id` int NOT NULL COMMENT '关联护理级别',
  `item_id` int NOT NULL COMMENT '关联护理项目',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_level`(`level_id` ASC) USING BTREE,
  INDEX `idx_item`(`item_id` ASC) USING BTREE,
  CONSTRAINT `fk_level_item_level` FOREIGN KEY (`level_id`) REFERENCES `nursing_level` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_level_item_service` FOREIGN KEY (`item_id`) REFERENCES `nursing_service` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 172 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '级别与项目关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of level_item
-- ----------------------------
INSERT INTO `level_item` VALUES (109, 1, 2);
INSERT INTO `level_item` VALUES (163, 2, 2);
INSERT INTO `level_item` VALUES (164, 2, 3);
INSERT INTO `level_item` VALUES (165, 1, 6);
INSERT INTO `level_item` VALUES (166, 4, 5);
INSERT INTO `level_item` VALUES (167, 4, 3);
INSERT INTO `level_item` VALUES (168, 4, 4);
INSERT INTO `level_item` VALUES (169, 1, 5);
INSERT INTO `level_item` VALUES (170, 1, 4);
INSERT INTO `level_item` VALUES (171, 1, 3);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menus_index` varchar(5) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '一级菜单索引',
  `title` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '菜单标题',
  `icon` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '菜单图标',
  `path` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '菜单路径',
  `parent_id` int NULL DEFAULT NULL COMMENT '父级Id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '1', '床位管理', 'Operation', NULL, 0);
INSERT INTO `menu` VALUES (2, '2', '客户管理', 'User', NULL, 0);
INSERT INTO `menu` VALUES (4, '4', '护理管理', 'SuitcaseLine', NULL, 0);
INSERT INTO `menu` VALUES (5, '5', '健康管家', 'Coin', NULL, 0);
INSERT INTO `menu` VALUES (6, '6', '用户管理', 'Avatar', NULL, 0);
INSERT INTO `menu` VALUES (7, NULL, '床位示意图', 'Picture', '/bed/bedMap', 1);
INSERT INTO `menu` VALUES (8, NULL, '床位管理', 'Collection', '/bed/bedManage', 1);
INSERT INTO `menu` VALUES (9, NULL, '入住登记', 'DArrowRight', '/customer/checkIn', 2);
INSERT INTO `menu` VALUES (11, NULL, '退住登记', 'DArrowLeft', '/customer/checkOut', 2);
INSERT INTO `menu` VALUES (12, NULL, '外出登记', 'Location', '/customer/outRecords', 2);
INSERT INTO `menu` VALUES (17, NULL, '护理级别', 'Sort', '/nurse/nurseLevel', 4);
INSERT INTO `menu` VALUES (18, NULL, '护理项目', 'ZoomIn', '/nurse/nurseItem', 4);
INSERT INTO `menu` VALUES (19, NULL, '客户护理设置', 'Setting', '/nurse/nurseSetting', 4);
INSERT INTO `menu` VALUES (20, NULL, '护理记录', 'ScaleToOriginal', '/nurse/nurseRecords', 4);
INSERT INTO `menu` VALUES (21, NULL, '设置服务对象', 'Setting', '/health/serviceCustomerSetting', 5);
INSERT INTO `menu` VALUES (22, '22', '客户管理', 'Coin', NULL, 0);
INSERT INTO `menu` VALUES (23, NULL, '日常护理', 'Help', '/health/dailyNurse', 26);
INSERT INTO `menu` VALUES (24, NULL, '服务关注', 'View', '/health/serviceCare', 5);
INSERT INTO `menu` VALUES (25, NULL, '基础数据维护', 'List', '/user/listUser', 6);
INSERT INTO `menu` VALUES (26, '26', '健康管家', 'User', NULL, 0);
INSERT INTO `menu` VALUES (27, NULL, '外出登记', 'Location', '/customer/outRecords', 22);
INSERT INTO `menu` VALUES (28, NULL, '退住登记', 'DArrowLeft', '/customer/checkOut', 22);
INSERT INTO `menu` VALUES (29, NULL, '护理记录', 'ScaleToOriginal', '/nurse/nurseRecordsToUser', 26);
INSERT INTO `menu` VALUES (30, NULL, '膳食管理', 'Setting', '/customer/preference', 2);
INSERT INTO `menu` VALUES (31, NULL, '膳食日历', 'Picture', '/customer/meal', 2);
INSERT INTO `menu` VALUES (32, NULL, '入住登记', 'DArrowRight', '/customer/checkIn', 22);

-- ----------------------------
-- Table structure for nurserecord
-- ----------------------------
DROP TABLE IF EXISTS `nurserecord`;
CREATE TABLE `nurserecord`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `is_deleted` int NOT NULL COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  `customer_id` int NOT NULL COMMENT '客户ID',
  `item_id` int NOT NULL COMMENT '护理项目ID，关联 nursing_service(id)',
  `nursing_time` date NOT NULL COMMENT '护理时间',
  `nursing_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '护理内容',
  `nursing_count` int NOT NULL COMMENT '护理数量',
  `user_id` int NOT NULL COMMENT '护理人员ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_nr_item`(`item_id` ASC) USING BTREE,
  CONSTRAINT `fk_nr_service` FOREIGN KEY (`item_id`) REFERENCES `nursing_service` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '护理记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nurserecord
-- ----------------------------
INSERT INTO `nurserecord` VALUES (1, 1, 24, 2, '2025-07-05', '1', 1, 6);
INSERT INTO `nurserecord` VALUES (2, 1, 24, 4, '2025-07-19', '2', 1, 6);
INSERT INTO `nurserecord` VALUES (3, 1, 24, 6, '2025-07-19', '2', 1, 6);
INSERT INTO `nurserecord` VALUES (4, 1, 24, 6, '2025-07-05', '1', 1, 6);
INSERT INTO `nurserecord` VALUES (5, 1, 24, 6, '2025-07-05', '1', 1, 6);
INSERT INTO `nurserecord` VALUES (6, 1, 24, 4, '2025-07-05', '1', 1, 6);
INSERT INTO `nurserecord` VALUES (7, 1, 24, 6, '2025-07-05', '2', 1, 6);
INSERT INTO `nurserecord` VALUES (8, 1, 24, 2, '2025-07-05', '1', 1, 6);
INSERT INTO `nurserecord` VALUES (9, 1, 24, 6, '2025-07-05', '1', 1, 6);
INSERT INTO `nurserecord` VALUES (10, 1, 24, 5, '2025-07-05', '', 1, 6);
INSERT INTO `nurserecord` VALUES (11, 1, 24, 6, '2025-07-05', '', 1, 6);
INSERT INTO `nurserecord` VALUES (12, 1, 24, 5, '2025-07-05', '', 1, 6);

-- ----------------------------
-- Table structure for nursing_level
-- ----------------------------
DROP TABLE IF EXISTS `nursing_level`;
CREATE TABLE `nursing_level`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `level_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '护理级别',
  `level_status` int NULL DEFAULT NULL COMMENT '级别状态 1：启用；2：停用',
  `is_deleted` int NOT NULL DEFAULT 0 COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '护理级别表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nursing_level
-- ----------------------------
INSERT INTO `nursing_level` VALUES (1, '53级护理', 1, 0);
INSERT INTO `nursing_level` VALUES (2, '二级护理', 1, 0);
INSERT INTO `nursing_level` VALUES (3, '三级护理', 1, 0);
INSERT INTO `nursing_level` VALUES (4, '特级护理', 1, 0);
INSERT INTO `nursing_level` VALUES (5, '啊', 2, 0);
INSERT INTO `nursing_level` VALUES (6, '2', 1, 0);

-- ----------------------------
-- Table structure for nursing_service
-- ----------------------------
DROP TABLE IF EXISTS `nursing_service`;
CREATE TABLE `nursing_service`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `serial_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '编号',
  `nursing_name` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名称',
  `service_price` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '价格',
  `message` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `status` int NOT NULL COMMENT '状态 1：启用；2：停用',
  `execution_cycle` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '执行周期',
  `execution_times` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '执行次数',
  `is_deleted` int NOT NULL DEFAULT 0 COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '护理项目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nursing_service
-- ----------------------------
INSERT INTO `nursing_service` VALUES (1, '1', '2', '2', '2', 1, '2', '2', 1);
INSERT INTO `nursing_service` VALUES (2, 'NS00242', '协助沐浴', '￥50', '含身体擦洗与吹干', 1, '每周', '2', 0);
INSERT INTO `nursing_service` VALUES (3, 'NS003', '协助进食', '￥30', '特殊餐食另计', 1, '每日', '3', 0);
INSERT INTO `nursing_service` VALUES (4, 'NS004', '更换床单', '￥20', '含全床更换及消毒', 1, '每周', '1', 0);
INSERT INTO `nursing_service` VALUES (5, 'NS005', '康复肢体牵拉训练', '￥80', '物理治疗师指导', 1, '每周', '2', 0);
INSERT INTO `nursing_service` VALUES (6, '1', '1', '1', '1', 1, '1', '1', 0);
INSERT INTO `nursing_service` VALUES (7, '1', '1', '1', '1', 1, '1', '1', 0);
INSERT INTO `nursing_service` VALUES (8, '阿萨', '啊', ' 是', '  啊', 1, ' 2', '2', 1);
INSERT INTO `nursing_service` VALUES (9, '饿啊是', '啊', '20', '1', 1, '1', '1', 0);
INSERT INTO `nursing_service` VALUES (10, '啊', '啊', '啊', ' 啊', 1, ' 啊', ' 啊', 0);

-- ----------------------------
-- Table structure for outward
-- ----------------------------
DROP TABLE IF EXISTS `outward`;
CREATE TABLE `outward`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `remarks` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  `is_deleted` int NOT NULL COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  `customer_id` int NOT NULL COMMENT '客户ID',
  `outgoing_reason` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '外出事由',
  `outgoing_time` date NOT NULL COMMENT '外出时间',
  `expected_return_time` date NOT NULL COMMENT '预计回院时间',
  `actual_return_time` date NULL DEFAULT NULL COMMENT '实际回院时间',
  `escorted` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '陪同人',
  `relation` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '与老人关系',
  `escorted_tel` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '陪同人电话',
  `audit_status` int NOT NULL COMMENT '审批状态  0-已提交 1-同意  2-拒绝',
  `audit_person` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '审批人',
  `audit_time` date NULL DEFAULT NULL COMMENT '审批时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of outward
-- ----------------------------
INSERT INTO `outward` VALUES (1, NULL, 0, 40, '想家', '2023-12-17', '2023-12-20', '2025-06-27', '女儿', '母女', '1', 1, '1', '2023-12-18');
INSERT INTO `outward` VALUES (2, NULL, 0, 33, '出门', '2023-12-17', '2023-12-19', NULL, '儿子', NULL, '13812341234', 2, NULL, NULL);
INSERT INTO `outward` VALUES (3, NULL, 0, 33, '出门', '2023-12-17', '2023-12-20', '2023-12-29', '儿子', NULL, '13812341234', 1, NULL, NULL);
INSERT INTO `outward` VALUES (4, NULL, 1, 33, '出门', '2023-12-18', '2023-12-20', NULL, '儿子', NULL, '13312341234', 0, NULL, NULL);
INSERT INTO `outward` VALUES (5, NULL, 0, 40, '外出业务', '2024-01-03', '2024-01-06', '2024-01-07', '儿子', NULL, '13819870987', 2, '1', '2024-01-03');
INSERT INTO `outward` VALUES (6, NULL, 0, 39, '回家', '2024-01-15', '2024-01-17', '2025-06-27', '儿子', '', '13312341234', 1, '', NULL);
INSERT INTO `outward` VALUES (7, NULL, 0, 41, '回家探亲', '2024-05-20', '2024-05-22', '2024-05-20', '女儿', NULL, '13312341234', 1, '1', '2024-05-20');
INSERT INTO `outward` VALUES (8, NULL, 0, 39, '考试', '2025-06-26', '2025-06-28', '2025-06-27', '李四', '', '1', 1, '1', '2025-06-26');
INSERT INTO `outward` VALUES (9, NULL, 0, 41, '考试', '2025-06-20', '2025-06-27', NULL, '李四', NULL, '13223128888', 1, '', NULL);
INSERT INTO `outward` VALUES (10, NULL, 1, 28, '1', '2025-06-28', '2025-06-28', NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `outward` VALUES (11, NULL, 0, 35, '1', '2025-06-28', '2025-06-28', '2025-06-28', '', '', '', 1, NULL, NULL);
INSERT INTO `outward` VALUES (12, NULL, 0, 34, '2', '2025-06-28', '2025-06-28', NULL, NULL, NULL, NULL, 1, NULL, NULL);
INSERT INTO `outward` VALUES (13, NULL, 1, 34, '1', '2025-06-28', '2025-06-28', NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `outward` VALUES (14, NULL, 0, 28, '1', '2025-07-01', '2025-07-01', NULL, NULL, NULL, NULL, 0, NULL, NULL);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime(6) NOT NULL COMMENT '创建时间',
  `update_time` datetime(6) NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` int NULL DEFAULT NULL COMMENT '更新人',
  `is_deleted` int NOT NULL COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '系统角色名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '2023-11-01 17:13:16.000000', NULL, NULL, 0, '系统管理员');
INSERT INTO `role` VALUES (2, '2023-11-01 17:13:13.000000', NULL, NULL, 0, '健康管家');

-- ----------------------------
-- Table structure for rolemenu
-- ----------------------------
DROP TABLE IF EXISTS `rolemenu`;
CREATE TABLE `rolemenu`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int NOT NULL COMMENT '角色编号',
  `menu` int NOT NULL COMMENT '菜单编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of rolemenu
-- ----------------------------
INSERT INTO `rolemenu` VALUES (1, 1, 1);
INSERT INTO `rolemenu` VALUES (2, 1, 2);
INSERT INTO `rolemenu` VALUES (3, 1, 3);
INSERT INTO `rolemenu` VALUES (4, 1, 4);
INSERT INTO `rolemenu` VALUES (5, 1, 5);
INSERT INTO `rolemenu` VALUES (6, 1, 6);
INSERT INTO `rolemenu` VALUES (7, 2, 26);
INSERT INTO `rolemenu` VALUES (8, 2, 22);

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `room_floor` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '房间楼层',
  `room_no` int NOT NULL COMMENT '房间编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES (1, '一楼', 1001);
INSERT INTO `room` VALUES (2, '一楼', 1002);
INSERT INTO `room` VALUES (3, '一楼', 1003);
INSERT INTO `room` VALUES (4, '一楼', 1004);
INSERT INTO `room` VALUES (5, '一楼', 1005);
INSERT INTO `room` VALUES (6, '一楼', 1006);
INSERT INTO `room` VALUES (7, '一楼', 1007);
INSERT INTO `room` VALUES (8, '一楼', 1008);
INSERT INTO `room` VALUES (9, '一楼', 1009);
INSERT INTO `room` VALUES (10, '一楼', 1010);
INSERT INTO `room` VALUES (11, '一楼', 1011);
INSERT INTO `room` VALUES (12, '一楼', 1012);
INSERT INTO `room` VALUES (13, '一楼', 1013);
INSERT INTO `room` VALUES (14, '一楼', 1014);
INSERT INTO `room` VALUES (15, '一楼', 1015);
INSERT INTO `room` VALUES (16, '一楼', 1016);
INSERT INTO `room` VALUES (17, '一楼', 1017);
INSERT INTO `room` VALUES (18, '一楼', 1018);
INSERT INTO `room` VALUES (19, '二楼', 2001);
INSERT INTO `room` VALUES (20, '二楼', 2002);
INSERT INTO `room` VALUES (21, '二楼', 2003);
INSERT INTO `room` VALUES (22, '二楼', 2004);
INSERT INTO `room` VALUES (23, '二楼', 2005);
INSERT INTO `room` VALUES (24, '二楼', 2006);
INSERT INTO `room` VALUES (25, '二楼', 2007);
INSERT INTO `room` VALUES (26, '二楼', 2008);
INSERT INTO `room` VALUES (27, '二楼', 2009);
INSERT INTO `room` VALUES (28, '二楼', 2010);
INSERT INTO `room` VALUES (29, '二楼', 2011);
INSERT INTO `room` VALUES (30, '二楼', 2012);
INSERT INTO `room` VALUES (31, '二楼', 2013);
INSERT INTO `room` VALUES (32, '二楼', 2014);
INSERT INTO `room` VALUES (33, '二楼', 2015);
INSERT INTO `room` VALUES (34, '二楼', 2016);
INSERT INTO `room` VALUES (35, '二楼', 2017);
INSERT INTO `room` VALUES (36, '二楼', 2018);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` date NOT NULL COMMENT '创建时间',
  `create_by` int NOT NULL COMMENT '创建者',
  `update_time` date NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` int NULL DEFAULT NULL COMMENT '更新者',
  `is_deleted` int NOT NULL COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  `nickname` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '真实姓名',
  `username` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '系统账号',
  `password` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `sex` int NOT NULL COMMENT '性别（0：女  1：男）',
  `email` varchar(254) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone_number` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '电话号码',
  `role_id` int NOT NULL COMMENT '系统角色编号（1-管理员 2-健康管家）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '2023-11-02', 0, '2023-11-02', 0, 0, 'admin', 'admin', 'admin', 1, 'zhangxing@s.cq', '13545453412', 1);
INSERT INTO `user` VALUES (3, '2023-11-21', 0, '2023-11-21', 0, 0, '陈小明', 'chenxiaoming', 'chenxiaoming', 0, 'chenxiaoming@s.cq', '18767890987', 2);
INSERT INTO `user` VALUES (4, '2023-11-21', 0, '2023-11-21', 0, 0, '张兴', 'zhangxing', 'zhangxing', 1, 'zhangxing@s.cq', '18878675643', 2);
INSERT INTO `user` VALUES (5, '2023-11-21', 0, '2023-11-21', 0, 0, '王年华', 'wangnianhua', 'wangnianhua', 0, 'wangnianhua@s.cq', '13412128976', 2);
INSERT INTO `user` VALUES (6, '2023-11-21', 0, '2023-11-21', 0, 0, '吴优', 'wuyou', 'wuyou', 0, 'wuyou@s.cq', '13567452789', 2);
INSERT INTO `user` VALUES (7, '2023-11-21', 0, '2023-11-21', 0, 0, '张三', 'kobe', '', 1, 'kobe@s.cq', '13567452789', 2);
INSERT INTO `user` VALUES (8, '2025-06-23', 1, NULL, NULL, 0, '小王', '小王', '000000', 1, 'zhong@163.com', '13122317219', 2);

SET FOREIGN_KEY_CHECKS = 1;
