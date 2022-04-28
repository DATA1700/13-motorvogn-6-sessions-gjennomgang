insert into Cars(brand, type)
values  ('Volvo','V30'),
        ('Volvo','V70'),
        ('Volvo','V91'),
        ('Audi','A8'),
        ('Audi','Q7'),
        ('Audi','Q8'),
        ('Toyota','Trueno'),
        ('Toyota','Corolla'),
        ('Toyota','Levin');

-- demo to debug button
insert into Registrations(ssn, name, address, characteristics, brand, type)
values   ('12345678901', 'Ulrik', 'OsloMet', 'AB12345', 'Toyota', 'Corolla'),
         ('09876543210', 'Ulrik', 'OsloMet', 'AB12345', 'Toyota', 'Corolla');

insert into User ( brukernavn, passord, admin)
values ('admin', 'admin', 1),
    ('user', 'user', 0);
