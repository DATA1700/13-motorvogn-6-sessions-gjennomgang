# Ukeoppgaver: SQL 1

Oppgave 1

Bytt ut de to arrayene med to tabeller i en relasjonsdatabase. Flytt initieringen av bil-tabellen til en data.sql fil (fra konstruktøren i controlleren).

Oppgave 2

Gjør om på GUI (og server) slik at det er mulig å slette en og en motorvogn via knapp i tabellen

Nye dependencies:

```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>
```

Husk å reloade maven etter at dere har lagt inn disse sammen med andre `<dependency>` tags inne i `<dependencies>` taggen i [`pom.xml`](pom.xml) filen

Kan hende at `jdbc` ikke treings, men bare `h2` og `jpa`