#!/bin/sh
javac -d ./out ./src/ro/ionescu/radu/food/Fruit.java ./src/ro/ionescu/radu/Apple.java
java -cp out ro/ionescu/radu/Apple
