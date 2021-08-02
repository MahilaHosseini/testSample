create sequence hibernate_sequence start with 1 increment by 1
create table base (dtype varchar(31) not null, id bigint not null, created_date timestamp not null, first_name varchar(30), is_deleted boolean, last_name varchar(50), national_code varchar(10) not null, is_done boolean, priority integer, title varchar(255) not null, deadline integer, description varchar(255) not null, password varchar(255) not null, user_name varchar(255) not null, task_detail_id bigint not null, user_id bigint, profile_id bigint, primary key (id))
alter table base add constraint UK_qqg296x6hif2os7iaxqsg56wg unique (national_code)
alter table base add constraint FK1d07yaqg2hwpyxk7kxgjhd9s6 foreign key (task_detail_id) references base
alter table base add constraint FKlgpygnsopj1xao0i7cghq452o foreign key (user_id) references base
alter table base add constraint FK5v6t6xlh0k20oyanljr3slhqw foreign key (profile_id) references base
create sequence hibernate_sequence start with 1 increment by 1
create table base (dtype varchar(31) not null, id bigint not null, created_date timestamp not null, first_name varchar(30), is_deleted boolean, last_name varchar(50), national_code varchar(10) not null, is_done boolean, priority integer, title varchar(255) not null, deadline integer, description varchar(255) not null, password varchar(255) not null, user_name varchar(255) not null, task_detail_id bigint not null, user_id bigint, profile_id bigint, primary key (id))
alter table base add constraint UK_qqg296x6hif2os7iaxqsg56wg unique (national_code)
alter table base add constraint FK1d07yaqg2hwpyxk7kxgjhd9s6 foreign key (task_detail_id) references base
alter table base add constraint FKlgpygnsopj1xao0i7cghq452o foreign key (user_id) references base
alter table base add constraint FK5v6t6xlh0k20oyanljr3slhqw foreign key (profile_id) references base
