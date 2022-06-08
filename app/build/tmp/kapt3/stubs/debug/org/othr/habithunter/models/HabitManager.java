package org.othr.habithunter.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\rH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lorg/othr/habithunter/models/HabitManager;", "Lorg/othr/habithunter/models/IHabitCrud;", "()V", "habits", "Ljava/util/ArrayList;", "Lorg/othr/habithunter/models/HabitModel;", "create", "", "habit", "getHabitById", "id", "", "getHabits", "Lkotlin/collections/ArrayList;", "app_debug"})
public final class HabitManager implements org.othr.habithunter.models.IHabitCrud {
    @org.jetbrains.annotations.NotNull()
    public static final org.othr.habithunter.models.HabitManager INSTANCE = null;
    private static java.util.ArrayList<org.othr.habithunter.models.HabitModel> habits;
    
    private HabitManager() {
        super();
    }
    
    @java.lang.Override()
    public void create(@org.jetbrains.annotations.NotNull()
    org.othr.habithunter.models.HabitModel habit) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.ArrayList<org.othr.habithunter.models.HabitModel> getHabits() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public org.othr.habithunter.models.HabitModel getHabitById(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
}