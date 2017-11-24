insert into cars (color, mark, model, number) values ('rojo','ferrari','deportivo', 121);
insert into cars (color, mark, model, number) values ('negro','Lamborghini','deportivo', 122);
insert into cars (color, mark, model, number) values ('azul','Audi','deportivo', 123);
insert into cars (color, mark, model, number) values ('gris','Mercedes Benz','deportivo', 124);
insert into cars (color, mark, model, number) values ('negro','BMW','deportivo', 125);

insert into person (DTYPE, name, surname, RUC, address, cellphone) values ('ClientDomain','adrian','aguero','4925875', 'Centro', '0985124789');
insert into person (DTYPE, name, surname, RUC, address, cellphone) values ('SupplierDomain','karina','sanabria','123456', 'Centro', '0875412369');
insert into person (DTYPE, name, surname, RUC, address, cellphone) values ('ClientDomain','guillermo','zarza','123457', 'Centro', '0995123478');
insert into person (DTYPE, name, surname, RUC, address, cellphone) values ('SupplierDomain','lorena','delpuerto','1234568', 'Centro', '0985012369');
insert into person (DTYPE, name, surname, RUC, address, cellphone) values ('EmployeeDomain','Albert','Einstein','123459', 'Centro', '0985102369');
insert into person (DTYPE, name, surname, RUC, address, cellphone) values ('EmployeeDomain','Marie','Curie','1234560', 'Centro', '0994125786');

insert into items (DTYPE, name, price, quantity) values ('ServiceDomain', 'cambio de aceite','100000',	null);
insert into items (DTYPE, name, price, quantity) values ('ServiceDomain', 'cambio de frenos','250000',	null);
insert into items (DTYPE, name, price, quantity) values ('PartDomain', 'caja mecanica',	'500000',	1);
insert into items (DTYPE, name, price, quantity) values ('ServiceDomain', 'cambio de motor',	'4000000',	null);
insert into items (DTYPE, name, price, quantity) values ('PartDomain', 'motor',			'2000000',	4);

insert into role (name) values ('admin');

insert into user (userName, name, surName, password, role_id) values ('mlored','lorena','del puerto', '123456', 1);