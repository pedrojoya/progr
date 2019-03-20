package es.iessaladillo.pedrojoya.carfactory.utils.console;

import java.util.Scanner;
import java.util.function.Predicate;

@SuppressWarnings({"WeakerAccess", "unused"})
public class ConsoleInput {

    private static final Scanner scanner = new Scanner(System.in);

    public static char readChar() {
        do {
            try {
                return scanner.nextLine().charAt(0);
            } catch (Exception ignored) {
            }
        } while (true);
    }

    public static String readString() {
        do {
            try {
                String line = scanner.nextLine();
                if (line != null && !line.isEmpty()) {
                    return line;
                }
            } catch (Exception ignored) {
            }
        } while (true);
    }

    public static byte readByte() {
        do {
            try {
                return scanner.nextByte();
            } catch (Exception ignored) {
            } finally {
                clearBuffer();
            }
        } while (true);
    }

    public static short readShort() {
        do {
            try {
                return scanner.nextShort();
            } catch (Exception ignored) {
            } finally {
                clearBuffer();
            }
        } while (true);
    }

    public static int readInt() {
        do {
            try {
                return scanner.nextInt();
            } catch (Exception ignored) {
            } finally {
                clearBuffer();
            }
        } while (true);
    }

    public static long readLong() {
        do {
            try {
                return scanner.nextLong();
            } catch (Exception ignored) {
            } finally {
                clearBuffer();
            }
        } while (true);
    }

    public static float readFloat() {
        do {
            try {
                return scanner.nextFloat();
            } catch (Exception ignored) {
            } finally {
                clearBuffer();
            }
        } while (true);
    }

    public static double readDouble() {
        do {
            try {
                return scanner.nextDouble();
            } catch (Exception ignored) {
            } finally {
                clearBuffer();
            }
        } while (true);
    }

    public static boolean readBoolean() {
        char c;
        do {
            c = readChar();
        } while (c != 'S' && c != 's' && c != 'N' && c != 'n');
        return c == 'S' || c == 's';
    }

    public static byte readByte(Predicate<Byte> predicate) {
        do {
            try {
                byte value = scanner.nextByte();
                if (predicate.test(value)) {
                    return value;
                }
            } catch (Exception ignored) {
            } finally {
                clearBuffer();
            }
        } while (true);
    }

    public static short readShort(Predicate<Short> predicate) {
        do {
            try {
                short value = scanner.nextShort();
                if (predicate.test(value)) {
                    return value;
                }
            } catch (Exception ignored) {
            } finally {
                clearBuffer();
            }
        } while (true);
    }

    public static int readInt(Predicate<Integer> predicate) {
        do {
            try {
                int value = scanner.nextInt();
                if (predicate.test(value)) {
                    return value;
                }
            } catch (Exception ignored) {
            } finally {
                clearBuffer();
            }
        } while (true);
    }

    public static long readLong(Predicate<Long> predicate) {
        do {
            try {
                long value = scanner.nextLong();
                if (predicate.test(value)) {
                    return value;
                }
            } catch (Exception ignored) {
            } finally {
                clearBuffer();
            }
        } while (true);
    }

    public static float readFloat(Predicate<Float> predicate) {
        do {
            try {
                float value = scanner.nextFloat();
                if (predicate.test(value)) {
                    return value;
                }
            } catch (Exception ignored) {
            } finally {
                clearBuffer();
            }
        } while (true);
    }

    public static double readDouble(Predicate<Double> predicate) {
        do {
            try {
                double value = scanner.nextDouble();
                if (predicate.test(value)) {
                    return value;
                }
            } catch (Exception ignored) {
            } finally {
                clearBuffer();
            }
        } while (true);
    }

    public static String readString(Predicate<String> predicate) {
        do {
            try {
                String value = readString();
                if (predicate.test(value)) {
                    return value;
                }
            } catch (Exception ignored) {
            }
        } while (true);
    }

    private static void clearBuffer() {
        scanner.nextLine();
    }

}
