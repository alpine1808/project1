# Sử dụng OpenJDK 17 làm base image
FROM openjdk:17

# Cài đặt Maven (nếu chưa có sẵn trong base image)
RUN apt-get update && apt-get install -y maven

# Sao chép toàn bộ mã nguồn vào thư mục làm việc /app trong container
COPY . /app

# Chuyển đến thư mục làm việc /app
WORKDIR /app

# Chạy lệnh build Maven để tạo file JAR
RUN mvn clean package -DskipTests

# Kiểm tra thư mục target đã có file JAR chưa
RUN ls -al target

# Sao chép file JAR từ thư mục target vào container
COPY target/your-app-name.jar app.jar

# Lệnh để chạy ứng dụng Spring Boot
ENTRYPOINT ["java", "-jar", "/app.jar"]
