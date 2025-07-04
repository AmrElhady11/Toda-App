create database if not exists Authentication_DB;
use Authentication_DB;
create table user(
                     id int auto_increment primary key ,
                     first_name varchar(55),
                     last_name varchar(55),
                     role varchar(20),
                     email varchar(55) not null unique ,
                     password varchar(255) not null ,
                     enabled boolean
);
create table otp(
                    id int auto_increment primary key ,
                    OTP varchar(20),
                    expiration_time datetime ,
                    user_id int ,
                    foreign key (user_id) references user(id)
);
CREATE TABLE token (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       token VARCHAR(255) NOT NULL,
                       token_type VARCHAR(255),
                       expired BOOLEAN NOT NULL,
                       revoked BOOLEAN NOT NULL,
                       user_id INT,
                       CONSTRAINT fk_user
                           FOREIGN KEY (user_id)
                               REFERENCES user(id)

);