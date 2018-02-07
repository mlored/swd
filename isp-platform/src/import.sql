insert into cars (color, mark, model, number) values ('Rojo','Ferrari','Deportivo', 121);
insert into cars (color, mark, model, number) values ('Negro','Lamborghini','Deportivo', 122);
insert into cars (color, mark, model, number) values ('Azul','Audi','Deportivo', 123);
insert into cars (color, mark, model, number) values ('Gris','Mercedes Benz','Deportivo', 124);
insert into cars (color, mark, model, number) values ('Negro','BMW','Deportivo', 125);

insert into person (DTYPE, name, surname, RUC, address, cellphone) values ('ClientDomain','Adrian','Aguero','4925875', 'Centro', '0985124789');
insert into person (DTYPE, name, surname, RUC, address, cellphone) values ('ClientDomain','Guillermo','Zarza','123457', 'Centro', '0995123478');
insert into person (DTYPE, name, surname, RUC, address, cellphone) values ('ClientDomain','Mario','Arce','4751233', 'Irrazabal', '0975412366');
insert into person (DTYPE, name, surname, RUC, address, cellphone) values ('ClientDomain','Carolina','Ocampos','4963658', 'Artigas', '0985741478');
insert into person (DTYPE, name, surname, RUC, address, cellphone) values ('ClientDomain','Elena','Ocampos','4785963214', 'Artigas', '0985412477');

insert into person (DTYPE, name, surname, RUC, address, cellphone) values ('SupplierDomain','Axel','Morel','4785123', 'Villarrica', '0985741235');
insert into person (DTYPE, name, surname, RUC, address, cellphone) values ('SupplierDomain','Karina','Sanabria','123456', 'Centro', '0875412369');
insert into person (DTYPE, name, surname, RUC, address, cellphone) values ('SupplierDomain','Carlos','Dure','4789999', 'San Pedro', '0975414222');
insert into person (DTYPE, name, surname, RUC, address, cellphone) values ('SupplierDomain','Elizabeth','Sanabria','5369874', 'Carlos A. López','0985741233');
insert into person (DTYPE, name, surname, RUC, address, cellphone) values ('SupplierDomain','Lorena','Delpuerto','1234568', 'Centro', '0985012369');

insert into person (DTYPE, name, surname, RUC, address, cellphone) values ('EmployeeDomain','Albert','Einstein','123459', 'Centro', '0985102369');
insert into person (DTYPE, name, surname, RUC, address, cellphone) values ('EmployeeDomain','Sonia','Curie','1234560', 'Centro', '0994125786');
insert into person (DTYPE, name, surname, RUC, address, cellphone) values ('EmployeeDomain','Lara','López','4789523', 'Miranda', '0985412369');
insert into person (DTYPE, name, surname, RUC, address, cellphone) values ('EmployeeDomain','Marian','Benitez','4782302', 'Encarnación', '0995748444');
insert into person (DTYPE, name, surname, RUC, address, cellphone) values ('EmployeeDomain','Fabiola','Acosta','47851233', 'Yuty', '0985417223');




insert into items (DTYPE, name, price, quantity) values ('ServiceDomain', 'Cambio de Aceite','100000',0);
insert into items (DTYPE, name, price, quantity) values ('ServiceDomain', 'Cambio de Frenos','250000',0);
insert into items (DTYPE, name, price, quantity) values ('PartDomain', 'Caja Mecanica',	'500000',1);
insert into items (DTYPE, name, price, quantity) values ('ServiceDomain', 'Cambio de Motor','4000000',0);
insert into items (DTYPE, name, price, quantity) values ('PartDomain', 'Motor','2000000',4);

insert into role (authority) values ('ROLE_ADMIN');
insert into user (username, name, surName, password, account_expired, account_locked, password_expired) values ('mlored','lorena','del puerto', '123456', false, false, false);
insert into user_role (user_id, role_id) values ('1','1');