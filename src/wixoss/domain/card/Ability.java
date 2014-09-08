/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wixoss.domain.card;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Gregor
 */
public class Ability
{

    public static final int START_UP = 1;
    public static final int CONTINUING = 1;
    public static final int ACTION = 1;

    private boolean multiAbility;
    private boolean choiceAbility;
    private String abilityDescription;
    private int abilityType;
    private List<Effect[]> abilityEffects;
    private Map<String, Integer> abilityCost;

    /**
     *
     * @param multiAbility
     * @param choiceAbility
     * @param abilityDescription
     * @param abilityType
     * @param abilityEffects
     * @param abilityCost
     */
    public Ability(boolean multiAbility, boolean choiceAbility, String abilityDescription, int abilityType, List<Effect[]> abilityEffects, Map<String, Integer> abilityCost)
    {
        this.multiAbility = multiAbility;
        this.choiceAbility = choiceAbility;
        this.abilityDescription = abilityDescription;
        this.abilityType = abilityType;
        this.abilityEffects = abilityEffects;
        this.abilityCost = abilityCost;
    }
}
