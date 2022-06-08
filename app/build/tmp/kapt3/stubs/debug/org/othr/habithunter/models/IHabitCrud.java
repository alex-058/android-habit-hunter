package org.othr.habithunter.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00050\nj\b\u0012\u0004\u0012\u00020\u0005`\u000bH&\u00a8\u0006\f"}, d2 = {"Lorg/othr/habithunter/models/IHabitCrud;", "", "create", "", "habit", "Lorg/othr/habithunter/models/HabitModel;", "getHabitById", "id", "", "getHabits", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "app_debug"})
public abstract interface IHabitCrud {
    
    public abstract void create(@org.jetbrains.annotations.NotNull()
    org.othr.habithunter.models.HabitModel habit);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.ArrayList<org.othr.habithunter.models.HabitModel> getHabits();
    
    @org.jetbrains.annotations.Nullable()
    public abstract org.othr.habithunter.models.HabitModel getHabitById(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
}