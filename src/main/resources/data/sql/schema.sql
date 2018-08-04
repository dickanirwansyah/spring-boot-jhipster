create table departement(
   id int not null auto_increment,
   name varchar(255) not null unique,
   description varchar(255) not null,

   constraint pk_departement_id primary key (id)
);

create table employee(
    id int not null auto_increment,
    name varchar(255) not null,
    salary int not null,
    departement_id int not null,

    constraint pk_employee_id primary key(id),
    constraint fk_emoloyee_departement_id foreign key (departement_id)
    references departement(id)
);