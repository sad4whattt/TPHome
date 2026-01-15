# HomePlugin

A simple Hytale plugin that allows players to set and teleport to their home location.

## Check us out
[Snipr](https://hytale.snipr.me/)

## Commands

- `/sethome` - Set your home at your current location
- `/home` - Teleport to your saved home location

## Installation

1. Download the JAR from [Releases](../../releases)
2. Place it in your server's `mods/` folder
3. Restart your server

## Data Storage

Homes are saved in: `mods/Snipr_HomePlugin/homes.txt`

Each player can have one home location that persists across server restarts.

## Building

**Requirements:** Java 21+, HytaleServer.jar in `libs/` folder

```bash
gradlew shadowJar
```

Output: `build/libs/HomePlugin-1.0.0.jar`

## ⚠️ Important: Permissions Setup

By default, Hytale prevents non-Operators from using slash commands. For regular players to use this plugin, you **must** add the permission node to your server's `permissions.json` file.

**Note:** You must **STOP** your server before editing this file, or it may reset your changes.

### Configuration
Locate `permissions.json` in your server root and add the permission string to the `default` group list.

**Correct Syntax:**
Ensure you use a **List `[]`**, not an Object `{}`.

```json
  "groups": {
    "Default": [],
    "OP": [
      "*"
    ],
    "default": [
      "snipr.homeplugin.*"
    ],
    "Adventure": [
      "snipr.homeplugin.*"
    ]
  }
```

## License

MIT - Use it however you want!

---



## Looking for quality hosting?
[![Kinetic Hosting - Hytale Server Hosting](https://i.ibb.co/5XFkWtyy/KH-Curse-Forge-Final-Wide-Banner-Hytale-Small.png)](https://billing.kinetichosting.com/aff.php?aff=1251)
