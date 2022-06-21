--liquibase formatted sql
--changeSet mardom:2

insert into event(id, title, description, place, status, created_date, updated_date, start_date, end_date)
values (1, 'Event 1', 'Description 1', 'Warszawa', 'PLANNED', '2019-01-01T13:14:05.562673800',
        '2020-01-01T13:14:05.574458300',
        '2021-01-01T13:14:05.602757600', '2022-01-01T13:14:05.616423900'),
       (2, 'Event 2', 'Description 2', 'Poznań', 'NOW', '2019-02-01T13:14:05.562673800',
        '2020-02-01T13:14:05.574458300',
        '2021-02-01T13:14:05.602757600', '2022-02-01T13:14:05.616423900'),
       (3, 'Event 3', 'Description 3', 'Kraków', 'NOW', '2019-03-01T13:14:05.562673800',
        '2020-03-01T13:14:05.574458300',
        '2021-03-01T13:14:05.602757600', '2022-03-01T13:14:05.616423900'),
       (4, 'Event 4', 'Description 4', 'Gdańsk', 'NOW', '2019-04-01T13:14:05.562673800',
        '2020-04-01T13:14:05.574458300',
        '2021-04-01T13:14:05.602757600', '2022-04-01T13:14:05.616423900'),
       (5, 'Event 5', 'Description 5', 'Szczecin', 'PLANNED', '2019-05-01T13:14:05.562673800',
        '2020-05-01T13:14:05.574458300',
        '2021-05-01T13:14:05.602757600', '2022-05-01T13:14:05.616423900'),
       (6, 'Event 6', 'Description 6', 'Wrocław', 'PLANNED', '2019-06-01T13:14:05.562673800',
        '2020-06-01T13:14:05.574458300',
        '2021-06-01T13:14:05.602757600', '2022-06-01T13:14:05.616423900'),
       (7, 'Event 7', 'Description 7', 'Łódź', 'PLANNED', '2019-07-01T13:14:05.562673800', '2020-07-01T13:14:05.574458300',
        '2021-07-01T13:14:05.602757600', '2022-07-01T13:14:05.616423900'),
       (8, 'Event 8', 'Description 8', 'Lublin', 'PLANNED', '2019-08-01T13:14:05.562673800',
        '2020-08-01T13:14:05.574458300',
        '2021-08-01T13:14:05.602757600', '2022-08-01T13:14:05.616423900'),
       (9, 'Event 9', 'Description 9', 'Sosnowiec', 'ARCHIVED', '2019-09-01T13:14:05.562673800',
        '2020-09-01T13:14:05.574458300',
        '2021-09-01T13:14:05.602757600', '2022-09-01T13:14:05.616423900'),
       (10, 'Event 10', 'Description 10', 'Radom', 'ARCHIVED', '2019-01-01T13:14:05.562673800',
        '2020-10-01T13:14:05.574458300',
        '2021-10-01T13:14:05.602757600', '2022-10-01T13:14:05.616423900'),
       (11, 'Event 11', 'Description 11', 'Olsztyn', 'ARCHIVED', '2019-01-01T13:14:05.562673800',
        '2020-10-01T13:14:05.574458300',
        '2021-10-01T13:14:05.602757600', '2022-10-01T13:14:05.616423900'),
       (12, 'Event 12', 'Description 12', 'Białystok', 'ARCHIVED', '2019-01-01T13:14:05.562673800',
        '2020-10-01T13:14:05.574458300',
        '2021-10-01T13:14:05.602757600', '2022-10-01T13:14:05.616423900'),
       (13, 'Event 13', 'Description 13', 'Toruń', 'PLANNED', '2019-01-01T13:14:05.562673800',
        '2020-10-01T13:14:05.574458300',
        '2021-10-01T13:14:05.602757600', '2022-10-01T13:14:05.616423900'),
       (14, 'Event 14', 'Description 14', 'Sopot', 'PLANNED', '2019-01-01T13:14:05.562673800',
        '2020-10-01T13:14:05.574458300',
        '2021-10-01T13:14:05.602757600', '2022-10-01T13:14:05.616423900'),
       (15, 'Event 15', 'Description 15', 'Gdynia', 'PLANNED', '2019-01-01T13:14:05.562673800',
        '2020-10-01T13:14:05.574458300',
        '2021-10-01T13:14:05.602757600', '2022-10-01T13:14:05.616423900'),
       (16, 'Event 16', 'Description 16', 'Otwock', 'PLANNED', '2019-01-01T13:14:05.562673800',
        '2020-10-01T13:14:05.574458300',
        '2021-10-01T13:14:05.602757600', '2022-10-01T13:14:05.616423900'),
       (17, 'Event 17', 'Description 17', 'Sulejówek', 'PLANNED', '2019-01-01T13:14:05.562673800',
        '2020-10-01T13:14:05.574458300',
        '2021-10-01T13:14:05.602757600', '2022-10-01T13:14:05.616423900'),
       (18, 'Event 18', 'Description 18', 'Pruszków', 'PLANNED', '2019-01-01T13:14:05.562673800',
        '2020-10-01T13:14:05.574458300',
        '2021-10-01T13:14:05.602757600', '2022-10-01T13:14:05.616423900'),
       (19, 'Event 19', 'Description 19', 'Wołomin', 'CANCELLED', '2019-01-01T13:14:05.562673800',
        '2020-10-01T13:14:05.574458300',
        '2021-10-01T13:14:05.602757600', '2022-10-01T13:14:05.616423900'),
       (20, 'Event 20', 'Description 20', 'Świebodzin', 'CANCELLED', '2019-01-01T13:14:05.562673800',
        '2020-10-01T13:14:05.574458300',
        '2021-10-01T13:14:05.602757600', '2022-10-01T13:14:05.616423900');