package com.example.sslost.Data.database.core.account.dao;


import androidx.room.Dao;

import com.example.sslost.Data.database.core.account.entity.NotesAccountEntity;
import com.example.sslost.Data.database.core.dao.BaseDao;

@Dao
public abstract class NotesAccountDAO extends BaseDao<NotesAccountEntity> {

    private static final String TAG = "NotesAccountDAO";

//    @Query("SELECT * FROM account WHERE accountGuid=:accountGuid ORDER BY _id DESC LIMIT 1")
//    public abstract NotesAccountEntity getEntity(@NonNull String accountGuid);
//
//    @Query("SELECT * FROM account WHERE accountGuid=:accountGuid ORDER BY _id DESC LIMIT 1")
//    public abstract NotesAccountEntity getAccount(@NonNull String accountGuid);
//
//    @Query("SELECT * FROM account WHERE primaryAccount IS 1 ORDER BY _id DESC LIMIT 1")
//    public abstract NotesAccountEntity getPrimaryAccount();
//
//    @Query("SELECT accountName FROM account WHERE accountGuid=:accountGuid ORDER BY _id DESC LIMIT 1")
//    public abstract String getAccountName(@NonNull String accountGuid);
//
//    @Query("SELECT accountType FROM account WHERE accountGuid=:accountGuid ORDER BY _id DESC LIMIT 1")
//    public abstract String getAccountType(@NonNull String accountGuid);
//
//    @Query("SELECT accountName FROM account WHERE primaryAccount IS 1 ORDER BY _id DESC LIMIT 1")
//    public abstract String getPrimaryAccountName();
//
//    @Query("SELECT accountType FROM account WHERE primaryAccount IS 1 ORDER BY _id DESC LIMIT 1")
//    public abstract String getPrimaryAccountType();
//
//    @Query("SELECT accountGuid FROM account WHERE primaryAccount IS 1 ORDER BY _id DESC LIMIT 1")
//    public abstract String getPrimaryAccountGuid();
//
//    @Query("UPDATE OR ABORT account SET primaryAccount=(accountGuid=:accountGuid)")
//    public abstract void changePrimaryAccount(@NonNull String accountGuid);
//
//    @Transaction
//    public void insertPrimaryAccount(@NonNull NotesAccountEntity accountEntity) {
//        insert(accountEntity);
//        changePrimaryAccount(accountEntity.getAccountGuid());
//    }
}
