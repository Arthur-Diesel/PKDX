package br.com.pokedex;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

public class View {
    public void showWelcome(){
        System.out.println("--------------------------------");
        System.out.println("| Olá, Bem vindo à Pokédex!    |");
        System.out.println("--------------------------------");   
    }
    public void showOptions(){
        System.out.println("--------------------------------");
        System.out.println("|                              |");
        System.out.println("| Para continuar, informe o    |");
        System.out.println("| código de uma das opções     |");
        System.out.println("| abaixo.                      |");
        System.out.println("|                              |");
        System.out.println("| 1: Lista os Pokémons;        |");
        System.out.println("|                              |");
        System.out.println("| 2: Informa os detalhes de um |");
        System.out.println("| Pokémon específico.          |");
        System.out.println("|                              |");
        System.out.println("| 3: Mostra as opções.         |");
        System.out.println("|                              |");
        System.out.println("| 4: Encerra o programa.       |");
        System.out.println("|                              |");
        System.out.println("--------------------------------");
    }
    public void showError(JSONException error){
        System.out.println("\n");
        System.out.println("--------------------------------");
        System.out.println("|" + error  + "|");
        System.out.println("--------------------------------");   
        System.out.println("\n");
    }

    public void showPokemons(JSONObject pokemons){
        System.out.println("--------------------------------");
        System.out.println("| Pokémons:");
        try{
            JSONArray pokemonArrays = pokemons.getJSONArray("results");
            for (int n = 0; n < pokemonArrays.length(); n++) {
                JSONObject pokemonObject = pokemonArrays.getJSONObject(n);
                String pokemonName = pokemonObject.getString("name");
                String url = pokemonObject.getString("url");
                String id = url.replace("https://pokeapi.co/api/v2/pokemon/", "");
                id = id.replace("/", "");
                System.out.println("| Name: " + pokemonName);
                System.out.println("| Id: " + id);
            }
        } catch(JSONException error){
            showError(error);
        }
        System.out.println("|");
        System.out.println("--------------------------------");
    }

    public void showStats(JSONArray stats){
        System.out.println("|");
        System.out.println("| Status:");
        for (int x = 0; x < stats.length(); x++) {
            try{
                JSONObject statsOverviewObject = stats.getJSONObject(x);
                JSONObject statsObject = statsOverviewObject.getJSONObject("stat");
                int statValue = statsOverviewObject.getInt("base_stat");
                String statName = statsObject.getString("name");
                System.out.println("| " + statName + ": " + statValue);
            } catch(JSONException error){
                showError(error);
            }
        }
        System.out.println("|");
    }
    public void showAbilities(JSONArray abilities){
        System.out.println("|");
        System.out.println("| Abilities:");
        for (int y = 0; y < abilities.length(); y++) {
            try{
                JSONObject abilitieOverviewObject = abilities.getJSONObject(y);
                JSONObject abilitieObject = abilitieOverviewObject.getJSONObject("ability");
                String abilitieName = abilitieObject.getString("name");
                System.out.println("| Name: " + abilitieName);
            } 
            catch(JSONException error){
                showError(error);
            }
        }
        System.out.println("|");
    }
    public void showMoves(JSONArray moves){
        System.out.println("|");
        System.out.println("| Moves:");
        for (int z = 0; z < moves.length(); z++) {
            try{
                JSONObject moveOverViewObject = moves.getJSONObject(z);
                JSONObject moveObject = moveOverViewObject.getJSONObject("move");
                String moveName = moveObject.getString("name");
                System.out.println("| Name: " + moveName);
            } catch(JSONException error){
                showError(error);
            }
        }
        System.out.println("|");
    }
    public void showTypes(JSONArray types){
        System.out.println("|");
        System.out.println("| Types:");
        for(int v = 0; v < types.length(); v++){
            try{
                JSONObject typeObject = types.getJSONObject(v);
                JSONObject typeOverviewObject = typeObject.getJSONObject("type");
                String typeName = typeOverviewObject.getString("name");
                System.out.println("| Name: " + typeName);
            } catch(JSONException error){
                showError(error);
            }
        }
        System.out.println("|");
    }
    public void showPokemon(JSONObject pokemon){
        try {
            JSONArray typesArray = pokemon.getJSONArray("types");
            JSONArray statsArray = pokemon.getJSONArray("stats");
            JSONArray abilitiesArray = pokemon.getJSONArray("abilities");
            JSONArray movesArray = pokemon.getJSONArray("moves");
            String name = pokemon.getString("name");
            int height = pokemon.getInt("height");
            int weight = pokemon.getInt("weight");
            System.out.println("\n");
            System.out.println("--------------------------------");
            System.out.println("| Nome: " + name);
            System.out.println("| Altura: " + height);
            System.out.println("| Peso: " + weight);
            showStats(statsArray);
            showAbilities(abilitiesArray);
            showMoves(movesArray);
            showTypes(typesArray);
            System.out.println("|");
            System.out.println("--------------------------------");
            System.out.println("\n");
        } catch(JSONException error){
            showError(error);
        }
    }
}
