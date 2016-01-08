/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50625
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2016-01-08 08:53:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `gsms_contact`
-- ----------------------------
DROP TABLE IF EXISTS `gsms_contact`;
CREATE TABLE `gsms_contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `phone` varchar(20) NOT NULL COMMENT '手机号码',
  `sex` bit(1) NOT NULL DEFAULT b'1' COMMENT '性别',
  `identifier` varchar(50) DEFAULT NULL COMMENT '编号',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `vip` bit(1) NOT NULL COMMENT '是否为VIP标志',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `extension1` varchar(50) DEFAULT NULL COMMENT '扩展字段',
  `extension2` varchar(50) DEFAULT NULL COMMENT '扩展字段',
  `extension3` varchar(50) DEFAULT NULL COMMENT '扩展字段',
  `group_id` int(11) NOT NULL COMMENT '所属组ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_gsms_contact_phone_group_id` (`phone`,`group_id`) USING BTREE,
  KEY `ix_contact_group_id` (`group_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='存放联系人信息';

-- ----------------------------
-- Records of gsms_contact
-- ----------------------------

-- ----------------------------
-- Table structure for `gsms_user`
-- ----------------------------
DROP TABLE IF EXISTS `gsms_user`;
CREATE TABLE `gsms_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(50) NOT NULL COMMENT '用户名称',
  `password` varchar(64) NOT NULL COMMENT '用户密码',
  `state` int(11) NOT NULL DEFAULT '0' COMMENT '账号状态：NORMAL(0), SUSPEND(1), TERMINATE(2), NOT_EFFECT(3); 0,1可以互转，从0或1转到2后不能再转',
  `parent_id` int(11) NOT NULL COMMENT '父ID',
  `signature` varchar(50) DEFAULT NULL COMMENT '用户签名',
  `sig_location` bit(1) NOT NULL DEFAULT b'0' COMMENT '0:后置\r\n            1:前置',
  `level` int(11) NOT NULL DEFAULT '3' COMMENT '企业优先级别',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '0: 企业, 1: 部门, 2: 个人, 3：代理商',
  `identify` varchar(20) DEFAULT NULL COMMENT '企业标识号或用户标识码或企业编号',
  `mms_signed_type` int(11) NOT NULL DEFAULT '0' COMMENT '企业彩信签约类型, 0:非签约企业; 1:签约企业',
  `phone` varchar(13) DEFAULT NULL COMMENT '联系电话',
  `address` varchar(100) DEFAULT NULL COMMENT '联系地址',
  `email` varchar(255) DEFAULT NULL COMMENT '联系EMAIL',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `priority` int(11) NOT NULL DEFAULT '4' COMMENT '1-4,1为最高级',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `enterprise_name` varchar(100) DEFAULT NULL COMMENT '企业名称或部门名称',
  `link_man` varchar(50) DEFAULT NULL COMMENT '联系人',
  `path` varchar(720) DEFAULT NULL COMMENT '路径，查询时以避免递归',
  `user_type` int(11) NOT NULL DEFAULT '0' COMMENT '0：普通账号',
  `is_first_time_login` bit(1) NOT NULL DEFAULT b'1' COMMENT '0:非第一次登录，1：第一次登录',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业ID',
  `init_password` varchar(64) DEFAULT NULL COMMENT '企业下的用户的默认初始密码',
  `auditing_flag` bit(1) NOT NULL COMMENT '是否需要审核,0-不审核',
  `auditing_num` int(11) DEFAULT NULL COMMENT '审核基数',
  `enable_black_list_filter` bit(1) NOT NULL COMMENT '是否启用黑名单过滤,1--启用,0--禁用',
  `enable_keyword_filter` bit(1) NOT NULL COMMENT '是否启用关键字过滤,1--启用,0--禁用',
  `domain` varchar(50) DEFAULT NULL COMMENT '企业域，类型为企业时必须唯一',
  `extend` bit(1) NOT NULL DEFAULT b'0' COMMENT '标识企业在分配端口时是否允许企业可以自定义扩展',
  `shift` bit(1) NOT NULL DEFAULT b'0' COMMENT '标识企业在分配端口时是否允许企业可以切换通道',
  `has_send_message` bit(1) NOT NULL DEFAULT b'0' COMMENT '标识该企业下的用户是否发送过信息\r\n            该字段只更新一次',
  `hide_default_roles` bit(1) NOT NULL DEFAULT b'0' COMMENT '显示或隐藏默认初始化角色；0-显示 1-隐藏；',
  `max_department_level` int(11) DEFAULT '20' COMMENT '最大树层级',
  `department_identify_prefix` varchar(10) DEFAULT NULL COMMENT '部门编号前缀',
  `last_login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `auditing_mms_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否需要彩信审核,0-不审核',
  `auditing_mms_num` int(11) DEFAULT NULL COMMENT '彩信审核基数',
  `enable_mms` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否启用彩信模块',
  `auditing_material_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否需要素材审核,0-不审核',
  `industry_id` int(11) DEFAULT NULL COMMENT '行业ID',
  `region_id` int(11) DEFAULT NULL COMMENT '地区ID',
  `saleman_id` int(11) DEFAULT NULL COMMENT '所属销售',
  `platform_id` int(11) NOT NULL DEFAULT '0' COMMENT '0:Backend; 2:FrontKit;',
  `billing_type` int(11) NOT NULL DEFAULT '0' COMMENT '企业扣费类型: 0--用户提量交扣费, 1--系统发送量扣费,2--系统送达量扣费 ',
  `sex` int(1) DEFAULT NULL COMMENT '性别',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `auditing_state` int(11) NOT NULL COMMENT '审核状态: 0--待审核，1--已通过，2--未通过',
  `telephone` varchar(21) DEFAULT NULL COMMENT '电话号码',
  `private_key` varchar(50) DEFAULT NULL COMMENT '私匙',
  PRIMARY KEY (`id`),
  KEY `ix_user_type` (`type`) USING BTREE,
  KEY `ix_user_parent_id` (`parent_id`) USING BTREE,
  KEY `ix_user_ent_id` (`enterprise_id`) USING BTREE,
  KEY `ix_gsms_user_login` (`user_name`,`state`) USING BTREE,
  KEY `ix_user_saleman_id` (`saleman_id`) USING BTREE,
  KEY `ix_gsms_user_path` (`path`(255)) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2118 DEFAULT CHARSET=utf8 COMMENT='存放代理商、企业、部门、用户信息';

-- ----------------------------
-- Records of gsms_user
-- ----------------------------
INSERT INTO `gsms_user` VALUES ('1', '', '', '0', '0', '', '', '3', '0', '', '0', '', null, null, '2012-06-08 09:15:14', '3', null, '玄武无线', '', '', '0', '', '0', '123456', '', null, '', '', '139130.net', '', '', '', '', '20', null, null, '', null, '', '', null, null, null, '0', '0', null, null, '1', '', null);
INSERT INTO `gsms_user` VALUES ('2', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '0', '1', '【玄武用户】', '', '3', '2', '', '0', '', null, null, '2012-06-08 09:15:14', '3', null, '玄武无线', '超级管理员', '1.', '0', '', '1', '', '', null, '', '', '139130.net', '', '', '', '', '20', null, '2015-12-28 17:43:40', '', null, '', '', null, null, null, '0', '0', null, null, '1', '', null);
INSERT INTO `gsms_user` VALUES ('3', '', '', '0', '0', '【400快线】', '', '3', '0', '0000', '0', '15011111111', 'ent01', null, '2014-11-24 14:38:50', '4', '', 'ent01', 'ent01', '', '0', '', '0', '123456', '', null, '', '', 'ent01', '', '', '', '', '20', null, null, '', null, '', '', '2', '1', '2', '2', '1', null, null, '1', '', null);
INSERT INTO `gsms_user` VALUES ('4', 'admin@ent01', 'e10adc3949ba59abbe56e057f20f883e', '0', '3', null, '', '3', '2', '', '0', null, null, null, '2014-11-24 14:38:50', '4', null, '', '超级管理员', '3.', '0', '', '3', null, '', null, '', '', null, '', '', '', '', '20', null, '2015-12-24 14:56:09', '', null, '', '', null, null, null, '2', '0', '0', null, '1', null, null);
INSERT INTO `gsms_user` VALUES ('5', '', '', '0', '3', null, '', '3', '1', 'dept5', '0', null, null, null, '2015-03-11 15:38:38', '4', '', 'aa', null, '3.', '0', '', '3', null, '', null, '', '', null, '', '', '', '', '20', null, null, '', null, '', '', null, null, null, '2', '0', null, null, '1', null, null);
INSERT INTO `gsms_user` VALUES ('6', 'user01@ent01', 'e10adc3949ba59abbe56e057f20f883e', '0', '5', '', '', '3', '2', '', '0', '15011111111', null, null, '2015-03-11 15:39:01', '4', '', '', 'dfsd', '3.5.', '0', '', '3', null, '', null, '', '', null, '', '', '', '', '20', null, '2015-12-16 10:19:30', '', null, '', '', null, null, null, '2', '0', '1', null, '1', null, null);
INSERT INTO `gsms_user` VALUES ('7', '', '', '0', '1', null, '', '3', '1', 'dept7', '0', null, null, null, '2015-03-12 09:57:22', '4', '', 'xxx', null, '1.', '0', '', '1', null, '', null, '', '', null, '', '', '', '', '20', null, null, '', null, '', '', null, null, null, '0', '0', null, null, '1', null, null);
INSERT INTO `gsms_user` VALUES ('8', 'user01【已删】', 'e10adc3949ba59abbe56e057f20f883e', '2', '7', '', '', '3', '2', '', '0', '15022222222', null, null, '2015-03-12 09:57:35', '4', '', '', 'user01', '1.7.', '0', '', '1', null, '', null, '', '', null, '', '', '', '', '20', null, '2015-03-12 09:59:53', '', null, '', '', null, null, null, '0', '0', '1', null, '1', null, null);
INSERT INTO `gsms_user` VALUES ('9', 'user02【已删】', 'e10adc3949ba59abbe56e057f20f883e', '2', '7', '', '', '3', '2', '', '0', '15033333333', null, null, '2015-03-12 09:59:40', '4', '', '', 'user02', '1.7.', '0', '', '1', null, '', null, '', '', null, '', '', '', '', '20', null, '2015-03-12 10:18:12', '', null, '', '', null, null, null, '0', '0', '1', null, '1', null, null);
INSERT INTO `gsms_user` VALUES ('10', 'xxx【已删】', 'e10adc3949ba59abbe56e057f20f883e', '2', '7', '', '', '3', '2', '', '0', '15022222222', null, null, '2015-03-13 13:04:44', '4', '', '', 'xxx', '1.7.', '0', '', '1', null, '', null, '', '', null, '', '', '', '', '20', null, null, '', null, '', '', null, null, null, '0', '0', '1', null, '1', null, null);
INSERT INTO `gsms_user` VALUES ('11', 'sdfsadf【已删】', 'e10adc3949ba59abbe56e057f20f883e', '2', '7', '', '', '3', '2', '', '0', '15022222222', null, null, '2015-03-13 13:09:28', '4', '', '', 'sadf', '1.7.', '0', '', '1', null, '', null, '', '', null, '', '', '', '', '20', null, null, '', null, '', '', null, null, null, '0', '0', '1', null, '1', null, null);
INSERT INTO `gsms_user` VALUES ('12', '111【已删】', 'e10adc3949ba59abbe56e057f20f883e', '2', '7', '', '', '3', '2', '', '0', '15088888881', null, null, '2015-03-13 13:12:24', '4', '', '', '111', '1.7.', '0', '', '1', null, '', null, '', '', null, '', '', '', '', '20', null, null, '', null, '', '', null, null, null, '0', '0', '1', null, '1', null, null);
INSERT INTO `gsms_user` VALUES ('13', 'user01', 'e10adc3949ba59abbe56e057f20f883e', '0', '7', '', '', '3', '2', '', '0', '15088888888', null, null, '2015-03-30 11:56:02', '4', '', '', 'user01', '1.7.', '0', '', '1', null, '', null, '', '', null, '', '', '', '', '20', null, '2015-12-16 10:25:15', '', null, '', '', null, null, null, '0', '0', '1', null, '1', null, null);
INSERT INTO `gsms_user` VALUES ('14', '', '', '0', '0', '【400快线】fdsfdsfd', '', '3', '0', '0000', '0', '15900000001', '1111111111', null, '2015-05-22 10:40:10', '2', '', 'ent02', '1111111111', '', '0', '', '0', '123456', '', null, '', '', 'ent02', '', '', '', '', '20', null, null, '', null, '', '', '1', '1', '2', '2', '1', null, null, '1', '15900000001', null);
INSERT INTO `gsms_user` VALUES ('15', 'admin@ent02', 'e10adc3949ba59abbe56e057f20f883e', '0', '14', null, '', '3', '2', '', '0', null, null, null, '2015-05-22 10:40:10', '4', null, '', '超级管理员', '14.', '0', '', '14', null, '', null, '', '', null, '', '', '', '', '20', null, '2015-10-10 22:04:32', '', null, '', '', null, null, null, '2', '0', '0', null, '1', null, null);
INSERT INTO `gsms_user` VALUES ('86', '', '', '0', '0', '', '', '3', '0', '1210', '0', '13111111111', null, null, '2013-12-02 00:00:00', '3', null, 'test10', 'test10', null, '0', '', null, 'W(y3ETyZ', '', null, '', '', 'test10', '', '', '', '', '20', null, null, '', null, '', '', '1', '1', '2', '2', '0', null, null, '0', null, null);
INSERT INTO `gsms_user` VALUES ('126', '', '', '0', '0', 'aa012', '', '3', '0', '1111', '0', '13111111111', null, null, '2014-01-21 00:00:00', '3', null, 'aa01', 'aa01', null, '0', '', null, 'W(y3ETyZ', '', null, '', '', 'aa01', '', '', '', '', '20', null, null, '', null, '', '', '1', '1', '42', '2', '1', null, null, '0', null, null);
INSERT INTO `gsms_user` VALUES ('132', '', '', '0', '0', 'bb01', '', '3', '0', '2222', '0', '13111111111', null, null, '2014-01-21 00:00:00', '3', null, 'bb01', 'bb01', null, '0', '', null, 'W(y3ETyZ', '', null, '', '', 'bb01', '', '', '', '', '20', null, null, '', null, '', '', '1', '1', '46', '2', '0', null, null, '0', null, null);
INSERT INTO `gsms_user` VALUES ('223', '', '', '0', '0', 'xx01', '', '3', '0', '1121', '0', '13111111111', null, null, '2014-01-23 00:00:00', '3', null, 'xx01', 'xx01', null, '0', '', null, 'W(y3ETyZ', '', null, '', '', 'xx01', '', '', '', '', '20', null, null, '', null, '', '', '1', '1', '46', '2', '0', null, null, '0', null, null);
INSERT INTO `gsms_user` VALUES ('225', '', '', '0', '0', 'xx02', '', '3', '0', '1241', '0', '13111111111', null, null, '2014-01-23 00:00:00', '3', null, 'xx02', 'xx02', null, '0', '', null, 'W(y3ETyZ', '', null, '', '', 'xx02', '', '', '', '', '20', null, null, '', null, '', '', '1', '1', '46', '2', '0', null, null, '0', null, null);
INSERT INTO `gsms_user` VALUES ('267', '', '', '0', '0', 'sd03', '', '3', '0', '1705', '0', '13612345678', null, null, '2014-01-23 00:00:00', '3', null, 'sd03', 'sd03', null, '0', '', null, 'W(y3ETyZ', '', null, '', '', 'sd03', '', '', '', '', '20', null, null, '', null, '', '', '1', '1', '42', '2', '0', null, null, '0', null, null);
INSERT INTO `gsms_user` VALUES ('273', '', '', '0', '0', 'sd06', '', '3', '0', '1706', '0', '13612345677', null, null, '2014-01-23 00:00:00', '3', null, 'sd06', 'sd06', null, '0', '', null, 'W(y3ETyZ', '', null, '', '', 'sd06', '', '', '', '', '20', null, null, '', null, '', '', '1', '1', '42', '2', '0', null, null, '0', null, null);
INSERT INTO `gsms_user` VALUES ('303', '', '', '0', '0', 'df01', '', '3', '0', '1112', '0', '13612345678', null, null, '2014-01-23 00:00:00', '3', null, 'df01', 'df01', null, '0', '', null, 'W(y3ETyZ', '', null, '', '', 'df01', '', '', '', '', '20', null, null, '', null, '', '', '1', '1', '46', '2', '0', null, null, '0', null, null);
INSERT INTO `gsms_user` VALUES ('313', '', '', '0', '0', 'df06', '', '3', '0', '1231', '0', '13612345678', null, null, '2014-01-23 00:00:00', '3', null, 'df06', 'df06', null, '0', '', null, 'W(y3ETyZ', '', null, '', '', 'df06', '', '', '', '', '20', null, null, '', null, '', '', '1', '1', '46', '2', '0', null, null, '0', null, null);
INSERT INTO `gsms_user` VALUES ('2112', '', '', '0', '0', 'abc', '', '3', '0', '6688', '0', '13409879904', null, 'abc@163.com', '2015-07-08 00:00:00', '2', null, 'nvasd', 'abc', null, '0', '', null, 'W(y3ETyZ', '', null, '', '', 'abc', '', '', '', '', '20', null, null, '', null, '', '', '4', '10', '79', '2', '0', null, null, '0', null, null);
INSERT INTO `gsms_user` VALUES ('2113', '', '', '0', '0', '【400快线】', '', '3', '0', '0000', '0', '18287131065', '海淀', null, '2015-12-10 09:21:56', '2', '测试企业添加绑定ip', '测试企业', '啊Q', '', '0', '', '0', '123456', '', null, '', '', 'test_ent', '', '', '', '', '20', null, null, '', null, '', '', '1', '1', '2', '2', '0', null, null, '1', '9632587', null);
INSERT INTO `gsms_user` VALUES ('2114', 'admin@test_ent', 'e10adc3949ba59abbe56e057f20f883e', '0', '2113', null, '', '3', '2', '', '0', null, null, null, '2015-12-10 09:23:33', '4', null, '', '超级管理员', '2113.', '0', '', '2113', null, '', null, '', '', null, '', '', '', '', '20', null, null, '', null, '', '', null, null, null, '2', '0', '0', null, '1', null, null);
INSERT INTO `gsms_user` VALUES ('2115', '', '', '0', '0', '【400快线】', '', '3', '0', '0000', '0', '18287131062', '海淀', null, '2015-12-14 09:43:29', '2', '测试企业2', '测试企业2', 'test', '', '0', '', '0', '123456', '', null, '', '', 'test_ent2', '', '', '', '', '20', null, null, '', null, '', '', '1', '1', '2', '2', '1', null, null, '1', '62354875', null);
INSERT INTO `gsms_user` VALUES ('2116', 'admin@test_ent2', 'e10adc3949ba59abbe56e057f20f883e', '0', '2115', null, '', '3', '2', '', '0', null, null, null, '2015-12-14 09:43:30', '4', null, '', '超级管理员', '2115.', '0', '', '2115', null, '', null, '', '', null, '', '', '', '', '20', null, null, '', null, '', '', null, null, null, '2', '0', '0', null, '1', null, null);
INSERT INTO `gsms_user` VALUES ('2117', 'test12', 'e10adc3949ba59abbe56e057f20f883e', '0', '7', '', '', '3', '2', '', '0', '18287131062', null, null, '2015-12-24 16:29:23', '4', '', '', 'test12', '1.7.', '0', '', '1', null, '', null, '', '', null, '', '', '', '', '20', null, '2015-12-24 18:23:00', '', null, '', '', null, null, null, '0', '0', '1', null, '1', null, null);

-- ----------------------------
-- Table structure for `location`
-- ----------------------------
DROP TABLE IF EXISTS `location`;
CREATE TABLE `location` (
  `location_id` int(11) NOT NULL,
  `location_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of location
-- ----------------------------
INSERT INTO `location` VALUES ('1', 'Beijing');

-- ----------------------------
-- Table structure for `test_log`
-- ----------------------------
DROP TABLE IF EXISTS `test_log`;
CREATE TABLE `test_log` (
  `log_name` varchar(20) DEFAULT NULL,
  `operator` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_log
-- ----------------------------
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');
INSERT INTO `test_log` VALUES ('test', 'update');

-- ----------------------------
-- Table structure for `test_pro`
-- ----------------------------
DROP TABLE IF EXISTS `test_pro`;
CREATE TABLE `test_pro` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT 'mysql测试进阶' COMMENT '姓名',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_pro
-- ----------------------------
INSERT INTO `test_pro` VALUES ('0', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('1', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('2', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('3', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('4', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('5', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('6', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('7', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('8', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('9', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('10', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('11', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('12', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('13', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('14', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('15', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('16', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('17', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('18', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('19', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('20', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('21', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('22', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('23', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('24', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('25', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('26', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('27', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('28', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('29', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('30', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('31', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('32', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('33', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('34', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('35', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('36', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('37', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('38', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('39', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('40', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('41', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('42', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('43', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('44', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('45', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('46', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('47', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('48', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('49', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('50', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('51', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('52', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('53', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('54', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('55', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('56', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('57', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('58', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('59', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('60', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('61', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('62', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('63', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('64', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('65', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('66', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('67', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('68', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('69', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('70', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('71', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('72', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('73', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('74', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('75', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('76', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('77', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('78', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('79', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('80', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('81', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('82', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('83', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('84', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('85', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('86', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('87', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('88', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('89', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('90', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('91', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('92', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('93', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('94', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('95', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('96', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('97', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('98', 'test', 'qq');
INSERT INTO `test_pro` VALUES ('99', 'test', 'qq');

-- ----------------------------
-- View structure for `sel_tri`
-- ----------------------------
DROP VIEW IF EXISTS `sel_tri`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `sel_tri` AS select `test_pro`.`name` AS `name`,`test_pro`.`remark` AS `remark` from `test_pro` ;

-- ----------------------------
-- Procedure structure for `handlerInsertWithException`
-- ----------------------------
DROP PROCEDURE IF EXISTS `handlerInsertWithException`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `handlerInsertWithException`()
BEGIN
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET @x2=1;
    SET @x=1;
    INSERT INTO location VALUES (1,'Beijing');
    SET @x=2;
    INSERT INTO location VALUES (1,'Wuxi');
    SET @x=3;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `selec_pro`
-- ----------------------------
DROP PROCEDURE IF EXISTS `selec_pro`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `selec_pro`()
BEGIN
	declare i int;
	select id into @i from test_pro where id=0;
	select @i;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `sel_pro`
-- ----------------------------
DROP PROCEDURE IF EXISTS `sel_pro`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sel_pro`(in rem varchar(100))
begin 
	declare num int;
	declare i int;
	set @num:=@rem;
	set @i:=0;
	while @i < @num do 
		insert into test_pro values(@i,'test','remark');
		set @i=@i+1;
	end while;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `trg_user_insert`;
DELIMITER ;;
CREATE TRIGGER `trg_user_insert` AFTER INSERT ON `gsms_user` FOR EACH ROW begin
	if exists (select * from gsms_sync_version where type=5) then 
		update gsms_sync_version set version=version+1 where type=5;
	else
		insert into gsms_sync_version(type, version) values(5, 1);
	end if;
                  if exists (select * from gsms_sync_version where type=7) then 
		update gsms_sync_version set version=version+1 where type=7;
	else
		insert into gsms_sync_version(type, version) values(7, 1);
	end if;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `trg_user_update`;
DELIMITER ;;
CREATE TRIGGER `trg_user_update` AFTER UPDATE ON `gsms_user` FOR EACH ROW begin
	if exists (select * from gsms_sync_version where type=5) then 
		update gsms_sync_version set version=version+1 where type=5;
	else
		insert into gsms_sync_version(type, version) values(5, 1);
	end if;
                   if exists (select * from gsms_sync_version where type=7) then 
		update gsms_sync_version set version=version+1 where type=7;
	else
		insert into gsms_sync_version(type, version) values(7, 1);
	end if;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `trg_user_delete`;
DELIMITER ;;
CREATE TRIGGER `trg_user_delete` AFTER DELETE ON `gsms_user` FOR EACH ROW begin
	if exists (select * from gsms_sync_version where type=5) then 
		update gsms_sync_version set version=version+1 where type=5;
	else
		insert into gsms_sync_version(type, version) values(5, 1);
	end if;
                  if exists (select * from gsms_sync_version where type=7) then 
		update gsms_sync_version set version=version+1 where type=7;
	else
		insert into gsms_sync_version(type, version) values(7, 1);
	end if;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `sel_tri`;
DELIMITER ;;
CREATE TRIGGER `sel_tri` AFTER UPDATE ON `test_pro` FOR EACH ROW BEGIN
	insert INTO test_log VALUES(NEW.name,'update'); 
end
;;
DELIMITER ;
