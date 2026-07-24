# SimpleBan

![Version](https://img.shields.io/badge/version-1.0.0-blue)
![Minecraft](https://img.shields.io/badge/Minecraft-1.21+-green)
![Java](https://img.shields.io/badge/Java-21-orange)

A simple and expandable ban system for Paper Minecraft servers.

Developed by **WRN**.

---

## Features

- Permanent bans
- Temporary bans
- Custom ban reasons
- UUID-based player storage
- YAML data storage
- Join protection for banned players
- Configurable messages
- Automatic expiration of temporary bans

---

## Requirements

- Minecraft: `1.21+`
- Server software:
  - Paper
  - Spigot
- Java: `21+`

---

## Installation

1. Download the latest `SimpleBan.jar`
2. Put the file into your server's plugin folder:

```
plugins/
```

3. Restart your Minecraft server.

After the first start, SimpleBan creates:

```
plugins/
└── SimpleBan/
    ├── config.yml
    └── bans.yml
```

---

# Commands

## Permanent Ban

```
/permban <player> <reason>
```

Example:

```
/permban Steve Advertising
```

The player will stay banned until manually unbanned.

---

## Temporary Ban

```
/tempban <player> <time> <reason>
```

Examples:

```
/tempban Steve 10m Spam
```

```
/tempban Alex 2h Toxicity
```

```
/tempban Player 7d Rule violation
```

---

## Time Formats

| Format | Description |
|---|---|
| s | Seconds |
| m | Minutes |
| h | Hours |
| d | Days |
| w | Weeks |

Example:

```
30m
```

= 30 minutes

---

# Permissions

| Permission | Description | Default |
|---|---|---|
| `simpleban.permban` | Use /permban | OP |
| `simpleban.tempban` | Use /tempban | OP |

---

# Configuration

Configuration file:

```
plugins/SimpleBan/config.yml
```

Example:

```yml
ban-settings:
  kick-player-on-ban: true

logging:
  enabled: true

update-check:
  enabled: true
```

---

# Build

This project uses Maven.

Build the plugin:

```bash
mvn clean package
```

The compiled plugin will be available at:

```
target/SimpleBan-1.0.0.jar
```

---

# Development

Project structure:

```
SimpleBan/
│
├── src/main/java/de/wrn/simpleban/
│   ├── SimpleBan.java
│   ├── BanCommand.java
│   ├── BanManager.java
│   └── BanListener.java
│
├── src/main/resources/
│   ├── plugin.yml
│   └── config.yml
│
└── pom.xml
```

---

# Planned Features

- [ ] `/unban`
- [ ] `/baninfo`
- [ ] Ban IDs
- [ ] Discord webhook integration
- [ ] MySQL/MariaDB support
- [ ] Web management panel
- [ ] WRN Update API integration
- [ ] Multi-server ban synchronization

---

# License

This project is currently closed source.

---

# Credits

Created by **WRN**

Minecraft plugin development project.
