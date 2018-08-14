/*
Navicat MySQL Data Transfer

Source Server         : tybs
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : tybs-all

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-08-14 21:39:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for card_base_info
-- ----------------------------
DROP TABLE IF EXISTS `card_base_info`;
CREATE TABLE `card_base_info` (
  `card_Base_Info_Id` varchar(256) NOT NULL,
  `user_Base_Info_Id` varchar(256) DEFAULT NULL,
  `card_Id` varchar(32) DEFAULT NULL,
  `trans_Pwd` varchar(256) DEFAULT NULL,
  `stat` char(2) DEFAULT NULL COMMENT '状态：Y-正常,L-挂失，D-删除，F-冻结',
  `oveage` decimal(19,2) DEFAULT NULL,
  `open_Date` date DEFAULT NULL,
  `card_Type` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`card_Base_Info_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='银行卡信息表';

-- ----------------------------
-- Records of card_base_info
-- ----------------------------
INSERT INTO `card_base_info` VALUES ('077a8f3e-763d-4267-98cd-de4eded5adb3', '3d7e2bbb-b644-43b6-b7f9-b3dd596b538c', '6221690208066161112', 'e10adc3949ba59abbe56e057f20f883e', '冻结', '0.00', '2018-05-01', '贷记卡');
INSERT INTO `card_base_info` VALUES ('0bd2d211-adcc-4836-80a6-2acb2e1574e0', '7ddf7a13-3942-407a-9028-ce95e562e6e5', '6221690208066161944', 'e10adc3949ba59abbe56e057f20f883e', '正常', '10.00', '2018-05-23', '储值卡');
INSERT INTO `card_base_info` VALUES ('0fee6c2f-5a06-4a0c-a603-915ee65fb921', 'df6daa16-e493-4810-ac49-3624c0d8f8ea', '6221690208066161888', 'e10adc3949ba59abbe56e057f20f883e', '正常', '9889138.00', '2018-05-31', '借记卡');
INSERT INTO `card_base_info` VALUES ('10615304-7ae1-44c6-be57-4963e188e23f', 'd440e65f-85dd-4121-b4d7-eb8e4310af23', '6221690208066162222', 'e10adc3949ba59abbe56e057f20f883e', '正常', '900.00', '2018-05-01', '借记卡');
INSERT INTO `card_base_info` VALUES ('16538dd7-4ae6-4f5a-9c1c-f02a5ce6ac42', '7ddf7a13-3942-407a-9028-ce95e562e6e5', '6221690208066161935', 'e10adc3949ba59abbe56e057f20f883e', '正常', '10.00', '2018-05-23', '贷记卡');
INSERT INTO `card_base_info` VALUES ('33db1ad4-bdc2-4f6c-87e8-0935fd283e28', '004630fa-72b1-407b-9115-795d8632cb57', '6221690208066161223', 'e10adc3949ba59abbe56e057f20f883e', '正常', '123456.00', '2018-05-01', '贷记卡');
INSERT INTO `card_base_info` VALUES ('36a1ee6b-3b24-4843-90e3-873c0ba02278', '7ddf7a13-3942-407a-9028-ce95e562e6e5', '6221690208066161936', 'e10adc3949ba59abbe56e057f20f883e', '正常', '10.00', '2018-05-23', '借记卡');
INSERT INTO `card_base_info` VALUES ('4b76ab4e-e7b6-433a-90b6-3f143c234f56', '587853fc-b3dd-4520-94b5-b6de927f5b4e', '6221690208066161114', 'e10adc3949ba59abbe56e057f20f883e', '正常', '1200.00', '2018-05-15', '贷记卡');
INSERT INTO `card_base_info` VALUES ('59cf037b-5ff4-4492-8914-e58bf33cdc86', '48d80467-5f1e-4d47-88fc-870bb144eb87', '6221690208066161938', 'e10adc3949ba59abbe56e057f20f883e', '正常', '1100.00', '2018-05-15', '借记卡');
INSERT INTO `card_base_info` VALUES ('6e935dd1-6414-46cc-a334-17a183c84083', 'eda72430-794c-42c7-8333-ec9c29966b6e', '6221690208066161937', 'e10adc3949ba59abbe56e057f20f883e', '注销', '1000.00', '2018-05-02', '借记卡');
INSERT INTO `card_base_info` VALUES ('72822e08-ca1d-4e6e-956f-ae613cbc75bb', '91943779-8582-4ede-ab9b-34a9cde9ec22', '6221690208066161931', 'e10adc3949ba59abbe56e057f20f883e', '正常', '323.00', '2018-05-16', '借记卡');
INSERT INTO `card_base_info` VALUES ('7733cfd6-9ba7-46bf-822e-375f71ec4f3e', '91943779-8582-4ede-ab9b-34a9cde9ec22', '6221690208066161932', 'e10adc3949ba59abbe56e057f20f883e', '正常', '100.00', '2018-05-16', '贷记卡');
INSERT INTO `card_base_info` VALUES ('7f8495a0-d275-488f-8f95-3c121cc5cda8', 'd234936f-4ccf-4c55-aa49-c472a1cf817f', '6221690208066161934', 'e10adc3949ba59abbe56e057f20f883e', '正常', '100.00', '2018-05-16', '储值卡');
INSERT INTO `card_base_info` VALUES ('8599ed6e-dba4-493f-be70-d1d8eaa7ea80', '3d7e2bbb-b644-43b6-b7f9-b3dd596b538c', '6221690208066161111', 'e10adc3949ba59abbe56e057f20f883e', '正常', '0.00', '2018-05-01', '借记卡');
INSERT INTO `card_base_info` VALUES ('86118cac-6f67-4c50-8868-ffa31e44c0a2', '587853fc-b3dd-4520-94b5-b6de927f5b4e', '6221690208066161113', 'e10adc3949ba59abbe56e057f20f883e', '正常', '1010657.00', '2018-05-15', '借记卡');
INSERT INTO `card_base_info` VALUES ('8f0f69b6-8b33-4b2e-a6a6-f49ca5f0a875', 'beff91dd-75bc-4419-9b3c-3ac0e794f021', '6221690208066161000', 'e10adc3949ba59abbe56e057f20f883e', '正常', '100.00', '2018-05-02', '借记卡');
INSERT INTO `card_base_info` VALUES ('95af68f2-e85c-40f0-a81c-d5d4ee682b54', '587853fc-b3dd-4520-94b5-b6de927f5b4e', '6221690208066161115', '202cb962ac59075b964b07152d234b70', '注销', '10100.00', '2018-05-15', '储值卡');

-- ----------------------------
-- Table structure for rsa_pwd_info
-- ----------------------------
DROP TABLE IF EXISTS `rsa_pwd_info`;
CREATE TABLE `rsa_pwd_info` (
  `rsa_Pwd_Info_Id` varchar(64) NOT NULL,
  `card_Base_Info_Id` varchar(64) DEFAULT NULL,
  `privateKey` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`rsa_Pwd_Info_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rsa_pwd_info
-- ----------------------------

-- ----------------------------
-- Table structure for trans_list_info
-- ----------------------------
DROP TABLE IF EXISTS `trans_list_info`;
CREATE TABLE `trans_list_info` (
  `trans_List_Info_Id` varchar(256) NOT NULL,
  `card_base_info_id` varchar(256) DEFAULT NULL,
  `serial_Number` varchar(32) DEFAULT NULL,
  `trans_Type` varchar(32) DEFAULT NULL COMMENT '类型：存款、取款、转账',
  `trans_Amount` decimal(19,2) DEFAULT NULL,
  `trans_Time` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`trans_List_Info_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交易明细表';

-- ----------------------------
-- Records of trans_list_info
-- ----------------------------
INSERT INTO `trans_list_info` VALUES ('0103540f-7026-4524-9bbe-8e6981e3878a', '0fee6c2f-5a06-4a0c-a603-915ee65fb921', '214842128', '收款', '8888888.00', '2018-05-31 21:48:42');
INSERT INTO `trans_list_info` VALUES ('043c1fee-151c-4389-a0de-3d5e6ea8cfdd', '6ddb52ac-ae2b-4c30-9b99-3ebe45507e00', '175033544', '取款', '123.00', '2018-06-13 17:50:33');
INSERT INTO `trans_list_info` VALUES ('0c616b93-96a5-498f-996a-5684bc492375', '72822e08-ca1d-4e6e-956f-ae613cbc75bb', '214519350', '转账', '100.00', '2018-05-23 23:08:36');
INSERT INTO `trans_list_info` VALUES ('0d0b5a02-7820-4f7a-884f-99350735abd6', '6ddb52ac-ae2b-4c30-9b99-3ebe45507e00', '180634155', '取款', '123.00', '2018-06-13 18:06:34');
INSERT INTO `trans_list_info` VALUES ('0e205f66-b7aa-4364-9571-d78c2c89b11a', '0fee6c2f-5a06-4a0c-a603-915ee65fb921', '214751299', '存款', '100.00', '2018-05-31 21:47:51');
INSERT INTO `trans_list_info` VALUES ('13d815e5-c169-469e-b4e6-7a6a352ffcd3', '86118cac-6f67-4c50-8868-ffa31e44c0a2', '141143918', '收款', '1000000.00', '2018-05-18 23:08:36');
INSERT INTO `trans_list_info` VALUES ('14b90c6f-c8da-4ac5-99e6-79b9389041d5', '72822e08-ca1d-4e6e-956f-ae613cbc75bb', '230838842', '存款', '100.00', '2018-05-29 23:08:38');
INSERT INTO `trans_list_info` VALUES ('1ceb626b-d3ee-493d-83f0-ebd3431e26bd', '6ddb52ac-ae2b-4c30-9b99-3ebe45507e00', '190815665', '取款', '123.00', '2018-06-13 19:08:15');
INSERT INTO `trans_list_info` VALUES ('1d7a6e74-a019-41c4-868b-e9e6d9cebd76', '86118cac-6f67-4c50-8868-ffa31e44c0a2', '141211084', '取款', '1000.00', '2018-05-18 23:08:36');
INSERT INTO `trans_list_info` VALUES ('20785b0b-8d80-4a0e-b230-dbce4c6087f7', '0fee6c2f-5a06-4a0c-a603-915ee65fb921', '214825969', '收款', '100.00', '2018-05-31 21:48:25');
INSERT INTO `trans_list_info` VALUES ('36744424-d8a4-4690-8d35-e7297dd4989f', '86118cac-6f67-4c50-8868-ffa31e44c0a2', '175645525', '存款', '1334.00', '2018-06-09 17:56:45');
INSERT INTO `trans_list_info` VALUES ('3d3e81f1-3e85-415a-b531-f8fa12e7cfdd', '6ddb52ac-ae2b-4c30-9b99-3ebe45507e00', '175416989', '取款', '123.00', '2018-06-13 17:54:16');
INSERT INTO `trans_list_info` VALUES ('3d7c49a6-ba72-4baf-84a6-089c7ec51feb', '86118cac-6f67-4c50-8868-ffa31e44c0a2', '175638104', '存款', '122.00', '2018-06-09 17:56:38');
INSERT INTO `trans_list_info` VALUES ('3da1a517-a87e-4e50-ae2d-4a7bc49d552e', '59cf037b-5ff4-4492-8914-e58bf33cdc86', '172018268', '取款', '100.00', '2018-05-31 17:20:18');
INSERT INTO `trans_list_info` VALUES ('3e1ea6e6-58d7-4281-92ae-a08d95a15a0a', '72822e08-ca1d-4e6e-956f-ae613cbc75bb', '120605326', '取款', '500.00', '2018-05-18 23:08:36');
INSERT INTO `trans_list_info` VALUES ('40ccef77-9e5a-484f-97be-0bb680667a75', '72822e08-ca1d-4e6e-956f-ae613cbc75bb', '120602776', '取款', '500.00', '2018-05-18 23:08:36');
INSERT INTO `trans_list_info` VALUES ('425d6c58-025c-4890-a6fc-dd6bfd4386e3', '86118cac-6f67-4c50-8868-ffa31e44c0a2', '175632081', '存款', '100.00', '2018-06-09 17:56:32');
INSERT INTO `trans_list_info` VALUES ('445e9de2-e61e-4de2-b86b-b1309a537e35', '0fee6c2f-5a06-4a0c-a603-915ee65fb921', '214803538', '取款', '50.00', '2018-05-31 21:48:03');
INSERT INTO `trans_list_info` VALUES ('54758f81-606f-4d42-83a1-4cf9b5718b46', '59cf037b-5ff4-4492-8914-e58bf33cdc86', '214519354', '收款', '100.00', '2018-05-23 23:08:36');
INSERT INTO `trans_list_info` VALUES ('5ed8b9ec-f3f4-44c7-8216-9a69524f88ae', '72822e08-ca1d-4e6e-956f-ae613cbc75bb', '214426016', '取款', '123.00', '2018-05-23 23:08:36');
INSERT INTO `trans_list_info` VALUES ('5fee5aeb-7dea-40f2-8eab-b55f09aebad0', '6ddb52ac-ae2b-4c30-9b99-3ebe45507e00', '174705186', '取款', '123.00', '2018-06-13 17:47:05');
INSERT INTO `trans_list_info` VALUES ('65d4cc6b-90c5-4dc5-a8b3-bc3b236d0080', '4b76ab4e-e7b6-433a-90b6-3f143c234f56', '171940481', '存款', '1000.00', '2018-05-31 17:19:40');
INSERT INTO `trans_list_info` VALUES ('682e1aa1-0cfa-4ac6-ad91-a902c7b59f04', '6ddb52ac-ae2b-4c30-9b99-3ebe45507e00', '175420544', '取款', '123.00', '2018-06-13 17:54:20');
INSERT INTO `trans_list_info` VALUES ('6e08f321-1953-4e1d-8d4e-a7e1f42b7ad8', '59cf037b-5ff4-4492-8914-e58bf33cdc86', '172109588', '收款', '1000.00', '2018-05-31 17:21:09');
INSERT INTO `trans_list_info` VALUES ('7683fdef-97bf-4eee-93ea-089c3f904d1b', '59cf037b-5ff4-4492-8914-e58bf33cdc86', '172041491', '收款', '100.00', '2018-05-31 17:20:41');
INSERT INTO `trans_list_info` VALUES ('7df478bc-3664-446e-8a59-daba033053bd', '6ddb52ac-ae2b-4c30-9b99-3ebe45507e00', '175147841', '取款', '123.00', '2018-06-13 17:51:47');
INSERT INTO `trans_list_info` VALUES ('80cb98ea-dcae-4660-95ff-ccea80bbc12d', '72822e08-ca1d-4e6e-956f-ae613cbc75bb', '112046863', '取款', '100.00', '2018-05-28 23:08:36');
INSERT INTO `trans_list_info` VALUES ('833322ff-9705-49f6-b378-f998f1dd0d32', '6ddb52ac-ae2b-4c30-9b99-3ebe45507e00', '191523504', '取款', '111.00', '2018-06-13 19:15:23');
INSERT INTO `trans_list_info` VALUES ('85a6afad-cd38-41b7-8798-a9ec400adc1c', '72822e08-ca1d-4e6e-956f-ae613cbc75bb', '214438015', '收款', '123.00', '2018-05-28 00:00:01');
INSERT INTO `trans_list_info` VALUES ('8e37fb17-6b1b-4699-bdb4-2dbbe3d21d22', '95af68f2-e85c-40f0-a81c-d5d4ee682b54', '220623056', '存款', '10000.00', '2018-05-30 22:06:23');
INSERT INTO `trans_list_info` VALUES ('91930d47-3ecf-4958-b887-8e74dea6fe55', '6ddb52ac-ae2b-4c30-9b99-3ebe45507e00', '182348782', '取款', '123.00', '2018-06-13 18:23:48');
INSERT INTO `trans_list_info` VALUES ('9206cd9b-386a-40aa-831c-20bffcfb2969', '86118cac-6f67-4c50-8868-ffa31e44c0a2', '175625883', '存款', '100.00', '2018-06-09 17:56:25');
INSERT INTO `trans_list_info` VALUES ('a89120fb-a918-4a3d-ac27-24f839e0b16f', '86118cac-6f67-4c50-8868-ffa31e44c0a2', '142420689', '存款', '1.00', '2018-05-18 23:08:36');
INSERT INTO `trans_list_info` VALUES ('b4b30997-7b59-49f4-97bb-d3ee2c4a85b2', '72822e08-ca1d-4e6e-956f-ae613cbc75bb', '230836447', '存款', '100.00', '2018-05-29 23:08:36');
INSERT INTO `trans_list_info` VALUES ('bd68707c-60b6-49e4-8188-3918bcdfdb15', '86118cac-6f67-4c50-8868-ffa31e44c0a2', '141127986', '存款', '10000.00', '2018-05-18 23:08:36');
INSERT INTO `trans_list_info` VALUES ('c01b1f82-3f12-4aa5-9923-967bd448fc8e', '72822e08-ca1d-4e6e-956f-ae613cbc75bb', '120535434', '取款', '100.00', '2018-05-18 23:08:36');
INSERT INTO `trans_list_info` VALUES ('c0f11d40-c572-447d-a19d-ee54046a3a92', '86118cac-6f67-4c50-8868-ffa31e44c0a2', '141159841', '取款', '100.00', '2018-05-18 23:08:36');
INSERT INTO `trans_list_info` VALUES ('c68a468b-87ff-4d7d-8bea-9db51b4983be', '6ddb52ac-ae2b-4c30-9b99-3ebe45507e00', '192016034', '取款', '123.00', '2018-06-13 19:20:16');
INSERT INTO `trans_list_info` VALUES ('ca448a0b-1048-456c-be12-0b704e3965ea', '10615304-7ae1-44c6-be57-4963e188e23f', '214825928', '转账', '100.00', '2018-05-31 21:48:25');
INSERT INTO `trans_list_info` VALUES ('db7ae575-2d3b-4fd9-a877-fef13f1aacfb', '0fee6c2f-5a06-4a0c-a603-915ee65fb921', '214751643', '存款', '100.00', '2018-05-31 21:47:51');
INSERT INTO `trans_list_info` VALUES ('dd200fcc-c163-492a-bcb6-ba713ee51cb3', '72822e08-ca1d-4e6e-956f-ae613cbc75bb', '222816837', '存款', '100.00', '2018-05-29 23:08:36');
INSERT INTO `trans_list_info` VALUES ('e15e6fb6-67dd-4238-94b2-260afbea6586', '86118cac-6f67-4c50-8868-ffa31e44c0a2', '141157347', '取款', '100.00', '2018-05-18 23:08:36');
INSERT INTO `trans_list_info` VALUES ('e254dad2-0f6a-44b5-9236-71f23199944b', '8599ed6e-dba4-493f-be70-d1d8eaa7ea80', '141306278', '转账', '100.00', '2018-05-18 23:08:36');
INSERT INTO `trans_list_info` VALUES ('e6e056fc-ed2e-4e9d-9b1a-608e62e87da8', '6ddb52ac-ae2b-4c30-9b99-3ebe45507e00', '175518403', '取款', '123.00', '2018-06-13 17:55:18');
INSERT INTO `trans_list_info` VALUES ('e81baa78-7db8-48c8-9d52-84d2dd9cb6b1', '72822e08-ca1d-4e6e-956f-ae613cbc75bb', '214416552', '存款', '123.00', '2018-05-23 23:08:36');
INSERT INTO `trans_list_info` VALUES ('eb5ee308-5477-43d9-8b50-fb537b4e698b', '10615304-7ae1-44c6-be57-4963e188e23f', '172109586', '转账', '1000.00', '2018-05-31 17:21:09');
INSERT INTO `trans_list_info` VALUES ('ff015f5d-d9e8-4345-bafb-9c769b87193a', '86118cac-6f67-4c50-8868-ffa31e44c0a2', '141306280', '收款', '100.00', '2018-05-18 23:08:36');

-- ----------------------------
-- Table structure for user_admin_info
-- ----------------------------
DROP TABLE IF EXISTS `user_admin_info`;
CREATE TABLE `user_admin_info` (
  `Id` int(11) NOT NULL,
  `admin_Name` varchar(255) DEFAULT NULL,
  `admin_Pwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_admin_info
-- ----------------------------
INSERT INTO `user_admin_info` VALUES ('1', 'admin', '123456');

-- ----------------------------
-- Table structure for user_base_info
-- ----------------------------
DROP TABLE IF EXISTS `user_base_info`;
CREATE TABLE `user_base_info` (
  `user_Base_Info_Id` varchar(256) NOT NULL,
  `user_Name` varchar(32) DEFAULT NULL,
  `user_Card_Id` varchar(32) DEFAULT NULL,
  `user_Tel` varchar(32) DEFAULT NULL,
  `user_Email` varchar(32) DEFAULT NULL,
  `user_Sex` char(1) DEFAULT NULL,
  `user_Address` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`user_Base_Info_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of user_base_info
-- ----------------------------
INSERT INTO `user_base_info` VALUES ('004630fa-72b1-407b-9115-795d8632cb57', '刘一', '430725199406242222', '13517363655', '99@qq.com', '男', '湖南');
INSERT INTO `user_base_info` VALUES ('3d7e2bbb-b644-43b6-b7f9-b3dd596b538c', '胡杰', '430725199406241111', '13722126752', '111@qq.com', '男', '湖南');
INSERT INTO `user_base_info` VALUES ('48d80467-5f1e-4d47-88fc-870bb144eb87', '李凤鸣', '430725199406247578', '13517636550', '66@qq.com', '男', '湖南常德');
INSERT INTO `user_base_info` VALUES ('587853fc-b3dd-4520-94b5-b6de927f5b4e', '李凤鸣', '430725199406247571', '13517363655', '22@qq.com', '男', '湖南省桃源县郑家驿乡塘河村潘湾组');
INSERT INTO `user_base_info` VALUES ('7ddf7a13-3942-407a-9028-ce95e562e6e5', '胡杰', '430725199406241112', '13722126752', '66@qq.com', '男', '江西');
INSERT INTO `user_base_info` VALUES ('91943779-8582-4ede-ab9b-34a9cde9ec22', '胡杰', '430725198807061111', '13722126752', '99@qq.com', '男', '湖南');
INSERT INTO `user_base_info` VALUES ('beff91dd-75bc-4419-9b3c-3ac0e794f021', 'root', '430725199406247579', '13722126752', '88@qq.com', '男', '湖南常德桃源');
INSERT INTO `user_base_info` VALUES ('d234936f-4ccf-4c55-aa49-c472a1cf817f', '刘一', '430725199406242223', '13722126752', '66@qq.com', '男', '湖南常德');
INSERT INTO `user_base_info` VALUES ('d440e65f-85dd-4121-b4d7-eb8e4310af23', '廖勇', '430725198807067575', '13722126752', '99@qq.com', '男', '湖南常德');
INSERT INTO `user_base_info` VALUES ('d7d63291-e77b-4ccc-93f5-f36a96a1171c', '李凤鸣', '430725199406247577', '13722126752', '66@qq.com', '男', '湖南常德');
INSERT INTO `user_base_info` VALUES ('df6daa16-e493-4810-ac49-3624c0d8f8ea', 'lfm', '430725199406240000', '13722126752', '123@qq.com', '男', '湖南常德桃源');
INSERT INTO `user_base_info` VALUES ('eda72430-794c-42c7-8333-ec9c29966b6e', '李凤鸣', '43072519940624757X', '13517363655', '672457123@qq.com', '男', '湖南');

-- ----------------------------
-- Table structure for user_oper_info
-- ----------------------------
DROP TABLE IF EXISTS `user_oper_info`;
CREATE TABLE `user_oper_info` (
  `user_Oper_Info_Id` varchar(32) NOT NULL,
  `oper_Name` varchar(32) DEFAULT NULL,
  `login_Pwd` varchar(32) DEFAULT NULL,
  `oper_Sex` char(3) DEFAULT NULL,
  `oper_Statu` varchar(32) DEFAULT NULL COMMENT '状态：Y能登录，N不能登录',
  `oper_Mobil_Phone` char(11) DEFAULT NULL COMMENT '11位手机号码',
  `oper_Email` varchar(32) DEFAULT NULL,
  `oper_Card_Id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`user_Oper_Info_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作员信息表';

-- ----------------------------
-- Records of user_oper_info
-- ----------------------------
INSERT INTO `user_oper_info` VALUES ('000', '胡杰', 'e10adc3949ba59abbe56e057f20f883e', '女', '注销', '13722126752', '13@qq.com', '430725199406247577');
INSERT INTO `user_oper_info` VALUES ('001', '李凤鸣', '3d9188577cc9bfe9291ac66b5cc872b7', '女', '注销', '13722126752', '888@qq.com', '430725199406247573');
INSERT INTO `user_oper_info` VALUES ('002', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '男', '正常', '15702666189', '9999@qq.com', '235407195106112745');
INSERT INTO `user_oper_info` VALUES ('005', 'root', 'e10adc3949ba59abbe56e057f20f883e', '男', '正常', '13588887777', '99@qq.com', '430725199406248888');
INSERT INTO `user_oper_info` VALUES ('006', 'lfm', 'e10adc3949ba59abbe56e057f20f883e', '女', '正常', '13722126752', '77@qq.com', '430725199406247571');
INSERT INTO `user_oper_info` VALUES ('007', '李红', 'e10adc3949ba59abbe56e057f20f883e', '女', '正常', '13722126752', '88@qq.com', '43072519940624757X');
INSERT INTO `user_oper_info` VALUES ('008', 'mvv', 'e10adc3949ba59abbe56e057f20f883e', '女', '正常', '13722126752', '99@qq.com', '430725199406247576');
INSERT INTO `user_oper_info` VALUES ('010', '胡杰', 'e10adc3949ba59abbe56e057f20f883e', '女', '注销', '13722126752', '99@qq.com', '430725199406247555');
