# Pull base image
FROM java:8
# Add metadata to an image
LABEL maintainer="jacek.p.zygiel@hsbc.com"

# Copy file to container
ADD Hello.java root/Hello.java

# Execute bash command
RUN cd root && javac Hello.java

# Set working directory
WORKDIR root

# Define default command after container start
CMD ["java", "-cp", ".", "Hello"]