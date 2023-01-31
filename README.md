# miroservices
two micro services(employee-service, leave-service) which are using
postgresq database,
spring boot,
webflux framework,
maven,
registered with eureka server and can be accessed using spring cloud gateway
images will be created using respective docker files
#employee-service
employee-service is used for CRUD operations of employee
#leave-service
leave service is used for CRUD operations of leave and An api to return the number of leaves
for each employee that returns an array as the following:
Employee Id.
Employee Name.
Current submitted leaves.
docker composer will be used to run and manage services 
create database "employee_db" and schema as "employees_db"
two tables are there employee(id,name,email,phone,address) and leave(id,employee_id,leave_type,status,reason)
employee_id will be foreign key in leave table.
