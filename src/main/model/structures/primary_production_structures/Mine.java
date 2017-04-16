package model.structures.primary_production_structures;

import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;
import model.resources.*;
import model.structures.ProductionStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class Mine extends PrimaryProduction{

    private ArrayList<Gold> goldList = new ArrayList<>();
    private List<Iron> ironList = new ArrayList<>();

    public Mine(ParentNode parentNode) {
        super(parentNode);
        addShaft();
    }

    @Override
    public void produce(TileStorage resourceStorage){
        if(goldList.isEmpty() && ironList.isEmpty())
            return;
        else if(goldList.isEmpty())
            resourceStorage.addIron(mineIron());
        else if(ironList.isEmpty())
            resourceStorage.addGold(mineGold());
        else{
            Random random = new Random();
            if(random.nextBoolean())
                resourceStorage.addIron(mineIron());
            else
                resourceStorage.addGold(mineGold());
        }
    }

    public void addShaft(){
        for(int i = 0; i < 3; i++){
            goldList.add(new Gold());
            ironList.add(new Iron());
        }
    }

    public void addBigShaft(){
        for(int i = 0; i < 5; i++){
            goldList.add(new Gold());
            ironList.add(new Iron());
        }
    }

    public void addSpecializedGoldShaft(){
        for(int i = 0; i < 4; i++){
            goldList.add(new Gold());
        }
    }

    public void addSpecializedIronShaft(){
        for(int i = 0; i < 4; i++){
            ironList.add(new Iron());
        }
    }

    public String prospectMine(){
        return "Gold: " + goldList.size() + " Iron: " + ironList.size();
    }

    private Iron mineIron(){
        Iron iron = ironList.get(0);
        ironList.remove(0);
        return iron;
    }
    private Gold mineGold(){
        Gold gold = goldList.get(0);
        goldList.remove(0);
        return gold;
    }

}
