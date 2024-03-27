package com.zsgs.chandru.librarymanagement.model;

import com.zsgs.chandru.librarymanagement.librarydatabase.LibraryDatabase;

public class IdMaintain {

    public void serializeId() {
        User user = new User();
        Book book = new Book();
        Library library = new Library();
        Librarian librarian = new Librarian();

        // Serialize IDs
        LibraryDatabase.getInstance().setUpdatedId("UserId", user.getUniqueUserId());
        LibraryDatabase.getInstance().setUpdatedId("BookId", book.getUniqueBookId());
        LibraryDatabase.getInstance().setUpdatedId("LibraryId", library.getUniqueLibraryId());
        LibraryDatabase.getInstance().setUpdatedId("LibrarianId", librarian.getUniqueLibrarianId());
    }

    public void deserializeId() {
        User user = new User();
        Book book = new Book();
        Library library = new Library();
        Librarian librarian = new Librarian();

        // Deserialize IDs
        int userId = LibraryDatabase.getInstance().getUpdatedId("UserId");
        int bookId = LibraryDatabase.getInstance().getUpdatedId("BookId");
        int libraryId = LibraryDatabase.getInstance().getUpdatedId("LibraryId");
        int librarianId = LibraryDatabase.getInstance().getUpdatedId("LibrarianId");

        user.setUniqueUserId(userId);
        book.setUniqueBookId(bookId);
        library.setUniqueLibraryId(libraryId);
        librarian.setUniqueLibrarianId(librarianId);
    }
}
