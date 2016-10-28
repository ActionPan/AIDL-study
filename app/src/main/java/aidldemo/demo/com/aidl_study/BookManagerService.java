package aidldemo.demo.com.aidl_study;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import aidldemo.demo.com.aidl_study.Utils.LogUtils;
import aidldemo.demo.com.aidl_study.aidl.Book;
import aidldemo.demo.com.aidl_study.aidl.IBookManager;

public class BookManagerService extends Service {
    //支持并发读写
    private CopyOnWriteArrayList<Book> mBookList = new CopyOnWriteArrayList<>();
    private Binder mBinder = new IBookManager.Stub() {

        @Override
        public List<Book> getBookList() throws RemoteException {
            LogUtils.d("calling getBookList~!");
            return mBookList;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            LogUtils.d("calling addBook~!");
            mBookList.add(book);
        }
    };
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LogUtils.d("onBind");
        return mBinder;
    }
}