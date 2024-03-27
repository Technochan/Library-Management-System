
# Library Management System Documentation - Version 0.1.0
## Introduction

The Library Management System (LMS) is a Java-based console application developed to streamline library operations. It provides librarians with tools to efficiently manage library resources, including book inventory, user accounts, and book loans. The system follows the **Model-View pattern**, with data stored in database classes and handled through **JSON** conversion for persistence.




## Login Section
```bash
- Control Book Section
- Control Users Section
- Control Issue Book Section
```
    
## Section Features

### -> Control Book Section
```bash
    * Add New Book
    * Search Book
    * Delete Book
    * Show All Books
    * Book Stock Update
```
- ### **`Add New Books`**: 
     Allows librarians to add new books to the library inventory by providing details such as title, author, publication, edition, and availability.
- ### **`Search Books`**: 
    Enables librarians to search for books by various criteria, providing quick access to specific titles.
- ### **`Delete Books`**: 
    Allows removal of books from the library inventory, maintaining an updated catalog.
- ### **`Update Book Stock`**: 
    Provides functionality to update the stock quantity of existing books, reflecting changes in availability.
- ### **`Display All Books`**: 
    Presents a comprehensive list of all books in the library inventory, aiding librarians in catalog management.

### -> Control User Section
```bash
    * Add New User
    * Search USer
    * Delete User
    * Show All User
```
- ### **`Add New USer`**: 
     Facilitates the addition of new users to the system, capturing essential user details such as name, contact information, and membership status.
- ### **`Search User`**: 
    Allows librarians to search for users by various parameters, facilitating user account management.
- ### **`Delete USer`**: 
    Enables removal of user accounts from the system, ensuring accurate user records.
- ### **`Display All Users`**: 
    Provides librarians with a complete list of registered users, enhancing user account administration.

### -> Control Issue Book Section
```bash
    * Issue Book
    * Show Issue Book
    * Show Overdue Book
    * Show Issued Book User
    * Revoke Book
```
- ### **`Issue Book`**: 
     Allows librarians to issue books to users, specifying return dates and managing book loans efficiently.
- ### **`Show Issue Book`**: 
   Presents a list of currently issued books, aiding librarians in tracking book loans and due dates.
- ### **`Show Overdue Book`**: 
    Provides information on the book which is borrowed by the users and the return date is exceed the expected return date
- ### **`Show Issued Book User`**: 
    Provides information on users who have borrowed books, facilitating communication and follow-up on book returns.
-  ### **`Revoke Book`**: 
    Revoking the book again from the user. Update the stock count






## Environment Setup And Deploy

To deploy this project and run

```bash
  - Extract the project file and unzip it.
  - Download the Gson from Maven Repository
  - Configure the Gson library with your IDE
  - Start Run  -  Enjoy  :)
```


## Librarian Setup
- Initial Setup: During the initial setup, librarians configure their accounts by providing credentials and basic library details, ensuring personalized access to the system.
- Subsequent Logins: After the initial setup, librarians can log in using their credentials, accessing administrative controls and functionalities.
- Authentication Credential Management: The system manages librarian credentials securely, ensuring authentication during login sessions for authorized access to administrative features.

## Implementation Details
- Language: Java
- Interface: Console-based
- Data Storage:
   Data is stored in memory during runtime for efficient processing.Upon program exit, data is serialized to JSON format using the Gson library and stored in a text file, ensuring data persistence across sessions.


## Modules

![module](https://github.com/Technochan/Library-Management-System/assets/133956496/66421c19-c9ff-4e20-9b47-edb969494349)

## Screenshots
![Screenshots](https://github.com/Technochan/Library-Management-System/assets/133956496/70f4b3b6-c15d-407d-b4ad-dbd77be6dbb1)

# Conclusion

- In the future upcoming version i would like to update some more features to make the console based application to the next level.
- Some features are : 
    - Increasing the libraries and librarians.
    - Planning to design a dashboard for each users  
    - Connection between user and librarian, etc.

