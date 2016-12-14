# memoryLeakDemo
常见引起内存泄露的方式:
单例使用（addListener 与 removeListener没有配对使用）
使用static成员去引用Activity context
使用static成员去引用View
内部类使用
Closable对象（Cursor, InputStream等）没有close
使用第三方sdk引起的内存泄露
系统引起内存泄露
 registerReceiver, ServiceConnection
 Thread.setDefaultUncaughtExceptionHandler
 Context.getSystemService();
 WebView 、InputMethodManager等


编码建议：
1.尽量用application context代替Activity context
2.使用static变量特别注意内存泄露
3.使用单例、管理类时、第三方sdk时注意remove、unregister  destroy  、stop 、cancel等关键方法使用（Timer.cancel()、unregisterReceiver()）
4.尽量使用静态类代替内部类
5.对于后台周期长的任务巧妙使用WeakReference来避免泄露
6.建议webView最好在一个单独进程中使用。

泄露原因总结：
用了一个生命周期长的对象引用了一个生命周期短的对象。
