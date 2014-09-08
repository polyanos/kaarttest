/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wixoss.domain.card;

/**
 *
 * @author Gregor
 */
public class CardType
{

    private String name;
    private String description;
    private String[] allowedFields; //Allowed positions on the playing board (like your hand or the enerzone).
    private String[] allowedDecks; //Allowed containers (mostly called decks) where the can be a part off.

    /**
     *
     * @param name
     * @param description
     * @param allowedFields
     * @param allowedDecks
     */
    public CardType(String name, String description, String[] allowedFields, String[] allowedDecks)
    {
        this.name = name;
        this.description = description;
        this.allowedFields = allowedFields;
        this.allowedDecks = allowedDecks;

    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public String[] getAllowedFields()
    {
        return allowedFields;
    }

    public String[] getAllowedDecks()
    {
        return allowedDecks;
    }

}
