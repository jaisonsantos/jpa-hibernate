CREATE TABLE diary (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255),
  registrationDate DATETIME,
  phone VARCHAR(255),
  PRIMARY KEY (id)
);

--INSERT EXAMPLE: 
-- Diary load
INSERT INTO diary (name, registrationDate, phone) 
	values("Harry B. Travel", '2017-01-20 23:28:51', "(21) 9355-6024");
    
INSERT INTO diary (name, registrationDate, phone) 
	values("Book Away", '2017-01-20 22:25:04', "(21) 2554-6790");

INSERT INTO diary (name, registrationDate, phone) 
	values("Listen", '2017-01-20 21:43:16', "(21) 2009-5677");

INSERT INTO diary (name, registrationDate, phone) 
	values("x-man evolution", '2017-01-20 20:12:25', "(21) 3412-6314");
	
--finish    

--list table Diary	
select * from diary;

--drop table Client
drop table diary;
