---
navigation:
  title: 入门 (1.20+)
  position: 10
---

<div class="notification is-info">
  以下信息仅适用于 Minecraft 1.20 及更新版本中的 应用能源 2 (AE2)。
</div>

# 入门

## 获取初始材料

<GameScene zoom="4" background="transparent">
  <ImportStructure src="assets/assemblies/meteor_interior.snbt" />
</GameScene>

要开始发展应用能源 2 (AE2)，首先必须找到一块 [陨石](ae2-mechanics/meteorites.md)。这些陨石相当常见，往往会在地形上留下巨大的坑洞，所以你也许在旅途中遇到过。
如果还没有，你可以制作一个 <ItemLink id="meteorite_compass" />, 它将指向最近的 <ItemLink id="mysterious_cube" />。

一旦你找到一颗陨石，请在陨石中心挖掘。你会发现赛特斯石英簇，赛特斯石英芽，各种类型的 [赛特斯石英母岩](items-blocks-machines/budding_certus.md)，以及中心的神秘方块。

挖掘你发现的任何赛特斯石英簇和赛特斯石英块。你也可以采集赛特斯石英母岩，但如果没有精准采集附魔的工具，它们会退化 1 级。

不要破坏任何无瑕的赛特斯石英母岩，因为即使用精准采集附魔的工具，它们也会退化成有瑕疵的赛特斯石英母岩，而且不可能将它们修复回无暇。

还可以挖掘陨石中央的神秘方块，以获得全部 4 个压印模板。

## 培育赛特斯石英

<GameScene zoom="4" background="transparent">
<ImportStructure src="assets/assemblies/budding_certus_1.snbt" />
</GameScene>

赛特斯石英芽会从 [赛特斯石英母岩](items-blocks-machines/budding_certus.md)中萌发，与紫水晶类似。
如果破坏一个尚未长成的石英芽，它将掉落一个 <ItemLink id="certus_quartz_dust" />，不受时运魔咒影响。
如果破坏一簇完全长成的石英簇，则会掉落四个 <ItemLink id="certus_quartz_crystal" />，时运魔咒会增加掉落数量。

赛特斯石英母岩有四个损坏等级：无瑕、有瑕疵、开裂和损坏。

<GameScene zoom="4" background="transparent">
<ImportStructure src="assets/assemblies/budding_blocks.snbt" />
<IsometricCamera yaw="195" pitch="30" />
</GameScene>

每当一个石英芽生长到另一个阶段，石英母岩就有几率退化一级，最终变成一个普通的石英块。
只要将石英母岩（或石英块）与一个或多个 <ItemLink id="charged_certus_quartz_crystal" /> 一起扔到水中，
就能修复它们（或者生成新的石英母岩）。

<RecipeFor id="damaged_budding_quartz" />

无瑕的赛特斯石英母岩不会退化，并能无限生成赛特斯石英。
不过，它们无法制作或用镐采集，即使使用精准采集。(不过它们*可以*用 [空间存储](ae2-mechanics/spatial-io.md) 移动)

就赛特斯石英芽本身而言，其生长速度非常缓慢。
幸运的是，当 <ItemLink id="growth_accelerator" /> 放在石英母岩旁边时，会大大加快这一过程。当务之急是建造几个这样的装置。

<GameScene zoom="4" background="transparent">
<ImportStructure src="assets/assemblies/budding_certus_2.snbt" />
<IsometricCamera yaw="195" pitch="30" />
</GameScene>

如果你没有足够的石英来制作 <ItemLink id="energy_acceptor" /> 或 <ItemLink id="vibration_chamber" />，
你可以制作一个 <ItemLink id="crank" /> 并将其安装在催生器的末端。

自动收获赛特斯石英请 [参阅此处](example-setups/simple-certus-farm.md)。

## 关于福鲁伊克斯水晶的题外话

你将会需要的另一种材料是福鲁伊克斯水晶，其在制作催生器时已经用到过。将充能赛特斯石英水晶、红石粉和下界石英投入水中即可制成。自动化这一过程“留待读者练习”。

<ItemLink id="charger" /> 是制作 <ItemLink id="charged_certus_quartz_crystal" /> 所必需的，如果你还没有充能器，则需要制作一个。

## 压印一些处理器

在你采集陨石的过程中，你会发现有四个“压印模板”是在破坏神秘方块后找到的。在 <ItemLink id="inscriber" /> 中，它们被用来制作三种处理器。

<ItemGrid>
  <ItemIcon id="silicon_press" />

  <ItemIcon id="logic_processor_press" />

  <ItemIcon id="calculation_processor_press" />

  <ItemIcon id="engineering_processor_press" />
</ItemGrid>

压印器是一个“多面交互”机器，就像原版熔炉一样。从顶部或底部输入时，物品会被放入顶部或底部的插槽中，而从侧面或背面输入时，物品会被放入中间的插槽中。产物可以从侧面或背面提取。

