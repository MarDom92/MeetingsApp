--liquibase formatted sql
--changeSet mardom:5

CREATE TABLE USER_ENTITY (
    id SERIAL PRIMARY KEY,
    email VARCHAR(200) NOT NULL,
    password VARCHAR(200) NULL,
    username VARCHAR(400) NULL,
    firstname VARCHAR(400) NULL,
    lastname VARCHAR(400) NULL,
    role VARCHAR(100)
);