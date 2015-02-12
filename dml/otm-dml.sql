/*
 * 创建的OTM消息表
 *
*/
drop table if exists `g_otm_messages_tab`;

create table `g_otm_messages_tab`
(
	`message_id` int(11) not null auto_increment comment '留言id',
	`message_context` varchar(512) not null comment '内容',
	`read_delay` int(5) not null default 180 comment '阅读后多少秒销毁',
	`unread_delay` int(3) not null default 365 comment '未读留言最长保留多少天',
	`access_password` char(32) not null comment '访问密码',
	`read_count` int(3) not null default 0 comment '阅读次数',
	`max_read_count` int(3) not null default 1 comment '最大可阅读次数',
	`visit_count` int (5) not null default 0 comment '访问计数',
	`create_user` char(32) comment '发送者的注册id',
	`create_date` TIMESTAMP  comment '留言创建时间',
	`read_date` TIMESTAMP comment '消息读取时间',
	`update_date` TIMESTAMP comment '最后更新时间',
	primary key (`message_id`)
)ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=gbk  comment='OTM消息表';

#新建消息
drop procedure if exists `g_otm_insert_messages_proc`;

/*
 * 创建存储过程
 */
/*
 * delimiter命令来把语句定界符从\;变为//
 */
#在命令行中执行需要
#delimiter //
#需要用 executed Selected text as one statement
create procedure `g_otm_insert_messages_proc`
(
	-- in in_message_id int(11),
	in in_message_context varchar(512),
	in in_read_delay int(5),
	in in_unread_delay int(3),
	in in_access_password char(32),
	in in_read_count int(3),
	in in_max_read_count int(3),
	in in_visit_count int (5),
	in in_create_user char(32),
	in in_create_date TIMESTAMP,
	in in_read_date TIMESTAMP,
	in in_update_date TIMESTAMP,
	
	out out_message_id int(11),
	out OUT_RETCODE VARCHAR(4),
	out OUT_RETMESSAGE VARCHAR(140)
)	
begin
	declare read_delay_seconds int(5) default 180;#定义临时变量	
	declare max_unread_delay_days int(3) default 30;#最长保存时间
	
	set read_delay_seconds=in_read_delay*60;
	set max_unread_delay_days=in_unread_delay*30;
	
	insert into g_otm_messages_tab(`message_context`,`read_delay`,`unread_delay`,`access_password`,`read_count`,
	`max_read_count`,`visit_count`,`create_user`,`create_date`,`read_date`,`update_date`)
	values(in_message_context,read_delay_seconds,
	max_unread_delay_days,
	in_access_password,in_read_count,
	in_max_read_count,in_visit_count,in_create_user,in_create_date,in_read_date,in_update_date);
	
	select last_insert_id() into out_message_id;
	#------------------------------
	set OUT_RETCODE='0';
	set OUT_RETMESSAGE='db log success';
	
	commit;
end;

#delimiter ;
#End存储过程
###################################################################################################################################33

/**
 * 更新消息表，更新访问计数、访客计数、读取时间、更新时间
 */
drop procedure if exists `g_otm_update_messages_proc`;

create procedure `g_otm_update_messages_proc`
(
	in in_message_id int(11),

	in in_read_count int(3),
	in in_visit_count int (5),
	in in_case TINYINT,
	/*
	in in_read_date TIMESTAMP,
	in in_update_date TIMESTAMP,
	*/
	
	out OUT_RETCODE VARCHAR(4),
	out OUT_RETMESSAGE VARCHAR(140)
)
begin
	declare current_now	TIMESTAMP default now();
	
	if in_case=0 then	
		update g_otm_messages_tab t set t.read_count=in_read_count,
		t.visit_count=in_visit_count,
		t.read_date=current_now,
		t.update_date=current_now 
		where t.message_id=in_message_id;
	#--
	else 	
	-- xxxxxxxxxx
		update g_otm_messages_tab t set 		
		t.visit_count=in_visit_count,	
		t.update_date=current_now 
		where t.message_id=in_message_id;
	end if;
	
	#------------------------------
	set OUT_RETCODE='0';
	set OUT_RETMESSAGE='db log success';
	
	commit;
