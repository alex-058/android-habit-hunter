package org.othr.habithunter.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0015B%\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000bR\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lorg/othr/habithunter/adapters/HabitAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lorg/othr/habithunter/adapters/HabitAdapter$MainHolder;", "habits", "Ljava/util/ArrayList;", "Lorg/othr/habithunter/models/HabitModel;", "Lkotlin/collections/ArrayList;", "listener", "Lorg/othr/habithunter/adapters/HabitClickListener;", "(Ljava/util/ArrayList;Lorg/othr/habithunter/adapters/HabitClickListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeAt", "MainHolder", "app_debug"})
public final class HabitAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<org.othr.habithunter.adapters.HabitAdapter.MainHolder> {
    private java.util.ArrayList<org.othr.habithunter.models.HabitModel> habits;
    private final org.othr.habithunter.adapters.HabitClickListener listener = null;
    
    public HabitAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<org.othr.habithunter.models.HabitModel> habits, @org.jetbrains.annotations.NotNull()
    org.othr.habithunter.adapters.HabitClickListener listener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.othr.habithunter.adapters.HabitAdapter.MainHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    org.othr.habithunter.adapters.HabitAdapter.MainHolder holder, int position) {
    }
    
    public final void removeAt(int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lorg/othr/habithunter/adapters/HabitAdapter$MainHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lorg/othr/habithunter/databinding/CardviewHabitsBinding;", "(Lorg/othr/habithunter/adapters/HabitAdapter;Lorg/othr/habithunter/databinding/CardviewHabitsBinding;)V", "getBinding", "()Lorg/othr/habithunter/databinding/CardviewHabitsBinding;", "bind", "", "habit", "Lorg/othr/habithunter/models/HabitModel;", "listener", "Lorg/othr/habithunter/adapters/HabitClickListener;", "app_debug"})
    public final class MainHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final org.othr.habithunter.databinding.CardviewHabitsBinding binding = null;
        
        public MainHolder(@org.jetbrains.annotations.NotNull()
        org.othr.habithunter.databinding.CardviewHabitsBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.othr.habithunter.databinding.CardviewHabitsBinding getBinding() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        org.othr.habithunter.models.HabitModel habit, @org.jetbrains.annotations.NotNull()
        org.othr.habithunter.adapters.HabitClickListener listener) {
        }
    }
}