FROM mcr.microsoft.com/devcontainers/java:3-21-bookworm

USER root

RUN apt-get update \
    && DEBIAN_FRONTEND=noninteractive apt-get install -y --no-install-recommends \
        maven \
        mariadb-server \
        mariadb-client \
        git-lfs \
        xvfb \
        x11-utils \
        x11vnc \
        openbox \
        novnc \
        websockify \
        xterm \
        dbus-x11 \
        fonts-dejavu-core \
        curl \
    && git lfs install --system \
    && rm -rf /var/lib/apt/lists/*

USER vscode
