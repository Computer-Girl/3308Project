package dachman.lucas.letsgoapp2;

/**
 * Created by lucas on 3/8/17.
 */

public enum Category {

    CARER("Career"),                        // Career Events
    PUBLIC_SPEAKERS("Public Speakers"),     // Public Speakers
    GREEK("Greek"),                         // Fraternity, Sorority Events
    CULTURAL("Cultural"),                   // Cultural
    ARTISTIC("Artistic"),                   // Movies, Music, Theater
    OTHER("Other");

    private String name;

    private Category(String name) {
        this.name = name;
    }
}
