FROM mcr.microsoft.com/devcontainers/java:3-21-bookworm

USER root

RUN apt-get update \
    && DEBIAN_FRONTEND=noninteractive apt-get install -y --no-install-recommends \
        maven \
        mariadb-server \
        mariadb-client \
        git-lfs \
    && git lfs install --system \
    && rm -rf /var/lib/apt/lists/*

USER vscode
