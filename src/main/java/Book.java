import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    private String title;
    private String author;
    private String genre;
    private int year;
    private String isbn;
    private int id;

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                ", isbn='" + isbn + '\'' +
                ", id=" + id +
                '}';
    }
}