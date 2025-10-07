 // Dana Sader

package bots;

import com.badlogic.gdx.math.Vector2;
import com.gats.manager.Bot;
import com.gats.manager.Controller;
import com.gats.simulation.GameCharacter;
import com.gats.simulation.GameState;
import com.gats.simulation.Tile;
import com.gats.simulation.WeaponType;
import com.gats.simulation.campaign.CampaignResources;
import com.gats.ui.menu.buttons.TeamAmountSlider;
import java.util.ArrayList;
import java.util.LinkedList;
import static java.lang.Float.*;

public class MyBot extends Bot {

    /**
     * Enter your name here
     *
     * @return Format: First name Last name
     */
    @Override
    public String getStudentName() {
        return "Dana Sader";
    }

    /**
     * Here you enter your registration number
     *
     * @return your registration number
     */
    @Override
    public int getMatrikel() {
        return 231981;
    }

    /**
     * Here you can give your bot a (creative) name
     *
     * @return Name of the bot
     */
    @Override
    public String getName() {
        return "smileyminion/beepboop";
    }

    float px;             // Position
    float py;
    float vx = 0.0f;       // Velocity
    float vy = 0.0f;
    float ax = 0.0f;        // Acceleration
    float ay = 0.0f;
    float friction = 0.0f;       // Friction
    boolean CheckStablility = false;   // the bot stopped moving
    WeaponType currentWeapon;
    boolean Aimleft = false;    // aim to the left
    boolean Aimright = false;   // aim to the right
    boolean Shoot = false;      //shoot
    float TargetAngle = 0.0f;       // the angle which the bot should aim for
    float TargetStrength = 0.0f;    // the Strength level which the bot should aim for
    float SafeXPosition = 0.0f;    // X-Coordinate considered safe for the bot and moves to that direction
    float TargetXWeapon = 0.0f;    // X-Coordinate of target weapon location
    float TargetYWeapon = 0.0f;    // Y-Coordinate of target weapon location
    boolean ShootWeapon = false;
    float StrengthLevel = 0.0f;
    float ResponseXVector = 0;
    float ResponseYVector = 0;
    boolean CheckCollision1 = false;
    float ShootAngle = 1.0f;
    float NearestDistance = POSITIVE_INFINITY;
    float Direction = 0.0f;
    float fTurnTime = 0.0f;
    public ArrayList<Tile> healthBoxes = new ArrayList<>();
    ArrayList<Tile> Tile = new ArrayList<>();


    public void ChooseReaction() {

        int act = (int) (Math.random() * 3);
        if (px < NearestDistance) {
            NearestDistance = px;
            Direction = px < 0.0f ? 1.0f : -1.0f;
        }
        if (NearestDistance < 16.0f) {
            SafeXPosition = px + Direction;
        } else {
            SafeXPosition = px;
        }

        // bot moves to the middle
        if (act == 1) {
            float Direction1;
            if (px < 0.0f) {
                Direction1 = -1.0f;
            } else {
                Direction1 = 1.0f;
                SafeXPosition = px + Direction1;
            }
        }
        if (act == 2) {

            // bot does not move
            SafeXPosition = px;
        }
    }

    public void move() {

        if (px != SafeXPosition) {

            // bot moves to the target until it is in range of the enemy team member
            if (SafeXPosition < px) {
                ShootAngle = -1.0f;
            }
            if (SafeXPosition > px) {
                ShootAngle = 1.0f;
            }
        }
    }

