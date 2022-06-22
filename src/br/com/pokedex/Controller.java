package br.com.pokedex;
import org.json.JSONObject;
import br.com.pokedex.network.HTTPRequest;

public class Controller {
    public JSONObject getPokemons(int offset, int limit){
        JSONObject object = new HTTPRequest()
                .requestGetMethod("https://pokeapi.co/api/v2/pokemon?offset=" + offset + "&limit=" + limit);
        return object;
    }
    public JSONObject getPokemon(int id){
        JSONObject object = new HTTPRequest()
                .requestGetMethod("https://pokeapi.co/api/v2/pokemon/" + id);
        return object;
    }
}
