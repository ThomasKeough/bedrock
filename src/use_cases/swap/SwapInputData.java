package use_cases.swap;

public class SwapInputData {
    //TODO: review thomas' PR and add import statements for the Pokemon entities

    final private Pokemon active_pokemon;
    final private Pokemon target_pokemon; // the pokemon that the user wants to swap to

    // TODO: add constructor

    Pokemon getActive_pokemon() { return this.active_pokemon; }

    Pokemon getTarget_pokemon() { return this.target_pokemon; }

}
