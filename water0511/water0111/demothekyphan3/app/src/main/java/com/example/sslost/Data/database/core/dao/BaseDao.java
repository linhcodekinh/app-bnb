package com.example.sslost.Data.database.core.dao;

import androidx.annotation.NonNull;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

import java.util.Collection;

public abstract class BaseDao<Entity> {

    public abstract Entity getEntity(@NonNull String uuid);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(@NonNull Entity entity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(@NonNull Entity... entities);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(@NonNull Collection<? extends Entity> entities);

    @Delete
    public abstract int delete(@NonNull Entity entity);

    @Delete
    public abstract int delete(@NonNull Entity... entities);

    @Delete
    public abstract int delete(@NonNull Collection<? extends Entity> entities);

    @Update
    public abstract int update(@NonNull Entity entity);

    @Update
    public abstract int update(@NonNull Entity... entities);

    @Update
    public abstract int update(@NonNull Collection<? extends Entity> entities);
}
