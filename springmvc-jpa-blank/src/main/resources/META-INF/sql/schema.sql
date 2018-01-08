create table t_person (
person_id integer(20) auto_increment,
age integer not null check (age>=1 AND age<=200), 
person_name varchar(30) not null, 
primary key (person_id)
);

CREATE TABLE jc_city(
city_id integer(20) auto_increment,
city_name varchar(200),
region_id integer(20),
primary key(city_id)
); 

CREATE TABLE jc_region(
region_id integer(20) auto_increment,
region_name varchar(200),
primary key(region_id)
);