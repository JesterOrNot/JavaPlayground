import java.util.ArrayList;

/**
 * ReviewCollector
 */
public class ReviewCollector {

    private ArrayList<ProductReview> reviewList;
    private ArrayList<String> productList;

    public ReviewCollector() {
        reviewList = new ArrayList<ProductReview>();
        productList = new ArrayList<String>();
    }

    public void addReview(ProductReview prodReview) {
        this.reviewList.add(prodReview);
        if (!this.productList.contains(prodReview.getName())) {
            this.productList.add(prodReview.getName());
        }
    }

    public int getNumGoodReviews(String prodName) {
        int count = 0;
        for(ProductReview review : this.reviewList) {
            if (review.getName().equals(prodName)) {
                if (review.getReview().indexOf("best") != -1) {
                  count++;
                }
            }
        }
        return count;
    }
}
