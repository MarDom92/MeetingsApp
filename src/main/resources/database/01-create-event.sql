--liquibase formatted sql
--changeSet mardom:1

CREATE TABLE EVENT_ENTITY (
    id SERIAL PRIMARY KEY,
    title VARCHAR(400) NOT NULL,
    description VARCHAR(2000) NULL,
    place VARCHAR(400) NULL,
    status VARCHAR(100),
    created_date timestamp,
    updated_date timestamp,
    start_date timestamp,
    end_date timestamp
);