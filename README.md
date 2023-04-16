# Simple JPA

This is a simple JPA example using Spring Boot.

Works out of the box with h2

Visit the h2 console at http://localhost:8080/h2-console

```
url      : jdbc:h2:mem:mydb
username : sa
password : password
```

You can launch the application with the `postgres` profile

``
docker run --name simplejpa-postgres -e POSTGRES_USER=simplejpa -e POSTGRES_PASSWORD=simplejpa -e POSTGRES_DB=simplejpa -p 5432:5432 -d postgres
```

If you want to reset your database, you can use the following command

```
docker stop onlinestore-postgres ; docker rm -f onlinestore-postgres
```