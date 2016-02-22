drop database if exists loginTest;
create database loginTest;
use loginTest;
create table user(
id int primary key not null,
password varchar(100) not null);
insert into user(
id,password)
values(
1234,1234);

