#!/bin/bash

set -e

echo "==== 1) Levantando Docker Compose ===="
docker compose up -d

echo "==== 2) Construyendo JAR con Maven Wrapper ===="
cd fibonacci

# Ejecuta Maven wrapper incluso si mvn no está instalado
./mvnw clean package

echo "==== 3) Ejecutando aplicación ===="
JAR_FILE=$(ls target/*.jar | head -n 1)

if [ ! -f "$JAR_FILE" ]; then
  echo "ERROR: No se encontró ningún JAR en target/"
  exit 1
fi

echo "Ejecutando: java -jar $JAR_FILE"
java -jar "$JAR_FILE"

