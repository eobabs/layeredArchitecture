package data.models;

public class Item {
    private int id;
    private String name;
    private String description;
    private int weightInGrams;
//    private Receiver receiver;
//    private Sender sender;
//    private TrackingInfo trackingInfo;


    public Item( String name, String description, int weightInGrams) {
//        this.sender = sender;
//        this.receiver = receiver;
        this.weightInGrams = weightInGrams;
        this.description = description;
        this.name = name;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getWeightInGrams() { return weightInGrams; }
    public void setWeightInGrams(int weightInGrams) { this.weightInGrams = weightInGrams; }
////    public Receiver getReceiver() { return receiver; }
//    public void setReceiver(Receiver receiver) { this.receiver = receiver; }
////    public Sender getSender() { return sender; }
//    public void setSender(Sender sender) { this.sender = sender; }
//    public TrackingInfo getTrackingInfo() { return trackingInfo; }
//    public void setTrackingInfo(TrackingInfo trackingInfo) { this.trackingInfo = trackingInfo; }

}
