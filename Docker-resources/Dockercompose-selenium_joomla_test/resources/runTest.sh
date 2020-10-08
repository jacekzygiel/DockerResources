#!/usr/bin/env bash

echo "Go to Java project folder"
cd root/scripts/Java-Selenium
echo "Execute maven tests"
mvn clean test
echo "Generate report"
mvn site
echo "Copy report"
cp -Rf target/site /root/reports/$(date +%Y%m%d%H%M%S)
