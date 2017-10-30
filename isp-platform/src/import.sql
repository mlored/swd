insert into cars (color, mark, model, number) values ('rojo','ferrari','deportivo', 121);
insert into cars (color, mark, model, number) values ('negro','Lamborghini','deportivo', 122);
insert into cars (color, mark, model, number) values ('azul','Audi','deportivo', 123);
insert into cars (color, mark, model, number) values ('gris','Mercedes Benz','deportivo', 124);
insert into cars (color, mark, model, number) values ('negro','BMW','deportivo', 125);

insert into person (DTYPE, name, surname, RUC, address, cellphone, personType) values ('ClientDomain','adrian','aguero','4925875', 'Centro', '0985124789', 'Proveedor');
insert into person (DTYPE, name, surname, RUC, address, cellphone, personType) values ('SupplierDomain','karina','sanabria','123456', 'Centro', '0875412369', 'Proveedor');
insert into person (DTYPE, name, surname, RUC, address, cellphone, personType) values ('ClientDomain','guillermo','zarza','123457', 'Centro', '0995123478', 'Cliente');
insert into person (DTYPE, name, surname, RUC, address, cellphone, personType) values ('SupplierDomain','lorena','delpuerto','1234568', 'Centro', '0985012369', 'Empleado');
insert into person (DTYPE, name, surname, RUC, address, cellphone, personType) values ('EmployeeDomain','Albert','Einstein','123459', 'Centro', '0985102369', 'Proveedor');
insert into person (DTYPE, name, surname, RUC, address, cellphone, personType) values ('EmployeeDomain','Marie','Curie','1234560', 'Centro', '0994125786', 'Cliente');

insert into items (DTYPE, name, price, quantity) values ('ServiceDomain', 'cambio de aceite','100000',	null);
insert into items (DTYPE, name, price, quantity) values ('ServiceDomain', 'cambio de frenos','250000',	null);
insert into items (DTYPE, name, price, quantity) values ('PartDomain', 'caja mecanica',	'500000',	1);
insert into items (DTYPE, name, price, quantity) values ('ServiceDomain', 'cambio de motor',	'4000000',	null);
insert into items (DTYPE, name, price, quantity) values ('PartDomain', 'motor',			'2000000',	4);