package web.noname.service.domain.item;

import lombok.Data;

@Data
public class Item {
    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;
    private String manufacturer;
    private String classification;
    private String itemStatus;
    private String deliveryMethod;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity, String manufacturer, String classification, String itemStatus, String deliveryMethod) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.manufacturer = manufacturer;
        this.classification = classification;
        this.itemStatus = itemStatus;
        this.deliveryMethod = deliveryMethod;
    }
}
