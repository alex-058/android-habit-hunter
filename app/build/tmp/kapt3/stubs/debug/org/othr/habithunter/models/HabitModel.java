package org.othr.habithunter.models;

import java.lang.System;

@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0006H\u00c6\u0003J\t\u0010$\u001a\u00020\bH\u00c6\u0003J\t\u0010%\u001a\u00020\bH\u00c6\u0003J\t\u0010&\u001a\u00020\u000bH\u00c6\u0003JE\u0010\'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u00c6\u0001J\t\u0010(\u001a\u00020\bH\u00d6\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u00d6\u0003J\t\u0010-\u001a\u00020\bH\u00d6\u0001J\t\u0010.\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\bH\u00d6\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\t\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014\u00a8\u00064"}, d2 = {"Lorg/othr/habithunter/models/HabitModel;", "Landroid/os/Parcelable;", "habitId", "", "habitTitle", "habitImage", "Landroid/net/Uri;", "habitGoal", "", "habitProgress", "habitIntervall", "Lorg/othr/habithunter/models/HabitIntervall;", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;IILorg/othr/habithunter/models/HabitIntervall;)V", "getHabitGoal", "()I", "setHabitGoal", "(I)V", "getHabitId", "()Ljava/lang/String;", "setHabitId", "(Ljava/lang/String;)V", "getHabitImage", "()Landroid/net/Uri;", "setHabitImage", "(Landroid/net/Uri;)V", "getHabitIntervall", "()Lorg/othr/habithunter/models/HabitIntervall;", "setHabitIntervall", "(Lorg/othr/habithunter/models/HabitIntervall;)V", "getHabitProgress", "setHabitProgress", "getHabitTitle", "setHabitTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
public final class HabitModel implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String habitId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String habitTitle;
    @org.jetbrains.annotations.NotNull()
    private android.net.Uri habitImage;
    private int habitGoal;
    private int habitProgress;
    @org.jetbrains.annotations.NotNull()
    private org.othr.habithunter.models.HabitIntervall habitIntervall;
    public static final android.os.Parcelable.Creator<org.othr.habithunter.models.HabitModel> CREATOR = null;
    
    @org.jetbrains.annotations.NotNull()
    public final org.othr.habithunter.models.HabitModel copy(@org.jetbrains.annotations.NotNull()
    java.lang.String habitId, @org.jetbrains.annotations.NotNull()
    java.lang.String habitTitle, @org.jetbrains.annotations.NotNull()
    android.net.Uri habitImage, int habitGoal, int habitProgress, @org.jetbrains.annotations.NotNull()
    org.othr.habithunter.models.HabitIntervall habitIntervall) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public HabitModel() {
        super();
    }
    
    public HabitModel(@org.jetbrains.annotations.NotNull()
    java.lang.String habitId, @org.jetbrains.annotations.NotNull()
    java.lang.String habitTitle, @org.jetbrains.annotations.NotNull()
    android.net.Uri habitImage, int habitGoal, int habitProgress, @org.jetbrains.annotations.NotNull()
    org.othr.habithunter.models.HabitIntervall habitIntervall) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHabitId() {
        return null;
    }
    
    public final void setHabitId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHabitTitle() {
        return null;
    }
    
    public final void setHabitTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.net.Uri component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.net.Uri getHabitImage() {
        return null;
    }
    
    public final void setHabitImage(@org.jetbrains.annotations.NotNull()
    android.net.Uri p0) {
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getHabitGoal() {
        return 0;
    }
    
    public final void setHabitGoal(int p0) {
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int getHabitProgress() {
        return 0;
    }
    
    public final void setHabitProgress(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.othr.habithunter.models.HabitIntervall component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.othr.habithunter.models.HabitIntervall getHabitIntervall() {
        return null;
    }
    
    public final void setHabitIntervall(@org.jetbrains.annotations.NotNull()
    org.othr.habithunter.models.HabitIntervall p0) {
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public static final class Creator implements android.os.Parcelable.Creator<org.othr.habithunter.models.HabitModel> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final org.othr.habithunter.models.HabitModel createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final org.othr.habithunter.models.HabitModel[] newArray(int size) {
            return null;
        }
    }
}