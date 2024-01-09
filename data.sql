insert into category (is_deleted, sort_order,label, value,created_at,updated_at) VALUES (0,0,'자유게시판','free',current_timestamp,current_timestamp);
insert into category (is_deleted, sort_order,label, value,created_at,updated_at) VALUES (0,1,'개발게시판','dev',current_timestamp,current_timestamp);
insert into category (is_deleted, sort_order,label, value,created_at,updated_at) VALUES (0,2,'일상게시판','daily',current_timestamp,current_timestamp);
insert into category (is_deleted, sort_order,label, value,created_at,updated_at) VALUES (0,3,'사건사고게시판','issue',current_timestamp,current_timestamp);

insert into article (category_id, is_deleted,password,content,  title, view_count, created_at, updated_at ) values (1,0,'비밀번호123','첫번째 글 입니다.','첫번째 글',0, current_timestamp,current_timestamp)
