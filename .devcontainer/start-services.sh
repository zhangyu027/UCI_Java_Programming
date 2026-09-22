#!/usr/bin/env bash
set -euo pipefail

# Start MariaDB for JDBC exercises.
sudo service mariadb start >/dev/null 2>&1 || true

# Codespaces has no physical display. Xvfb provides a virtual X11 display,
# x11vnc exposes it internally on localhost:5900, and noVNC exposes the
# browser desktop on 6080.
export DISPLAY=:1

if ! pgrep -f "Xvfb :1" >/dev/null 2>&1; then
  setsid -f Xvfb :1 -screen 0 1280x800x24 -ac -noreset     </dev/null >/tmp/uci-xvfb.log 2>&1
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

if ! pgrep -f "openbox-session" >/dev/null 2>&1; then
  setsid -f env DISPLAY=:1 openbox-session     </dev/null >/tmp/uci-openbox.log 2>&1
fi

# Port 5900 is an internal backend. Students should open only port 6080.
# x11vnc catches SIGHUP itself, so nohup is not sufficient in Codespaces.
# Start it in a separate session so the postStart shell cannot terminate it.
if ! ss -ltn 2>/dev/null | grep -q '127.0.0.1:5900'; then
  pkill -f "x11vnc.*5900" >/dev/null 2>&1 || true
  : > /tmp/uci-x11vnc.log
  setsid -f x11vnc     -display :1     -forever     -shared     -nopw     -listen 127.0.0.1     -rfbport 5900     -noxdamage     </dev/null >>/tmp/uci-x11vnc.log 2>&1
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

# Keep exactly one noVNC/websockify process and serve from the explicit web root.
pkill -f "websockify.*6080" >/dev/null 2>&1 || true
pkill -f "novnc_proxy.*6080" >/dev/null 2>&1 || true
sleep 0.25

: > /tmp/uci-novnc.log
setsid -f websockify   --web=/usr/share/novnc   6080   127.0.0.1:5900   </dev/null >>/tmp/uci-novnc.log 2>&1

NOVNC_READY=0
for _ in {1..40}; do
  if curl -fsS http://127.0.0.1:6080/vnc_auto.html >/dev/null 2>&1; then
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

# Keep the chain healthy for the lifetime of the Codespace.
# Start the watchdog in its own session so it survives postStart shell exit too.
if [ "${UCI_NO_WATCHDOG:-0}" != "1" ] && ! pgrep -f "bash .devcontainer/watch-services.sh" >/dev/null 2>&1; then
  : > /tmp/uci-watch-services.log
  setsid -f bash .devcontainer/watch-services.sh     </dev/null >>/tmp/uci-watch-services.log 2>&1
fi

echo "MariaDB started."
echo "Swing display available on DISPLAY=:1."
echo "x11vnc is ready internally on 127.0.0.1:5900."
echo "noVNC is ready on port 6080."
echo "Swing watchdog is running."
echo "Open only port 6080 (Swing Desktop) from the Codespaces Ports tab."
