## Signfluent

***
Application developed by Angel, Dorcia, Gheorge and David as a final project at VIA University College.

### Start Application

- Run `start.bat` on the Windows machine
- Run `start.sh` on Linux or Mac

### Stop Application

- Run `stop.bat` on the Windows
- Run `stop.sh` on Linux or Mac

### Service Startup

By default, all the services will be started by executing above-mentioned script. To avoid starting a specific service,
open `docker-compose.yml` and comment out the service which is not required to be started.

### Swagger

Swagger was used in order to reduce effort to manually maintain the endpoints and models of the consuming services.

#### Swagger API Documentation

Is used for generating the client. Make sure that every Controller has `@RestController` annotation and
`@RequestMapping("/dk.signfluent.service.document.api/<name-of-controller>")`. Swagger is configured to detect endpoints starting with `/dk.signfluent.service.document.api`.
