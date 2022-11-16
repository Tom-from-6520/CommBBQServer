drop table if exists patrons cascade;
drop table if exists organizers cascade;
drop table if exists events cascade;
drop table if exists attend cascade;
drop table if exists favoriteOrg cascade;
drop table if exists favoriteEvent cascade;

-- create table users (
--     id serial primary key,
--     username varchar(50) unique not null,
--     password varchar(64) not null
-- );

-- create table roles (
--     id serial primary key,
--     name varchar(50) not null
-- );

-- create table users_roles (
--     user_id bigint,
--     role_id bigint,
--     constraint fk_user
--         foreign key(user_id)
--         references users(id)
--         on delete cascade,
--     constraint fk_role
--         foreign key(role_id)
--         references roles(id)
--         on delete set null
-- );