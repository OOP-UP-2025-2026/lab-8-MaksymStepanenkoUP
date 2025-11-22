package ua.opnu;

class BookData implements Comparable<BookData> {

    private final String title;
    private final String author;
    private final int reviews;
    private final double total;

   BookData(final String nTitle, final String nAuthor,
            final int nReviews, final double nTotal) {
        this.title = nTitle;
        this.author = nAuthor;
        this.reviews = nReviews;
        this.total = nTotal;
    }

    public double getRating() {
        if (reviews == 0) {
            return 0;
        }
        return total / reviews;
    }

    @Override
    public int compareTo(final BookData other) {
        double ratingThis = this.getRating();
        double ratingOther = other.getRating();

        // Сортування за спаданням
        int compareRating = Double.compare(ratingOther, ratingThis);
        if (compareRating != 0) {
            return compareRating;
        }

        // Якщо рейтинги однакові порівнюємо назви у звичайному порядку
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return title + " (rating=" + getRating() + ")";
    }
}
