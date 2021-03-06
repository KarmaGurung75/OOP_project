create database billing_system;
use billing_system;

create table tbl_buyer(
      name varchar(50) not null,
      username varchar(50) not null,
      password varchar(50) not null,
      contact_no int not null,
      email varchar(50) not null,
      address varchar(50) not null,
      constraint pk_buyer primary key (contact_no) 
);
select * from tbl_buyer;
#insert into tbl_buyer (name,username,passwordcontact_no,email,address)
#values('karma',980,'karam1661','kathmandu');
#insert into tbl_buyer values('pooja', 978, 'pooja134', 'manumaiju');
#insert into tbl_buyer values('sudikshya',684, 'sudik_koju','bhaktapur'); 
#insert into tbl_buyer values('prasesh', 946, 'prasesh675','baktapur');

drop table tbl_buyer;

create table tbl_product(
    product_id int unique,
    product_name varchar(50) not null,
    rate int not null,
    quantity int not null,
    description varchar(50) not null
);
select * from tbl_product;
insert into tbl_product values(1,'Erik','1500', '1','T-Shirt');
insert into tbl_product values(2, 'Erik','2000', 1,'sport shoe');
insert into tbl_product values(3, 'Nike', 4000, 1, 'shoe');
insert into tbl_product values(4,'addias',6000, 1, 'hoodie');
insert into tbl_product values(5, 'apple', 8000, 1,'ear phone');


create table final_data(
        customer_name varchar(50) not null,
        contact_no int not null,
        product_name varchar(50) not null,
        product_id int not null,
        total int not null,
        paid_amount int not null,
        return_amount int not null
);

select * from final_data;
drop table final_data;
