package org.othr.habithunter.ui.dashboard;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0016J \u0010 \u001a\u00020\u001a2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\"j\b\u0012\u0004\u0012\u00020\u001d`#H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lorg/othr/habithunter/ui/dashboard/DashboardFragment;", "Landroidx/fragment/app/Fragment;", "Lorg/othr/habithunter/adapters/HabitClickListener;", "()V", "_binding", "Lorg/othr/habithunter/databinding/FragmentDashboardBinding;", "binding", "getBinding", "()Lorg/othr/habithunter/databinding/FragmentDashboardBinding;", "dashboardViewModel", "Lorg/othr/habithunter/ui/dashboard/DashboardViewModel;", "getDashboardViewModel", "()Lorg/othr/habithunter/ui/dashboard/DashboardViewModel;", "setDashboardViewModel", "(Lorg/othr/habithunter/ui/dashboard/DashboardViewModel;)V", "loggedInViewModel", "Lorg/othr/habithunter/ui/profile/LoggedInViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onHabitClick", "habit", "Lorg/othr/habithunter/models/HabitModel;", "onResume", "onStart", "render", "habitList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "app_debug"})
public final class DashboardFragment extends androidx.fragment.app.Fragment implements org.othr.habithunter.adapters.HabitClickListener {
    private org.othr.habithunter.databinding.FragmentDashboardBinding _binding;
    public org.othr.habithunter.ui.dashboard.DashboardViewModel dashboardViewModel;
    private org.othr.habithunter.ui.profile.LoggedInViewModel loggedInViewModel;
    
    public DashboardFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.othr.habithunter.ui.dashboard.DashboardViewModel getDashboardViewModel() {
        return null;
    }
    
    public final void setDashboardViewModel(@org.jetbrains.annotations.NotNull()
    org.othr.habithunter.ui.dashboard.DashboardViewModel p0) {
    }
    
    private final org.othr.habithunter.databinding.FragmentDashboardBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void render(java.util.ArrayList<org.othr.habithunter.models.HabitModel> habitList) {
    }
    
    @java.lang.Override()
    public void onHabitClick(@org.jetbrains.annotations.NotNull()
    org.othr.habithunter.models.HabitModel habit) {
    }
}