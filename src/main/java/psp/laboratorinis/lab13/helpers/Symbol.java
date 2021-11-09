package psp.laboratorinis.lab13.helpers;

public class Symbol {
    public static boolean IsNumber(char symbol)
    {
        return (symbol >= '0' && symbol <= '9');
    }
    public static boolean IsLetter(char symbol)
    {
        return IsUppercase(symbol) || IsLowercase(symbol);
    }
    public static boolean IsUppercase(char symbol)
    {
        return symbol >= 'A' && symbol <= 'Z';
    }
    public static boolean IsLowercase(char symbol)
    {
        return symbol >= 'a' && symbol <= 'z';
    }
}
