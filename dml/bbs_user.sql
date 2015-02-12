/*
 * 注册用户表
 *
*/
drop table if exists `g_client_users`;

create table `g_client_users`
(
	`user_id` int(11) not null auto_increment comment 'ID',
	`username` varchar(100) not null comment '用户名',
	`email` varchar(100) default null comment '电子邮箱',
	`password` char(32) not null comment '密码',
	`encrypt_type` tinyint(1) not null default '0' comment '密码加密方式',
	
	`register_time` datetime not null comment '注册时间',
	`register_ip` varchar(50) not null default '127.0.0.1' comment '注册IP',
	`last_login_time` datetime not null comment '最后登录时间',
	`last_login_ip` varchar(50) not null default '127.0.0.1' comment '最后登录IP',
	`login_count` int(11) not null default '0' comment '登录次数',
	
	`reset_key` char(32) default null comment '重置密码问题',
	`reset_pwd` varchar(10) default null comment '重置密码答案',
	`activation` tinyint(1) not null default 0 comment '激活状态',
	`activation_code` char(32) default null comment '激活码',
	
	primary key (`user_id`),
	unique key `ak_username` (`username`)

)ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=gbk  comment='注册用户表';

commit;

/*
`user_id` int(11) NOT NULL auto_increment COMMENT '用户ID',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `email` varchar(100) default NULL COMMENT '电子邮箱',
  `password` char(32) NOT NULL COMMENT '密码',
  `register_time` datetime NOT NULL COMMENT '注册时间',
  `register_ip` varchar(50) NOT NULL default '127.0.0.1' COMMENT '注册IP',
  `last_login_time` datetime NOT NULL COMMENT '最后登录时间',
  `last_login_ip` varchar(50) NOT NULL default '127.0.0.1' COMMENT '最后登录IP',
  `login_count` int(11) NOT NULL default '0' COMMENT '登录次数',
  `reset_key` char(32) default NULL COMMENT '重置密码KEY',
  `reset_pwd` varchar(10) default NULL COMMENT '重置密码VALUE',
  `activation` tinyint(1) NOT NULL default '0' COMMENT '激活状态',
  `activation_code` char(32) default NULL COMMENT '激活码',
  PRIMARY KEY  (`user_id`),
  UNIQUE KEY `ak_username` (`username`)
*/