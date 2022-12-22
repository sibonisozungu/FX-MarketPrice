package data;

public class Message {
    private String uniqueId;
    private String instrumentName;
    private String bid;
    private String ask;
    private String timestamp;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "uniqueId='" + uniqueId + '\'' +
                ", instrumentName='" + instrumentName + '\'' +
                ", bid='" + bid + '\'' +
                ", ask='" + ask + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
