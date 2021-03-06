--liquibase formatted sql
--changeSet mardom:3

CREATE TABLE COMMENT_ENTITY (
    id SERIAL PRIMARY KEY,
    event_id BIGINT NOT NULL,
    title VARCHAR(400)  NOT NULL,
    description VARCHAR(2000) NULL,
    created_date timestamp
);

ALTER TABLE COMMENT_ENTITY
    ADD CONSTRAINT comment_event_id
    FOREIGN KEY (event_id) REFERENCES eventEntity(id)