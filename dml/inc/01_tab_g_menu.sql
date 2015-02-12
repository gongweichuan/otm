drop table if exists G_MENU; 
create table G_MENU 
( 
  ID              VARCHAR(32) default '' not null COMMENT 'uuid()', 
  MENU_ID         INTEGER COMMENT '菜单id', 
  MENU_TEXT       VARCHAR(60) COMMENT '菜单文本', 
  MENU_PATH       VARCHAR(200) COMMENT '菜单url', 
  MENU_SORT_VALUE INTEGER not null COMMENT '排序', 
  MENU_PARENT_ID  INTEGER COMMENT '上级菜单', 
  ATTR1           VARCHAR(50), 
  ATTR2           VARCHAR(50), 
  ATTR3           VARCHAR(50),  

  CREATE_TIME timestamp default '0000-00-00 00:00:00' COMMENT '创建时间', 
  UPDATE_TIME timestamp default now() on update now() COMMENT '修改时间',  
  CREATED_BY   VARCHAR(30) default 'CURRENT_USER' not null COMMENT '创建人',  
  UPDATED_BY   VARCHAR(30) default 'CURRENT_USER' not null COMMENT '修改人',  

  UNIQUE INDEX `MENU_ID_unique` (`MENU_ID`) 
) COMMENT '菜单' 
AUTO_INCREMENT = 10000 
/*AUTO_ID    INTEGER  auto_increment PRIMARY KEY comment '自增id',*/ 
;
 
-- drop index IX_G_MENU_ID on G_MENU;
create unique index IX_G_MENU_ID on G_MENU (MENU_ID);

-- drop index IX_G_MENU_PK on G_MENU;
create unique index IX_G_MENU_PK on G_MENU (ID);
 
-- alter table G_MENU drop primary key;
alter table G_MENU
  add constraint PK_G_MENU_ID primary key (ID); 
  
 /* 
  * using index IX_G_MENU_PK; 
  * */  


 
/*创建同义词*/
/*CREATE PUBLIC SYNONYM G_MENU FOR test.G_MENU;*/

/*授予权限*/
/*GRANT SELECT,INSERT,UPDATE,DELETE ON test.G_MENU TO test;*/


DROP TABLE IF EXISTS G_ROLE_MENU_MAP;
create table G_ROLE_MENU_MAP
(
  ID           VARCHAR(32) default '' not null COMMENT 'uuid()',
  ROLE_CODE    VARCHAR(60) COMMENT '角色编号',
  MENU_ID      INTEGER COMMENT '菜单编号',
  
  CREATE_TIME timestamp default '0000-00-00 00:00:00' COMMENT '创建时间',
  UPDATE_TIME timestamp default now() on update now() COMMENT '修改时间',  
  CREATED_BY   VARCHAR(30) default 'CURRENT_USER' not null COMMENT '创建人',  
  UPDATED_BY   VARCHAR(30) default 'CURRENT_USER' not null COMMENT '修改人'
)
	COMMENT '角色菜单对应表'
;

-- alter table G_ROLE_MENU_MAP DROP INDEX IX_G_ROLE_MENU_MAP_ID;
create unique index IX_G_ROLE_MENU_MAP_ID ON G_ROLE_MENU_MAP(ID);

-- alter table G_ROLE_MENU_MAP DROP PRIMARY KEY ;
ALTER TABLE G_ROLE_MENU_MAP
	ADD constraint PK_G_ROLE_MENU_MAP_ID PRIMARY KEY (ID);
	
-- 一个表中的 FOREIGN KEY 指向另一个表中的 PRIMARY KEY
-- ALTER TABLE G_ROLE_MENU_MAP DROP FOREIGN KEY FK_G_ROLE_MENU_MAP_MENU_ID
ALTER TABLE G_ROLE_MENU_MAP
	ADD CONSTRAINT FK_G_ROLE_MENU_MAP_MENU_ID 
	FOREIGN KEY (MENU_ID)	REFERENCES G_MENU(MENU_ID);
	
/*
 * 创建同义词
 */
/*CREATE PUBLIC SYNONYM G_ROLE_MENU_MAP FOR test.G_ROLE_MENU_MAP;*/

/* 
 * 授予权限
 */
/*GRANT SELECT,INSERT,UPDATE,DELETE ON test.G_ROLE_MENU_MAP TO test;*/  

# show table status like g_menu; 
# show full columns from g_menu; 
-- show create table g_menu; 

/* 
// select now(),sysdate(),curdate(),curtime(),unix_timestamp() 
// current_user()
*/
