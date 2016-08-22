-- Kullanicilar
insert into User(id, userName, password, name, surname, userType) values(1, 'admin', 'admin', 'John', 'Doe', 'A');
insert into User(id, userName, password, name, surname, userType) values(2, 'admin2', 'admin2', 'Jane', 'Doe', 'A');
insert into User(id, userName, password, name, surname, userType) values(3, 'user', 'user', 'Kay', 'Doe', 'M');
insert into User(id, userName, password, name, surname, userType) values(4, 'user2', 'user2', 'Sam', 'Doe', 'M');
insert into User(id, userName, password, name, surname, userType) values(5, 'user3', 'user3', 'Sam', 'Doe', 'M');
insert into User(id, userName, password, name, surname, userType) values(6, 'user4', 'user4', 'Sam', 'Doe', 'M');

-- Kahve cesitleri
insert into Beverage(id, status, cuserid, cdate, name, cost) values(1, 'A', 1, CURRENT_DATE, 'Filtre Kahve', 4);
insert into Beverage(id, status, cuserid, cdate, name, cost) values(2, 'A', 1, CURRENT_DATE, 'Latte', 5);
insert into Beverage(id, status, cuserid, cdate, name, cost) values(3, 'A', 1, CURRENT_DATE, 'Mocha', 6);
insert into Beverage(id, status, cuserid, cdate, name, cost) values(4, 'A', 1, CURRENT_DATE, 'Çay', 3);
insert into Beverage(id, status, cuserid, cdate, name, cost) values(5, 'A', 1, CURRENT_DATE, 'Türk Kahvesi', 5);

insert into Condiment(id, status, cuserid, cdate, name, cost) values(1, 'A', 1, CURRENT_DATE, 'Süt', 2);
insert into Condiment(id, status, cuserid, cdate, name, cost) values(2, 'A', 1, CURRENT_DATE, 'Fındık şurubu', 3);
insert into Condiment(id, status, cuserid, cdate, name, cost) values(3, 'A', 1, CURRENT_DATE, 'Çikolata Sosu', 5);
insert into Condiment(id, status, cuserid, cdate, name, cost) values(4, 'A', 1, CURRENT_DATE, 'Limon', 2);



