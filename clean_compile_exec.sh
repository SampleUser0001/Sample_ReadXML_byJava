#!/bin/bash

export $(cat .env | grep -v ^# | xargs)
cd ${PROJECT_NAME}

FILE_DIR=${PWD}/src/main/resources

MVN_COMMAND="clean compile exec:java -Dexec.mainClass=\"sample.read.xml.App\" -Dexec.args=\"'${FILE_DIR}/input.xml' '${FILE_DIR}/output.xml' '${FILE_DIR}/attribute.lst' \" "

echo ${MVN_COMMAND}

mvn ${MVN_COMMAND}

# mvn clean compile exec:java -Dexec.mainClass="sample.read.xml.App" -Dexec.args="'./src/main/resources/input.xml' './src/main/resources/output.xml' './src/main/resources/attribute.lst' "
