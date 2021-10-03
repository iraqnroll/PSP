package pair.main.java;

import java.util.Arrays;
import java.util.List;

public class EmailValidator {
    /* Source:
    https://en.wikipedia.org/wiki/Email_address#Local-part
    https://en.wikipedia.org/wiki/Email_address#Domain
    */

    private int maxLocalPartLength;
    private int maxDomainPartLength;

    private List<Character> allowedLocalSymbols;
    private List<Character> allowedDomainSymbols;

    public EmailValidator(int localLength, int domainLength, List<Character> localSymbols, List<Character> domainSymbols)
    {
        this.maxLocalPartLength = localLength;
        this.maxDomainPartLength = domainLength;

        this.allowedDomainSymbols = domainSymbols;
        this.allowedLocalSymbols = localSymbols;
    }

    public boolean validateEmail(String email) {
        return emailContainsAtSign(email)
                && emailHasCorrectDomain(email)
                && emailHasCorrectLocalPart(email);
    }

    //Teste nepagalvota apie duplikatus simbolius ('@', '.', ir tt..)
    private boolean emailContainsAtSign(String email) {
        var count = email.chars().filter(ch -> ch == '@').count();

        return count == 1;
    }
    /*
    Turetu buti isskirtas tikrinimas neleistinu
    simboliu domenui ir lokaliai daliai, nes jiems taikomi skirtingi reikalavimai.
    Sito metodo manau visiskai nereikia.
     */

    private boolean emailHasCorrectDomain(String email) {
        String domain = email.split("@")[1];
        if(!domain.isEmpty())
        {
            var domainParts = domain.split("\\.");

            for (String part : domainParts) {
                if (part.length() <= maxDomainPartLength && !part.isEmpty()) {
                    for (int i = 0; i < part.length(); i++) {
                        char currChar = part.charAt(i);
                        if (!allowedDomainSymbols.contains(currChar) && !Character.isLetter(currChar)) {
                            return false;
                        }
                    }

                }
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    //Nebuvo tikrinama email adreso username dalis.
    private boolean emailHasCorrectLocalPart(String email){
        String localPart = email.split("@")[0];

        if(localPart.length() <= maxLocalPartLength && !localPart.isEmpty())
        {
            for(int i = 0; i < localPart.length(); i++)
            {
                char currChar = localPart.charAt(i);
                if(!allowedLocalSymbols.contains(currChar) && !Character.isLetter(currChar))
                {
                  return false;
                }
            }

            return true;
        }
        else
        {
            return false;
        }
    }
}
