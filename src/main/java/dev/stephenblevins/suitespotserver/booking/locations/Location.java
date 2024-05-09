package dev.stephenblevins.suitespotserver.booking.locations;

public class Location {
    private String dest_id;
    private String dest_type;

    public String getDest_type() {
        return dest_type;
    }

    public void setDest_type(String dest_type) {
        this.dest_type = dest_type;
    }

    public String getDest_id() {
        return dest_id;
    }

    public void setDest_id(String dest_id) {
        this.dest_id = dest_id;
    }

    @Override
    public String toString() {
        return "Location [dest_id=" + dest_id + ", dest_type=" + dest_type + "]";
    }
}
