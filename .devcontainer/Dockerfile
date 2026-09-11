FROM mcr.microsoft.com/devcontainers/universal:2-linux

RUN sudo rm -f /etc/apt/sources.list.d/yarn.list \
    /etc/apt/sources.list.d/yarnpkg.list \
    && sudo apt-get update \
    && sudo DEBIAN_FRONTEND=noninteractive apt-get install -y \
        mariadb-server \
        mariadb-client \
        git-lfs \
    && sudo apt-get clean \
    && sudo rm -rf /var/lib/apt/lists/*
