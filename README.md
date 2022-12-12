# Community BBQ Server

## Introduction
This project serves as the back-end to the Community BBQ mobile application. 

## Tech specs
* Server framework: Spring Boot
* Database: PostgreSQL

## Setup

### Prerequisite
#### Back-end Server
- Linux Ubuntu. Fully updated 
- Java 19. Guide to install is here https://docs.aws.amazon.com/corretto/latest/corretto-19-ug/generic-linux-install.html
- Maven 3.6 or above (try `sudo apt-get install maven`)
- PostgreSQL 12. Guide to install is here https://www.postgresql.org/download/linux/debian/

#### PostgreSQL Server

PostgreSQL should have version 12.

### Create a database for the back-end server.

To create the database for the server follow these steps.

1. On your Ubuntu machine, use `psql` to connect to your PostgreSQL server. The bash lines to do that is generally below:
```
$ sudo -i -u postgres
$ psql --host=<DB instance endpoint> --port=<port> --username=<master username> --password --dbname=<database name>
```
where `<DB instance endpoint>`, `<port>`, `<master username>`, and `<database name>` is specified for one's own PostgreSQL servers.

2. Run the `db_creation.sql` file in the `[root]/cbbq/src/main/resources/db_files` to create the tables for the database. Note: this will drop all previous tables.

3. (Optional) Run the `db_add_test_data.sql` file in the same folder as above to populate the tables with test data. 

### Install all dependencies and run the server

To install all dependecies of the project and run the server, enter the following bash line:
```
$ cd ../[install_folder]
$ sudo mvn clean spring-boot:run
```
The server will start at port 80.

### Note for AWS instances

Remember to set up the security group to open for HTTP and/or HTTPS at port 80 as well as a port for SSH connection to the developers' machine(s). 

### Test file

The project also contain a Postman set of test cases in the `[root]/cbbq/src/test/java/com/example/cbbq/postman_tests`.

## Future work
There are some important TODOs to this project:
- [ ] Add authetications for both patrons and organizers
- [ ] Connect with the front-end of the project