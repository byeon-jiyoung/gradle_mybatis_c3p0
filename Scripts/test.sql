select user(), database();

select * from department;
select title_code, title_name from title;
select * from employee;

select eno, ename, salary, dept_code, dept_name, floor, gender, joindate, title_code, title_name from employee e join department d on e.dno = d.dept_code join title t on e.title = t.title_code;