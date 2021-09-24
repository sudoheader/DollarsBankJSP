-- drop database if exists dollarsbank_db;

create database dollarsbank_db;

use dollarsbank_db;

create table transaction_history(userid varchar(255), history varchar(255));

create table transactions(userid varchar(255), history varchar(255));

create table account(name varchar(255), address varchar(255), contact varchar(255), user_id varchar(255), password varchar(255), balance double);