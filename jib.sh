FROM_BASE=eclipse-temurin:21.0.1_12-jdk
ECR_REGISTRY=020157571320.dkr.ecr.us-east-1.amazonaws.com
ECR_REPOSITORY=app-prod-virtualthreads
mvn compile com.google.cloud.tools:jib-maven-plugin:3.4.0:build \
   -Djib.from.image=${FROM_BASE} \
   -Djib.to.image=${ECR_REGISTRY}/${ECR_REPOSITORY}:jiblatest \
   -Djib.to.image=${ECR_REGISTRY}/${ECR_REPOSITORY}:latest \
   -Djib.container.ports.port=3000
