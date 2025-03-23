create database school_management;

create table students(
                         student_id serial primary key ,
                         student_name varchar(50) not null ,
                         email varchar(100) unique ,
                         phone_number varchar(15)
);

create table instructors(
                            instructor_id serial primary key ,
                            instructor_name varchar(50) not null ,
                            email varchar(100) unique
);

drop table students, instructors;

create table courses(
                        course_id serial primary key ,
                        course_name varchar(100) not null ,
                        description varchar(255),
                        instructor_id integer not null
                            constraint fk_instructor
                                references instructors
                                ON UPDATE CASCADE
                                ON DELETE CASCADE );

drop table courses;

create table student_course(
                               id serial primary key ,
                               student_id integer not null ,
                               course_id integer not null ,
                               constraint student_id_course_id_fk foreign key (student_id)
                                   references students(student_id),
                               constraint course_id foreign key (course_id) references courses(course_id)
);

insert into instructors values (default, 'Vorn Tavann', 'tavann@gmail.com');

delete from instructors where instructor_id=11;

select * from students where student_id=1;

update instructors set instructor_name = 'Leng HongMeng', email = 'hongmeng002@gmail.com' where instructor_id = 13;

select * from students
                  inner join student_course sc
                             on students.student_id = sc.student_id
where student_id = 1;

insert into students values (default, 'JoJoBa', 'jojoba@gmail.com') returning *;
insert into courses values (default, 'Dance', 'Learn Dance', 2) returning *;

delete from courses where course_id = 6;

update courses set course_name = 'CSS', description = 'Learn CSS', instructor_id = 1 where course_id = 12 returning *;
select * from courses where course_id = 4;

select * from student_course where student_id = 1;

select *
from student_course sc
         inner join courses c on c.course_id = sc.course_id
where student_id = 1;

delete from students where student_id = 28 returning *;

-- create table student_course(
--     id serial primary key ,
--     student_id integer ,
--     course_id integer ,
--     foreign key (student_id) references students(student_id) on delete cascade ,
--     foreign key (course_id) references courses(course_id) on delete cascade
-- )

