.class public abstract Landroid/arch/lifecycle/Lifecycle;
.super Ljava/lang/Object;
.source "Lifecycle.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/arch/lifecycle/Lifecycle$State;,
        Landroid/arch/lifecycle/Lifecycle$Event;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    .line 75
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public abstract addObserver(Landroid/arch/lifecycle/LifecycleObserver;)V
    .annotation build Landroid/support/annotation/MainThread;
    .end annotation
.end method

.method public abstract getCurrentState()Landroid/arch/lifecycle/Lifecycle$State;
    .annotation build Landroid/support/annotation/MainThread;
    .end annotation

    .annotation build Landroid/support/annotation/NonNull;
    .end annotation
.end method

.method public abstract removeObserver(Landroid/arch/lifecycle/LifecycleObserver;)V
    .annotation build Landroid/support/annotation/MainThread;
    .end annotation
.end method
