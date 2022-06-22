package br.com.pokedex;
import java.util.Scanner;
import org.json.JSONObject;

public class App {
    public static void main(String[] args) throws Exception {

    View view = new View();        
    Controller controller = new Controller();
    view.showWelcome();
    view.showOptions();
    
    int opcao = 0;
    int offset = 20;
    int id = 0;
    int limit = 20;

    Scanner sc = new Scanner(System.in);
    Scanner offsetSc = new Scanner(System.in);
    Scanner idSc = new Scanner(System.in);
    Scanner limitSc = new Scanner(System.in);

    while(opcao != 4){
        System.out.print("Digite a opção: ");
        opcao = sc.nextInt();
        System.out.print("\n");
        switch(opcao){
            case 1:
                System.out.print("Digite a partir de qual pokémon você deseja visualizar: ");
                offset = offsetSc.nextInt();
                System.out.print("Digite quantos pokémons você deseja visualizar: ");
                limit = limitSc.nextInt();
                JSONObject pokemons = controller.getPokemons(offset, limit);
                view.showPokemons(pokemons);
                break;
            case 2:
                System.out.print("Digite o id do pokémon: ");
                id = idSc.nextInt();
                System.out.print("\n");
                JSONObject pokemon = controller.getPokemon(id);
                view.showPokemon(pokemon);
                break;
            case 3: 
                view.showOptions();
                break;
            case 4: 
                break;
        }
    }

    idSc.close();
    offsetSc.close();
    limitSc.close();
    sc.close();

    }
}
