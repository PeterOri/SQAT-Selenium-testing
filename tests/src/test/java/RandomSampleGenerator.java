import java.util.Random;

public class RandomSampleGenerator {
    private static final String smallLetters = "abcdefghijklmnopqrstuvwxyz";
    private static final String bigLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String numbers = "0123456789";
    private static final String characters = smallLetters + numbers + bigLetters;

    private static final int MIN_LENGTH = Integer.parseInt(ConfigReader.get("login_credential_min_len"));
    private static final int MAX_LENGTH = Integer.parseInt(ConfigReader.get("login_credential_max_len"));

    public static String getUsername() {
        String characterPool = characters;
        Random random = new Random();
        int usernameLength = MIN_LENGTH + random.nextInt(MAX_LENGTH - MIN_LENGTH + 1);
        StringBuilder username = new StringBuilder();

        for (int i = 0; i < usernameLength; i++) {
            int index = random.nextInt(characterPool.length());
            username.append(characterPool.charAt(index));
        }

        return username.toString();
    }

    public static String getPassword() {
        String characterPool = characters;
        Random random = new Random();
        int passwordLength = MIN_LENGTH + random.nextInt(MAX_LENGTH - MIN_LENGTH + 1);
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < passwordLength; i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        return password.toString();
    }
}
