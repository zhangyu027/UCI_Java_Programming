#!/usr/bin/env bash
set -euo pipefail

# Start MariaDB for JDBC exercises.
sudo service mariadb start >/dev/null 2>&1 || true

# Codespaces has no physical display. Xvfb provides a virtual X11 display,
# x11vnc exposes it on localhost:5900, and noVNC exposes a browser UI on 6080.
export DISPLAY=:1

if ! pgrep -f "Xvfb :1" >/dev/null 2>&1; then
  nohup Xvfb :1 -screen 0 1280x800x24 -ac -noreset \
    >/tmp/uci-xvfb.log 2>&1 &
fi

DISPLAY_READY=0
for _ in {1..40}; do
  if xdpyinfo -display :1 >/dev/null 2>&1; then
    DISPLAY_READY=1
    break
  fi
  sleep 0.25
done

if [ "$DISPLAY_READY" -ne 1 ]; then
  echo "ERROR: Swing virtual display did not start."
  cat /tmp/uci-xvfb.log 2>/dev/null || true
  exit 1
fi

if ! pgrep -f "openbox" >/dev/null 2>&1; then
  nohup env DISPLAY=:1 openbox-session >/tmp/uci-openbox.log 2>&1 &
fi

# Always ensure exactly one healthy x11vnc server is attached to DISPLAY=:1.
# Binding to localhost is sufficient because noVNC connects from inside the container.
VNC_RESTARTED=0

if ! ss -ltn 2>/dev/null | grep -q '127.0.0.1:5900'; then
  pkill -f "x11vnc.*5900" >/dev/null 2>&1 || true
  nohup x11vnc \
    -display :1 \
    -forever \
    -shared \
    -nopw \
    -listen 127.0.0.1 \
    -rfbport 5900 \
    -noxdamage \
    >/tmp/uci-x11vnc.log 2>&1 &
  VNC_RESTARTED=1
fi

VNC_READY=0
for _ in {1..40}; do
  if ss -ltn 2>/dev/null | grep -q '127.0.0.1:5900'; then
    VNC_READY=1
    break
  fi
  sleep 0.25
done

if [ "$VNC_READY" -ne 1 ]; then
  echo "ERROR: x11vnc did not become ready on 127.0.0.1:5900."
  cat /tmp/uci-x11vnc.log 2>/dev/null || true
  exit 1
fi

# Use noVNC's packaged launcher.
# Restart noVNC when its port is missing OR whenever x11vnc had to be restarted,
# so the browser proxy cannot remain attached to a stale VNC backend.
if [ "$VNC_RESTARTED" -eq 1 ] || ! ss -ltn 2>/dev/null | grep -q ':6080 '; then
  pkill -f "websockify.*6080" >/dev/null 2>&1 || true
  pkill -f "novnc_proxy.*6080" >/dev/null 2>&1 || true
  nohup /usr/share/novnc/utils/novnc_proxy \
    --listen 6080 \
    --vnc 127.0.0.1:5900 \
    >/tmp/uci-novnc.log 2>&1 &
fi

NOVNC_READY=0
for _ in {1..40}; do
  if curl -fsS http://127.0.0.1:6080/vnc.html >/dev/null 2>&1; then
    NOVNC_READY=1
    break
  fi
  sleep 0.25
done

if [ "$NOVNC_READY" -ne 1 ]; then
  echo "ERROR: noVNC did not become ready on port 6080."
  cat /tmp/uci-novnc.log 2>/dev/null || true
  exit 1
fi

echo "MariaDB started."
echo "Swing display available on DISPLAY=:1."
echo "x11vnc is ready on 127.0.0.1:5900."
echo "noVNC is ready on port 6080."
echo "Open port 6080 from the Codespaces Ports tab."
