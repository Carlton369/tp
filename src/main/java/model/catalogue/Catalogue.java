package model.catalogue;

import java.util.ArrayList;

/**
 * A generic catalogue of items, providing common methods for managing them.
 * This class serves as a base for various catalogues such as inventory, shopping lists, and recipes.
 * Subclasses should implement methods to handle adding and deleting items with custom behavior.
 *
 * @param <T> The type of item stored in the catalogue.
 */
public abstract class Catalogue<T> {
    protected static final int FIRST_ITEM_INDEX = 0;
    protected static final int SINGLE_MATCH = 1;
    protected ArrayList<T> items;
    protected String catalogueName;
    protected CatalogueContentManager contentManager;

    /**
     * Constructs an empty catalogue.
     */
    public Catalogue(String catalogueName) {
        this.items = new ArrayList<>();
        this.catalogueName = catalogueName;
        this.contentManager = new CatalogueContentManager(catalogueName);
    }

    /**
     * Adds an item to the catalogue.
     *
     * @param item The item to be added.
     */
    public abstract void addItem(T item);

    /**
     * Deletes an item from the catalogue.
     *
     * @param item The item to be removed.
     */
    public abstract void deleteItem(T item);

    /**
     * Updates an existing item in the catalogue by replacing it with a new version.
     * If the item does not exist, no action is taken.
     *
     * @param oldItem The item to be replaced.
     * @param newItem The updated item.
     */
    public void updateItem(T oldItem, T newItem) {
        int index = items.indexOf(oldItem);
        if (index != -1) {
            items.set(index, newItem);
        }
    }

    /**
     * Retrieves all items stored in the catalogue.
     *
     * @return An {@link ArrayList} containing all items in the catalogue.
     */
    public ArrayList<T> getItems() {
        return items;
    }

    /**
     * Displays all items in the catalogue in a numbered list format.
     * If the catalogue is empty, a message is displayed instead.
     */
    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("No items found.");
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
    }

    /**
     * Retrieves all items in the catalogue as a formatted string.
     *
     * @return A string representation of all items in the catalogue.
     */
    public String getCatalogueContent() {
        if (items.isEmpty()) {
            return "No items found.";
        }
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            content.append(items.get(i).toString()).append("\n");
        }
        return content.toString();
    }
}
