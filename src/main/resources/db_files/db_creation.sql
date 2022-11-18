drop table if exists patrons cascade;
drop table if exists organizers cascade;
drop table if exists events cascade;
drop table if exists attend cascade;
drop table if exists favorite_org cascade;
drop table if exists favorite_event cascade;
drop table if exists addresses cascade;
drop table if exists foods cascade;
drop table if exists have_food;

-- table for organizers
create table organizers (
    id serial primary key,
    username varchar(32) unique not null,
    name varchar(64) not null,
    phone varchar(10),
    password varchar(64) not null
);

-- table for organizers' addresses
--     cardinality 1:N (org:address)
create table addresses (
    id serial primary key,
    org_id bigint not null references organizers(id) on delete cascade,
    street_address varchar(64) not null,
    city varchar(64) not null,
    us_state char(2) not null,
    zip_code char(5) not null,
    country varchar(32) not null
);

-- table for events
create table events (
    id serial primary key,
    org_id bigint not null references organizers(id) on delete cascade,
    address_id bigint references addresses(id) on delete set null,
    name varchar(64) not null,
    event_time varchar(32) not null,
    price varchar(32)
);

-- table for types of foods
create table foods (
    id serial primary key,
    name varchar(32) not null
);

-- table for the occurence of food in an event
--     cardinality M:N 
create table have_food (
    food_id bigint references foods(id) on delete cascade,
    event_id bigint references events(id) on delete cascade,
    primary key(food_id, event_id)
);

-- table for patrons
create table patrons (
    id serial primary key,
    username varchar(32) unique not null,
    name varchar(64) not null,
    phone varchar(10),
    password varchar(64) not null
);

-- table for patrons' attendance to events
--     cardinality M:N 
create table attend (
    patron_id bigint references patrons(id) on delete cascade,
    event_id bigint references events(id) on delete cascade,
    primary key(patron_id, event_id)
);

-- table for patrons' favorite events
--     cardinality M:N 
create table favorite_event (
    patron_id bigint references patrons(id) on delete cascade,
    event_id bigint references events(id) on delete cascade,
    primary key(patron_id, event_id)
);

-- table for patrons' favorite organizers
--     cardinality M:N 
create table favorite_org (
    patron_id bigint references patrons(id) on delete cascade,
    org_id bigint references organizers(id) on delete cascade,
    primary key(patron_id, org_id)
);