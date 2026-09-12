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

echo "[4/4] Verifying course databases..."

echo
echo "===== DATABASES ====="
sudo mariadb -e "SHOW DATABASES;"

echo
echo "===== University TABLES ====="
sudo mariadb University -e "SHOW TABLES;"

echo
echo "===== library_db TABLES ====="
sudo mariadb library_db -e "SHOW TABLES;"

echo
echo "===== company_db TABLES ====="
sudo mariadb company_db -e "SHOW TABLES;"

echo
echo "===== hamburger_db TABLES ====="
sudo mariadb hamburger_db -e "SHOW TABLES;"

echo
echo "===== student_grade_db TABLES ====="
sudo mariadb student_grade_db -e "SHOW TABLES;"

echo
echo "===== warehouse_db TABLES ====="
sudo mariadb warehouse_db -e "SHOW TABLES;"

echo
echo "=================================================="
echo " MariaDB Codespaces setup complete"
echo "=================================================="
echo
echo "University DB URL:"
echo "  jdbc:mariadb://127.0.0.1:3306/University"
echo
echo "Library DB URL:"
echo "  jdbc:mariadb://127.0.0.1:3306/library_db"
echo
echo "Classroom DB user:"
echo "  javauser"
echo
echo "Module 4 databases:"
echo "  company_db"
echo "  hamburger_db"
echo "  student_grade_db"
echo "  warehouse_db"
echo
