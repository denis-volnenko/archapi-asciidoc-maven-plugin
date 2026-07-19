#!/bin/bash

mvn clean install

mvn archapi-asciidoc:generate -f pom.xml