INSERT INTO genres (genre_name)
VALUES ('sci-fi'),
       ('fairytail'),
       ('comedy'),
       ('novel'),
       ('fantasy');

INSERT INTO authors (author_fio)
VALUES ('Philip Kindred Dick'),
       ('Andy Weir'),
       ('Herbert George Wells'),
       ('Jules Gabriel Verne'),
       ('Stanisław Herman Lem'),
       ('Hans Christian Andersen'),
       ('Толстой Алексей Николаевич'),
       ('Александр Сергеевич Пушкин'),
       ('Charles Perrault'),
       ('Giovanni Francesco Rodari'),
       ('Фёдор Михайлович Достоевский'),
       ('Александр Сергеевич Грибоедов'),
       ('Лев Николаевич Толстой'),
       ('Олег Игоревич Дивов'),
       ('Александр Романович Беляев');

INSERT INTO books (book_name, author_id, genre_id)
VALUES ('Do Androids Dream of Electric Sheep?',1,1),
       ('The Martian',2,1),
       ('The War of the Worlds',3,1),
       ('Vingt mille lieues sous les mers',4,1),
       ('Солярис',5,1),
       ('Snedronningen',6,2),
       ('Жар-птица',7,2),
       ('Руслан и Людмила',8,2),
       ('Cinderella',9,2),
       ('Le avventure di Cipollino',10,2),
       ('Преступление и наказание',11,4),
       ('Горе от ума',12,3),
       ('Война и мир',13,4),
       ('Лучший экипаж Солнечной',14,5),
       ('Человек-амфибия',15,5);






-- insert into AUTHORS (
--     FIO,
--     BIRTHDAY,
--     DATE_OF_DEATH)
-- values ('Достоевский Ф М', '1821-10-30', '1881-01-28'); --1
--
-- insert into AUTHORS (
--     FIO,
--     BIRTHDAY)
-- values ('Стивен Эдвин Кинг', '1947-09-21'); --2
--
-- insert into AUTHORS (
--     FIO,
--     BIRTHDAY)
-- values ('Пелевин В О', '1962-11-22'); --3
--
-- insert into LITERARY (ID, NAME)
-- values (LITERARY_SEQ.nextval, 'Униженные и оскорбленные'); --1
--
-- insert into LITERARY (ID, NAME)
-- values (LITERARY_SEQ.nextval, 'Чапаев и пустота'); --2
--
-- insert into LITERARY (ID, NAME) --3
-- values (LITERARY_SEQ.nextval, 'ОНО');
--
-- insert into LITERARY (ID, NAME) --4
-- values (LITERARY_SEQ.nextval, 'Коллаборация ужасов');
--
-- insert into GENRES (NAME) values ('Роман'); --1
-- insert into GENRES (NAME) values ('Ужасы'); --2
-- insert into GENRES (NAME) values ('Классика'); --3
--
-- insert into BOOKS (NAME, ISBN, GENRE_ID)
-- values ('Сборник русских авторов', 'ISBN-00001', 1);
--
-- insert into BOOKS (NAME, ISBN, GENRE_ID)
-- values ('Лучшее Стивена Кинга', 'ISBN-00023', 2);
--
-- insert into AUTHORS_IN_LITERARY (AUTHOR_ID, LITERARY_ID)
-- values (1, 1);
-- insert into AUTHORS_IN_LITERARY (AUTHOR_ID, LITERARY_ID)
-- values (3, 2);
-- insert into AUTHORS_IN_LITERARY (AUTHOR_ID, LITERARY_ID)
-- values (2, 4);
-- insert into AUTHORS_IN_LITERARY (AUTHOR_ID, LITERARY_ID)
-- values (2, 3);
--
-- insert into LITERARY_IN_BOOKS (BOOK_ID, LITERARY_ID)
-- values (1, 1);
-- insert into LITERARY_IN_BOOKS (BOOK_ID, LITERARY_ID)
-- values (1, 2);
-- insert into LITERARY_IN_BOOKS (BOOK_ID, LITERARY_ID)
-- values (2, 3);
--
