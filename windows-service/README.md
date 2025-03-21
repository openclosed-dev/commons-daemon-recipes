# windows-service

A code sample demonstrating how to launch a Spring Boot application as a Windows Service.

## Prerequisites

* [OpenJDK 21](https://adoptium.net/temurin/archive/?version=21)
* [Apache Maven](https://maven.apache.org/download.cgi) 3.9.x
* [Apache Commons Daemon](https://downloads.apache.org/commons/daemon/binaries/windows/commons-daemon-1.4.1-bin-windows.zip) 1.4.x

Download and unpack the distribution binary `commons-daemon-1.4.1-bin-windows.zip`.
Extract a file named `prunsrv.exe` from `amd64` and copy it into this directory before your build.

## How to build

```
mvn package
```

A file for distribution will be outputted at `target/example-service.zip`.
