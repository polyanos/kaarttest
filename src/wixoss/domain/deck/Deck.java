/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wixoss.domain.deck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import wixoss.domain.card.Card;

/**
 *
 * @author Gregor
 */
public class Deck
{
    private String name;
    private Integer maxCards;
    private List<Card> cards;

    /**
     *
     * @param name
     * @param maxCards
     */
    public Deck(String name, Integer maxCards)
    {
        this.name = name;
        this.maxCards = maxCards;
        
    }
    
    public Card getCard(int index) throws IndexOutOfBoundsException
    {
        return cards.remove(index);
    }
    
    public Card viewCard(int index) throws IndexOutOfBoundsException
    {       
        return cards.get(index);
    }
    
    public List<Card> viewAllCards()
    {
        return cards;
    }
    
    public void addCard(Card card, int index) throws IndexOutOfBoundsException
    {
        cards.add(index, card);
    }
    
    public void addCards(List<Card> cardList, int index) throws IndexOutOfBoundsException
    {
        cards.addAll(index, cardList);
    }
}
