#!/bin/bash

git pull
git pull git@github.com:denis-volnenko/asyncapi-asciidoc-maven-plugin.git

git add .
git commit -m "Examples updated."

git push

git push git@github.com:denis-volnenko/asyncapi-asciidoc-maven-plugin.git
