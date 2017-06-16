package entity;

public class Item {
    private int itemID;
    private String text;
    private int state;
    private int userID;

    public Item(){}

    public Item(String text, int state, int userID) {
        this.text = text;
        this.state = state;
        this.userID = userID;
    }

    public Item(int itemID, String text, int state, int userID) {
        this.itemID = itemID;
        this.text = text;
        this.state = state;
        this.userID = userID;
    }

    public int getItemID() {
        return itemID;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemID=" + itemID +
                ", text='" + text + '\'' +
                ", state=" + state +
                ", userID=" + userID +
                '}';
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
