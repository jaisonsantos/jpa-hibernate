CREATE TABLE cliente (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  age INTEGER,
  sex VARCHAR(1) NOT NULL,
  profession VARCHAR(30),
  PRIMARY KEY (id)
);

--INSERT EXAMPLE: 
-- client load
INSERT INTO client (name, age, sex, profession) 
	values("José da Silva", 25, "M", "Engenheiro");
    
INSERT INTO client (name, age, sex, profession)
	values("Maria Rita", 21, "F", "Magendaédica");
--finish    

--list table Clien	
select * from clien;

--drop table Client
drop table client;