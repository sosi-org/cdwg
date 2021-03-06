package sboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


//@Component("TheGame") //Requires a default constructor
public class GameInstance {

    /*
    This actually should be done in a @Configuration
    @Value("${graph.shape}")
    public static GameInstance createGameInstance(String graphShape) {
        GameInstance g= new GameInstance(graphShape);
        g.simple();
        return g;
    }
    */

    //temporary
    //@
    // ensures
    // this.players.size()>=1
    public void simple() { //(long uid, UserState us){

        UserState us = new UserState("John");
        this.players.put(7L, us);

        this.players.put(8L, new UserState("Jack"));

        assert this.players.size() == 2;

    }

    //UserState is for this game. A user (a UserEntity) can have more than one UserState when more tha one game is being played.
    //UserState =1:1= (UserEntity x GameInstance)
    //private ArrayList<UserState> players;
    private Map<Long,UserState> players;

    //@Value("${graph.shape}") Cannot be used for constructors
    public GameInstance(String graphShape) {
        assert graphShape.equals("clique");
        //graphShape is/defines the allocation strategy
        //players.add();
        this.players = new HashMap<>(); //new HashMap<Long,UserState>();
        //new Hashtable<>();
        //new HashMap<>();
        // new ArrayList<>();
        //new WeakReferenceMap<>()
    }


    //UserState.newJoins


    /*
    public void playerJoins(UserEntity ue){
        //public playerJoins(UserState us){
        //UserState us = null;
        //this.players.add(us);
        UserState us = new UserState(ue); //Generates the first and only instance for this ue.
        this.players.add(us);
    }
    */

    /*
    Candidate properties:
        setName()
        getDate() //TimeStarted
    */

    //Problem: UserState (e.g. in getUserSpace) is also called Player (e.g. in getPlayerCount) :inconsistency in names.
    public UserState getUserState(Long uid){
        //assert uid==7;
        //assert this.players.size()==1; //Works only in this case
        //return this.players.get(0);
        return this.players.get(uid); //why is get(arg : Object)?
    }

    public int getPlayerCount(){
        return this.players.size();
    }

    public Collection<UserState> getPlayers() {
        //getFirstPlayerName(){
        return this.players.values();
    }

    public UserState getPlayer(long uid){
        return this.players.get(uid);
    }
}


//String name, String phoneno