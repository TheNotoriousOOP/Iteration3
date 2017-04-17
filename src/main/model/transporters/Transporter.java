package model.transporters;

import model.ability_management.AbilitySubject;
import model.ability_management.ability.Ability;
import model.ability_management.ability.build_abilities.road.RoadBuildingAbilities;
import model.ability_management.ability.move_abilities.MovementAbilities;
import model.ability_management.ability_set.AbilitySet;
import model.map.tile.nodeRepresentation.nodes.child.ChildLandNode;
import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;
import model.phase.WonderPhaseMediator;
import model.phase.observers.PhaseObserver;
import model.player.Player;
import model.research.PlayerResearchSettings;

import view.renderer.MapRenderer;

import model.resources.TransportStorage;
import model.resources.resourceVisitor.AddResourceVisitor;
import model.resources.resourceVisitor.InnerResourceVisitor;
import model.resources.resourceVisitor.RemoveResourceVisitor;


import java.util.List;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public abstract class Transporter extends AbilitySubject implements PhaseObserver, MovementAbilities, RoadBuildingAbilities {
    private TransporterID transporterID;
    private Player owner;
    private PlayerResearchSettings settings;
    private TransportStorage resources;
    private Transporter transporterCargo;
    private ParentNode parentNode;
    private AbilitySet abilitySet;
    private int movementSpeed;


    public Transporter(Player owner, ParentNode parentNode, int capacity, int movementSpeed) {
        this.transporterID = new TransporterID();
        this.owner = owner;
        this.settings = owner.getResearchSettings();
        this.resources = new TransportStorage(capacity);
        this.transporterCargo = null;
        this.parentNode = parentNode;
        this.movementSpeed = movementSpeed;
        this.abilitySet = new AbilitySet();
    }

    public abstract void render(MapRenderer r);



    public void pickUpTransporter(){
        //TODO implement
    }

    public void dropOffTransporter(){
        //TODO implement
    }



    public TransporterID getTransporterID() {
        return transporterID;
    }

    public void setTransporterID(int newID) {
        this.transporterID.setUniqueID(newID);
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
        System.out.println("class: Transporter " + toString() + " is updating ability set to: " + abilitySet.toString());
        this.abilitySet = abilitySet;
        notifyObservers();
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }



    @Override
    public void onTradePhaseStart() {
        abilitySet = getParentNode().getNodeStorageAbility();
        abilitySet.appendToValidAbility(resources.getAllAbilities());
        abilitySet.addActorToSet(this);
        setAbilitySet(abilitySet);
    }

    @Override
    public void onProductionPhaseStart() {

    }

    @Override
    public void onBuildPhaseStart() {
        updateBuildAbilitySet();
    }

    @Override
    public void onMovementPhaseStart() {
        updateMovementAbilitySet();
        abilitySet.appendToValidAbility(resources.getAllAbilities());
        abilitySet.addActorToSet(this);
    }


    @Override
    public void onWonderPhaseStart(WonderPhaseMediator mediator) {
        updateWonderAbilitySet(mediator.generateAbilitySet(owner));
    }

    public abstract void updateMovementAbilitySet();


    public void updateBuildAbilitySet(){
        abilitySet = parentNode.getBuildRoadAbilitySet();
        abilitySet.appendToValidAbility(parentNode.getBuildAbility());
        abilitySet.addActorToSet(this);
        setAbilitySet(abilitySet);

    }

    public void updateWonderAbilitySet(AbilitySet wonderAbilitySet) {
        if(owner.getStartingLocation() == parentNode)
            setAbilitySet(wonderAbilitySet);
        else
            setAbilitySet(new AbilitySet());
    }

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

        abilitySet = getParentNode().getNodeStorageAbility();
        abilitySet.appendToValidAbility(resources.getAllAbilities());
        abilitySet.addActorToSet(this);
    }

    public void dropOffFromNode(InnerResourceVisitor visitor) {
        resources.accept(new RemoveResourceVisitor(visitor));
        ((ParentLandNode)parentNode).acceptResourceVisitor(new AddResourceVisitor(visitor));

        abilitySet = getParentNode().getNodeStorageAbility();
        abilitySet.appendToValidAbility(resources.getAllAbilities());
        abilitySet.addActorToSet(this);
    }


    @Override
    public void buildRoadNorth() {
        ((ParentLandNode)parentNode).buildRoad((ChildLandNode) parentNode.getChildNodesOnFace(1).get(0));

    }

    @Override
    public void buildRoadNorthEast() {
        ((ParentLandNode)parentNode).buildRoad((ChildLandNode)parentNode.getChildNodesOnFace(2).get(0));
    }

    @Override
    public void buildRoadNorthWest() {
        ((ParentLandNode)parentNode).buildRoad((ChildLandNode)parentNode.getChildNodesOnFace(6).get(0));
    }

    @Override
    public void buildRoadNorthRight() {
        ((ParentLandNode)parentNode).buildRoad((ChildLandNode)parentNode.getChildNodesOnFace(1).get(1));
    }

    @Override
    public void buildRoadNorthLeft() {
        ((ParentLandNode)parentNode).buildRoad((ChildLandNode)parentNode.getChildNodesOnFace(1).get(-1));
    }

    @Override
    public void buildRoadNorthEastLeft() {
        ((ParentLandNode)parentNode).buildRoad((ChildLandNode)parentNode.getChildNodesOnFace(2).get(-1));
    }

    @Override
    public void buildRoadNorthEastRight() {
        ((ParentLandNode)parentNode).buildRoad((ChildLandNode)parentNode.getChildNodesOnFace(2).get(1));
    }

    @Override
    public void buildRoadNorthWestLeft() {
        ((ParentLandNode)parentNode).buildRoad((ChildLandNode)parentNode.getChildNodesOnFace(6).get(-1));
    }

    @Override
    public void buildRoadNorthWestRight() {
        ((ParentLandNode)parentNode).buildRoad((ChildLandNode)parentNode.getChildNodesOnFace(6).get(1));
    }

    @Override
    public void buildRoadSouth() {
        ((ParentLandNode)parentNode).buildRoad((ChildLandNode)parentNode.getChildNodesOnFace(4).get(0));
    }

    @Override
    public void buildRoadSouthEast() {
        ((ParentLandNode)parentNode).buildRoad((ChildLandNode)parentNode.getChildNodesOnFace(3).get(0));
    }

    @Override
    public void buildRoadSouthWest() {
        ((ParentLandNode)parentNode).buildRoad((ChildLandNode)parentNode.getChildNodesOnFace(5).get(0));
    }

    @Override
    public void buildRoadSouthRight() {
        ((ParentLandNode)parentNode).buildRoad((ChildLandNode)parentNode.getChildNodesOnFace(4).get(1));
    }

    @Override
    public void buildRoadSouthLeft() {
        ((ParentLandNode)parentNode).buildRoad((ChildLandNode)parentNode.getChildNodesOnFace(4).get(-1));
    }

    @Override
    public void buildRoadSouthEastLeft() {
        ((ParentLandNode)parentNode).buildRoad((ChildLandNode)parentNode.getChildNodesOnFace(3).get(-1));
    }

    @Override
    public void buildRoadSouthEastRight() {
        ((ParentLandNode)parentNode).buildRoad((ChildLandNode)parentNode.getChildNodesOnFace(3).get(1));
    }

    @Override
    public void buildRoadSouthWestLeft() {
        ((ParentLandNode)parentNode).buildRoad((ChildLandNode)parentNode.getChildNodesOnFace(5).get(-1));
    }

    @Override
    public void buildRoadSouthWestRight() {
        ((ParentLandNode)parentNode).buildRoad((ChildLandNode)parentNode.getChildNodesOnFace(5).get(1));
    }

    public List<String> getResourcesStringOnNode() {
        return parentNode.getResourcesStringOnNode();
    }

    public List<String> getResourcesString() {
        return resources.getResourceStrings();
    }

}
