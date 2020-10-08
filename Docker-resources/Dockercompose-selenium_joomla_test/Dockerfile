# Select base image
FROM maven:3.6.3-jdk-8
# Add metadata to an image
LABEL maintainer="jacek.p.zygiel@hsbc.com"
# RUN apt update
# RUN apt install -y maven
# Copy files to container
ADD resources/Java-Selenium/ root/Java-Selenium/

# Install maven dependencies
RUN cd root/Java-Selenium &&\
mvn install -DskipTests=true

# Define default command after container start
CMD ["/bin/bash", "/root/scripts/runTest.sh"]
