package listservice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sonad on 12.09.17.
 */
public class LiteratureListService {

    private static List<BookProfile> literatureList = new ArrayList<BookProfile>();

    static {
        literatureList.add(new BookProfile("Test546","Замятин","Тест"));
        literatureList.add(new BookProfile("Test090","Замятин","Тест"));

    }

    public BookProfile addBook(final String name, final String author, final String publisher) {
        BookProfile bookProfile = new BookProfile(name, author, publisher);
        literatureList.add(bookProfile);
        return bookProfile;
    }

    public boolean deleteBook(final String name) {
        Iterator<BookProfile> iterator = literatureList.iterator();
        while (iterator.hasNext()) {
            BookProfile currentProfile = iterator.next();

            if (currentProfile.getName().toLowerCase().equals(name.toLowerCase())) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public List<BookProfile> searchBook(final String name) {
        List<BookProfile> result = new LinkedList<>();
        if (name==null) return result;
        for (BookProfile profile:literatureList) {
            if (profile.getName().toLowerCase().equals(name.toLowerCase())) result.add(profile);
        }
        return result;
    }

    public List<BookProfile> getLiteratureList() {
        return literatureList;
    }}
