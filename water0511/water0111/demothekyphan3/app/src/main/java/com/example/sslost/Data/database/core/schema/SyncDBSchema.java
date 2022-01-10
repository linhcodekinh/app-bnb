package com.example.sslost.Data.database.core.schema;

public final class SyncDBSchema {
    private static final String UUID_STRING = "UUID";

    public interface SyncInfo {
        String TABLE_NAME = "sync_info";
        String ID = "_id";
        //server side values
        String SERVER_ID = "serverId";
        String CLIENT_ID = "clientId";
        String CLIENT_MODIFIED_TIME = "clientModifiedTime";
        String IS_DIRTY_FOLDER = "isDirtyFolder";
        String CLIENT_MODIFIED_TIME_FOLDER = "clientModifiedTimeFolder";
        String LAST_MODIFIED_TIME_FOLDER = "lastModifiedTimeFolder";
        String IS_SYNC_FAILED = "isSyncFailed";
    }
}
