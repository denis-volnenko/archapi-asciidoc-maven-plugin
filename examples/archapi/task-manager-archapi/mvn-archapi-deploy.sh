#!/bin/bash

mvn clean install

mvn archapi-asciidoc:deploy -f pom.xml