
深克隆：
克隆完的过程，基本类型直接克隆，引用类型 源对象和克隆对象分别指向一个内存地址

浅克隆：
克隆的过程，基本类型直接克隆，引用类型 源对象和克隆对象指向同一个内存地址

实现原型模式需要实现标记性接口Cloneable
一般会重写object的clone方法，
一般用于对象的属性已经确定，但是需要产生很多相同对象的时候