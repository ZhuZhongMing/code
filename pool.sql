/*
 Navicat Premium Data Transfer

 Source Server         : fast
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : pool

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 07/09/2019 12:11:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gs_material
-- ----------------------------
DROP TABLE IF EXISTS `gs_material`;
CREATE TABLE `gs_material`  (
  `BatchId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '材料批次编码',
  `MaterialId` int(11) NULL DEFAULT NULL COMMENT '材料类型:(1:xx 2:oo)',
  `ProcessMode` int(11) NULL DEFAULT NULL COMMENT '材料加工模式:(1:xx 2:oo)',
  `State` int(11) NULL DEFAULT NULL COMMENT '材料加工状态:(1:等待加工 2:正在加工 3:加工完毕)',
  `Remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`BatchId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gs_material
-- ----------------------------
INSERT INTO `gs_material` VALUES ('111111111', 1, 1, 2, '111111111材料备注');
INSERT INTO `gs_material` VALUES ('111111112', 2, 2, 3, '111111112材料备注');
INSERT INTO `gs_material` VALUES ('111111113', 3, 1, 1, '111111113材料备注');

-- ----------------------------
-- Table structure for gs_process
-- ----------------------------
DROP TABLE IF EXISTS `gs_process`;
CREATE TABLE `gs_process`  (
  `ProcessId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工序编号',
  `ProcessName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工序名称',
  `ReactionCellId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '反应池编号',
  `ProcessTime` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '工序所需时间（单位：秒）',
  `Remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ProcessId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gs_process
-- ----------------------------
INSERT INTO `gs_process` VALUES ('1', '第一道工序', '1', '480', '第一道工序备注');
INSERT INTO `gs_process` VALUES ('2', '第二道工序', '2', '560', '第二道工序备注');
INSERT INTO `gs_process` VALUES ('3', '第三道工序', '3', '640', '第三道工序备注');
INSERT INTO `gs_process` VALUES ('4', '第四道工序', '4', '720', '第四道工序备注');

-- ----------------------------
-- Table structure for gs_reactioncell
-- ----------------------------
DROP TABLE IF EXISTS `gs_reactioncell`;
CREATE TABLE `gs_reactioncell`  (
  `ReactionCellId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '反应池编号',
  `ReactionCellName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '反应池名称',
  `Remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ReactionCellId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gs_reactioncell
-- ----------------------------
INSERT INTO `gs_reactioncell` VALUES ('1', '1号反应池', '1号反应池备注');
INSERT INTO `gs_reactioncell` VALUES ('2', '2号反应池', '2号反应池备注');
INSERT INTO `gs_reactioncell` VALUES ('3', '3号反应池', '3号反应池备注');
INSERT INTO `gs_reactioncell` VALUES ('4', '4号反应池', '4号反应池备注');
INSERT INTO `gs_reactioncell` VALUES ('5', '5号反应池', '5号反应池备注');
INSERT INTO `gs_reactioncell` VALUES ('6', '6号反应池', '6号反应池备注');
INSERT INTO `gs_reactioncell` VALUES ('7', '7号反应池', '7号反应池备注');
INSERT INTO `gs_reactioncell` VALUES ('8', '8号反应池', '8号反应池备注');
INSERT INTO `gs_reactioncell` VALUES ('9', '9号反应池', '9号反应池备注');

-- ----------------------------
-- Table structure for gs_schedule
-- ----------------------------
DROP TABLE IF EXISTS `gs_schedule`;
CREATE TABLE `gs_schedule`  (
  `WorkId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作业单编号ID',
  `BatchId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '材料批次编码',
  `ProcessId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工序编号',
  `StartTime` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `EndTime` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `WorkTime` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '加工耗时',
  PRIMARY KEY (`WorkId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gs_schedule
-- ----------------------------
INSERT INTO `gs_schedule` VALUES ('8008846', '111111111', '1', '2019-04-20 11:39:54', '2019-04-20 11:48:56', '9分02秒');
INSERT INTO `gs_schedule` VALUES ('8008847', '111111112', '2', '2019-04-21 11:39:54', '2019-04-21 11:48:56', '9分02秒');

-- ----------------------------
-- Table structure for gs_temperature
-- ----------------------------
DROP TABLE IF EXISTS `gs_temperature`;
CREATE TABLE `gs_temperature`  (
  `RecordId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '记录ID',
  `ReactionCellId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '反应池编号',
  `Temperature` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '温度（单位：℃）',
  `WriteTime` datetime(0) NOT NULL COMMENT '记录时间',
  PRIMARY KEY (`RecordId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gs_temperature
-- ----------------------------
INSERT INTO `gs_temperature` VALUES ('01', '1', '45', '2019-04-20 11:39:54');
INSERT INTO `gs_temperature` VALUES ('02', '1', '47', '2019-04-20 11:39:56');
INSERT INTO `gs_temperature` VALUES ('03', '1', '53', '2019-04-20 11:39:58');
INSERT INTO `gs_temperature` VALUES ('04', '1', '44', '2019-04-20 11:40:00');
INSERT INTO `gs_temperature` VALUES ('05', '1', '57', '2019-04-20 11:40:02');
INSERT INTO `gs_temperature` VALUES ('06', '1', '39', '2019-04-20 11:40:04');
INSERT INTO `gs_temperature` VALUES ('07', '1', '68', '2019-04-20 11:40:06');
INSERT INTO `gs_temperature` VALUES ('08', '1', '66', '2019-04-20 11:40:08');
INSERT INTO `gs_temperature` VALUES ('09', '1', '65', '2019-04-20 11:40:10');
INSERT INTO `gs_temperature` VALUES ('10', '1', '65', '2019-04-20 11:40:12');
INSERT INTO `gs_temperature` VALUES ('11', '1', '65', '2019-04-20 11:40:14');
INSERT INTO `gs_temperature` VALUES ('12', '1', '70', '2019-04-20 11:40:16');
INSERT INTO `gs_temperature` VALUES ('13', '1', '71', '2019-04-20 11:40:18');
INSERT INTO `gs_temperature` VALUES ('14', '1', '68', '2019-04-20 11:40:20');
INSERT INTO `gs_temperature` VALUES ('15', '1', '66', '2019-04-20 11:40:22');

SET FOREIGN_KEY_CHECKS = 1;
