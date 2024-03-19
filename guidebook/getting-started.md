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
如果还没有，您可以制作一个 <ItemLink id="meteorite_compass" />, 它将指向最近的 <ItemLink id="mysterious_cube" />。

一旦您找到一颗陨石，请在陨石中心挖掘。你会发现赛特斯石英簇，赛特斯石英芽，各种类型的 [赛特斯石英母岩](items-blocks-machines/budding_certus.md)，以及中心的神秘方块。

挖掘您发现的任何赛特斯石英簇和赛特斯石英块。您也可以采集赛特斯石英母岩，但如果没有精准采集附魔的工具，它们会退化 1 级。

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
幸运的是，当 <ItemLink id="growth_accelerator" /> 放在石英母岩旁边时，会大大加快这一过程。您应该首先建造几个这样的装置。

<GameScene zoom="4" background="transparent">
<ImportStructure src="assets/assemblies/budding_certus_2.snbt" />
<IsometricCamera yaw="195" pitch="30" />
</GameScene>

如果您没有足够的石英来制作 <ItemLink id="energy_acceptor" /> 或 <ItemLink id="vibration_chamber" />，
您可以制作一个 <ItemLink id="crank" /> 并将其安装在催生器的末端。

自动收获赛特斯石英请 [参阅此处](example-setups/simple-certus-farm.md)。

## 关于福鲁伊克斯水晶的题外话

您将会需要的另一种材料是福鲁伊克斯水晶，您在制作催生器时已经用到过。将充能赛特斯石英水晶、红石粉和下界石英投入水中即可制成。自动化这一过程“留待读者练习”。

<ItemLink id="charger" /> 是制作 <ItemLink id="charged_certus_quartz_crystal" /> 所必需的，如果您还没有充能器，则需要制作一个。

## 压印一些处理器

在您采集陨石的过程中，您会发现有四个“压印模板”是在破坏神秘方块后找到的。在 <ItemLink id="inscriber" /> 中，它们被用来制作三种处理器。

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

### What do I need to know to get started?

First, ME Stores items inside of other items, called [Storage cells](items-blocks-machines/storage_cells.md); there are 5 tiers with ever increasing amounts of
storage. In order to use a Storage Cell it must be placed inside either an <ItemLink id="chest" />,
or an <ItemLink id="drive" />.

The <ItemLink id="chest" /> shows you the contents of the Cell as soon as its placed inside, and you
can add and remove items from it as if it were a <ItemLink id="minecraft:chest" />, with the exception that the items are
actually stored in the Storage cells, and not the <ItemLink id="chest" /> itself.

The <ItemLink id="chest" /> is quite situational and limited in utility. To really
take advantage of AE2, you need to set up an [ME Network](ae2-mechanics/me-network-connections.md).

## Your Very First ME System

Now that you have all of the basic materials and machines for Applied Energistics 2, you can make your first ME (Matter Energy) system. This will be a very basic one, no autocrafting, no logistics, just nice, simple, searchable storage.

<GameScene zoom="6" interactive={true}>
<ImportStructure src="assets/assemblies/tiny_me_system.snbt" />

</GameScene>

*   Your ingredients list:
    * 1x <ItemLink id="drive" />
    * 1x <ItemLink id="terminal" /> or <ItemLink id="crafting_terminal" />
    * 1x <ItemLink id="energy_acceptor" />
    * A few [cables](items-blocks-machines/cables.md), either glass, covered, or smart, but not dense
    * A few [storage cells](items-blocks-machines/storage_cells.md), recommended of the 4k variety for a good mix of
    capacity and types (it would be more efficient to [partition](items-blocks-machines/cell_workbench.md) a mix of 4k and 1k but that's a complexity we won't go into now)
---
1.  Place the drive down.
2.  The energy acceptor (and several other AE2 [devices](ae2-mechanics/devices.md)) comes in 2 modes, cube and flat. They can be switched between in a crafting grid. If your energy acceptor is a cube, place it down next to the drive. If it's a flat square, place a cable on the drive and place the acceptor on that.
3.  Run energy into the energy acceptor with a cable/pipe/conduit from your favorite energy-generation mod.
4.  Place a cable on top of the drive (or otherwise at eye level) and place your terminal or crafting terminal on it.
5.  Put your storage cells into the drive
6.  Profit
7.  Fiddle with the terminal's settings
8.  Bask in your ultimate power and ability
9.  Realize that this network is, in the grand scheme, rather small

### Expanding your Network

So you have some basic storage, and access to that storage, it's a good start, but you'll likely be looking to maybe
automate some processing.

A great example of this is to place a <ItemLink id="export_bus" /> on the top of a furnace to
dump in ores, and a <ItemLink id="import_bus" />
on the bottom of the furance to extract furnaced ores.

The <ItemLink id="export_bus" /> lets you export items from the network, into the attached
inventory, while the <ItemLink id="import_bus" /> imports items from the attached inventory into
the network.

### Overcoming Limits

At this point you probably getting close to 8 or so [devices](ae2-mechanics/devices.md), once you hit 9 devices you'll have to start
managing [channels](ae2-mechanics/channels.md). Many devices but not all, require a channel to
function.

By default a network can support 8 channels, once you break this limit, you'll have to add
an <ItemLink id="controller" /> to your network. this allows you to expand your network greatly.
[Smart cables](items-blocks-machines/cables.md) will allow you to see how channels are routed through your network. Use them extensively when starting out to learn how channels act, or if you have a lot of redstone and glowstone.
