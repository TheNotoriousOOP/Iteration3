package controller;

import model.ability_management.ability.Ability;
import model.wonder.wonder_abilities.WonderAbility;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Customer-PC on 4/14/2017.
 */
public class WonderPhaseController implements KeyListener{

    private HashMap<Integer, Runnable> keyMappingHash;
    private List<WonderAbility> abilityList;
    private AbilityScroller scroller;
    private class AbilityScroller {
        int itr = 0;

        void scrollUp() {
            itr++;
            if(itr >= abilityList.size())
                itr = 0;
        }

        void scrollDown() {
            itr--;
            if(itr < 0)
                itr = abilityList.size() - 1;
        }
    }

    public WonderPhaseController() {
        keyMappingHash = new HashMap<Integer, Runnable>(3);

        keyMappingHash.put(KeyEvent.VK_UP, new Runnable(){
            public void run() { scroller.scrollUp(); }
        });

        keyMappingHash.put(KeyEvent.VK_DOWN, new Runnable(){
            public void run() { scroller.scrollDown(); }
        });

        keyMappingHash.put(KeyEvent.VK_ENTER, new Runnable(){
            public void run() { //abilityList.get(scroller.itr).run();
                }
        });

        abilityList = new ArrayList<WonderAbility>(4);
        scroller = new AbilityScroller();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(keyMappingHash.containsKey(e.getKeyCode()))
            keyMappingHash.get(e.getKeyCode()).run();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void assignAbility(WonderAbility ability) {
        if(!abilityList.contains(ability))
            abilityList.add(ability);
    }

    public void unassignAbility(WonderAbility ability) {
        if(abilityList.contains(ability))
            abilityList.remove(ability);
    }
}
