# SQL notes

## Pull mysql image
```bash
docker pull mysql:latest
```

## Set up SQL Server
```bash
docker run -d --name test-mysql -e MYSQL_ROOT_PASSWORD=root -p 3307:3306 mysql
# -p 3307:3306: Maps the container's port 3306 (the default port for MySQL) to your local port 3307. This means any traffic sent to your local port 3307 will be forwarded to the container's port 3306 and your MySQL server will be accessible on that port.

docker ps -a
# Find container_id and use it for next command.
docker exec -it container_id bash
mysql -u root -p
# Need to enter password here (strong_password)
CREATE DATABASE employees;
```

## Run node script to check connection from local
```bash
npm install mysql2
```
```js
node check_sql.js
```
