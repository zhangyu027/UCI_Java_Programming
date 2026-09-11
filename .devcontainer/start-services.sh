#!/usr/bin/env bash
set -euo pipefail

# Start MariaDB for JDBC exercises.
sudo service mariadb start >/dev/null 2>&1 || true

# Codespaces has no physical display. Xvfb provides a virtual X11 display,
# x11vnc exposes it, and noVNC/websockify makes it viewable in a browser.
export DISPLAY=:1

if ! pgrep -f "Xvfb :1" >/dev/null 2>&1; then
  nohup Xvfb :1 -screen 0 1280x800x24 -ac -noreset \
    >/tmp/uci-xvfb.log 2>&1 &
fi

for _ in {1..20}; do
  if xdpyinfo -display :1 >/dev/null 2>&1; then
    break
  fi
  sleep 0.25
done

if ! pgrep -f "openbox.*DISPLAY=:1" >/dev/null 2>&1; then
  nohup env DISPLAY=:1 openbox-session >/tmp/uci-openbox.log 2>&1 &
fi

if ! pgrep -f "x11vnc.*-rfbport 5900" >/dev/null 2>&1; then
  nohup x11vnc -display :1 -forever -shared -nopw -rfbport 5900 \
    >/tmp/uci-x11vnc.log 2>&1 &
fi

if ! pgrep -f "websockify.*6080" >/dev/null 2>&1; then
  nohup websockify --web=/usr/share/novnc 6080 localhost:5900 \
    >/tmp/uci-novnc.log 2>&1 &
fi

echo "MariaDB started."
echo "Swing display available on DISPLAY=:1."
echo "Open forwarded port 6080 in the Codespaces Ports tab to view Swing windows."
