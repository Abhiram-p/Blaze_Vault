# Blaze Vault

Blaze Vault is a powerful, feature-rich Minecraft mod designed to automate server backups and restore processes effortlessly. Built with modularity and scalability in mind, Blaze Vault ensures your server data stays secure, accessible, and organized.

---

## 🚀 Features
### Backup
- **Incremental Backups**: Save storage by only backing up changed files.
- **Encryption**: Optional AES-256 encryption to secure your backups.
- **Compression**: Reduce backup sizes while maintaining file integrity.
- **Progress Bar & ETAs**: Real-time updates during backups.
- **Adaptive Scheduling**: Automatically adjust backup times based on server activity.

### Restore
- **Flexible Restore Options**: Restore backups from local or remote storage.
- **Encrypted Backup Support**: Seamlessly restore encrypted backups.
- **Progress Tracking**: Real-time updates and error reporting.

### Notifications
- **Custom Alerts**: Aesthetically pleasing, minimal notifications.
- **Audio Alerts**: Owl and tweet sounds for day and night notifications.
- **Command Feedback**: Detailed but non-intrusive updates for OPs and players.

### Storage & Management
- **Multiple Storage Locations**: Support for local, cloud, and GitHub backups.
- **Siphon Mode**: Backups are stored locally when the server is active and uploaded during idle times.
- **Smart Retry Logic**: Automatically retries failed backups on server restarts.
- **Backup History Logs**: Track and analyze all backup activities.

---

## 📦 Installation
1. Download the latest version of **Blaze Vault** from [Modrinth](https://modrinth.com/).
2. Place the mod JAR file into the `mods` folder of your Minecraft server directory.
3. Start your server to generate the default configuration file.
4. Customize the configuration (`blazevault-config.json`) as per your needs.

---

## 🛠️ Commands
| Command                   | Description                                       |
|---------------------------|---------------------------------------------------|
| `/vault backup`           | Initiates a manual backup.                       |
| `/vault restore`          | Restores a backup from local storage.            |
| `/vault status`           | Displays the latest backup status and details.   |
| `/vault config`           | View or update Blaze Vault configurations.       |

---

## 📄 Configuration
Blaze Vault generates a default configuration file (`blazevault-config.json`) in your server's directory. Key settings include:
- **Backup Frequency**: Adjust backup intervals.
- **Encryption**: Enable or disable backup encryption.
- **Storage Options**: Configure local, cloud, or GitHub backup paths.

---

## 🤝 Compatibility
Blaze Vault supports **Minecraft 1.21+** and is compatible with Fabric API.

---

## 🌟 Contributing
Contributions are welcome! Feel free to fork this repository and submit pull requests for bug fixes, features, or enhancements.

---

## 🔒 License
This project is licensed under the **MIT License**.  
You are free to use, modify, and distribute this software as per the terms of the MIT License.  
See the [LICENSE](./LICENSE) file for details.

---

## 📬 Feedback
Have ideas, suggestions, or encountered a bug? Open an issue or leave a review on [Modrinth](https://modrinth.com/).

---

## 📜 Roadmap
- **Future Updates**: 
  - Remote backup monitoring (Discord/email alerts).
  - Advanced restore options.
  - Cross-server compatibility enhancements.
