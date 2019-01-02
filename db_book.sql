/*
 Navicat MySQL Data Transfer

 Source Server         : MySQL_Redsheep
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : db_book

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 02/01/2019 21:32:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `bookName` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `author` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `isDomestic` tinyint(1) UNSIGNED NOT NULL DEFAULT 1,
  `grade` float(2, 1) UNSIGNED NULL DEFAULT NULL COMMENT '豆瓣评分',
  `price` float(6, 2) UNSIGNED NOT NULL,
  `bookTypeId` int(4) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`, `bookName`) USING BTREE,
  UNIQUE INDEX `index_id`(`id`) USING BTREE,
  INDEX `index_bookName`(`bookName`) USING BTREE,
  INDEX `bookType`(`bookTypeId`) USING BTREE,
  CONSTRAINT `bookType` FOREIGN KEY (`bookTypeId`) REFERENCES `t_booktype` (`booktypeid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES (1, '失踪的孩子', '埃莱娜·费兰特 著/陈英 译', 0, 9.2, 62.00, 1);
INSERT INTO `t_book` VALUES (2, '追寻逝去的时光·第一卷：去斯万家那边', '马塞尔·普鲁斯特 著/斯泰凡·厄埃 绘/周克希 译', 0, 9.2, 160.00, 3);
INSERT INTO `t_book` VALUES (3, '房思琪的初恋乐园', '林奕含 著', 1, 9.2, 45.00, 1);
INSERT INTO `t_book` VALUES (4, '奥古斯都', '约翰·威廉斯 著/郑远涛 译', 0, 9.1, 56.00, 2);
INSERT INTO `t_book` VALUES (5, '我们一无所有', '安东尼·马拉 著/施清真 译', 0, 8.9, 49.80, 4);
INSERT INTO `t_book` VALUES (6, '莫斯科绅士', '埃莫·托尔斯 著/马韧 译', 0, 8.9, 79.80, 1);
INSERT INTO `t_book` VALUES (7, '如父如子', '是枝裕和 著/佐野晶 著/丹勇 译', 0, 8.9, 49.80, 1);
INSERT INTO `t_book` VALUES (8, '观山海', '杉泽 著/梁超 著', 1, 8.9, 168.00, 3);
INSERT INTO `t_book` VALUES (9, '漫长的告别', '雷蒙德·钱德勒 著/姚向辉 译', 0, 8.6, 69.00, 1);
INSERT INTO `t_book` VALUES (10, '回答不了', '匡扶 著', 1, 8.8, 59.00, 3);
INSERT INTO `t_book` VALUES (11, '发现燕然山铭', '辛德勇 著', 1, 9.1, 49.00, 2);
INSERT INTO `t_book` VALUES (12, '20世纪简史', '杰弗里·布莱内 著/张心童 译', 0, 8.9, 54.00, 2);
INSERT INTO `t_book` VALUES (13, '娜塔莎之舞', '奥兰多·费吉斯 著/曾小楚 译/郭丹杰 译', 0, 9.3, 139.00, 2);
INSERT INTO `t_book` VALUES (14, '利奥波德国王的鬼魂', '亚当·霍赫希尔德 著/扈喜林 译', 0, 9.2, 79.00, 2);
INSERT INTO `t_book` VALUES (15, '4321', '保罗·奥斯特 著/李鹏程 译', 0, 8.8, 148.00, 1);
INSERT INTO `t_book` VALUES (16, '冬泳', '班宇 著', 1, 8.5, 49.00, 1);
INSERT INTO `t_book` VALUES (17, '南宋行暮', '虞云国 著', 1, 8.4, 35.00, 2);

-- ----------------------------
-- Table structure for t_booktype
-- ----------------------------
DROP TABLE IF EXISTS `t_booktype`;
CREATE TABLE `t_booktype`  (
  `bookTypeId` int(4) UNSIGNED NOT NULL AUTO_INCREMENT,
  `bookType` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`bookTypeId`, `bookType`) USING BTREE,
  INDEX `bookTypeId`(`bookTypeId`) USING BTREE,
  INDEX `bookTypeId_2`(`bookTypeId`) USING BTREE,
  INDEX `bookTypeId_3`(`bookTypeId`) USING BTREE,
  INDEX `bookTypeId_4`(`bookTypeId`) USING BTREE,
  INDEX `bookTypeId_5`(`bookTypeId`) USING BTREE,
  INDEX `bookTypeId_6`(`bookTypeId`) USING BTREE,
  INDEX `bookTypeId_7`(`bookTypeId`) USING BTREE,
  INDEX `bookTypeId_8`(`bookTypeId`) USING BTREE,
  INDEX `bookTypeId_9`(`bookTypeId`) USING BTREE,
  INDEX `bookTypeId_10`(`bookTypeId`) USING BTREE,
  INDEX `bookTypeId_11`(`bookTypeId`) USING BTREE,
  INDEX `bookTypeId_12`(`bookTypeId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_booktype
-- ----------------------------
INSERT INTO `t_booktype` VALUES (1, '小说');
INSERT INTO `t_booktype` VALUES (2, '历史');
INSERT INTO `t_booktype` VALUES (3, '漫画');
INSERT INTO `t_booktype` VALUES (4, '杂记');
INSERT INTO `t_booktype` VALUES (5, '诗歌');
INSERT INTO `t_booktype` VALUES (6, '神话');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` int(20) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '张纯杰', 123456);
INSERT INTO `t_user` VALUES (2, '刘健荣', 234567);
INSERT INTO `t_user` VALUES (3, '许嘉浩', 345678);
INSERT INTO `t_user` VALUES (4, '钟睿', 456789);

SET FOREIGN_KEY_CHECKS = 1;