end ;

/*
 * 查询所有消息
 */
drop procedure if exists `g_otm_select_messages_proc`;

create procedure `g_otm_select_messages_proc`
(	
	in in_message_id int(11),
	in in_from_date timestamp,
	in in_to_date timestamp,
	in in_perpage int,
	in in_pagesize int,
	out out_totalnum int,
	#out out_result Cursor,
	out OUT_RETCODE VARCHAR(4),
	out OUT_RETMESSAGE VARCHAR(140)
)
begin
	
	select count(*) from  g_otm_messages_tab t into out_totalnum;
	
	if in_message_id!=null then	
	
		set @stmt = concat('select * from g_otm_messages_tab t where t.message_id=?  limit ?,?');
		prepare st from @stmt;
		set @s1 = in_message_id;
  		set @s2 = in_perpage;
  		set @s3 = in_pagesize;
		execute s1 using @s1,@s2,@s3;
  		deallocate prepare st;		
		
	else	
		set @stmt = concat('select * from g_otm_messages_tab t where t.create_date between ? and ? limit ?,?');
		prepare st from @stmt;
		set @s1 = in_from_date;
  		set @s2 = in_to_date;
  		set @s3 = in_perpage;
  		set @s4 = in_pagesize;
		execute s1 using @s1,@s2,@s3,@s4;
  		deallocate prepare st;	
	end if;	
	
	#------------------------------
	set OUT_RETCODE='0';
	set OUT_RETMESSAGE='db log success';
	
	commit;
end ;

/**
 * 阅读详细信息访客的信息
 */
drop table if exists `g_otm_visits_info_tab`;

create table `g_otm_visits_info_tab`
(
	`visits_id` int(11) not null auto_increment comment '访客id',
	`isFirstSuccess` int(0) not null default 0 comment '是否第一次阅读',
	`visits_receipt` char(32) comment '回执附言',
	`fk_message_id` int(11) not null comment '外键',
	`session_id`    char(64) not null comment '回话session',
	`ip` char(16) not null comment 'ip地址',
	`refers` text(1024) comment '来源网址',
	`os_version` char(128) comment '操作系统',
	`browser_version` char(128) comment '浏览器',
	`visits_date` TIMESTAMP  comment '访客访问时间',
	`update_date` TIMESTAMP comment '最后更新时间',
	
	primary key (`visits_id`)
)ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=gbk  comment='OTM阅读值信息表';

commit;

/**
 * 新增访客信息的procedures
 */
drop procedure if exists `g_otm_insert_visits_info_proc`;

create procedure `g_otm_insert_visits_info_proc`
(
	in in_isFirstSuccess int(0),
	in in_visits_receipt char(32),
	in in_fk_message_id int(11),
	in in_session_id char(64),
	in in_ip char(16),
	in in_refers text(1024),
	in in_os_version char(128),
	in in_browser_version char(128),

	out out_visits_id int(11),
	out OUT_RETCODE VARCHAR(4),
	out OUT_RETMESSAGE VARCHAR(140)
)
begin
	declare tmp_visits_date timestamp;
	declare tmp_update_date timestamp;
	declare nowdate timestamp default now();
	
	set tmp_visits_date=nowdate;
	set tmp_update_date=nowdate;
	
	insert into g_otm_visits_info_tab(
	`isFirstSuccess` ,
	`visits_receipt` ,
	`fk_message_id` ,
	`session_id`,
	`ip` ,
	`refers`,
	`os_version`,
	`browser_version`,
	`visits_date` ,
	`update_date`
	) values(
	in_isFirstSuccess ,
	in_visits_receipt ,
	in_fk_message_id ,
	in_session_id ,
	in_ip ,
	in_refers ,
	in_os_version ,
	in_browser_version ,
	tmp_visits_date ,
	tmp_update_date 
	);
	
	select last_insert_id() into out_visits_id;
	
	#------------------------------
	set OUT_RETCODE='0';
	set OUT_RETMESSAGE='db log success';
	
	commit;
