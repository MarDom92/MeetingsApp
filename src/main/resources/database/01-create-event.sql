--liquibase formatted sql
--changeset mardom:1
CREATE TABLE EVENT
(
    id      SERIAL PRIMARY KEY,
    title   VARCHAR(400)  NOT NULL,
    description VARCHAR(2000) NULL,
    place VARCHAR(400) NULL,
    created_date timestamp,
    updated_date timestamp,
    start_date timestamp,
    end_date timestamp
);