#!/usr/bin/env bash

echo "Setting up Java 17"
export JAVA_HOME=$(/usr/libexec/java_home -v 17)
export PATH=$JAVA_HOME/bin:$PATH
java -version