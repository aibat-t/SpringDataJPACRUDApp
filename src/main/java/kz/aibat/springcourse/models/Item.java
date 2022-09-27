package kz.aibat.springcourse.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Item")
public class Item {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;

    @NotEmpty
    @Column(name = "item_name")
    private String itemName;

    public Item() {
    }

    public Item(int id, Person owner, String itemName) {
        this.id = id;
        this.owner = owner;
        this.itemName = itemName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", owner=" + owner +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