end ;


/**
 * 更新访客信息的procedures
 */
drop procedure if exists `g_otm_update_visits_info_proc`;

create procedure `g_otm_update_visits_info_proc`
(
	in in_visits_id int(11),
	in in_isFirstSuccess int(0),
	in in_visits_receipt char(32),
	in in_fk_message_id int(11),
	in in_session_id char(64),
	in in_ip char(16),
	in in_refers text(1024),
	in in_os_version char(128),
	in in_browser_version char(128),
	
	out OUT_RETCODE VARCHAR(4),
	out OUT_RETMESSAGE VARCHAR(140)
)
begin
	
	declare tmp_update_date timestamp;
	declare nowdate timestamp default now();

	set tmp_update_date=nowdate;
	
	update  g_otm_visits_info_tab t
	set
		t.isFirstSuccess=in_isFirstSuccess ,
		t.visits_receipt=in_visits_receipt ,
		t.fk_message_id= in_fk_message_id,
		t.session_id=in_session_id,
		t.ip= in_ip,
		t.refers=in_refers,
		t.os_version=in_os_version,
		t.browser_version=in_browser_version,
		t.update_date=tmp_update_date
	
	where t.visits_id =in_visits_id;
	
	
	
	#------------------------------
	set OUT_RETCODE='0';
	set OUT_RETMESSAGE='db log success';
	
	commit;
end ;

/**
 * 查询访客的信息
 */
drop procedure if exists `g_otm_select_visits_info_proc`;

create procedure `g_otm_select_visits_info_proc`
(
	in in_fk_message_id int(11),
	in in_perpage int,
	in in_pagesize int,
	out out_totalnum int,
	
	out OUT_RETCODE VARCHAR(4),
	out OUT_RETMESSAGE VARCHAR(140)
)
begin
	#-----------------
	select count(*) from  g_otm_visits_info_tab t into out_totalnum;
	
	if in_fk_message_id!=null then
	
	set @stmt = concat('select * from g_otm_visits_info_tab t where t.fk_message_id=?  limit ?,?');
		prepare st from @stmt;
		set @s1 = in_fk_message_id;  #这个应该定义为外键
  		set @s2 = in_perpage;
  		set @s3 = in_pagesize;
		execute s1 using @s1,@s2,@s3;
  		deallocate prepare st;			
	else
		set OUT_RETCODE='1';
		set OUT_RETMESSAGE='查询条件为空';
	end if;
	
	#------------------------------
	set OUT_RETCODE='0';
	set OUT_RETMESSAGE='db log success';
	
	commit;
end ;

/**
 * TOOD 查询访客信息
 */

/**
	 * DECLARE l_int int unsigned default 4000000;    
		DECLARE l_numeric number(8,2) DEFAULT 9.95;    
		DECLARE l_date date DEFAULT '1999-12-31';    
		DECLARE l_datetime datetime DEFAULT '1999-12-31 23:59:59';    
		DECLARE l_varchar varchar(255) DEFAULT 'This will not be padded';
	 */

/**
 * 查存储过程信息
 *
*select * from mysql.proc t where t.db='test' and t.name='g_otm_insert_messages_proc';
SHOW PROCEDURE STATUS
select floor(rand()*10000);
select ceil(rand()*10000);
*/
/**
 * -- limit
 *  set @stmt = concat('select * from ',table_name,' limit ?,?');
  prepare s1 from @stmt;
  set @s1 = page_begin;
  set @s2 = page_end;
  execute s1 using @s1,@s2;
  deallocate prepare s1;

 */
*/