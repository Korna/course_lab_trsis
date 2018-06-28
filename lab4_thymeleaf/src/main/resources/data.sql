--CREATE TABLE School (  SCHOOL_ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),  SCHOOL_NUMBER INT,  SCHOOL_NAME VARCHAR(128));
--CREATE TABLE Batch (  BATCH_ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),  BATCH_NUMBER VARCHAR(45),  BATCH_SCHOOL_ID INT NOT NULL,  CONSTRAINT fk_BATCH_SCHOOL1    FOREIGN KEY (BATCH_SCHOOL_ID)    REFERENCES SCHOOL (SCHOOL_ID));
--CREATE TABLE Student (  STUD_ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),  STUD_FNAME VARCHAR(128),  STUD_LNAME VARCHAR(128),  STUD_PNAME VARCHAR(128),  STUD_NUM_ZACH VARCHAR(45),  STUD_BATCH_ID INT NOT NULL,  CONSTRAINT fk_STUDENT_BATCH    FOREIGN KEY (STUD_BATCH_ID)    REFERENCES BATCH (BATCH_ID));
--create table user ("id" bigint generated by default as identity,"hash" varchar(255) not null, "login" varchar(255) not null, primary key ("id"));

--insert into "school" ("school_number", "school_name") values (1, '��������� 1');
--insert into "school" ("school_number", "school_name") values (2, '��������� 2');
--insert into "school" ("school_number", "school_name") values (3, '��������� 3');
--insert into "school" ("school_number", "school_name") values (4, '��������� 4');
--insert into "school" ("school_number", "school_name") values (5, '��������� 5');

insert into "user"("login", "hash") values ('guest','$2a$10$6mf3CesQx9eRGB4B3sjr8e1eSr5cYO/zt87bwYVdA4O8rmjDMDdHO');
insert into "user"("login", "hash") values ('user','$2a$10$6mf3CesQx9eRGB4B3sjr8e1eSr5cYO/zt87bwYVdA4O8rmjDMDdHO');
--hello
--password $2y$10$ul8JyyF8WmkOZoQUEoLX1ez/5mZDQ2rXHOBT0oZf4gyAZ.Y6u9g7u