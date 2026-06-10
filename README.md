# Witches Drop Blaze Powder — v1.4
Fabric mod for Minecraft 1.21.1

## What it does
Adds **0–2 blaze powder** to the witch loot pool when a player kills a witch.
All vanilla witch drops (glass bottles, glowstone dust, gunpowder, redstone, spiders eye, sugar, sticks) are completely preserved.

## Requirements
- Minecraft 1.21.1
- Fabric Loader 0.16.5+
- Fabric API 0.110.0+1.21.1

## Building from source

### Prerequisites
- JDK 21 (e.g. [Adoptium](https://adoptium.net/))
- Internet connection (Gradle downloads dependencies automatically)

### Steps
```bash
# 1. Clone / unzip this project
cd witches-drop-blaze-powder

# 2. Build
./gradlew build          # Linux / macOS
gradlew.bat build        # Windows

# 3. The compiled .jar is at:
#    build/libs/witches-drop-blaze-powder-1.4.jar
```

### First-time setup (generates Gradle wrapper if missing)
```bash
gradle wrapper --gradle-version 8.8
./gradlew build
```

## Installing
Copy `witches-drop-blaze-powder-1.4.jar` into your `.minecraft/mods/` folder alongside Fabric API.

## How it works
Uses `LootTableEvents.MODIFY` (Fabric API v3) to append a new loot pool to
`minecraft:entities/witch` at runtime. The vanilla loot table is never
overwritten — it remains fully intact and is additively modified only in memory.

The new pool:
- Rolls **0–1 times** (giving ~50% chance per kill)
- Drops **1–2 blaze powder**
- Only triggers when **killed by a player** (matches vanilla behaviour for bonus drops)
