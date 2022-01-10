package com.example.sslost.Data.database.core.schema;

public final class DBSchema {
    public interface Store {


    }
    public interface Chapter {

    }
    public interface User {

    }
    public interface Content {

    }
    public interface History {

    }

    public interface Comment {

    }

    public interface Account {
        String TABLE_NAME = "account";
        String ID = "_id";
        String ACCOUNT_GUID = "accountGuid";
        String ACCOUNT_TYPE = "accountType";
        String ACCOUNT_NAME = "accountName";
        String PRIMARY_ACCOUNT = "primaryAccount";
    }

}
