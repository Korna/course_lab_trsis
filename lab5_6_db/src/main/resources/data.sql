/*
CREATE TABLE POSITION (  POSITION_ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),  POSITION VARCHAR(128),  TOLERANCE_LEVEL VARCHAR(128));
*/


insert into "position" ("position","tolerance_level") values ('Пройден','1');
insert into "position" ("position","tolerance_level") values ('Не пройден','2');




/*
CREATE TABLE PERSONS (  PERSON_ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),  PERSON_SURNAME VARCHAR(128),  PERSON_NAME VARCHAR(128),PERSON_PATRONYMIC VARCHAR(128),PERSON_PASSPORT VARCHAR(128), POSITION_ID VARCHAR(128) ,  CONSTRAINT fk_Position_Persons1 FOREIGN KEY (POSITION_ID)    REFERENCES POSITION (POSITION_ID));
*/


insert into "persons" ("person_surname", "person_name","person_patronymic","person_passport","position_id") values ('Автор 1','Клиент 2','Больница 1','12.11.2017', 1);
insert into "persons" ("person_surname", "person_name","person_patronymic","person_passport","position_id") values ('Автор 2','Клиент 2','Поликлиника 2','09.11.2016', 2);
insert into "persons" ("person_surname", "person_name","person_patronymic","person_passport","position_id") values ('Автор 1','Клиент 1','Пункт сбора крови 2','01.01.2015', 1);
insert into "persons" ("person_surname", "person_name","person_patronymic","person_passport","position_id") values ('Автор 1','Клиент 3','Больница 1','16.11.2017', 2);


