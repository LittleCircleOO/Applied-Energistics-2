---
navigation:
  parent: ae2-mechanics/ae2-mechanics-index.md
  title: 自动合成
  icon: pattern_provider
---

# 自动合成

### 大家伙

<GameScene zoom="4" interactive={true}>
  <ImportStructure src="../assets/assemblies/autocraft_setup_greebles.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

自动合成是 AE2 的主要功能之一。您可以让您的 ME 系统为您代劳，而不必手动制作正确数量的每种子原料，像某种*帕鲁*一样劳累。
亦或是自动制作物品并导出到某个地方。亦或是通过巧妙的应急行为自动保持一定数量的库存。
它还适用于流体，如果你有某些额外的 MOD 材料类型，如通用机械的气体，那么这些材料也同样适用。它非常棒。

这是一个相当复杂的话题，所以请坐好，我们开始吧。

自动合成装置包括 3 个部分：
- 发送制作请求的来源
- 合成处理单元(CPU)
- <ItemLink id="pattern_provider" />

具体情况如下：

1.  一些东西创建了制作请求。这可能是你在终端点击了某件可自动制作的物品、
    或者输出总线/ME 接口上的合成卡请求输出/储存其中一件物品。

*   （**重要：** 使用“选取方块”键（通常是鼠标中键）来请求制作已有库存的物品，这可能会与物品整理模组发生冲突），

2.  ME 系统会计算满足要求所需的材料和前置合成步骤，并将其存储在选定的合成 CPU 中

3.  带有相关 [样板](../items-blocks-machines/patterns.md) 的 <ItemLink id="pattern_provider" /> 会将样板中指定的材料推送到任何相邻的容器中。
    如果是工作台配方（“合成样板”）容器将是一个 <ItemLink id="molecular_assembler" />。
    如果是非合成配方（“处理样板”）容器将是其他一些块、机器或精心制作的红石控制装置。

4.  合成的产物会以某种方式返回系统，无论是通过输入总线、ME 接口，还是将产物推送回样板供应器。
    **请注意，必须发生“物品进入系统”事件，不能单纯将产物输入一个带有 <ItemLink id="storage_bus" /> 的箱子。**

5.  如果某合成是请求中另一合成的前置条件，则物品会存储在该合成 CPU 中，然后用于该前置合成。

## 递归配方

<ItemImage id="minecraft:netherite_upgrade_smithing_template" scale="4" />

自动合成算法 *无法* 处理的一种情况是递归配方。例如“1 个红石粉 = 2 个红石粉”这样的复制配方，来源于将红石粉丢入植物魔法魔力池。
另一个例子是原版 Minecraft 中的锻造模板。
不过，有 [一种方法可以处理这些配方](../example-setups/recursive-crafting-setup.md)。

# 样板

<ItemImage id="crafting_pattern" scale="4" />

样板在 <ItemLink id="pattern_encoding_terminal" /> 中由空白样板制作。

有几种不同类型的样板适用于不同的合成方式：

*   <ItemLink id="crafting_pattern" /> 对工作台合成的配方进行编码。它们可以直接放在 <ItemLink id="molecular_assembler" /> 中
    使其在给定材料的情况下制作出结果。但它们的主要用途是放在分子装配室相邻的 <ItemLink id="pattern_provider" /> 中。
    在这种情况下，样板供应器具有特殊行为，会将相关样板连同材料一起发送给相邻的分子装配室。
    由于装配器会自动将制作结果弹射到相邻的库存中，因此只需在样板供应器上安装一个分子装配室，就能自动制作合成样板指定的配方。

***

*   <ItemLink id="smithing_table_pattern" /> 与合成样板非常相似，但它们编码的是锻造台配方。
    它们也由样板供应器和分子装配室自动完成，功能完全相同。
    事实上，合成样板、锻造台样板和切石机样板可以在相同的装置中使用。

***

*   <ItemLink id="stonecutting_pattern" /> 与合成样板非常相似，但它们编码的是切石机配方。
    它们也由样板供应器和分子装配室自动完成，功能完全相同。
    事实上，合成样板、锻造台样板和切石机样板可以在相同的装置中使用。

