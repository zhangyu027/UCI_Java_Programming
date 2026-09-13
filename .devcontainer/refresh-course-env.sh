#!/usr/bin/env bash
set -euo pipefail

# Refresh the classroom environment after pulling new repository changes.
# Safe to run repeatedly.

echo "=================================================="
echo " UCI Java Programming - Refresh Course Environment"
echo "=================================================="

echo "[1/3] Applying database setup..."
bash .devcontainer/setup-db.sh

echo "[2/3] Starting classroom services..."
bash .devcontainer/start-services.sh

echo "[3/3] Quick verification..."
mariadb -u "${UCI_DB_USER:-javauser}" -p"${UCI_DB_PASSWORD:-JavaClass2026}" -e "
SHOW DATABASES;
SHOW TABLES FROM rental_shop;
SHOW TABLES FROM EmployeeManagement;
"

echo
echo "Environment refresh complete."
echo "For Swing apps, open forwarded port 6080 and then /vnc_auto.html"
