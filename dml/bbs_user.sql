/*
 * ע���û���
 *
*/
drop table if exists `g_client_users`;

create table `g_client_users`
(
	`user_id` int(11) not null auto_increment comment 'ID',
	`username` varchar(100) not null comment '�û���',
	`email` varchar(100) default null comment '��������',
	`password` char(32) not null comment '����',
	`encrypt_type` tinyint(1) not null default '0' comment '������ܷ�ʽ',
	
	`register_time` datetime not null comment 'ע��ʱ��',
	`register_ip` varchar(50) not null default '127.0.0.1' comment 'ע��IP',
	`last_login_time` datetime not null comment '����¼ʱ��',
	`last_login_ip` varchar(50) not null default '127.0.0.1' comment '����¼IP',
	`login_count` int(11) not null default '0' comment '��¼����',
	
	`reset_key` char(32) default null comment '������������',
	`reset_pwd` varchar(10) default null comment '���������',
	`activation` tinyint(1) not null default 0 comment '����״̬',
	`activation_code` char(32) default null comment '������',
	
	primary key (`user_id`),
	unique key `ak_username` (`username`)

)ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=gbk  comment='ע���û���';

commit;

/*
`user_id` int(11) NOT NULL auto_increment COMMENT '�û�ID',
  `username` varchar(100) NOT NULL COMMENT '�û���',
  `email` varchar(100) default NULL COMMENT '��������',
  `password` char(32) NOT NULL COMMENT '����',
  `register_time` datetime NOT NULL COMMENT 'ע��ʱ��',
  `register_ip` varchar(50) NOT NULL default '127.0.0.1' COMMENT 'ע��IP',
  `last_login_time` datetime NOT NULL COMMENT '����¼ʱ��',
  `last_login_ip` varchar(50) NOT NULL default '127.0.0.1' COMMENT '����¼IP',
  `login_count` int(11) NOT NULL default '0' COMMENT '��¼����',
  `reset_key` char(32) default NULL COMMENT '��������KEY',
  `reset_pwd` varchar(10) default NULL COMMENT '��������VALUE',
  `activation` tinyint(1) NOT NULL default '0' COMMENT '����״̬',
  `activation_code` char(32) default NULL COMMENT '������',
  PRIMARY KEY  (`user_id`),
  UNIQUE KEY `ak_username` (`username`)
*/