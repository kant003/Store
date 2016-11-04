CREATE DATABASE Store_Desarrollo;
GRANT ALL ON Store_Desarrollo.* TO 'store'@'localhost' IDENTIFIED BY 'Ad1234';
USE Store_Desarrollo; 

CREATE TABLE Provider( 
IdProvider INT PRIMARY KEY, 
CifProvider int(9), 
NameProvider VARCHAR(20) Not Null,
Adress VARCHAR(20)Not Null,
Email VARCHAR(40)Not null,
Phone int(9)
)ENGINE = InnoDB; 

CREATE TABLE Client(
IdClient int PRIMARY KEY,
NameClient VARCHAR(20)NOT NULL,
SURNAME VARCHAR(30) NOT NULL,
TELEPHONE longtext NOT NULL,
EMAIL varchar(40)NOT NULL,
ADRESS varchar(20) NOT NULL,
PasswordCliente varchar(20)
)
Engine=InnoDB;

CREATE TABLE PRODUCT(
IdProduct int PRIMARY KEY,
NameProduct VARCHAR(20) Not Null,
RefProduct INT Not Null,
Stock int Not Null,
Price double,
IdProvider int, 
FOREIGN KEY (IdProvider) REFERENCES Provider (IdProvider)
)ENGINE = InnoDB; 

Create table PURCHASE(
IdClient int PRIMARY KEY,
IdProduct int Not Null,
DatePurchase date,
foreign key (IdClient) references Client(IdClient),
foreign key (IdProduct)references Product(IdProduct)
)Engine = InnoDB;