为便于使用漏斗实现自动化（并尽可能减轻管线杂乱），可使用 <ItemLink id="certus_quartz_wrench" /> 旋转压印器。

每种类型的处理器都制作一些，为下一步构建一个非常基本的 ME 系统做准备。处理器生产自动化“[留作读者练习](example-setups/processor-automation.md)”。

## 物质能量技术：ME 网络和存储

### 什么是 ME 存储?

它的发音是 Emm-Eee，代表物质能量 (Matter Energy)。

物质能量 (ME) 是 应用能源 2 (AE2) 的主要组成部分，
它就像是疯狂科学家版的多方块箱子，可以彻底改变你的存储情况。
ME 与 Minecraft 中的其他存储系统极为不同，可能需要一点发散性思维才能适应；
但一旦你开始使用，在狭小空间中的大量存储和多重访问终端只是可能实现的冰山一角。

### 我需要知道哪些入门知识?

首先，ME 将物品储存在其他物品内部，称为 [存储元件](items-blocks-machines/storage_cells.md)；存储元件共有 5 级，存储量逐级递增。
要使用存储元件，必须将其放置在 <ItemLink id="chest" />
或 <ItemLink id="drive" /> 中。

只要将存储元件放入 <ItemLink id="chest" /> 中，ME 箱子就会显示存储元件中的内容，你还可以向其添加或移除物品，
就像 <ItemLink id="minecraft:chest" /> 一样，不同的是，物品实际上存储在存储元件中，
而不是 <ItemLink id="chest" /> 本身。

The <ItemLink id="chest" /> 的功能非常有限，只能在特定情况下使用。
要真正利用 AE2 的优势，你需要建立一个 [ME 网络](ae2-mechanics/me-network-connections.md)。

## 你的第一个 ME 系统

现在你已经拥有了应用能源 2 的所有基本材料和机器，你可以制作第一个 ME（物质能量）系统了。这将是一个非常基本的系统，没有自动制造，没有物流，只有漂亮、简单、可搜索的存储。

<GameScene zoom="6" interactive={true}>
<ImportStructure src="assets/assemblies/tiny_me_system.snbt" />

</GameScene>

*   材料清单:
    * 1x <ItemLink id="drive" />
    * 1x <ItemLink id="terminal" /> 或者 <ItemLink id="crafting_terminal" />
    * 1x <ItemLink id="energy_acceptor" />
    * 若干 [线缆](items-blocks-machines/cables.md)，玻璃线缆，包层线缆或智能线缆，但不是致密线缆
    * 若干 [存储元件](items-blocks-machines/storage_cells.md)，建议使用 4k 存储元件，以实现容量和类型的良好组合
    （4k 和 1k 混合 [分区](items-blocks-machines/cell_workbench.md) 会更有效，但这是一个复杂的问题，我们现在就不讨论了）
---
1.  放置驱动器。
2.  能源接收器（以及其他几种 AE2 [设备](ae2-mechanics/devices.md)）有两种变体，方块和面板。它们可以在合成栏中进行转换。如果你的能源接收器是方块，就把它放在驱动器旁边。如果是面板，则在驱动器上放置一根电缆，然后将接受器放在电缆上。
3.  用电缆/管道/导管将能量从你最喜欢的能量发生器输入能源接收器。
4.  将线缆放在驱动器顶部（或与视线水平的位置），然后将终端或合成终端放在上面。
5.  将存储元件放入驱动器。
6.  享受。
7.  摆弄终端设置。
8.  尽情享受你的终极力量和能力。
9.  意识到从总体来看，这个网络非常小。

### 扩展你的网络

这样你就有了一些基本的存储空间，并可以访问这些存储空间，
这是一个良好的开端，但你很可能会寻求一些自动化处理。

一个很好的例子是
在熔炉顶部放置一个 <ItemLink id="export_bus" /> 来供给矿石，
在熔炉底部放置一个 <ItemLink id="import_bus" /> 来提取烧炼后的矿石。

<ItemLink id="export_bus" /> 可将物品从网络导出到其贴靠的容器，
而 <ItemLink id="import_bus" /> 可将物品从其贴靠的容器导入网络。

### 克服限制

此时，你可能拥有接近 8 个左右的 [设备](ae2-mechanics/devices.md)，一旦达到 9 个设备，你就必须开始管理
[频道](ae2-mechanics/channels.md)。许多设备需要频道才能运行，但并非所有设备都是如此。

默认情况下，一个网络可支持 8 个频道，一旦超过这一限制，就必须在网络中添加 <ItemLink id="controller" />，这样就可以大大扩展网络。
[智能线缆](items-blocks-machines/cables.md) 可以让你查看频道在网络中的路由情况。在刚开始了解频道的作用时，或者在拥有大量红石粉和荧石粉的情况下，可以广泛使用它们。
