FROM openjdk:11.0.6-jre-slim

WORKDIR /opt

EXPOSE 8080

RUN ln -svT /usr/local/openjdk-11/bin/java /etc/alternatives/java; \
    ln -svT /etc/alternatives/java /usr/bin/java

RUN export DEBIAN_FRONTEND=noninteractive && \
    apt-get update && \
    apt-get install -y -q \
        less \
        net-tools && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

ARG USR_GRP=app
RUN groupadd --gid 1000 $USR_GRP && \
    useradd --uid 1000 --gid $USR_GRP --no-create-home --shell /bin/false $USR_GRP && \
    chown -R $USR_GRP:$USR_GRP /opt

USER $USR_GRP

COPY --chown=$USR_GRP:$USR_GRP target/App-*.jar /opt/app.jar

CMD ["sh", "-c", "/usr/bin/java $JAVA_OPTS -jar /opt/app.jar"]
