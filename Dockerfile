# Utiliza una imagen base que incluye Java (por ejemplo, OpenJDK)
FROM openjdk:20

WORKDIR /home

COPY out/artifacts/goros_jar/goros.jar /home/goros.jar

EXPOSE 8080

ENV AWS_ACCESS_KEY_ID=test
ENV AWS_SECRET_ACCESS_KEY=test
ENV AWS_DEFAULT_REGION=us-west-2
ENV AWS_ENDPOINT=http://localstack:4566

ENV SQS_QUEUE_NAME=goros-queue
ENV S3_BUCKET_NAME=goros-bucket
ENV DYNAMODB_TABLE_NAME=goros-table
ENV SERVER_PORT=8080
ENV ERP_URL=http://localhost:8080
ENV TOKENIZER_SERVICE_URL=http://tokenizer-service:10000
ENV METRICS_DASHBOARD_URL=http://metrics-dashboard:20000

ENV LOCALSTACK_HOSTNAME=localstack
ENV EDGE_PORT=4566

CMD ["java", "-jar", "/home/goros.jar"]
