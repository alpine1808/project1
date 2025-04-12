# Dùng OpenJDK 17 (Render hỗ trợ tốt)
FROM openjdk:17

# Cài đặt Maven (nếu cần)
RUN apt-get update && apt-get install -y maven

# Sao chép mã nguồn vào container
COPY . /app

# Đặt thư mục làm việc
WORKDIR /app

# Build ứng dụng (mvn clean package sẽ tạo ra file JAR trong thư mục target)
RUN mvn clean package -DskipTests

# Sao chép file JAR vào container
COPY target/your-app-name.jar app.jar

# Lệnh chạy ứng dụng Spring Boot
ENTRYPOINT ["java", "-jar", "/app.jar"]
