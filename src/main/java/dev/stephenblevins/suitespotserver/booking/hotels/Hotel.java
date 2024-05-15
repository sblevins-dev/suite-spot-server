package dev.stephenblevins.suitespotserver.booking.hotels;

public class Hotel {
    private float review_score;
    private String review_score_word;
    private String accommodation_type_name;
    private String zip;
    private String address;
    private String city;
    private String main_photo_url;
    private String url;
    private String hotel_name;
    private String unity_configuration_label;
    private float min_total_price;
    private String max_photo_url;

    public Hotel() {

    }

    public Hotel(float review_score, String review_score_word,
                 String accommodation_type_name, String zip, String address,
                 String city, String main_photo_url, String url, String hotel_name,
                 String unity_configuration_label, float min_total_price,
                 String max_photo_url) {
        this.review_score = review_score;
        this.review_score_word = review_score_word;
        this.accommodation_type_name = accommodation_type_name;
        this.zip = zip;
        this.address = address;
        this.city = city;
        this.main_photo_url = main_photo_url;
        this.url = url;
        this.hotel_name = hotel_name;
        this.unity_configuration_label = unity_configuration_label;
        this.min_total_price = min_total_price;
        this.max_photo_url = max_photo_url;
    }

    public float getReview_score() {
        return review_score;
    }

    public void setReview_score(float review_score) {
        this.review_score = review_score;
    }

    public String getReview_score_word() {
        return review_score_word;
    }

    public void setReview_score_word(String review_score_word) {
        this.review_score_word = review_score_word;
    }

    public String getAccommodation_type_name() {
        return accommodation_type_name;
    }

    public void setAccommodation_type_name(String accommodation_type_name) {
        this.accommodation_type_name = accommodation_type_name;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMain_photo_url() {
        return main_photo_url;
    }

    public void setMain_photo_url(String main_photo_url) {
        this.main_photo_url = main_photo_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getUnity_configuration_label() {
        return unity_configuration_label;
    }

    public void setUnity_configuration_label(String unity_configuration_label) {
        this.unity_configuration_label = unity_configuration_label;
    }

    public float getMin_total_price() {
        return min_total_price;
    }

    public void setMin_total_price(float min_total_price) {
        this.min_total_price = min_total_price;
    }

    public String getMax_photo_url() {
        return max_photo_url;
    }

    public void setMax_photo_url(String max_photo_url) {
        this.max_photo_url = max_photo_url;
    }
}
