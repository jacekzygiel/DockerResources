# Select base image
FROM java
# Add metadata to an image
LABEL maintainer="jacek.p.zygiel@hsbc.com"

# Use HSBC proxy to allow install debian packages
ENV http_proxy "http://docker.for.mac.host.internal:3128/"
RUN apt update
RUN apt install -y maven

#Set workdir
WORKDIR root

# Hsbc authentication files
ADD resources/settings.xml .m2/settings.xml
ADD resources/settings-security.xml .m2/settings-security.xml
ADD resources/nexus-certificate.jks nexus-certificate.jks
ADD resources/nexus-certificate nexus-certificate

# Set environment variables
ENV HOME=/root
ENV MAVEN_OPTS="-Xmx512m -Djavax.net.ssl.trustStore=$HOME/nexus-certificate.jks -Djavax.net.ssl.trustStorePassword=changeit"