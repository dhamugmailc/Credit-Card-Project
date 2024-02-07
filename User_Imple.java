package validation.icicibank.service;

import org.springframework.stereotype.Service;

import validation.icicibank.entity.User_Entity;
import validation.icicibank.repository.User_Repo;
@Service
public class User_Imple implements User_serv{
private User_Repo rep;

	public User_Imple(User_Repo rep) {
	
	this.rep = rep;
}

	@Override
	public User_Entity register(User_Entity ent) {
		
		return rep.save(ent);
	}

	@Override
	public String validate(String cardnumber) {
	    String cardType = getCardType(cardnumber);

        if (cardType != null) {
            boolean isValid = creditCardValid(cardnumber);

            if (isValid) {
                return "Card Type: " + cardType + " - Valid credit card number";
            } else {
                return "Card Type: " + cardType + " - Invalid credit card number";
            }
        } else {
            return "Unknown card type or Invalid credit card number";
        }
    }

    private String getCardType(String cardnumber) {
    	
		if (cardnumber.length() == 15) {
			if ((cardnumber.startsWith("37")) || (cardnumber.startsWith("34"))) {
				return "American Express";
			} else if ((cardnumber.startsWith("2123")) || (cardnumber.startsWith("1800"))) {
				return "JCB";
			}
		} else if ((cardnumber.length() == 16) || (cardnumber.length() == 13)) {
			if ((cardnumber.startsWith("51")) || (cardnumber.startsWith("52")) || (cardnumber.startsWith("53"))
					|| (cardnumber.startsWith("54")) || (cardnumber.startsWith("55"))) {
				return "Master Card";
			} else if (cardnumber.startsWith("3")) {
				return "JCB";
			} else if (cardnumber.startsWith("4")) {
				return "Visa";
			} else if (cardnumber.startsWith("6011")) {
				return "Discover";
			} else if ((cardnumber.startsWith("60")) || (cardnumber.startsWith("6521"))
					|| (cardnumber.startsWith("6522"))) {
				return "Rupay Card";
			}
		} else if (cardnumber.length() == 14) {
			if ((cardnumber.startsWith("36")) || (cardnumber.startsWith("38")) || (cardnumber.startsWith("300"))
					|| (cardnumber.startsWith("301")) || (cardnumber.startsWith("302"))
					|| (cardnumber.startsWith("303")) || (cardnumber.startsWith("304"))
					|| (cardnumber.startsWith("305"))) {
				return "Diners club and Carte blanche";
			}
			}
        return null;
		}
		

    private boolean creditCardValid(String cardnumber) {
        char ch[] = cardnumber.toCharArray();
        int d[] = new int[ch.length / 2];
        int r[] = new int[d.length];

        int j = 0;
        for (int i = ch.length - 2; i >= 0; i -= 2) {
            d[j++] = (ch[i] - 48) * 2;
        }

        int k = 0;
        for (int i = 1; i <= ch.length; i += 2) {
            r[k++] = (ch[i] - 48);
        }

        int s1 = 0;
        for (int i = 0; i < d.length; i++) {
            int r1 = d[i] % 10;
            int d1 = d[i] / 10;
            s1 += d1 + r1;
        }

        int s2 = 0;
        for (int i = 0; i < r.length; i++) {
            s2 += r[i];
        }

        int sol = s1 + s2;

        return sol % 10 == 0;
    }

	}


