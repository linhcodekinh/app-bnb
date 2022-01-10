package com.example.sslost.Data.database.core.document.dao;


import androidx.room.Dao;

@Dao
public abstract class NotesContentDAO {}
//        extends BaseDao<NotesContentEntity> {

//    @Query("SELECT * FROM " + DBSchema.Content.TABLE_NAME)
//    public abstract LiveData<List<NotesContentEntity>> getAllLiveDatas();
//
//    @Query("SELECT * FROM " + DBSchema.Content.TABLE_NAME)
//    public abstract List<NotesContentEntity> getAll();
//
//    @Override
//    @Query("SELECT * FROM " + DBSchema.Content.TABLE_NAME +
//            " WHERE UUID=:contentUuid" +
//            " LIMIT 1")
//    public abstract NotesContentEntity getEntity(String contentUuid);
//
//    @Query("DELETE FROM " + DBSchema.Content.TABLE_NAME +
//            " WHERE UUID=:contentUuid")
//    public abstract void deleteByUuid(String contentUuid);
//
//    @Transaction
//    public void deleteByUuid(Collection<String> contentUuidList) {
//        if (contentUuidList != null && !contentUuidList.isEmpty()) {
//            for (String contentUuid : contentUuidList) {
//                deleteByUuid(contentUuid);
//            }
//        }
//    }
//
//    @Query("DELETE FROM " + DBSchema.Content.TABLE_NAME +
//            " WHERE sdocUUID=:sdocUuid")
//    public abstract void deleteBySDocUuid(String sdocUuid);
//
//    @Query("DELETE FROM " + DBSchema.Content.TABLE_NAME)
//    public abstract void deleteAll();
//}
