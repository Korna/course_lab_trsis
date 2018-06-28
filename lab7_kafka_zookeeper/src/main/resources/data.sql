insert into "user"("login", "hash") values ('admin','$2a$10$c7F/kxpJy1QOgI1/nrXIzub8Ez.63gRyxx4m4S.Cy3j1OXwy18rIC');
insert into "user"("login", "hash") values ('guest','$2a$04$NETuIa4j9Xuv.Vr9Vmo/remOOPH1bEv1ctkWCEa2T1MIbEhrXA1pK');

insert into "category" ("category_id", "author") values (1, 'Положительный');
insert into "category" ("category_id", "author") values (2, 'Отрицательный');

insert into "record" ("author", "description", "date", "category_id")
values ('Врач 1', 'Пациент 1', '01.02.2012', 1);
insert into "record" ("author", "description", "date", "category_id")
values ('Врач 1', 'Пациент 2', '10.10.2010', 1);
insert into "record" ("author", "description", "date", "category_id")
values ('Врач 2', 'Пациент 3', '20.11.2017', 2);
insert into "record" ("author", "description", "date", "category_id")
values ('Врач 3', 'Пациент 1', '20.03.2013', 2);