    public Vector2 PositionAtTarget(Vector2 myposition, Vector2 Targetpos) {

        float dy = Targetpos.y - myposition.y;
        float dx = Targetpos.x - myposition.x;
        float Speed = 30.0f;
        float Gravity1 = 2.0f;
        if (dy < 0 || dy > 16)
            Targetpos.y += 16;
        dy = Targetpos.y - myposition.y;
        float a = Speed * Speed * Speed * Speed - Gravity1 * (Gravity1 * dx * dx + 2.0f * dy * Speed * Speed);
        float t = Speed * Speed + (float) Math.sqrt(a);
        float Angle11 = (float) Math.atan(t / (Gravity1 * dx));
        float Degree = (float) Math.toDegrees(Angle11);

        if (a < 0) {
            // the target is out of the range
            if (fTurnTime >= 1.0f) {

                // Walk towards target until it is in range
                if (px < 0) {
                    Degree = 3.14f * 0.6f;
                } else if (px > 0) {
                    Degree = 3.14f * 0.4f;
                }
            }
        }
        return dx < 0 ? new Vector2(-1, 0).rotateDeg(Degree) : new Vector2(1, 0).rotateDeg(Degree);
    }
    public void AimAtTarget() {
        Aimleft = false;
        Aimright = false;
        if (ShootAngle < TargetAngle) {
            Aimright = true;
        } else {
            Aimleft = true;
        }
    }
    public void ShootMethod() {

        Shoot = true;
        ShootWeapon = false;
        if (StrengthLevel >= TargetStrength) {
            ShootWeapon = true;
            Shoot = false;
            //Weapon Direction
            float dx = (float) Math.cos(ShootAngle);
            float dy = (float) Math.sin(ShootAngle);
        }
    }
    public void SetCurrentWeapon(WeaponType Weapon) {
        this.currentWeapon = Weapon;
    }
    public WeaponType GetCurrentWeapon() {
        return this.currentWeapon;
    }
    private final LinkedList<WeaponType> weaponList = new LinkedList<>();
    public LinkedList<WeaponType> GetAllAvailableWeapons() {
        return this.weaponList;
    }
    public void GetNextWeapon() {
        LinkedList<WeaponType> weaponList = this.GetAllAvailableWeapons();
        int index = weaponList.indexOf(this.GetCurrentWeapon());
        if (index + 1 >= weaponList.size()) {
            this.SetCurrentWeapon(weaponList.getFirst());
        } else {
            this.SetCurrentWeapon(weaponList.get(index + 1));
        }
    }
    public ArrayList<Tile> findBoxType(GameState stategame1, Tile.TileType TileType) {

        for (int i = 0; i < stategame1.getBoardSizeX(); i++) {
            for (int j = 0; j < stategame1.getBoardSizeY(); j++) {
                if (stategame1.getTile(i, j) != null)
                    if (stategame1.getTile(i, j).getTileType() == TileType)
                        Tile.add(stategame1.getTile(i, j));
            }
        }
        return Tile;
    }
    public Vector2 getHealthBox(GameState stategame, Vector2 pos1) {
        healthBoxes = findBoxType(stategame, com.gats.simulation.Tile.TileType.HEALTH_BOX);
        Tile nearest = healthBoxes.get(0);
        float n = Float.MAX_VALUE;
        for (Tile t : healthBoxes) {
            float d = Math.abs(t.getWorldPosition().sub(pos1.cpy()).len());
            if (d < n) {
                n = d;
                nearest = t;
            }
        }
        return nearest.getWorldPosition();
    }

    /**
     * This method is called when the map is loaded. Ideal for initializing values if necessary.
     *
     * @param state The {@link GameState game state} at the start of the game
     */
    @Override
    protected void init(GameState state) {

        state.getGameMode();
        state.getScores();
        // System.out.println("it's a smileyminion, just a beepboop...booboop");
    }

    /**
     * This method describes the move your Gadse makes
     *
     * @param state      The {@link GameState game state} during the turn -> Game information
     * @param controller The {@link Controller Controller} belongs to the character whose turn it is -> Character Control
     */

    @Override
    protected void executeTurn(GameState state, Controller controller) {

        int enemyteams = controller.getGameCharacter().getTeam();
        for (int i = 0; i < state.getTeamCount(); i++) {
            if (i != enemyteams) {
                for (int j = 0; j < state.getCharactersPerTeam(); j++) {
                    GameCharacter mycharacter = state.getCharacterFromTeams(i, j);

                    if (mycharacter.isAlive()) {
                        Vector2 p = new Vector2(-16, 0);
                        float scaleFactor = (float) (Math.random() * 85 + 5); // Random number between 5 and 90
                        p.scl(scaleFactor); // Scales the vector p by the generated scaling factor
                        controller.aim(p, 1.0f);
                        controller.shoot(p, 1.0f, WeaponType.WATER_PISTOL);

                    } else if (state.isActive()) {
                        float angle = (float) Math.random() * 180;
                        controller.aim(angle,1.0f);
                        controller.shoot();
                    }
                    return;
                }
                if(controller.getGameCharacter().getHealth() != 100){
                    float angle = (float) Math.random() * 180;
                    controller.selectWeapon(WeaponType.WATER_PISTOL);
                    controller.aim(angle,1.0f);
                    controller.shoot();
                }
                return;
            }
        }
    }
}