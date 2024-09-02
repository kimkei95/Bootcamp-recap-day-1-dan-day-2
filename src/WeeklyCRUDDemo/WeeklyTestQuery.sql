--===================================--

--CREATE TABLE AND INSERTING DATA--
CREATE TABLE Categories(id serial primary key,
category_name varchar(40), description varchar(60));

insert into Categories(category_name, description)
values
('makanan siap saji', 'bisa langsung dimakan'),
('makanan mentah', 'harap dimasak terlebih dahulu'),
('frozen food', 'dimasak setengah matang'),
('perkakas', 'alat tukang rumah'),
('alat mandi', 'untuk dikamar mandi');

select*from categories;

--=====================================--
CREATE TABLE Products (id serial primary key,
Product_name varchar(50),
description varchar(70),
price varchar(20),
stock int not null,
category_id int not null,
foreign key (category_id) references Categories(id));


insert into Products(Product_name,
Description, price, stock, category_id) values
('ayam boiler', 'ayam segar', '56000',15,2),
('sushi', 'sushi segar isi 3', '18000',30,1),
('bakso urat', 'harap masukkan ke kulkas', '25000',50,3),
('gergaji mesin', 'alat untuk memotong kayu', '1250000',35,4),
('kunci inggris', 'alat untuk muter sekrup', '50000',45,4),
('kunci L', 'alat untuk buka kunci', '100000',50,4),
('deodoran', 'supaya tidak bau badan', '32000',40,5),
('sabun cair', 'sabun manusia', '18000',50,5),
('sampo rambut', 'sampo untuk keramas', '35000',60,5);


select*from Products;
--==============================================--
create table Customers (id serial primary key,
first_name varchar(255) not null,
last_name varchar (255) not null,
address varchar(60) not null,
no_hp varchar(12) not null,
email varchar (255) unique not null);

insert into Customers (first_name, last_name, address, no_hp, email)
values
('budi','budiman','jonggol','346039940491 ','budi@smtown.co.kr'),
('andi', 'adinata', 'dunia virtual', '497613618622','andiadi@vr.vi'),
('kim', 'jong-un', 'korea utara', '972690406144','jongunch@korut.nk'),
('aldi', 'yanto', 'jakarta', '661971326848', 'aldyan@mailg.oc.di'),
('mul', 'yono', 'ikn', '428084008844', 'mul@maily.com');

select*from Customers;


--=============================================--
create table orders (id serial primary key,
order_date date not null,
customer_id int not null,
foreign key (customer_id) references Customers(id)
);

insert into orders (order_date, customer_id)
values
('2024-09-01', 3),
('2024-08-30',4),
('2024-08-19',3),
('2024-08-20',2),
('2024-08-29',2),
('2024-07-21',1),
('2024-07-21',1),
('2024-09-01',4),
('2024-09-01',5),
('2024-06-15',5);

select*from orders;
--===============================================--
create table order_item (order_id int not null,
product_id int not null,
quantity int not null,
status varchar(20),
foreign key (order_id) references orders(id),
foreign key (product_id) references Products(id));

insert into order_item (order_id, product_id, quantity, status)
values
(1,1,3,'delivered'),
(2,2,8,'delivered'),
(3,3,7, 'pending'),
(4,3,6, 'with courier'),
(5,4,5, 'pending'),
(6,7,10, 'with courier'),
(7,9,8, 'searching courier'),
(8,6,6, 'searching courier'),
(9,5,6, 'pending'),
(10,8,6, 'delivered');

select*from order_item;
--===============================--
create table reviews (id serial primary key,
product_id int not null,
customer_id int not null,
rating int not null,
review varchar(50),
foreign key (product_id) references Products(id),
foreign key (customer_id) references customers(id));

insert into reviews(product_id,customer_id,rating,review)
values
(1,3,3,'packing jelek tapi aman'),
(2,1,4,'ya oke lah'),
(3,2,1, 'sudah expired pas tiba'),
(4,4,5, 'aman bosque'),
(5,5,1, 'kuncinya ga dari inggris'),
(6,1,5, 'mantab'),
(7,4,1, 'rollnya ga ada'),
(8,2,2, 'sabunnya bocor'),
(9,4,5, 'uwooogh wangy wangy');

--===================================================--

create table payment (id serial primary key,
method_payment varchar(50),
order_id int not null,
foreign key (order_id) references orders(id));

insert into payment (method_payment, order_id)
values
('gobank',1),
('debit',2),
('paylater',3),
('COD',4),
('COD',5),
('paylater',6),
('debit',7),
('gobank',8),
('paylater',9),
('debit',10);
--===================================================---

--JOIN QUERIES--
select*from products
inner join categories on products.category_id = categories.id;

select first_name,last_name, address from orders
inner join customers on orders.customer_id = orders.id;

select*from order_item
inner join products on order_item.order_id = products.id;

select order_item.order_id, order_item.product_id, products.product_name, order_item.quantity, status from order_item
inner join orders on order_item.order_id = orders.id
inner join products on products.id = order_item.product_id;

select customer_id, first_name, rating,product_name, review
from reviews
inner join customers on customers.id = reviews.customer_id
inner join products on reviews.product_id = products.id;

--================================--
-- CREATE VIEW--
CREATE VIEW Product_details as select product_name, category_id,
category_name
from products
inner join categories on products.category_id = categories.id;
select* from product_details;

CREATE VIEW Customer_order as select first_name, last_name, order_id, product_name, status
from order_item
inner join orders on orders.id = order_item.order_id
inner join customers on orders.customer_id = customers.id
inner join products on order_item.product_id = products.id;
select*from Customer_order;

CREATE VIEW Rating_From_Users as select first_name, last_name,
rating, product_name, review

from reviews
inner join customers on customers.id = reviews.customer_id
inner join products on products.id = reviews.product_id;

select*from Rating_From_Users;


CREATE VIEW order_item_details as
select order_item.order_id, order_item.product_id, products.product_name, order_item.quantity, status from order_item
inner join orders on order_item.order_id = orders.id
inner join products on products.id = order_item.product_id;

select *from order_item_details;