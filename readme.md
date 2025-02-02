![Header](media/main.png)

# SensorStreamer

Our phones are full of useful sensors - accelerometer, gyroscope, magnetometer, and more. Many developers have needed to test these sensors. Traditionally, this meant using an Arduino with sensor breakout boards and writing code for serial communication.

However, sensor availability and wiring can be limiting factors. SensorStreamer offers a solution - a lightweight Android app that logs sensor data and transmits it over network to your computer for analysis, for example using Python scripts.

Download the latest version from Github Releases: [SensorStreamer](https://github.com/ibratabian17/SensorStreamer/releases)

## Supported Features

- Stream data from any Android-supported phone sensor
- TCP socket streaming in:
  - Client mode
  - Server mode
- Data formats:
  - JSON object
  - Binary packet

## Format of the JSON Packet

Each packet contains a JSON object with fields for each sensor. Each sensor provides:

- `timestamp` (in nanoseconds)
- `value`: either a single float or a 3D float array. For details on these values, see [Android Sensor Reference](https://developer.android.com/guide/topics/sensors/sensors_motion.html#sensors-motion-accel).

Timestamps are included per sensor due to impossibility of simultaneous capture. While differences are typically minimal, precise timing data is available if needed.

## Format of the Binary Packet

The binary packet format is optimized for simplicity and compactness:

```
[0x80] [timestamp 8 bytes] [sensor values 1 or 3 float] ... [sensor values 1 or 3 float]
```

Timestamp is optional. Sensors appear in the same order as configured in the app, with a single timestamp for efficiency.

## Timing

Android API limits sensor reading to 4 frequency modes: approximately 5 Hz, 16 Hz, 100 Hz, and maximum possible speed. Actual frequencies may be lower, limited by the slowest configured sensor.

## Python Client

A third-party Python tool is available: [PhoneSensor](https://github.com/nup002/PhoneSensors).

## Project Status

This project was originally developed by Jan "yaqwsx" Mrázek with graphics by [Martin Mikšík](https://github.com/mamiksik). The current fork by [ibratabian17](https://github.com/ibratabian17) includes:

- Compatibility with newer Android versions
- Updates to meet modern Android security requirements
- UI/UX improvements
- Updated dependencies and SDK support

The original project is no longer maintained, but this fork keeps the functionality alive on modern devices.

