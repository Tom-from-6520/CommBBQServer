-- drop all table in the cbbq database
do $$ 
declare r record;
begin
    for r in (select tablename from pg_tables where schemaname='public') loop 
        execute 'drop table if exists ' ||quote_ident(r.tablename)|| ' cascade';
    end loop;
end $$;

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
    event_time timestamp not null,
    price varchar(32)
);

-- table for types of foods
--     cardinality M:N 
create table foods (
    id serial primary key,
    name varchar(32) not null
);

-- table for patrons
create table patrons (
    id serial primary key,
    username varchar(32) unique not null,
    name varchar(64) not null,
    phone varchar(10),
    password varchar(64) not null
);