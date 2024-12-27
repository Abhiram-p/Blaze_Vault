package com.blazevault;

import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BackupManager {

    private static final String BACKUP_DIR = "server_backups";

    public static void createBackup() {
        try {
            // Get current timestamp for backup folder
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            Path backupPath = Paths.get(BACKUP_DIR, "backup_" + timestamp);

            // Ensure backup directory exists
            Files.createDirectories(backupPath);

            // Specify server folders to back up
            String[] foldersToBackup = {"world", "mods", "config"};

            for (String folder : foldersToBackup) {
                Path source = Paths.get(folder);
                Path destination = backupPath.resolve(folder);

                if (Files.exists(source)) {
                    copyFolder(source, destination);
                    System.out.println("Backed up: " + folder);
                } else {
                    System.out.println("Skipped (not found): " + folder);
                }
            }

            System.out.println("Backup completed successfully: " + backupPath);
        } catch (IOException e) {
            System.err.println("Backup failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void copyFolder(Path source, Path destination) throws IOException {
        Files.walk(source).forEach(path -> {
            try {
                Path targetPath = destination.resolve(source.relativize(path));
                if (Files.isDirectory(path)) {
                    Files.createDirectories(targetPath);
                } else {
                    Files.copy(path, targetPath, StandardCopyOption.REPLACE_EXISTING);
                }
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        });
    }
}