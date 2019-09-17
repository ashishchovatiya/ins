import java.util.*;

public class vigenere
{
    public static String encrypt(String text, final String key)
    {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            
            res += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            
            j = ++j % key.length();

        }
        return res;
    }


    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String message,key;
        System.out.println("Enter the Message :");
        message=sc.nextLine();
        System.out.println("\nEnter the key :");
        key=sc.nextLine();

        String encryptedMsg = encrypt(message, key);

        System.out.println("String: " + message);

        System.out.println("Encrypted message: " + encryptedMsg);

    }

}