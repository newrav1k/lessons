package university.Homework1.variant5;

public class Auditor {
    public void closeStore(Store store) {
        store.setName(null);
    }

    public void rebrand(Store store) {
        if (store.getName().equals("MacDonalds")) {
            store.setName("Вкусно и точка");
        } else {
            store.setName(store.getName().substring(1));
        }
    }
}