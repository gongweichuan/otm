-- 预设数据
-- CREATE_TIME为null 不可省略
insert into g_menu (MENU_ID, MENU_TEXT, MENU_PATH, MENU_SORT_VALUE, MENU_PARENT_ID, ATTR1, ATTR2, ATTR3,CREATE_TIME)
values (1, 'GWC系统', '', 1, null, 'v', '', '',null);

insert into g_menu (MENU_ID, MENU_TEXT, MENU_PATH, MENU_SORT_VALUE, MENU_PARENT_ID, ATTR1, ATTR2, ATTR3,CREATE_TIME)
values (5, '人员管理', '', 1, 1, 'v', '', '',null);

insert into g_menu (MENU_ID, MENU_TEXT, MENU_PATH, MENU_SORT_VALUE, MENU_PARENT_ID, ATTR1, ATTR2, ATTR3,CREATE_TIME)
values (6, '查询坐席', '/work/staff/qryBatchStaff.do', 1, 5, 'v', '', '',null);

insert into g_menu (MENU_ID, MENU_TEXT, MENU_PATH, MENU_SORT_VALUE, MENU_PARENT_ID, ATTR1, ATTR2, ATTR3,CREATE_TIME)
values (7, '新增坐席', '/saveStaff.screen', 2, 5, 'v', '', '',null);

insert into g_menu (MENU_ID, MENU_TEXT, MENU_PATH, MENU_SORT_VALUE, MENU_PARENT_ID, ATTR1, ATTR2, ATTR3,CREATE_TIME)
values (8, '批量新增', '/work/staff/uploadBatchStaff.do', 3, 5, 'v', '', '',null);

-- 设置菜单角色权限
insert into g_role_menu_map(menu_id,role_code,create_time) values(6,upper('R_ADMIN'),null);
insert into g_role_menu_map(menu_id,role_code,create_time) values(7,upper('R_ADMIN'),null);
insert into g_role_menu_map(menu_id,role_code,create_time) values(8,upper('R_ADMIN'),null);

-- SELECT * FROM information_schema.triggers WHERE TRIGGER_NAME='tr_menu_id'

-- select * from g_menu m;

-- select * from g_role_menu_map t;

/*
 * show variables like 'collation_%';
 * show variables like 'character_set_%';
 * alter database test character set utf8;
 * create database test character set utf8;
 * 
 * #cmd status;
 * 
 * #cmd show create table test;
 */