# SpringBootPractices

For Docker container

docker create --name postgres-demo -e POSTGRES_PASSWORD=Welcome -p 5432:5432 postgres:11.5-alpine
docker container ls
docker start postgres-demo
docker container exec -it postgres-demo /bin/bash


#Add to the docker machine the create and insert scripts in /home
psql postgres postgres
create database conference_app;
\i /home/create_tables.sql
\i /home/insert_data.sql

