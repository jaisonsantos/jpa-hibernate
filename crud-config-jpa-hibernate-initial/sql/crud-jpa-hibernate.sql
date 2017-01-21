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

--create table Current Account
CREATE TABLE account_current (
  id BIGINT NOT NULL AUTO_INCREMENT,
  number VARCHAR(12) NOT NULL,
  balance DECIMAL,
  client_id BIGINT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (client_id) REFERENCES client (id)
);

--INSERT EXAMPLE: 
-- Current account load

INSERT INTO account_current (number, balance, client_id)
	values(123456, 1000.00, 1);

INSERT INTO account_current (number, balance, client_id)
	values(2222, 5000.00, 2);

-- finsh INSERT

select * from account_current;

select name, balance from client c
inner join account_current cc ON cc.client_id = c.id
where c.name like '%Jose%';

