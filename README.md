## Join the Discord!

[Epic Discord Server with updates](https://discord.gg/7Tzqrbsdyp)

# HomePlugin

A simple Hytale plugin that allows players to set and teleport to their home location.

## Commands (players)

- `/home [name]` - Teleport to your saved home (default or named)
- `/sethome [name]` - Set your home at your current location (optional name)
- `/sethome <x> <y> <z>` - Set default home at specific coordinates
- `/sethome <name> <x> <y> <z>` - Set a named home at specific coordinates
- `/homes` - List all of **your** homes with coordinates (message is private)
- `/homewipe` - Delete all of **your** homes

## Admin-only

- `/sethome max <number>` - Set the max homes per player (0 = unlimited). Requires OP group permission.

## Installation

1. Download the JAR
2. Place it in your server's `mods/` folder
3. Restart your server

## Data Storage

- Homes are saved in: `plugins/Snipr_HomePlugin/homes.txt`
- Max homes setting is saved in: `plugins/Snipr_HomePlugin/maxhomes.txt`

Each player can have multiple homes (subject to the max homes setting) that persist across server restarts.


## ⚠️ Important: Permissions Setup

By default, Hytale prevents non-Operators from using slash commands. For regular players to use this plugin, you **must** add the permission node to your server's `permissions.json` file.

**Note:** You must **STOP** your server before editing this file, or it may reset your changes.

### Configuration

Locate `permissions.json` in your server root and add the permission string to the `default` group list.

**Correct Syntax:** Ensure you use a **List `[]`**, not an Object `{}`.

```
{
  "groups": {
    "Default": [],
    "OP": [
      "*"
    ],
    "default": [
      "snipr.homeplugin.*",
    ],
    "Adventure": [
      "snipr.homeplugin.*",
    ]
  }
```


## Building

**Requirements:** Java 21+, HytaleServer.jar in `libs/` folder

```bash
gradlew shadowJar
```

Output: `build/libs/HomePlugin-1.0.0.jar`

## Looking for quality hosting?

[![Kinetic Hosting - Hytale Server Hosting](https://i.ibb.co/5XFkWtyy/KH-Curse-Forge-Final-Wide-Banner-Hytale-Small.png)](https://billing.kinetichosting.com/aff.php?aff=1251)
