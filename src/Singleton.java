/*
Simple Solution

public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return INSTANCE;
    }
}

Плюсы:
Простота и прозрачность кода
Потокобезопасность
Высокая производительность в многопоточной среде

Минусы:
Не ленивая инициализация.





Lazy Initialization

public class Singleton {
    private static Singleton INSTANCE;

    private Singleton() {}

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
}

Плюсы:
Ленивая инициализация.

Минусы:
Не потокобезопасно





Synchronized Accessor

public class Singleton {
    private static Singleton INSTANCE;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
}

Плюсы:
Ленивая инициализация.
Потокобезопасность

Минусы:
Низкая производительность в многопоточной среде




Double Checked Locking

public class Singleton {
    private static Singleton INSTANCE;

    private Singleton() {}

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}

Плюсы:
Ленивая инициализация.
Потокобезопасность
Высокая производительность в многопоточной среде

Минусы:
Не поддерживается на версиях Java ниже 1.5 (в версии 1.5 исправили работу ключевого слова volatile)





Class Holder Singleton

public class Singleton {
    private Singleton() {}

    private static class SingletonHolder {
        public static final Singleton HOLDER_INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }
}

Плюсы:
Ленивая инициализация.
Потокобезопасность.
Высокая производительность в многопоточной среде.

Минусы:
Для корректной работы необходима гарантия, что объект класса Singleton инициализируется без ошибок.
Иначе первый вызов метода getInstance закончится ошибкой ExceptionInInitializerError,
а все последующие NoClassDefFoundError.





public class Singleton {
    private Singleton() {}

    private static class SingletonHolder {
        public static final Singleton HOLDER_INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }
}
*/