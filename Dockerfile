# Sử dụng base image Maven đã bao gồm OpenJDK 17 và Maven
FROM maven:3.8.6-openjdk-17

# Sao chép toàn bộ mã nguồn vào thư mục làm việc /app trong container
COPY . /app

# Chuyển đến thư mục làm việc /app
WORKDIR /app

# Chạy lệnh build Maven để tạo file JAR
RUN mvn clean package -DskipTests

# Kiểm tra thư mục target đã có file JAR chưa
RUN ls -al target

# Sao chép file JAR từ thư mục target vào container
COPY target/spring-security-form-login-0.0.1-SNAPSHOT.jar app.jar

# Lệnh để chạy ứng dụng Spring Boot
ENTRYPOINT ["java", "-jar", "/app.jar"]
