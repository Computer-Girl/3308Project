package dachman.lucas.letsgoapp2.Models;

/**
 * Created by lucas on 3/8/17.
 */

public enum Category {

    CAREER("Career"),                        // Career Events
    PUBLIC_SPEAKERS("Public Speakers"),     // Public Speakers
    GREEK("Greek"),                         // Fraternity, Sorority Events
    CULTURAL("Cultural"),                   // Cultural
    ARTISTIC("Artistic"),                   // Movies, Music, Theater
    OTHER("Other");


    private String name;
    // Use this string to display the enum name
    public static final String NAME = "CATEGORY";

    private Category(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return this.name;
    }
}
