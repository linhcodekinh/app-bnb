package com.example.sslost.Data.database.core.account.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.example.sslost.Data.database.core.schema.DBSchema;


@Entity(
        tableName = DBSchema.Account.TABLE_NAME,
        indices = {
                @Index(value = {DBSchema.Account.ACCOUNT_GUID}, unique = true)
        }
)
public class NotesAccountEntity {

    private static final String TAG = "NotesAccountEntity";

    @ColumnInfo(name = DBSchema.Account.ID)
    @PrimaryKey(autoGenerate = true)
    private long id;

//    @ColumnInfo(name = DBSchema.Account.ACCOUNT_GUID, defaultValue = "")
//    @NonNull
//    private String accountGuid;
//
//    @ColumnInfo(name = DBSchema.Account.ACCOUNT_TYPE, defaultValue = "")
//    @NonNull
//    private String accountType;
//
//    @ColumnInfo(name = DBSchema.Account.ACCOUNT_NAME, defaultValue = "")
//    private String accountName;
//
//    @ColumnInfo(name = DBSchema.Account.PRIMARY_ACCOUNT, defaultValue = "1")
//    private int primaryAccount = 1;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    @NonNull
//    public String getAccountGuid() {
//        return accountGuid;
//    }
//
//    public void setAccountGuid(@NonNull String accountGuid) {
//        this.accountGuid = accountGuid;
//    }
//
//    @NonNull
//    public String getAccountType() {
//        return accountType;
//    }
//
//    public void setAccountType(@NonNull String accountType) {
//        this.accountType = accountType;
//    }
//
//    public String getAccountName() {
//        return accountName;
//    }
//
//    public void setAccountName(String accountName) {
//        this.accountName = accountName;
//    }
//
//    public int getPrimaryAccount() {
//        return primaryAccount;
//    }
//
//    public void setPrimaryAccount(int primaryAccount) {
//        this.primaryAccount = primaryAccount;
//    }
//
//    @NonNull
//    @Override
//    public String toString() {
//        return "NotesAccountEntity{" +
//                "id=" + id +
//                ", accountGuid='" + accountGuid + '\'' +
//                ", accountType='" + accountType + '\'' +
//                ", accountName='" + accountName + '\'' +
//                ", primaryAccount=" + primaryAccount +
//                '}';
//    }
}
