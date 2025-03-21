import logic.commands.Commands;

import commands.ByeCommand;
import commands.Command;
import commands.CommandResult;

import model.Ingredient;
import model.Recipe;
import model.catalogue.IngredientCatalogue;
import model.catalogue.RecipeCatalogue;

import ui.inputparser.Parser;
import ui.inputparser.Ui;

import java.util.Scanner;

public class KitchenCTRL {
    static IngredientCatalogue ingredientCatalogue = new IngredientCatalogue();
    static RecipeCatalogue recipeCatalogue = new RecipeCatalogue();

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        final String LOGO = """
                   .-.    .-.    .-.    .-.  .-.  .-"-.  .-.      .--.      .-.  .--.
                  <   |  <   |  <   |   | |  | |  | | |  | |      |()|     /  |  |  |
                   )  |   )  |   )  |   | |  | |  | | |  | |      |  |     |  |  |  |
                   )()|   )()|   )()|   |o|  | |  | | |  | |      |  |     |  |  |()|
                   )()|   )()|   )()|   |o|  | |  | | |  | |      |  |     |  |  |()|
                  <___|  <___|  <___|   |\\|  | |  | | |  | |      |  |     |  |  |__|
                   }  |   || |   =  |   | |  | |  `-|-'  | |      |  |     |  |  |   L
                   }  |   || |   =  |   | |  | |   /A\\   | |      |  |     |  |  |   J
                   }  |   || |   =  |   |/   | |   |H|   | |      |  |     |  |  |    L
                   }  |   || |   =  |        | |   |H|   | |     _|__|_    |  |  |    J
                   }  |   || |   =  |        | |   |H|   | |    | |   |    |  |  | A   L
                   }  |   || |   =  |        | |   \\V/   | |    | |   |     \\ |  | H   J
                   }  |   FF |   =  |        | |    "    | |    | \\   |      ,Y  | H A  L
                   }  |   LL |    = |       _F J_       _F J_   \\  `--|       |  | H H  J
                   }  |   LL |     \\|     /       \\   /       \\  `.___|       |  | H H A L
                   }  |   \\\\ |           J         L |  _   _  |              |  | H H U J
                   }  |    \\\\|           J         F | | | | | |             /   | U ".-'
                    } |     \\|            \\       /  | | | | | |    .-.-.-.-/    |_.-'
                     \\|                    `-._.-'   | | | | | |   ( (-(-(-( )
                                                     `-' `-' `-'    `-`-`-`-'
                """;

        System.out.println(LOGO);
        System.out.println("Welcome to KitchenCTRL!");



        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());

        System.out.flush();

        Command command;
        boolean done = false;
        do {
            String userCommandText = Ui.getUserCommand();
            command = new Parser().parseCommand(userCommandText);
            if (command instanceof ByeCommand) {
                CommandResult result = command.execute();
                done = true;
            } else {
                CommandResult result = command.execute(ingredientCatalogue);
                Ui.showResultToUser(result);
            }
        } while (!done);

        cwTest();
        // carltonTest();
    }

    public static void cwTest() {
        Ingredient egg = new Ingredient("Egg", 2);
        Ingredient whiteSugar = new Ingredient("White sugar", 2);
        Ingredient brownSugar = new Ingredient("Brown sugar", 2);
        Ingredient sugar = new Ingredient("Sugar", 2);
        Ingredient sugar2 = new Ingredient("Sugar", 2);

        ingredientCatalogue.addItem(egg);
        ingredientCatalogue.addItem(whiteSugar);
        ingredientCatalogue.addItem(brownSugar);
        ingredientCatalogue.addItem(sugar);
        ingredientCatalogue.deleteItem(sugar2);
        ingredientCatalogue.displayItems();
    }

    public static void carltonTest() {
        IngredientCatalogue inventory = new IngredientCatalogue();
        inventory.addItem(new Ingredient("White sugar", 50));
        inventory.addItem(new Ingredient("Egg", 3));
        inventory.addItem(new Ingredient("Flour", 50));

        Recipe recipe = new Recipe();
        recipe.addItem(new Ingredient("White sugar", 20));
        recipe.addItem(new Ingredient("Egg", 1));
        recipe.addItem(new Ingredient("Flour", 10));


        System.out.println(recipe);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("PRINTING MISSING");
        Commands.cookRecipe(inventory, recipe);
        inventory.displayItems();
    }
}
