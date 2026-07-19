#!/bin/bash

mvn clean install

mvn archapi-asciidoc:dependency -f pom.xml