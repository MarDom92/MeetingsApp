--liquibase formatted sql
--changeSet mardom:3

CREATE TABLE COMMENT
(
    id SERIAL PRIMARY KEY,
    title VARCHAR(400)  NOT NULL,
    description VARCHAR(2000) NULL,
    created_date timestamp
);