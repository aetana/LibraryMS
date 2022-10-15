package dataaccess;

import java.util.HashMap;

import business.Book;
import business.LibraryMember;
import dataaccess.DataAccessFacade.StorageType;

public interface DataAccess { 
	public HashMap<String,Book> readBooksMap();
	public HashMap<String,User> readUserMap();
	public HashMap<String, LibraryMember> readMemberMap();
	public void saveNewMember(LibraryMember member); 
	public Book searchBook(String ISBN);
	public LibraryMember searchMember(String memberId);
	public void saveBookCopy(Book book);
	public void saveNewBook(Book book);
	public void saveMember(LibraryMember member);
	public void saveBook(Book book);
	public void updateMember(LibraryMember member);
	public void updateBook(Book book);
}
