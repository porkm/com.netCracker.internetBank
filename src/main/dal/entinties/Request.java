package main.dal.entinties;

public class Request {
    private int id;
    private String friend;
    private int customerId;

    public Request(int id, String friend, int customerId) {
        this.id = id;
        this.friend = friend;
        this.customerId = customerId;
    }

    public Request() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
