package model.transporters;

import model.ability_management.ability.Ability;
import model.ability_management.ability.move_abilities.MovementAbilities;
import model.ability_management.ability_set.AbilitySet;
import model.map.tile.nodeRepresentation.nodes.Node;
import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;
import model.phase.observers.PhaseObserver;
import model.player.Player;
import model.resources.Resource;
import model.resources.TransportStorage;
import model.resources.resourceVisitor.AddResourceVisitor;
import model.resources.resourceVisitor.InnerResourceVisitor;
import model.resources.resourceVisitor.RemoveResourceVisitor;
import model.resources.resourceVisitor.ResourceVisitor;

import java.util.List;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public abstract class Transporter implements PhaseObserver, MovementAbilities {
    private TransporterID transporterID;
    private Player owner;
    private TransportStorage resources;
    private Transporter transporterCargo;
    private ParentNode parentNode;
    private AbilitySet abilitySet;
    private int movementSpeed;


    public Transporter(Player owner, ParentNode parentNode, int capacity, int movementSpeed) {
        this.transporterID = new TransporterID();
        this.owner = owner;
        this.resources = new TransportStorage(capacity);
        this.transporterCargo = null;
        this.parentNode = parentNode;
        this.movementSpeed = movementSpeed;
        this.abilitySet = new AbilitySet();
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

    public TransportStorage getResources() {
        return resources;
    }

    public void setResources(TransportStorage resources) {
        this.resources = resources;
    }

    public Transporter getTransporterCargo() {
        return transporterCargo;
    }

    public void setTransporterCargo(Transporter transporterCargo) {
        this.transporterCargo = transporterCargo;
    }

    public ParentNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(ParentNode parentNode) {
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


    public boolean equals(Transporter t) {
        return this.toString().equals(t.toString());
    }


    @Override
    public void onTradePhaseStart() {

    }

    @Override
    public void onProductionPhaseStart() {

    }

    @Override
    public void onBuildPhaseStart() {

    }

    @Override
    public void onMovementPhaseStart() {
        updateMovementAbilitySet();
    }

    @Override
    public void onWonderPhaseStart() {

    }

    public abstract void updateMovementAbilitySet();

    @Override
    public void moveNorth() {
        setParentNode(getParentNode().getChildNodesOnFace(1).get(0).getNeighboringTileChild().getParentNode());
        updateMovementAbilitySet();
    }

    @Override
    public void moveNorthEast() {
        setParentNode(getParentNode().getChildNodesOnFace(2).get(0).getNeighboringTileChild().getParentNode());
        updateMovementAbilitySet();
    }

    @Override
    public void moveNorthWest() {
        setParentNode(getParentNode().getChildNodesOnFace(6).get(0).getNeighboringTileChild().getParentNode());
        updateMovementAbilitySet();
    }

    @Override
    public void moveNorthRight() {
        setParentNode(getParentNode().getChildNodesOnFace(1).get(1).getNeighboringTileChild().getParentNode());
        updateMovementAbilitySet();
    }

    @Override
    public void moveNorthLeft() {
        setParentNode(getParentNode().getChildNodesOnFace(1).get(-1).getNeighboringTileChild().getParentNode());
        updateMovementAbilitySet();
    }

    @Override
    public void moveNorthEastLeft() {
        setParentNode(getParentNode().getChildNodesOnFace(2).get(-1).getNeighboringTileChild().getParentNode());
        updateMovementAbilitySet();

    }

    @Override
    public void moveNorthEastRight() {
        setParentNode(getParentNode().getChildNodesOnFace(2).get(1).getNeighboringTileChild().getParentNode());
        updateMovementAbilitySet();
    }

    @Override
    public void moveNorthWestLeft() {
        setParentNode(getParentNode().getChildNodesOnFace(6).get(-1).getNeighboringTileChild().getParentNode());
        updateMovementAbilitySet();
    }

    @Override
    public void moveNorthWestRight() {
        setParentNode(getParentNode().getChildNodesOnFace(6).get(1).getNeighboringTileChild().getParentNode());
        updateMovementAbilitySet();
    }

    @Override
    public void moveSouth() {
        setParentNode(getParentNode().getChildNodesOnFace(4).get(0).getNeighboringTileChild().getParentNode());
        updateMovementAbilitySet();

    }

    @Override
    public void moveSouthEast() {
        setParentNode(getParentNode().getChildNodesOnFace(3).get(0).getNeighboringTileChild().getParentNode());
        updateMovementAbilitySet();

    }

    @Override
    public void moveSouthWest() {
        setParentNode(getParentNode().getChildNodesOnFace(5).get(0).getNeighboringTileChild().getParentNode());
        updateMovementAbilitySet();
    }

    @Override
    public void moveSouthRight() {
        setParentNode(getParentNode().getChildNodesOnFace(4).get(1).getNeighboringTileChild().getParentNode());
        updateMovementAbilitySet();

    }

    @Override
    public void moveSouthLeft() {
        setParentNode(getParentNode().getChildNodesOnFace(4).get(-1).getNeighboringTileChild().getParentNode());
        updateMovementAbilitySet();
    }

    @Override
    public void moveSouthEastLeft() {
        setParentNode(getParentNode().getChildNodesOnFace(3).get(-1).getNeighboringTileChild().getParentNode());
        updateMovementAbilitySet();
    }

    @Override
    public void moveSouthEastRight() {
        setParentNode(getParentNode().getChildNodesOnFace(3).get(1).getNeighboringTileChild().getParentNode());
        updateMovementAbilitySet();
    }

    @Override
    public void moveSouthWestLeft() {
        setParentNode(getParentNode().getChildNodesOnFace(5).get(-1).getNeighboringTileChild().getParentNode());
        updateMovementAbilitySet();
    }

    @Override
    public void moveSouthWestRight() {
        setParentNode(getParentNode().getChildNodesOnFace(5).get(1).getNeighboringTileChild().getParentNode());
        updateMovementAbilitySet();
    }

    public void pickupFromNode(InnerResourceVisitor visitor) {
        ((ParentLandNode)parentNode).acceptResourceVisitor(new RemoveResourceVisitor(visitor));
        resources.accept(new AddResourceVisitor(visitor));
    }

    public void dropOffFromNode(InnerResourceVisitor visitor) {
        resources.accept(new RemoveResourceVisitor(visitor));
        ((ParentLandNode)parentNode).acceptResourceVisitor(new AddResourceVisitor(visitor));
    }
}
