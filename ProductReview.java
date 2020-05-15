/**
 * PublicReview
 */
public class ProductReview {

    private String name;
    private String review;

    public ProductReview(String pName, String pReview) {
        this.name = pName;
        this.review = pReview;
    }

    public String getName() {
        return this.name;
    }

    public String getReview() {
        return this.review;
    }
}