package app.utils;

public final class OsUtils {
    private static String OS = null;

    public static String getOsName() {
        if (OS == null) {
            OS = System.getProperty("os.name");
        }
        return OS;
    }

    public static boolean isWindows() {
        return getOsName().startsWith("Windows");
    }

    public static boolean isUnix() {
        String osName = getOsName().toLowerCase();
        return osName.contains("nix") || osName.contains("nux") || osName.contains("mac");
    }
}
