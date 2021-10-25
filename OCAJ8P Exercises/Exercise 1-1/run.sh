#!/bin/sh

arg1=$1

if [ -z "$1" ]; then
        echo "Missing arguments, exiting.."
        echo "Usage : $0 arg1 arg2"
        exit 1
fi

java /out/ro/ionescu/radu/food/Fruit 
