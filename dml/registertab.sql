drop table if exists `registertab`; 

/*ɾ���� ������*/
CREATE TABLE `registertab` (
  `id` varchar(20) NOT NULL comment '���к�',
  `name` varchar(20) default NULL COMMENT '�û���',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 comment 'ע���';

insert into registertab values("1","1");
insert into registertab values("2","2");

commit;

/* �Զ�����id 
alter table registertab add   guid varchar(36)  default upper(replace(uuid(),'-',''));

alter table `registertab` add shortid  varchar(36) default UUID_SHORT();

alter table registertab alter   guid varchar(36)  default upper(replace(uuid(),'-',''));


DROP TRIGGER IF EXISTS `test`.`default_id`//

CREATE TRIGGER `test`.`default_id` BEFORE INSERT ON `test`.`test`
 FOR EACH ROW if (new.id='' or new.id is null) then  
       set new.id= uuid();  
     end if
//

ִ��sql��ʱ���Delimiter �ĳ� // ����

create table test (id int not null auto_increment primary key, t datetime);
delimiter //
create trigger ins_time before insert on test 
for each row set NEW.t = now(); //
delimiter ;

insert into test (id) values (NULL);

mysql Ĭ��ֵ��֧�ֺ���
*/
http://www.w3school.com.cn/sql/sql_create_table.asp

-- mysql û��trunc��ֻ��select  DATE_FORMAT(now(), '%Y-%m-%d %H:%i:%s');


-- �ݹ��ѯ 

select b.menu_id,b.menu_text,b.MENU_PARENT_ID,b.menu_path 
from g_menu as a, g_menu as b 
where a.menu_id=b.MENU_PARENT_ID 
and (a.menu_id=5 or a. MENU_PARENT_ID =5);


select b.menu_id,b.menu_text,b.MENU_PARENT_ID,b.menu_path 
from g_menu as a, g_menu as b 
where a.menu_id=b.MENU_PARENT_ID 
and (
a.menu_id in (select rmm.menu_id from g_role_menu_map rmm where rmm.role_code in ('R_ADMIN') )
);

-- 
select rmt.* from (
	select b.menu_id,b.menu_text,b.MENU_PARENT_ID,b.menu_path 
	from g_menu as a, g_menu as b 
	where a.menu_id=b.MENU_PARENT_ID 
)
as rmt where  rmt.menu_id in (6,7,8) or rmt.MENU_PARENT_ID in (6,7,8)
;
 
 select * from g_menu t;
 
 insert into g_menu (MENU_ID, MENU_TEXT, MENU_PATH, MENU_SORT_VALUE, MENU_PARENT_ID, ATTR1, ATTR2, ATTR3,CREATE_TIME)
values (1, '@@@', '', 1, , 'v', '', '',null);
 
 
 
 
 
 
 
 