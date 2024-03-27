package com.zsgs.chandru.librarymanagement.librarydatabase;

import com.google.gson.reflect.TypeToken;
import com.zsgs.chandru.librarymanagement.datahandling.DataHandlingHelper;
import com.zsgs.chandru.librarymanagement.model.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class LibraryDatabase {

    private static LibraryDatabase libraryDatabase;

    private static DataHandlingHelper dataHandlingHelper;

    public static LibraryDatabase getInstance() {
        if (libraryDatabase == null) {
            dataHandlingHelper = new DataHandlingHelper();
            libraryDatabase = new LibraryDatabase();
        }
        return libraryDatabase;
    }

    // ------------------------------   Overall Data Structures used ------------------------------------------------
    private HashMap<Integer, Librarian> librarianDetails; // admin id , admin details
    private HashMap<Integer, String> librarianCredentials; // librarian id , librarian password
    private HashMap<Integer, Library> libraryDetails; // Library id , Library details
    private HashMap<Integer, Integer> adminIdLibraryId; // librarian id, library id
    private HashMap<Integer, Book> booksInLibrary; // Book id , Book Details
    private HashMap<Integer, User> userIdUserDetails; // user id , user Details
    private HashMap<Integer, ArrayList<IssueBook>> issuedBookDetails; //User Id , IssueBookDetails (Book,User)
    private HashMap<String, Integer> idMaintainMap; // All ID Maintaining

    // ------------------------------   End ---------------------------------------------------------------------------




    // ----------------------Serialization and Deserialization Process---------------------------------------

    // Librarian Details Serialization and Deserialization
    public void serializeLibrarianDetails() {
        dataHandlingHelper.serializeData(librarianDetails, "LibrarianDetails.txt");
    }

    public void deserializeLibrarianDetails() {
        Type librarianDetailsType = new TypeToken<HashMap<Integer, Librarian>>() {}.getType();
        librarianDetails = dataHandlingHelper.deserializeData("LibrarianDetails.txt", librarianDetailsType, HashMap.class);
    }


    // Librarian Credentials Serialization and Deserialization
    public void serializeLibrarianCredentials() {
        dataHandlingHelper.serializeData(librarianCredentials, "LibrarianCredentials.txt");
    }

    public void deserializeLibrarianCredentials() {
        Type librarianCredentialsType = new TypeToken<HashMap<Integer, String>>() {}.getType();
        librarianCredentials = dataHandlingHelper.deserializeData("LibrarianCredentials.txt", librarianCredentialsType, HashMap.class);
    }


    // Library Details Serialization and Deserialization
    public void serializeLibraryDetails() {
        dataHandlingHelper.serializeData(libraryDetails, "LibraryDetails.txt");
    }

    public void deserializeLibraryDetails() {
        Type libraryDetailsType = new TypeToken<HashMap<Integer, Library>>() {}.getType();
        libraryDetails = dataHandlingHelper.deserializeData("LibraryDetails.txt", libraryDetailsType, HashMap.class);
    }


    // Librarian Id , Library Id Serialization and Deserialization
    public void serializeAdminIdLibraryId() {
        dataHandlingHelper.serializeData(adminIdLibraryId, "AdminIdLibraryId.txt");
    }

    public void deserializeAdminIdLibraryId() {
        Type adminIdLibraryIdType = new TypeToken<HashMap<Integer, Integer>>() {}.getType();
        adminIdLibraryId = dataHandlingHelper.deserializeData("AdminIdLibraryId.txt", adminIdLibraryIdType, HashMap.class);
    }


    //Book id , Books details Serialization and Deserialization
    public void serializeBooksInLibrary() {
        dataHandlingHelper.serializeData(booksInLibrary, "BooksInLibrary.txt");
    }

    public void deserializeBooksInLibrary() {
        Type booksInLibraryType = new TypeToken<HashMap<Integer, Book>>() {}.getType();
        booksInLibrary = dataHandlingHelper.deserializeData("BooksInLibrary.txt", booksInLibraryType, HashMap.class);
    }


    //User details Serialization and Deserialization
    public void serializeUserIdUserDetails() {
        dataHandlingHelper.serializeData(userIdUserDetails, "UserIdUserDetails.txt");
    }

    public void deserializeUserIdUserDetails() {
        Type userIdUserDetailsType = new TypeToken<HashMap<Integer, User>>() {}.getType();
        userIdUserDetails = dataHandlingHelper.deserializeData("UserIdUserDetails.txt", userIdUserDetailsType, HashMap.class);
    }


    // Issue Book Section Serialization and Deserialization
    public void serializeIssuedBookDetails() {
        dataHandlingHelper.serializeData(issuedBookDetails, "issuedBookDetails.txt");
    }
    public void deserializeIssuedBookDetails() {
        Type issuedBookDetailsType = new TypeToken<HashMap<Integer, ArrayList<IssueBook>>>() {}.getType();
        issuedBookDetails = dataHandlingHelper.deserializeData("issuedBookDetails.txt", issuedBookDetailsType, HashMap.class);
    }


    //Id Maintaining Serialization and Deserialization
    public void serializeIdMaintainLists() {
        dataHandlingHelper.serializeData(idMaintainMap, "idMaintainLists.txt");
    }

    public void deserializeIdMaintainLists() {
        Type idMaintainListsType = new TypeToken<HashMap<String, Integer>>() {}.getType();
        idMaintainMap = dataHandlingHelper.deserializeData("idMaintainLists.txt", idMaintainListsType, HashMap.class);
    }


    // ------------------Serialization and Deserialization Process End Here -------------------------------------------------



    // ----------------------------- Data Retrieve and Updation Process Start-------------------------------------------------

    // Librarian Details
    public boolean setupCheck() {
        return librarianDetails.isEmpty();
    }

    public void insertLibrarianDetails(int librarianId, Librarian librarian) {
        librarianDetails.put(librarianId, librarian);
    }

    public String getLibrarianName(int librarianId) {
        if (librarianDetails.containsKey(librarianId)) {
            return librarianDetails.get(librarianId).getLibrarianName();
        }
        return "No Admin Found";
    }


    // Librarian Credentials
    public void insertLibrarianCredentials(int librarianId, String password) {
        librarianCredentials.put(librarianId, password);
    }

    public boolean checkLibrarianCredentials(int librarianId, String password) {
        return librarianCredentials.entrySet().stream()
                .anyMatch(entry -> entry.getKey() == librarianId && entry.getValue().equals(password));

    }


    // Library Details
    public void insertLibraryDetails(int libraryId, Library library) {
        libraryDetails.put(libraryId, library);
    }

    public String getLibraryName(int libraryId) {
        return libraryDetails.entrySet().stream()
                .filter(entry -> entry.getKey() == libraryId)
                .findFirst()
                .map(entry -> entry.getValue().getLibraryName())
                .orElse("No Library Found");
    }

    public boolean isLibraryEmpty() {
        return libraryDetails.isEmpty();
    }


    // Librarian Id , Library Id

    public void insertAdminIdLibraryId(int adminId, int libraryId) {
        adminIdLibraryId.put(adminId, libraryId);
    }

    public int getLibraryId(int librarianId) {
        return adminIdLibraryId.getOrDefault(librarianId, 0);
    }



    //Book id , Books details
    public boolean checkBooksAreEmpty() {
        return booksInLibrary.isEmpty();
    }

    public void insertBookDetails(int bookId, Book book) {
        booksInLibrary.put(bookId, book);
        serializeBooksInLibrary();
    }

    public boolean checkDuplicateBookInDatabase(Book book) {
        return booksInLibrary.values().stream()
                .anyMatch(entry -> entry.getBookName().equals(book.getBookName()) &&
                        entry.getBookAuthor().equals(book.getBookAuthor()) &&
                        entry.getBookVolume() == book.getBookVolume());
    }

    public ArrayList<Book> searchBookInDatabase(String guessName) {
        return booksInLibrary.values().stream()
                .filter(book -> book.getBookName().contains(guessName))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public boolean deleteBookInDatabase(int bookId) {
        if (booksInLibrary.containsKey(bookId)) {
            booksInLibrary.remove(bookId);
            return true;
        } else {
            return false;
        }
    }

    public Book updateBookStockInDatabase(int bookId) {
        return booksInLibrary.values().stream()
                .filter(book -> book.getBookId() == bookId)
                .findFirst()
                .orElse(null);
    }

    public boolean isBookAvailableInDatabase(int bookId) {
        return booksInLibrary.values().stream()
                .filter(book -> book.getBookId() == bookId)
                .map(Book::getBookAvailabilityStock)
                .findFirst()
                .orElse(0) > 0;
    }

    public HashMap<Integer, Book> getBooksInLibrary() {
        return booksInLibrary;
    }

    public Book getBookById(int bookId) {
        return booksInLibrary.get(bookId);
    }

    public boolean checkValidBookIdInDatabase(int bookId) {
        return booksInLibrary.containsKey(bookId);
    }


    //User details

    public void insertUserDetails(int userId, User user) {
        userIdUserDetails.put(userId, user);
        serializeBooksInLibrary();
    }

    public HashMap<Integer, User> getUserDetails() {
        return userIdUserDetails;
    }

    public ArrayList<User> searchUserInDatabase(String username) {
        ArrayList<User> users = userIdUserDetails.values().stream()
                .filter(user -> user.getUserName().contains(username))
                .collect(Collectors.toCollection(ArrayList::new));
        return users;

    }

    public boolean checkUserById(int userId) {
        return userIdUserDetails.containsKey(userId);
    }

    public boolean checkExistingUserByPhoneNo(String phoneNo) {
        return userIdUserDetails.values().stream().anyMatch(user -> user.getUserPhoneNo().equals(phoneNo));
    }

    public void deleteUser(int userId) {
        userIdUserDetails.remove(userId);
    }


    // Issue Book Section
    public void insertIssueBookDetails(int userId, IssueBook record) {
        ArrayList<IssueBook> records = issuedBookDetails.computeIfAbsent(userId, k -> new ArrayList<>());
        records.add(record);
        serializeBooksInLibrary();
    }

    public HashMap<Integer, ArrayList<IssueBook>> getIssuedBookDetails() {
        return issuedBookDetails;
    }

    public ArrayList<IssueBook> getParticularBookDetailsInDatabase(int userId) {
        return issuedBookDetails.get(userId);
    }

    public boolean isIssuedBookListEmpty() {
        return issuedBookDetails.isEmpty();
    }



    //Id Maintaining

    public void setUpdatedId(String idType, int id) {
        idMaintainMap.put(idType, id);
    }

    public int getUpdatedId(String idType) {
        return idMaintainMap.getOrDefault(idType, 0);
    }

    // ----------------------------- Data Retrieve and Updation Process End-------------------------------------------------


}
