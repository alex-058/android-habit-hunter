package org.othr.habithunter.ui.inputProgressHabit;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u000eJ\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0016"}, d2 = {"Lorg/othr/habithunter/ui/inputProgressHabit/InputProgressHabitViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_habit", "Landroidx/lifecycle/MutableLiveData;", "Lorg/othr/habithunter/models/HabitModel;", "observableHabit", "Landroidx/lifecycle/LiveData;", "getObservableHabit", "()Landroidx/lifecycle/LiveData;", "boostProgress", "", "decreaseProgress", "n", "", "getGoal", "getHabit", "id", "", "getProgress", "increaseProgress", "setProgress", "app_debug"})
public final class InputProgressHabitViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<org.othr.habithunter.models.HabitModel> _habit = null;
    
    public InputProgressHabitViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<org.othr.habithunter.models.HabitModel> getObservableHabit() {
        return null;
    }
    
    public final void getHabit(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
    }
    
    public final void increaseProgress(int n) {
    }
    
    public final void decreaseProgress(int n) {
    }
    
    public final int getProgress() {
        return 0;
    }
    
    public final void setProgress(int n) {
    }
    
    public final int getGoal() {
        return 0;
    }
    
    public final void boostProgress() {
    }
}