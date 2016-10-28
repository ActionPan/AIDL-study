// IBookManager.aidl
package aidldemo.demo.com.aidl_study.aidl;
import aidldemo.demo.com.aidl_study.aidl.Book;
interface IBookManager {
    List<Book> getBookList();
    void addBook(in Book book);
}
