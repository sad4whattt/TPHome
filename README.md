# HomePlugin

A simple Hytale plugin that allows players to set and teleport to their home location.

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

## License

MIT - Use it however you want!

---

Made for learning Hytale plugin development 🎮
