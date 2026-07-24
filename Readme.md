# SimpleBan

![Version](https://img.shields.io/badge/version-1.0.0-blue)
![Minecraft](https://img.shields.io/badge/Minecraft-1.21+-green)
![Java](https://img.shields.io/badge/Java-21-orange)

A simple and open-source ban system for Paper Minecraft servers.

Developed by **WRN**.

---

## Features

- Permanent bans
- Temporary bans
- Custom ban reasons
- UUID-based player storage
- YAML data storage
- Automatic temporary ban expiration
- Join protection for banned players
- Configurable messages
- Expandable architecture

---

## Requirements

- Minecraft: `1.21+`
- Server software:
  - Paper
  - Spigot
- Java: `21+`

---

# Installation

1. Download the latest release from GitHub.
2. Put the `.jar` file into your server plugin folder:

```
plugins/
```

3. Restart your Minecraft server.

SimpleBan will automatically create:

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

# Time Formats

| Format | Description |
|---|---|
| s | Seconds |
| m | Minutes |
| h | Hours |
| d | Days |
| w | Weeks |

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

You can customize messages, logging and update settings.

---

# Development

Source code:

```
src/main/java/de/wrn/simpleban/
```

Main classes:

```
SimpleBan.java
BanCommand.java
BanManager.java
BanListener.java
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
- [ ] Multi-server synchronization

---

# License

This project is open source.

You are free to view, modify and contribute to the project according to the repository license.

---

# Credits

Created by **WRN**

Minecraft plugin project.