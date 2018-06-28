package listservice;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */


public class BookProfile {
    private final String name;
    private final String author;
    private final String publisher;

    BookProfile(String name, String author, String publisher) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
    }

    public BookProfile(String name) {
        this.name = name;
        this.author = name;
        this.publisher = name;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }
}