***

*   <ItemLink id="processing_pattern" /> 是自动合成中许多灵活性的来源。它们是最通用的类型，简单地说就是
    “如果样板供应器将这些材料推送到邻近的容器中，ME 系统将在近期或远期的某个时间点收到这些产物”。
    几乎所有模组机械或熔炉等都可以通过它们进行自动合成。因为它们的使用非常普遍，而且不关心在推送材料和接收结果之间会发生什么，
    所以你可以做一些非常有趣的事情，比如把材料输入到整个复杂的工厂生产链中，这个生产链会分拣出东西，从无限生产的农场中接收其他材料，
    打印整个蜜蜂电影剧本，只要能得到样板指定的产物，ME 系统就不会关心。
    事实上，它甚至不在乎材料是否与结果有任何关联。
    你可以告诉它“1 块樱花木板 = 1 颗下界之星”，然后让你的凋灵农场在收到樱花木板时杀死一个凋灵，这样就可以了。

具有相同样板的多个 <ItemLink id="pattern_provider" /> 同样支持，并可并行工作。此外，你还可以设置一个样板，
例如，8 块圆石 = 8 块石头，而不是 1 块圆石 = 1 块石头，
这样样板供应器就会在每次操作中向你的熔炉装置中输入 8 块圆石，而不是一次输入一块。

## 最通用的“样板”形式

实际上，还有一种比处理样板更“通用”的“样板”。一个带有合成卡的 <ItemLink id="level_emitter" /> 可以被设置为发出红石信号以制作某种东西。
这种“样板”并不定义或甚至不关心材料。它说的只是“如果你从这个标准发信器发出红石信号，ME 系统将在近期或远期的某个时间点收到这个产物”。
这通常用于激活和停用不需要输入材料的无限农场，或者用于激活处理递归配方的系统（标准自动合成无法理解）
例如，如果你有一台可以复制圆石的机器，就可以激活“1 块圆石 = 2 块圆石”的自动合成。

# 合成处理单元 CPU

<GameScene zoom="4" background="transparent">
  <ImportStructure src="../assets/assemblies/crafting_cpus.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

合成 CPU 负责管理制作请求/任务。在执行多步骤的制作任务时，它们会存储中间材料，并影响任务的规模和完成速度。
它们是多方块块结构，必须是矩形棱柱，至少有一个合成存储器。

合成 CPU 由以下方块构成：

*   (必需) [合成存储器](../items-blocks-machines/crafting_cpu_multiblock.md)，提供所有标准元件容量 (1k, 4k, 16k, 64k, 256k)。它们存储合成中涉及的材料和中间材料，
    因此需要更大或更多的存储单元，CPU 才能处理含有更多材料的制作任务。
*   (可选) <ItemLink id="crafting_accelerator" />，让系统更频繁地从样板供应器那里发送材料批次。
    比如说，一个周围有 6 个分子装配室的样板供应器就可以同时向所有 6 个分子装配室发送材料（从而使用），而不是只向其中一个分子装配室发送材料。
*   (可选) <ItemLink id="crafting_monitor" />，它们显示 CPU 当前正在处理的任务。它们可以通过 <ItemLink id="color_applicator" /> 上色。
*   (可选) <ItemLink id="crafting_unit" />，它们只用于填充空间，以便 CPU 成为一个矩形棱柱。

每个合成 CPU 处理一个请求或任务，因此，如果要同时请求一个运算处理器和 256 个平滑石头，就需要 2 个多方块 CPU。

可以将它们设置为处理来自玩家、自动化（输出总线和 ME 接口）或两者的请求。

# 样板供应器

<Row>
<BlockImage id="pattern_provider" scale="4" />

<BlockImage id="pattern_provider" p:push_direction="up" scale="4" />

<GameScene zoom="4" background="transparent">
  <ImportStructure src="../assets/blocks/cable_pattern_provider.snbt" />
</GameScene>
</Row>

