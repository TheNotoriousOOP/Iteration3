package model.transporters;

import model.ability_management.ability.Ability;
import model.ability_management.ability_set.AbilitySet;
import model.map.tile.nodeRepresentation.nodes.Node;
import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;
import model.player.Player;
import model.resources.Resource;

import java.util.List;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public abstract class Transporter {
    private TransporterID transporterID;
    private Player owner;
    private Resource[] resources;
    private Transporter transporterCargo;
    private Node parentNode;
    private AbilitySet abilitySet;
    private int movementSpeed;

    public Transporter(TransporterID transporterID, Player owner, Resource[] resources, Transporter transporterCargo, Node parentNode, AbilitySet abilitySet, int movementSpeed) {
        this.transporterID = transporterID;
        this.owner = owner;
        this.resources = resources;
        this.transporterCargo = transporterCargo;
        this.parentNode = parentNode;
        this.abilitySet = abilitySet;
        this.movementSpeed = movementSpeed;
    }

    public void move(ParentNode destination){
        //TODO implement
    }

    //TODO implement below
    //public void pickUpXXX()
    //public void dropOffXXX()

    public void pickUpTransporter(){
        //TODO implement
    }

    public void dropOffTransporter(){
        //TODO implement
    }

    public void determineValidAbilities(List<Ability> abilitiesFromTile){
        //TODO implement
    }

    public TransporterID getTransporterID() {
        return transporterID;
    }

    public void setTransporterID(TransporterID transporterID) {
        this.transporterID = transporterID;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Resource[] getResources() {
        return resources;
    }

    public void setResources(Resource[] resources) {
        this.resources = resources;
    }

    public Transporter getTransporterCargo() {
        return transporterCargo;
    }

    public void setTransporterCargo(Transporter transporterCargo) {
        this.transporterCargo = transporterCargo;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public AbilitySet getAbilitySet() {
        return abilitySet;
    }

    public void setAbilitySet(AbilitySet abilitySet) {
        this.abilitySet = abilitySet;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }
}
