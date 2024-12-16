package com.example.book_service.enums;

public enum GenreType{
    FICTION,
    NON_FICTION,
    MYSTERY,
    FANTASY,
    SCIENCE_FICTION,
    ROMANCE,
    HORROR,
    THRILLER,
    BIOGRAPHY,
    HISTORY,
    POETRY,
    SELF_HELP,
    CLASSICS,
    GRAPHIC_NOVEL,
    CHILDREN,
    YOUNG_ADULT;

    @Override
    public String toString() {
        // Optional: Make the enum name more readable by replacing underscores and capitalizing words
        String[] words = name().split("_");
        StringBuilder readable = new StringBuilder();
        for (String word : words) {
            readable.append(word.charAt(0))
                    .append(word.substring(1).toLowerCase())
                    .append(" ");
        }
        return readable.toString().trim();
    }
}