<ItemLink id="pattern_provider" /> 是自动制作系统与世界互动的主要方式。它们将 [样板](../items-blocks-machines/patterns.md) 中的材料推送到邻近的容器中，物品也可以输入其中，以便将其输入网络。
通常情况下，将机器的输出输送回附近的样板供应器（通常是推送材料的供应器），而不是使用 <ItemLink id="import_bus" /> 将机器的输出送入网络，就能节省一个频道。

值得注意的是，由于它们直接从合成 CPU 中的 [合成存储器](../items-blocks-machines/crafting_cpu_multiblock.md#crafting-storage) 推送材料，
因此它们的库存中实际上并不包含材料，所以你无法从它们那里输出材料。你必须让样板供应器推送到另一个容器（如一个桶），然后再从那里输出。

还需要注意的是，样板供应器必须一次性推送所有材料，不能推送半批次的材料。这一点很值得利用。

样板供应器与 [子网络](../ae2-mechanics/subnetworks.md) 上的 ME 接口有一种特殊的交互方式：如果 ME 接口未经修改（请求槽中没有任何内容），
样板供应器将完全跳过接口，直接推送到该子网络的 [存储](../ae2-mechanics/import-export-storage.md)，
跳过接口，不向其填充材料批次，更重要的是，不输入下一个批次，直到存储中有空间。

具有相同样板的多个样板供应器同样支持，并可并行工作。

样板供应器会尝试将其材料批次轮询到所有面，从而并行使用所有连接的机器。

## 变种

样板供应器有三种不同的变体：普通、定向和面板。
这将影响它们向哪一边推送材料、从哪一边接收物品以及为哪一边提供网络连接。

*   普通样板供应器向四面八方推送材料，接收来自四面八方的输入，并像大多数 AE2 机器一样，像线缆一样向各方提供网络连接。

*   定向样板供应器是通过在普通样板供应器上使用 <ItemLink id="certus_quartz_wrench" /> 来改变其方向的。 
    它们只将材料推送到选定的一侧，接收来自所有侧的输入，特别是不在选定侧提供网络连接。
    如果你想建立一个子网络，这就允许它们在不连接网络的情况下向 AE2 机器推送。

*   面板样板供应器是一种 [线缆子部件](../ae2-mechanics/cable-subparts.md)，因此可以在同一根线缆上放置多个，从而实现紧凑的装置。
    它们的作用类似于定向样板供应器上的选定侧，提供样板、接收输入，但不提供网络连接。

样板供应器的普通和面板变体可以在合成栏中进行转换。

## 设置

样板供应器有多种模式：

*   **阻挡模式** 如果机器中已经有材料，则会阻止样板供应器推送新的材料。
*   **锁定合成** 可以在各种红石条件下锁定样板供应器，或者直到前一个合成的产物被输入到该特定样板供应器中。
*   样板供应器可在 <ItemLink id="pattern_access_terminal" /> 上显示或隐藏。

## 优先级

点击界面右上角的扳手可以设置优先级。如果同一项目有多个 [样板](../items-blocks-machines/patterns.md)，
则优先级较高的样板供应器中的样板将优先于优先级较低的样板供应器中的样板，除非网络不具备优先级较高样板的材料。

# 分子装配室

<BlockImage id="molecular_assembler" scale="4" />

<ItemLink id="molecular_assembler" /> 接收输入的物品，并执行相邻 <ItemLink id="pattern_provider" />，
或者插入的 <ItemLink id="crafting_pattern" />，<ItemLink id="smithing_table_pattern" />，或者 <ItemLink id="stonecutting_pattern" />，
所定义的操作，然后将产物推送到相邻的容器中。

它们主要在 <ItemLink id="pattern_provider" /> 旁边使用。
在这种情况下，样板供应器具有特殊行为，会将相关样板的信息连同材料一起发送给相邻的分子装配室。
由于分子装配室会自动将合成产物弹射到相邻的库存中（从而弹射到样板供应器的返回槽中），
因此只需在样板供应器上安装一个分子装配室，就能自动制作合成样板指定的配方。

<GameScene zoom="4" background="transparent">
<ImportStructure src="../assets/assemblies/assembler_tower.snbt" />
<IsometricCamera yaw="195" pitch="30" />
</GameScene>