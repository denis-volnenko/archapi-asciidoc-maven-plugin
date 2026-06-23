#!/bin/bash

git pull

git add .
git commit -m "Обновление `basename "$PWD"`."

git push
