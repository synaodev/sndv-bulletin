# Tyler Cadena's Revature Bulletin Project

## Running Locally
* Initialize mysql instance using one of two ways:
  * Open the command line and run `docker-compose up -d`.
  * Open the command line and run `docker container run -dit --rm --name dbsrv -p 3306:3306 -e 'MYSQL_ROOT_PASSWORD=synaodev' -e 'MYSQL_USER=spring' -e 'MYSQL_PASSWORD=password' -e 'MYSQL_DATABASE=bulletin' mysql:latest`
* Wait for a few minutes for the database to initialize.
* In the command line, start the application:
  * If you're using a unix-like OS or are using Git Bash on Windows, run `./mvnw spring-boot:run`.
  * If you're using cmd.exe on Windows, run `<full-path>\mvnw.cmd spring-boot:run`.
* The application listens on port 8000, so open your browser to localhost:8000.
