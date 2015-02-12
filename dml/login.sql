CREATE TABLE `registertab` (
  `id` varchar(20) NOT NULL,
  `name` varchar(20) default NULL,
 
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

insert into registertab(id,name,PARTYNO,REGIST_DATE,ACTIVE_FLAG,USER_NAME) values("1","1","1",now(),"1","1");
insert into registertab(id,name,PARTYNO,REGIST_DATE,ACTIVE_FLAG,USER_NAME) values("2","2","2",current_date,"0","2");

