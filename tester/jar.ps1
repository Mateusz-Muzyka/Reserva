cd reserve
./mvnw clean package
cd ..
docker-compose build
docker-compose up -d