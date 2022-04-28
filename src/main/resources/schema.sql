create table Cars (
    brand varchar(50) not null,
    type varchar(50) not null,
    primary key (brand, type)
);

create table Registrations (
    id integer auto_increment not null,
    ssn char(11) not null,
    name varchar(50),
    address varchar(50),
    characteristics varchar(50),
    brand varchar(50),
    type varchar(50),
    primary key (id),
    foreign key (brand, type) references Cars(brand, type)
);

create table User (
    id integer auto_increment not null,
    brukernavn varchar(50) not null,
    passord varchar(50) not null,
    admin smallint not null,
    primary key (id)
);
