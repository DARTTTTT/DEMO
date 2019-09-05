.class public Landroid/arch/lifecycle/ViewModelStore;
.super Ljava/lang/Object;
.source "ViewModelStore.java"


# annotations


# instance fields
.field private final mMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap<",
            "Ljava/lang/String;",
            "Landroid/arch/lifecycle/ViewModel;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .registers 2

    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/arch/lifecycle/ViewModelStore;->mMap:Ljava/util/HashMap;

    return-void
.end method


# virtual methods
.method public final clear()V
    .registers 3

    .line 55
    iget-object v0, p0, Landroid/arch/lifecycle/ViewModelStore;->mMap:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_a
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1a

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/arch/lifecycle/ViewModel;

    .line 56
    invoke-virtual {v1}, Landroid/arch/lifecycle/ViewModel;->onCleared()V

    goto :goto_a

    .line 58
    :cond_1a
    iget-object v0, p0, Landroid/arch/lifecycle/ViewModelStore;->mMap:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    return-void
.end method

.method final get(Ljava/lang/String;)Landroid/arch/lifecycle/ViewModel;
    .registers 3
    .parameter

    .line 48
    iget-object v0, p0, Landroid/arch/lifecycle/ViewModelStore;->mMap:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroid/arch/lifecycle/ViewModel;

    return-object p1
.end method

.method final put(Ljava/lang/String;Landroid/arch/lifecycle/ViewModel;)V
    .registers 4
    .parameter
    .parameter

    .line 41
    iget-object v0, p0, Landroid/arch/lifecycle/ViewModelStore;->mMap:Ljava/util/HashMap;

    invoke-virtual {v0, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroid/arch/lifecycle/ViewModel;

    if-eqz p1, :cond_d

    .line 43
    invoke-virtual {p1}, Landroid/arch/lifecycle/ViewModel;->onCleared()V

    :cond_d
    return-void
.end method
