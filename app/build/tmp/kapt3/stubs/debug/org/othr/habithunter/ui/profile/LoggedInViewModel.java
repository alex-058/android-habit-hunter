package org.othr.habithunter.ui.profile;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0016\u001a\u00020\u0017R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lorg/othr/habithunter/ui/profile/LoggedInViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "firebaseAuthManager", "Lorg/othr/habithunter/firebase/FirebaseAuthManager;", "getFirebaseAuthManager", "()Lorg/othr/habithunter/firebase/FirebaseAuthManager;", "setFirebaseAuthManager", "(Lorg/othr/habithunter/firebase/FirebaseAuthManager;)V", "liveFirebaseUser", "Landroidx/lifecycle/MutableLiveData;", "Lcom/google/firebase/auth/FirebaseUser;", "getLiveFirebaseUser", "()Landroidx/lifecycle/MutableLiveData;", "setLiveFirebaseUser", "(Landroidx/lifecycle/MutableLiveData;)V", "loggedOut", "", "getLoggedOut", "setLoggedOut", "logOut", "", "app_debug"})
public final class LoggedInViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private org.othr.habithunter.firebase.FirebaseAuthManager firebaseAuthManager;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.google.firebase.auth.FirebaseUser> liveFirebaseUser;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> loggedOut;
    
    public LoggedInViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.othr.habithunter.firebase.FirebaseAuthManager getFirebaseAuthManager() {
        return null;
    }
    
    public final void setFirebaseAuthManager(@org.jetbrains.annotations.NotNull()
    org.othr.habithunter.firebase.FirebaseAuthManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.google.firebase.auth.FirebaseUser> getLiveFirebaseUser() {
        return null;
    }
    
    public final void setLiveFirebaseUser(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.google.firebase.auth.FirebaseUser> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getLoggedOut() {
        return null;
    }
    
    public final void setLoggedOut(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    public final void logOut() {
    }
}