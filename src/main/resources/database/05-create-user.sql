--liquibase formatted sql
--changeSet mardom:5

CREATE TABLE USER_ACCOUNT(
    id SERIAL PRIMARY KEY,
    email VARCHAR(200) NOT NULL,
    password VARCHAR(200) NOT NULL,
    username VARCHAR(400) NOT NULL,
    firstname VARCHAR(400) NULL,
    lastname VARCHAR(400) NULL,
    role VARCHAR(100),
    is_expired BOOLEAN,
    is_locked BOOLEAN,
    is_credentials_expired BOOLEAN,
    is_enabled BOOLEAN
);