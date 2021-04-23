package com.hiral;

import com.hiral.entity.Inventory;
import com.hiral.interceptor.Logged;
import com.hiral.inventory.InventoryService;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;


@SessionScoped
@Named
public class InventoryAppBean implements Serializable {

    @Size(min = 5, max = 20)
    @NotEmpty
    private String name;

    @Size(min = 3, max = 25)
    @NotEmpty
    private String sportt;

    private int numberOfQuantity;
    private double pricePerUnit;

    @EJB
    private InventoryService inventoryService;

    public List<Inventory> getInventoryList() {

        return inventoryService.getInventoryList();
    }

    @Logged
    public void addToList() {
        inventoryService.addToList(buildinventory());
        clearFields();
        // Inventory inventory = new Inventory(name, sportt, numberOfQuantity, pricePerUnit);
    }
    private Inventory buildinventory()
    {
        return Inventory.builder().name(name).sportt(sportt).numberOfQuantity(numberOfQuantity).pricePerUnit(pricePerUnit).build();
    }

    private void clearFields() {
        setName("");
        setSportt("");
        setPricePerUnit(0.0);
        setNumberOfQuantity(1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSportt() {
        return sportt;
    }

    public void setSportt(String sportt) {
        this.sportt = sportt;
    }

    public int getNumberOfQuantity() {
        return numberOfQuantity;
    }

    public void setNumberOfQuantity(int numberOfQuantity) {
        this.numberOfQuantity = numberOfQuantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

   }
