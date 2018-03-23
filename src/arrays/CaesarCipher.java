package arrays;

public final class CaesarCipher {
    private final int offset;

    public CaesarCipher(int offset) {
        this.offset = offset;
    }

    public final String encrypt(String message) {
        StringBuilder encrytptedMsg = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            if (Character.isUpperCase(currentChar)) {
                encrytptedMsg.append((char) (((currentChar - 'A' + offset) % 26) + 'A'));
            } else if (Character.isLowerCase(currentChar)) {
                encrytptedMsg.append((char) (((currentChar - 'a' + offset) % 26) + 'a'));

            } else {
                encrytptedMsg.append(currentChar);
            }
        }
        return encrytptedMsg.toString();
    }

    public final String decrypt(String message) {
        StringBuilder decryptedMsg = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            if (Character.isUpperCase(currentChar)) {
                decryptedMsg.append((char) (((currentChar - 'Z' - offset) % 26) + 'Z'));
            } else if (Character.isLowerCase(currentChar)) {
                decryptedMsg.append((char) (((currentChar - 'z' - offset) % 26) + 'z'));

            } else {
                decryptedMsg.append(currentChar);
            }
        }
        return decryptedMsg.toString();
    }
}
