#!/bin/bash

cd Proyecto

mvn install -DskipTests

cd ..

docker build -t "app:local" --no-cache Proyecto
