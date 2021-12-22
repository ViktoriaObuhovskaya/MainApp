CREATE TYPE varchar AS ENUM ('MALE','FEMALE');

CREATE TABLE Employee
(
    employee_id   integer     not null PRIMARY KEY,
    first_name    varchar(30) not null,
    last_name     varchar(50) not null,
    department_id integer     not null,
    job_title     varchar(50) not null,
    gender        varchar     not null,
    data_of_birth date        not null
);

insert into employee
values (1, 'Petr', 'Petrov', 3, 'Engineer', 'MALE', '1986-06-20'),
       (2, 'Sergei', 'Sergeev', 1, 'Web Designer', 'MALE', '1988-03-09'),
       (3, 'Svetlana', 'Ivanova', 2, 'Manager', 'FEMALE', '1983-04-07'),
       (4, 'Alexandra', 'Petrova', 2, 'Manager', 'FEMALE', '1985-01-26'),
       (5, 'Sergey', 'Ivanov', 3, 'Engineer', 'MALE', '1987-07-17')

