create database Food_Delivery_App;
use Food_Delivery_App;

show tables;

create table user
(
USER_ID int not null auto_increment,
USER_NAME VARCHAR(255) UNIQUE,
USER_MOBILE_NUMBER VARCHAR(255) NOT NULL,
USER_EMAIL  VARCHAR(255) NOT NULL,
USER_PASSWORD VARCHAR(255) NOT NULL,
PRIMARY KEY(USER_ID)
);

select * from user;

create table rest_Category
(
  CATEGORY_ID        int auto_increment ,
  CATEGORY_NAME        VARCHAR(255) not null,
  primary key(CATEGORY_ID)
) ;

insert into rest_category(CATEGORY_NAME) values("Chinese");
insert into rest_category(CATEGORY_NAME) values("Indian");

create table restaurant
(
   RESTAURANT_ID int auto_increment,
   RESTAURANT_NAME VARCHAR(255) not null,
   RESTAURANT_ADDRESS VARCHAR(255) not null,
   CATEGORY_ID int,
   FOREIGN KEY (CATEGORY_ID) REFERENCES rest_Category(CATEGORY_ID),
   primary key(RESTAURANT_ID)
);

insert into restaurant(RESTAURANT_NAME, RESTAURANT_ADDRESS,CATEGORY_ID) values("Udupi grand","Udupi",4);
insert into restaurant(RESTAURANT_NAME, RESTAURANT_ADDRESS,CATEGORY_ID) values("Shengai","Bangalore",3);

create table food_ITems
(
  ITEM_ID        int not null auto_increment ,
  ITEM_NAME        VARCHAR(255) not null,
  PRICE       double precision not null,
  primary key(ITEM_ID),
  RESTAURANT_ID int,
  FOREIGN KEY (RESTAURANT_ID) REFERENCES restaurant(RESTAURANT_ID)
) ;

ALTER TABLE food_ITems ADD ITEM_AVAILABILITY long  AFTER ITEM_NAME ;
alter table food_ITems drop item_availabilty;

create table customer
(
  CUSTOMER_ID        int not null auto_increment primary key ,
  CUSTOMER_NAME VARCHAR(255) not null,
  CUSTOMER_ADDRESS VARCHAR(255) not null,
  EMAIL VARCHAR(255) not null
   );
   
   truncate table customer;
   
   create table cartz
(
  C_ID int not null auto_increment primary key,
  ITEM_ID int not null,
  CUST_ID int not null,
  FOREIGN KEY (ITEM_ID) REFERENCES food_ITems(ITEM_ID) ON DELETE CASCADE,
  FOREIGN KEY (CUST_ID) REFERENCES customer(CUSTOMER_ID),
  CONFIRM_ORDER TINYINT(1)
) ;
