
2014-4-3 21:11:24
添加了adapter
兼容多种不同布局
可以使用反射，给view注入，在activity也能使用
ViewInjectorByReflect.injectView(holder, getWindow().getDecorView());
ps:由于这个adapter的主要目的是简化使用方式，路漫漫其修远兮，所以，这里不定义接口，其目的是以后可以进一步优化，简化。

2014-3-31 22:50:41
修改http异步的代码，添加了http同步的方法

2014-3-30 22:50:28
初步完成了流程，http异步已经测试成功



主要目标是，将常用的代码进行隔离分层，给自己定义一个使用的规范。尽可能的提高代码的重用性与维护性等。
已经继承了基本的工具类，http