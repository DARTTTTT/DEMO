.class Landroid/support/design/chip/Chip$2;
.super Landroid/view/ViewOutlineProvider;
.source "Chip.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/design/chip/Chip;->initOutlineProvider()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/support/design/chip/Chip;


# direct methods
.method constructor <init>(Landroid/support/design/chip/Chip;)V
    .registers 2
    .parameter

    .line 277
    iput-object p1, p0, Landroid/support/design/chip/Chip$2;->this$0:Landroid/support/design/chip/Chip;

    invoke-direct {p0}, Landroid/view/ViewOutlineProvider;-><init>()V

    return-void
.end method


# virtual methods
.method public getOutline(Landroid/view/View;Landroid/graphics/Outline;)V
    .registers 3
    .parameter
    .parameter
    .annotation build Landroid/annotation/TargetApi;
        value = 0x15
    .end annotation

    .line 281
    iget-object p1, p0, Landroid/support/design/chip/Chip$2;->this$0:Landroid/support/design/chip/Chip;

    invoke-static {p1}, Landroid/support/design/chip/Chip;->access$000(Landroid/support/design/chip/Chip;)Landroid/support/design/chip/ChipDrawable;

    move-result-object p1

    if-eqz p1, :cond_12

    .line 282
    iget-object p1, p0, Landroid/support/design/chip/Chip$2;->this$0:Landroid/support/design/chip/Chip;

    invoke-static {p1}, Landroid/support/design/chip/Chip;->access$000(Landroid/support/design/chip/Chip;)Landroid/support/design/chip/ChipDrawable;

    move-result-object p1

    invoke-virtual {p1, p2}, Landroid/support/design/chip/ChipDrawable;->getOutline(Landroid/graphics/Outline;)V

    goto :goto_16

    :cond_12
    const/4 p1, 0x0

    .line 284
    invoke-virtual {p2, p1}, Landroid/graphics/Outline;->setAlpha(F)V

    :goto_16
    return-void
.end method
