# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table messages (
  message_id                    integer not null,
  sender_id                     varchar(255) not null,
  reciever_id                   varchar(255) not null,
  message_content               varchar(255) not null,
  recieved_on                   varchar(255) not null,
  constraint pk_messages primary key (message_id)
);
create sequence APPLICATION_SEQ;

create table users (
  user_id                       bigint not null,
  user_firstname                varchar(255) not null,
  user_lastname                 varchar(255) not null,
  user_email                    varchar(255) not null,
  user_password                 varchar(255) not null,
  constraint pk_users primary key (user_id)
);
create sequence USERS_seq;


# --- !Downs

drop table if exists messages;
drop sequence if exists APPLICATION_SEQ;

drop table if exists users;
drop sequence if exists USERS_seq;

