#!/usr/bin/env bash
set -u

export DISPLAY=:1
cd /workspaces/UCI_Java_Programming

# Keep the classroom Swing desktop healthy for the lifetime of the Codespace.
while true; do
  NEED_REPAIR=0

  if ! xdpyinfo -display :1 >/dev/null 2>&1; then
    NEED_REPAIR=1
  fi

  if ! ss -ltn 2>/dev/null | grep -q '127.0.0.1:5900'; then
    NEED_REPAIR=1
  fi

  if ! curl -fsS http://127.0.0.1:6080/vnc_auto.html >/dev/null 2>&1; then
    NEED_REPAIR=1
  fi

  if [ "$NEED_REPAIR" -eq 1 ]; then
    echo "$(date -Is) repairing Swing desktop services"
    UCI_NO_WATCHDOG=1 bash .devcontainer/start-services.sh || true
  fi

  sleep 10
done
