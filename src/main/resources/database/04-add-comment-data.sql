--liquibase formatted sql
--changeSet mardom:4

insert into comment(title, description, created_date)
values ('Comment 1', 'Description of comment 1', '2022-01-01T13:14:05.562673800');

insert into comment(title, description, created_date)
values ('Comment 2', 'Description of comment 2', '2022-02-01T13:14:05.562673800');

insert into comment(title, description, created_date)
values ('Comment 3', 'Description of comment 3', '2022-03-01T13:14:05.562673800');

insert into comment(title, description, created_date)
values ('Comment 4', 'Description of comment 4', '2022-04-01T13:14:05.562673800');

insert into comment(title, description, created_date)
values ('Comment 5', 'Description of comment 5', '2022-05-01T13:14:05.562673800');
