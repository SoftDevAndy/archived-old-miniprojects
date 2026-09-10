# DoomChat

DoomChat is an Oxide/uMod plugin for Rust servers. It was created for the DoomTown.io modded Rust server to provide chat moderation and player communication tools.

## Features

- Word filtering and optional automatic muting.
- Trade chat and private messages.
- Clan chat and clan management.
- Player ignore and online-status checks.
- Chat metrics and dice rolls.

## Requirements

This is a server plugin, not a standalone Windows application. It requires a Windows Rust server running a compatible Oxide/uMod version. Compatibility with current server and Oxide/uMod versions has not been verified.

## Installation on Windows

1. Back up the server before installing the plugin.
2. Copy `plugins/DoomChat.cs` into the server's `oxide/plugins` folder.
3. Start or reload the server and check the Oxide console for errors.
4. Review `config/DoomChat.json` and adjust the filter words, colors, and message text as needed.

The plugin creates and updates JSON files under the server's data folder, including mute, trade-chat, ignore, clan, and invitation data. Keep those files with the server when migrating the plugin.

## Commands

Player and moderator commands include:

```text
/t <message>                         Trade chat
/unsub                               Leave trade chat
/pm <playername> <message>           Private message
/r <message>                         Reply to the last private message
/ignore <playername>                 Ignore a player
/unignore <playername>               Stop ignoring a player
/poke <playername>                   Check whether a player is online
/clan                                View a pending clan invitation
/clan <accept|decline>               Respond to an invitation
/clan create <tag> <hexvalue>        Create a clan
/clan invite <playername>            Invite a player
/clan kick <playername>              Remove a player from a clan
/clan leave                          Leave or disband a clan
/clan online                         Show online clan members
/clans [page]                        List clans
/rolldice <player> <player> ...      Roll for players
```

Moderator commands include `/automute <true|false|on|off>`, `/filter list`, `/filter add <word>`, `/filter remove <word>`, and `/metrics`.

## Configuration

`config/DoomChat.json` contains the default mute setting, filtered words, display colors, message text, and metric values. The plugin stores player data in JSON files under `data/`.

## Source

- `plugins/DoomChat.cs` — Plugin implementation.
- `config/DoomChat.json` — Example configuration.
- `data/` — Example persisted plugin data.
