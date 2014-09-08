/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wixoss.domain.card;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Gregor
 */
public abstract class Card implements ViewCard
{

    private int id; //Internal id
    private String cardId; //Official id
    private Map<String, String> values; //Contains every value of the card, the fornat is <String parameter, String value>.
    private List<Ability> abilities; //Contains all abilities of the card.
    private CardType cardType; //The cardtype of this card.
    private Image cardPic;

    /**
     *
     * @param id
     * @param cardId
     * @param values
     * @param abilities
     * @param cardType
     * @param imageFile
     */
    public Card(int id, String cardId, Map<String, String> values, List<Ability> abilities, CardType cardType, String imageFile)
    {
        this.id = id;
        this.cardId = cardId;
        this.values = values;
        this.abilities = abilities;
        this.cardType = cardType;

        try
        {
            cardPic = ImageIO.read(new File(imageFile));
        }
        catch (IOException ex)
        {
            cardPic = new BufferedImage(250, 350, BufferedImage.TYPE_3BYTE_BGR);
        }
    }

    public int getId()
    {
        return id;
    }

    public String getCardId()
    {
        return cardId;
    }

    public String getValue(String parameter) throws NoSuchFieldException
    {
        if (values.containsKey(parameter))
        {
            return values.get(parameter);
        }
        else
        {
            throw new NoSuchFieldException("The specified parameter cannot be found.");
        }
    }

    public List<Ability> getAbilities()
    {
        return abilities;
    }
    
    public CardType getCardType()
    {
        return cardType;
    }

    public String setValue(String parameter, String newValue) throws NoSuchFieldException
    {
        if (values.containsKey(parameter))
        {
            return values.put(parameter, newValue);
        }
        else
        {
            throw new NoSuchFieldException("The specified parameter cannot be found.");
        }
    }

    @Override
    public Image getCardPic()
    {
        return cardPic;
    }
}
