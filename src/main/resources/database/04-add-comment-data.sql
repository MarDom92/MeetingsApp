--liquibase formatted sql
--changeSet mardom:4

insert into comment_entity (title, event_id, description, created_date)
values ('Comment 1', 1, 'Description of commentEntity 1', '2022-01-01T13:14:05.562673800'),
       ('Comment 2', 2, 'Description of commentEntity 2', '2022-02-01T13:14:05.562673800'),
       ('Comment 3', 3, 'Description of commentEntity 3', '2022-03-01T13:14:05.562673800'),
       ('Comment 4', 4, 'Description of commentEntity 4', '2022-04-01T13:14:05.562673800'),
       ('Comment 5', 5, 'Description of commentEntity 5', '2022-05-01T13:14:05.562673800'),
       ('Comment 6', 1, 'Description of commentEntity 6', '2022-05-01T13:14:05.562673800');
