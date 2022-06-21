--liquibase formatted sql
--changeSet mardom:6

insert into user_entity (email, password, username, firstname, lastname, role)
values ('a@gmail.com', 'a', 'a_username', 'a_firstname', 'a_lastname', 'USER'),
    ('b@gmail.com', 'b', 'b_username', 'b_firstname', 'b_lastname', 'USER'),
    ('c@envelo.com', 'c', 'c_username', 'c_firstname', 'c_lastname', 'ADMIN');