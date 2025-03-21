FROM maven:3.8.5-openjdk-11

# Install Node.js and Appium
RUN apt-get update && apt-get install -y nodejs npm
RUN npm install -g appium

WORKDIR /app
COPY . /app
RUN mvn clean install

# Expose Appium port
EXPOSE 4723

# Start Appium and run tests
CMD ["sh", "-c", "appium & sleep 5 && mvn test"]