/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wixoss.business;

import java.util.List;
import wixoss.data.CardReader;
import wixoss.domain.card.Card;

/**
 *
 * @author Gregor
 */
public class CardControl
{

    List<Card> wixossCards;

    public CardControl()
    {
        loadCards();
    }
    
    private void loadCards()
    {
        //reader.loadCards("C:\\\\cards.xml", this); //TODO:Filepath naar een extern bestand plaatsen.
    }
}
