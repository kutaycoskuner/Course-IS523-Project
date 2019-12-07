package domain;

import view.UIFacade;

public class Store {

    // Variables
    String name;
    
    // Instantiation
    ProductCatalog catalog;
    UIFacade ui = UIFacade.getInstance();

    // Constructor
    public Store() {
        catalog = new ProductCatalog();
    }

    // Command Functions
    public void manageProducts() {
        // !! it is initializing again on repetitive click fix it
        for (int iii = 1; iii <= catalog.getCatalogSize(); ++iii) {
            ui.addCatalog(catalog.getProducts("" + iii).getDescription());
        }
    }

    public void getDetails(int items[], int index) {
        if (items.length == 1) {
            ui.addDetails(
                    catalog.getProducts("" + index).getProductId(),
                    catalog.getProducts("" + index).getDescription(),
                    catalog.getProducts("" + index).getMinimumStockLevel(),
                    catalog.getProducts("" + index).getMaximumStockLevel(),
                    catalog.getProducts("" + index).getCurrentStockLevel()
            );
        }
    }

    public void deleteItem(int items) {
        try {
            catalog.deleteItem(items);
        } catch (Exception e) {
            //  Block of code to handle errors
        }
        // Delete elements from display list
        ui.purgeCatalog();
//        manageProducts();
        ui.inform("Selected Items are successfully deleted");
    }

    public void loadMap(String a, String b, String c, String d, String e) {
        catalog.createItem(a, b, c, d, e);
    }

    // Query Functions
    public ProductCatalog getCatalog() {
        return catalog;
    }

    public String getWriteData() {
        return catalog.getSaveData();
    }

}
