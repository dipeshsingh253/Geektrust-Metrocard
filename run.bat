@echo off

# .bat files are used to automate task in windows like operation systems.

mvn clean install -DskipTests assembly:single -q
java -jar target\geektrust.jar sample_input\input1.txt
