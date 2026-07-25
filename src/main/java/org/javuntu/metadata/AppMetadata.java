package org.javuntu.metadata;

/*
 * Metadata stores general information about the data (the project).
 *
 * This is "information about the application", such as its name, version,
 * author and short description. Keeping these values here makes them
 * easy to reuse in the desktop, shell, and other parts of the project.
 *
 * A simple way to understand metadata is to think about an image file: the
 * image itself is the data, while details like the file name, size, resolution,
 * creation date, and file type are metadata. In the same way, this class does
 * not contain Javuntu's logic, but information that describes Javuntu.
 */

public class AppMetadata {
    public static final String NAME = "Javuntu";
    public static final String VERSION = "0.1.1";
    public static final String AUTHOR = "Yoav Segev";
    public static final String TAGLINE = "A tiny Java-based Linux desktop shell";

    private AppMetadata() {
    }
}
