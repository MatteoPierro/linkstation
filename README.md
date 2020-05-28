# Link station

## Description
Write a program that solves the most suitable (with most power) link station for a device at given
point [x,y].

Please make this project as complete as you think it should be to be maintainable in the long
term by more than one maintainer. Provide instructions how to run the solution or if applicable
how to access a deployed running version.

This problem can be solved in 2-dimensional space. Link stations have reach and power.

A link station’s power can be calculated: <br/>
**power = (reach - device's distance from linkstation)^2** <br/>
**if distance > reach, power = 0**

Program should output following line:
> “Best link station for point x,y is x,y with power z”

or:

> “No link station within reach for point x,y”

**Link stations**​ are located at points (x, y) and have reach (r) ([x, y, r]):
```
[[0, 0, 10],
[20, 20, 5],
[10, 0, 12]]
```

Print out function output from **points**​ (x, y):
(0,0), (100, 100), (15,10) and (18, 18).

## How to run the solution

### Requirements

- Docker

### Build

```bash
$ docker build -t linkstation .
```

### Run

```bash
$ docker run --rm linkstation
```

## Design notes

The design decisions of this solution are mainly inspired by:

- [Hexagonal Architecture](https://en.wikipedia.org/wiki/Hexagonal_architecture_(software))
- [Domain Primitives](https://freecontent.manning.com/domain-primitives-what-they-are-and-how-you-can-use-them-to-make-more-secure-software/)

## Limitations

### Persistence mechanism
Currently the devices and the linked stations are stored in memory (see `InMemoryDeviceRepository` and `InMemoryLinkStationRepository`.

It will be possible to plug a different persistence mechanism (e.g. Database, FileSystem, etc.) providing a different implementation of the repositories and injecting them in the services.

### Display mechanism

Currently the output is displayed in the system console.

It will be possible to plug a different display mechanism (e.g. file, html, etc.) providing a different implementation of the `Display` interface.