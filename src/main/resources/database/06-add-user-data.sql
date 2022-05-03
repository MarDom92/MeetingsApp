--liquibase formatted sql
--changeSet mardom:6

insert into user_account(email, password, username, firstname, lastname, role, is_expired, is_locked, is_credentials_expired, is_enabled)
values ('a@gmail.com', '$2a$10$Js7yTXVejIowW.4oJkrSpen33LtQdh11EluWBM.io4Z3F2np1x40a', 'a_username', 'a_firstname', 'a_lastname', 'USER', FALSE, FALSE, FALSE, TRUE),
    ('b@gmail.com', '$2a$10$m.NYIHZkbzCIU6UCZ0I6wu3g/S.BO26uRdpQnbxylaLc/coJmgCBK', 'b_username', 'b_firstname', 'b_lastname', 'USER', FALSE, FALSE, FALSE, TRUE),
    ('c@envelo.com', '$2a$10$QO6py9CIqIeGg7qgD6oDrOnB/LPji/WC4WJ7JFrJJaiYrsEB4aT16', 'c_username', 'c_firstname', 'c_lastname', 'ADMIN', FALSE, FALSE, FALSE, TRUE);