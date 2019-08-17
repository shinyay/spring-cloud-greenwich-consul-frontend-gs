# Name

Overview

## Description

## Demo

## Features

- feature:1
- feature:2

## Requirement

## Usage

### Run Consul Container at Local

```
$ docker run --rm -it -d --name my-consul -p 8500:8500 consul:1.5.3
```
or
```
$ script/run-consul.fish
```

### Open Consul Dashboard

```
$ open http://localhost:8500
```

### Create Config in Consul

**config/application-name/key-name**

- `Key/Value -> Create`
- `config/frontend-service/server.port`
  - backend-service: Application Name
  - server.port: Config Key


## Installation

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)