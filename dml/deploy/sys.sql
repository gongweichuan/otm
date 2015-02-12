
SELECT DISTINCT M2.* FROM
(
select m1.menu_id         as menuid,
         m1.menu_text       as menutext,
         m1.menu_path       as menupath,
         m1.menu_parent_id  as menuparentid,
         m1.menu_sort_value as menusortvalue,
         m1.attr1           as attr1,
         m1.attr2           as attr2,
         m1.attr3           as attr3
    from g_menu m1 where m1.menu_id in (select m.menu_id
                               from g_menu m, g_role_menu_map mp
                              where m.menu_id = mp.menu_id
                                and mp.role_code in ('R_ADMIN')                            
                             )
union all
  select m1.menu_id         as menuid,
         m1.menu_text       as menutext,
         m1.menu_path       as menupath,
         m1.menu_parent_id  as menuparentid,
         m1.menu_sort_value as menusortvalue,
         m1.attr1           as attr1,
         m1.attr2           as attr2,
         m1.attr3           as attr3
    from g_menu m1  where m1.menu_id in
(
  select distinct
         mp.menu_parent_id  as menuparentid        
    from g_menu mp where mp.menu_id in (select m.menu_id
                               from g_menu m, g_role_menu_map mp
                              where m.menu_id = mp.menu_id
                                and mp.role_code in ('R_ADMIN')                                                        )
)
union all
  select m1.menu_id         as menuid,
         m1.menu_text       as menutext,
         m1.menu_path       as menupath,
         m1.menu_parent_id  as menuparentid,
         m1.menu_sort_value as menusortvalue,
         m1.attr1           as attr1,
         m1.attr2           as attr2,
         m1.attr3           as attr3 
    from g_menu m1  where m1.menu_id in (1)
)M2 ORDER BY M2.MENUSORTVALUE
;