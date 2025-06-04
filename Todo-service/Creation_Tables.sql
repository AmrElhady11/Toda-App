create database if not exists TodaApp_DB;
use TodaApp_DB;
create table item(
                     id int auto_increment primary key ,
                     title  varchar(100) not null ,
                     user_id  int not null ,
                     item_details_id  int ,
                     foreign key (item_details_id) references item_details(id)
);
create table item_details(
                             id int auto_increment primary key ,
                             description  text not null ,
                             created_at timestamp not null ,
                             priority  varchar(55) ,
                             status varchar(100)

);
