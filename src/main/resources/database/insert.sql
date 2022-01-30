insert into size(size) values ('S');
insert into size(size) values ('M');
insert into size(size) values ('L');

insert into category(category) values ('Футболка');
insert into category(category) values ('Рубашка');
insert into category(category) values ('Джинсы');

insert into brand(brand) values ('Levis');
insert into brand(brand) values ('Tommy Hilfiger');
insert into brand(brand) values ('Ralph Lauren');
insert into brand(brand) values ('Allsaints');
insert into brand(brand) values ('Saint Lauren');
insert into brand(brand) values ('Pendelton');

insert into things(brand_id, category_id, size_id, description, price) values (1, 1, 1, 'Футболка S', 3000);
insert into things(brand_id, category_id, size_id, description, price) values (1, 1, 2, 'Футболка M', 3000);
insert into things(brand_id, category_id, size_id, description, price) values (1, 1, 3, 'Футболка L', 3000);

insert into things(brand_id, category_id, size_id, description, price) values (2, 2, 1, 'Рубашка S', 5000);
insert into things(brand_id, category_id, size_id, description, price) values (2, 2, 2, 'Рубашка M', 5000);
insert into things(brand_id, category_id, size_id, description, price) values (2, 2, 3, 'Рубашка L', 5000);

insert into things(brand_id, category_id, size_id, description, price) values (3, 3, 1, 'Джинсы S', 10000);
insert into things(brand_id, category_id, size_id, description, price) values (3, 3, 2, 'Джинсы M', 10000);
insert into things(brand_id, category_id, size_id, description, price) values (3, 3, 3, 'Джинсы L', 10000);

insert into things(brand_id, category_id, size_id, description, price) values (4, 1, 1, 'Футболка S', 5000);
insert into things(brand_id, category_id, size_id, description, price) values (4, 1, 2, 'Футболка M', 5000);
insert into things(brand_id, category_id, size_id, description, price) values (4, 1, 3, 'Футболка L', 5000);

insert into things(brand_id, category_id, size_id, description, price) values (5, 2, 1, 'Рубашка S', 20000);
insert into things(brand_id, category_id, size_id, description, price) values (5, 2, 2, 'Рубашка M', 20000);
insert into things(brand_id, category_id, size_id, description, price) values (5, 2, 3, 'Рубашка L', 20000);

insert into things(brand_id, category_id, size_id, description, price) values (6, 3, 1, 'Джинсы S', 15000);
insert into things(brand_id, category_id, size_id, description, price) values (6, 3, 2, 'Джинсы M', 15000);
insert into things(brand_id, category_id, size_id, description, price) values (6, 3, 3, 'Джинсы L', 15000);