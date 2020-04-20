insert into USER (ID, EMAIL, FIRST_NAME, LAST_NAME, ROLE, SSN, USER_NAME) values(101, 'abc@gmail.com', 'LL', 'KK', 'Associate', 'ssn10', '668403');
insert into USER (ID, EMAIL, FIRST_NAME, LAST_NAME, ROLE, SSN, USER_NAME) values(102, 'fcd@gmail.com', 'KK', 'KK', 'VP', 'ssn101', '668404');
insert into USER (ID, EMAIL, FIRST_NAME, LAST_NAME, ROLE, SSN, USER_NAME) values(103, 'sku@gmail.com', 'DD', 'KK', 'Junior Associate', 'ssn110', '668405');
insert into USER (ID, EMAIL, FIRST_NAME, LAST_NAME, ROLE, SSN, USER_NAME) values(104, 'fff@gmail.com', 'SS', 'KK', 'Associate', 'ssn100', '668406');
insert into USER (ID, EMAIL, FIRST_NAME, LAST_NAME, ROLE, SSN, USER_NAME) values(105, 'yy@gmail.com', 'YY', 'KK', 'Developer', 'ssn104', '668407');

insert into ORDERS (ORDER_ID, ORDER_DESCRIPTION, USER_ID) values (2001, 'order-1', 101);
insert into ORDERS (ORDER_ID, ORDER_DESCRIPTION, USER_ID) values (2002, 'order-2', 101);
insert into ORDERS (ORDER_ID, ORDER_DESCRIPTION, USER_ID) values (2003, 'order-3', 101);
insert into ORDERS (ORDER_ID, ORDER_DESCRIPTION, USER_ID) values (2004, 'order-4', 102);
insert into ORDERS (ORDER_ID, ORDER_DESCRIPTION, USER_ID) values (2005, 'order-5', 102);
insert into ORDERS (ORDER_ID, ORDER_DESCRIPTION, USER_ID) values (2006, 'order-6', 103);
insert into ORDERS (ORDER_ID, ORDER_DESCRIPTION, USER_ID) values (2007, 'order-7', 104);