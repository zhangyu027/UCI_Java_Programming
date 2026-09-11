#!/usr/bin/env bash
set -euo pipefail

echo "=================================================="
echo " UCI Java Programming - MariaDB Codespace Setup"
echo "=================================================="

echo "[1/4] Starting MariaDB..."
sudo service mariadb start

echo "[2/4] Waiting for MariaDB..."
READY=0
for i in {1..30}; do
  if sudo mariadb -e "SELECT 1;" >/dev/null 2>&1; then
    READY=1
    break
  fi
  sleep 1
done

if [ "$READY" -ne 1 ]; then
  echo "ERROR: MariaDB did not become ready."
  exit 1
fi

echo "[3/4] Initializing course databases..."
sudo mariadb < .devcontainer/init.sql

echo "[4/4] Verifying..."
sudo mariadb -e "SHOW DATABASES;"
sudo mariadb University -e "SHOW TABLES;"
sudo mariadb library_db -e "SHOW TABLES;"

echo
echo "MariaDB Codespaces setup complete."
echo "University DB URL: jdbc:mariadb://127.0.0.1:3306/University"
echo "Library DB URL:    jdbc:mariadb://127.0.0.1:3306/library_db"
echo "Classroom DB user: javauser"
