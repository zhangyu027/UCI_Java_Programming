FROM mcr.microsoft.com/devcontainers/universal:2-linux

RUN sudo apt-get update \
    && sudo DEBIAN_FRONTEND=noninteractive apt-get install -y mariadb-server mariadb-client \
    && sudo apt-get clean \
    && sudo rm -rf /var/lib/apt/lists/*
