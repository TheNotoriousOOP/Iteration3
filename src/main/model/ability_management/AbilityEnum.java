package model.ability_management;

/**
 * A collection of all possible abilities
 * Enumerated with a string for parsing and view purposes
 */
public enum AbilityEnum {

    MOVE_NORTH           ("Move North"),
    MOVE_NORTHLEFT       ("Move North Left"),
    MOVE_NORTHRIGHT      ("Move North Right"),

    MOVE_SOUTH           ("Move South"),
    MOVE_SOUTHLEFT       ("Move South Left"),
    MOVE_SOUTHRIGHT      ("Move South Right"),

    MOVE_NORTHWEST       ("Move NorthWest"),
    MOVE_NORTHWESTLEFT   ("Move NorthWest Left"),
    MOVE_NORTHWESTRIGHT  ("Move NorthWest Right"),

    MOVE_NORTHEAST       ("Move NorthEast"),
    MOVE_NORTHEASTLEFT   ("Move NorthEast Left"),
    MOVE_NORTHEASTRIGHT  ("Move NorthEast Right"),

    TRADE_TRANSPORT      ("Trade with Transport"),
    TRADE_TILE           ("Trade with the Tile"),

    BUILD_WAGON             ("Build A Wagon"),
    BUILD_TRUCK             ("Build A Truck"),
    BUILD_RAFT              ("Build A Raft"),
    BUILD_ROWBOAT           ("Build A Rowboat"),
    BUILD_STEAMBOAT         ("Build A Steamboat"),
    SCUTTLE_TRANSPORTER     ("Destroy This Transporter"),
    BREED_DONKEY            ("Breed A Donkey"),

    RESEARCH                   ("Perform Research"),

    UPGRADE_WAGON_FACTORY      ("Upgrade A Wagon Factory"),
    UPGRADE_RAFT_FACTORY       ("Upgrade A Raft Factory"),
    UPGRADE_ROWBOAT_FACTORY    ("Upgrade A Rowboat Factory"),

    INPUT_RESOURCES             ("Input Resources To A Secondary Producer"),
    DROP_RESOURCES              ("Drop Off Resources On Tile"),
    PICK_UP_RESOURCES           ("Pick Up Resources From Tile"),
    PICK_UP_TRANSPORTER         ("Pick Up Transporter From Tile"),

    BUILD_CLAY_PIT              ("Build A Clay Pit"),
    BUILD_QUARRY                ("Build A Quarry"),
    BUILD_MINE                  ("Build A Mine"),
    BUILD_OIL_RIG               ("Build An Oil Rig"),
    BUILD_SAWMILL               ("Build A Sawmill"),
    BUILD_MINT                  ("Build A Mint"),
    BUILD_STOCK_MARKET          ("Build A Stock Market"),

    BUILD_WAGON_FACTORY         ("Build A Wagon Factory"),
    BUILD_TRUCK_FACTORY         ("Build A Truck Factory"),
    BUILD_RAFT_FACTORY          ("Build A Raft Factory"),
    BUILD_ROWBOAT_FACTORY       ("Build A Rowboat Factory"),
    BUILD_STEAMBOAT_FACTORY     ("Build A Steamboat Factory"),

    BUILD_WALL                  ("Make America Great Again"),
    DESTROY_WALL                ("Destroy A Wall"),
    STRENGTHEN_WALL             ("Strengthen A Wall"),

    BUILD_MINE_SHAFT            ("Build A Mine Shaft"),
    BUILD_ROAD                  ("Build A Road"),
    BUILD_BRIDGE                ("Build A Bridge"),

    BUILD_WONDER_BRICK          ("Build A Wonder Brick");

    // GUI description for each ability
    private final String description;

    // Constructor
    AbilityEnum(final String s) {
        this.description = s;
    }

    // Return the ability description
    public String getDescription() { return this.description; }


}
