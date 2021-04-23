package com.hiral;

import com.hiral.entity.Inventory;
import com.hiral.entity.Store;
import com.hiral.interceptor.Logged;
import com.hiral.inventory.InventoryService;
import com.hiral.inventory.StoreService;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class StoreAppBean implements Serializable {

    @Size(min = 5, max = 20)
    @NotEmpty
    private String name;

    @Size(min = 2, max = 55)
    @NotEmpty
    private String location;

    @Size(min = 2)
    @NotEmpty
    private String listOfInventory;

    @EJB
    private StoreService storeService;

    public List<Store> getStoreList() {
        return storeService.getStoreList();
    }


    @Logged
    public void addToList() {
        storeService.addToList(buildStore());
        clearFields();
    }
    private Store buildStore()
    {
        return Store.builder().name(name).location(location).build();
    }

    private void clearFields() {
        setName("");
        setLocation("");
        setListOfInventory("");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getListOfInventory() {
        return listOfInventory;
    }

    public void setListOfInventory(String listOfInventory) {
        this.listOfInventory = listOfInventory;
    }
}
