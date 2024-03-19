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

*   （**重要：** 使用“	选取方块”键（通常是鼠标中键）来请求制作已有库存的物品，这可能会与物品整理模组发生冲突），

2.  ME 系统会计算满足要求所需的原料和前置合成步骤，并将其存储在选定的合成 CPU 中

3.  带有相关 [样板](../items-blocks-machines/patterns.md) 的 <ItemLink id="pattern_provider" /> 会将样板中指定的原料推送到任何相邻的容器中。
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
    使其在给定原料的情况下制作出结果。但它们的主要用途是放在分子装配室相邻的 <ItemLink id="pattern_provider" /> 中。
    在这种情况下，样板供应器具有特殊行为，会将相关样板连同原料一起发送给相邻的分子装配室。
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
    “如果样板供应器将这些原料推送到邻近的容器中，ME 系统将在近期或远期的某个时间点收到这些产物”。
    几乎所有模组机械或熔炉等都可以通过它们进行自动合成。因为它们的使用非常普遍，而且不关心在推送原料和接收结果之间会发生什么，
    所以你可以做一些非常有趣的事情，比如把原料输入到整个复杂的工厂生产链中，这个生产链会分拣出东西，从无限生产的农场中接收其他原料，
    打印整个蜜蜂电影剧本，只要能得到样板指定的产物，ME 系统就不会关心。
    事实上，它甚至不在乎原料是否与结果有任何关联。
    你可以告诉它“1 块樱花木板 = 1 颗下界之星”，然后让你的凋灵农场在收到樱花木板时杀死一个凋灵，这样就可以了。

具有相同样板的多个 <ItemLink id="pattern_provider" /> 同样支持，并可并行工作。此外，您还可以设置一个样板，
例如，8 块圆石 = 8 块石头，而不是 1 块圆石 = 1 块石头，
这样样板供应器就会在每次操作中向您的熔炉装置中输入 8 块圆石，而不是一次输入一块。

## 最通用的“样板”形式

实际上，还有一种比处理样板更“通用”的“样板”。一个带有合成卡的 <ItemLink id="level_emitter" /> 可以被设置为发射红石信号以制作某种东西。
这种“样板”并不定义或甚至不关心原料。它说的只是“如果你从这个标准发信器发出红石信号，ME 系统将在近期或远期的某个时间点收到这个产物”。
这通常用于激活和停用不需要输入原料的无限农场，或者用于激活处理递归配方的系统（标准自动合成无法理解）
例如，如果你有一台可以复制圆石的机器，就可以激活“1 块圆石 = 2 块圆石”的自动合成。

# The Crafting CPU

<GameScene zoom="4" background="transparent">
  <ImportStructure src="../assets/assemblies/crafting_cpus.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

Crafting CPUs manage crafting requests/jobs. They store the intermediate ingredients while crafting jobs with multiple steps are
being carried out, and affect how big jobs can be, and to some degree how fast they are completed. They are multiblocks, and
must be rectangular prisms with at least 1 crafting storage.

Crafting CPUs are made out of:

*   (Required) [Crafting storages](../items-blocks-machines/crafting_cpu_multiblock.md), available in all the standard cell sizes (1k, 4k, 16k, 64k, 256k). They store the ingredients and
    intermediate ingredients involved in a craft, so larger or more storages are required for the CPU to handle crafting jobs
    with more ingredients.
*   (Optional) <ItemLink id="crafting_accelerator" />s, they make the system send out ingredient batches from pattern providers more often.
    This allows, say, a pattern provider surrounded by 6 molecular assemblers to send ingredients to (and thus use) all 6 at once instead of just one.
*   (Optional) <ItemLink id="crafting_monitor" />s, they display the job the CPU is handling at the moment. They can be colored via a <ItemLink id="color_applicator" />
*   (Optional) <ItemLink id="crafting_unit" />s, they simply fill space in order to make the CPU a rectangular prism.

Each crafting CPU handles 1 request or job, so if you want to request both a calculation processor and 256 smooth stone at once, you need 2 CPU multiblocks.

They can be set to handle requests from players, automation (export busses and interfaces), or both.

# Pattern Providers

<Row>
<BlockImage id="pattern_provider" scale="4" />

<BlockImage id="pattern_provider" p:push_direction="up" scale="4" />

<GameScene zoom="4" background="transparent">
  <ImportStructure src="../assets/blocks/cable_pattern_provider.snbt" />
</GameScene>
</Row>

<ItemLink id="pattern_provider" />s are the primary way in which your autocrafting system interacts with the world. They push the ingredients in
their [patterns](../items-blocks-machines/patterns.md) to adjacent inventories, and items can be inserted into them in order to insert them into the network. Often
a channel can be saved by piping the output of a machine back into a nearby pattern provider (often the one that pushed the ingredients)
instead of using an <ItemLink id="import_bus" /> to pull the output of the machine into the network.

Of note, since they push the ingredients directly from the [crafting storage](../items-blocks-machines/crafting_cpu_multiblock.md#crafting-storage) in a crafting CPU, they
never actually contain the ingredients in their inventory, so you cannot pipe out from them. You have to have the provider push
to another inventory (like a barrel) then pipe from that.

Also of note, the provider has to push ALL of the ingredients at once, it can't push half-batches. This is useful
to exploit.

Pattern providers have a special interaction with interfaces on [subnets](../ae2-mechanics/subnetworks.md): if the interface is unmodified (nothing in the request slots)
the provider will skip the interface entirely and push directly to that subnet's [storage](../ae2-mechanics/import-export-storage.md),
skipping the interface and not filling it with recipe batches, and more importantly, not inserting the next batch until there's space in storage.

Multiple pattern providers with identical patterns are supported and work in parallel.

Pattern providers will attempt to round-robin their batches to all of their faces, thus using all attached machines in parallel.

## Variants

Pattern Providers come in 3 different variants: normal, directional, and flat. This affects which specific sides they push
ingredients to, receive items from, and provide a network connection to.

*   Normal pattern providers push ingredients to all sides, receive inputs from all sides, and, like most AE2 machines, act
    like a cable providing network connection to all sides.

*   Directional pattern providers are made by using a <ItemLink id="certus_quartz_wrench" /> on a normal pattern provider to change its
    direction. They only push ingredients to the selected side, receive inputs from all sides, and specifically don't provide a network
    connection on the selected side. This allows them to push to AE2 machines without connecting networks, if you want to make a subnetwork.

*   Flat pattern providers are a [cable subpart](../ae2-mechanics/cable-subparts.md), and so multiple can be placed on the same cable, allowing for compact setups.
    They act similar to the selected side on a directional pattern provider, providing patterns, receiving inputs, and not
    providing a network connection on their face.

Pattern providers can be swapped between normal and flat in a crafting grid.

## Settings

Pattern providers have a variety of modes:

*   **Blocking Mode** stops the provider from pushing a new batch of ingredients if there are already
    ingredients in the machine.
*   **Lock Crafting** can lock the provider under various redstone conditions, or until the result of the
    previous craft is inserted into that specific pattern provider.
*   The provider can be shown or hidden on <ItemLink id="pattern_access_terminal" />s.

## Priority

Priorities can be set by clicking the wrench in the top-right of the GUI. In the case of several [patterns](../items-blocks-machines/patterns.md)
for the same item, patterns in providers with higher priority will be used over patterns in providers with lower priority,
unless the network does not have the ingredients for the higher priority pattern.

# Molecular Assemblers

<BlockImage id="molecular_assembler" scale="4" />

The <ItemLink id="molecular_assembler" /> takes items input into it and carries out the operation defined by an adjacent <ItemLink id="pattern_provider" />,
or the inserted <ItemLink id="crafting_pattern" />, <ItemLink id="smithing_table_pattern" />, or <ItemLink id="stonecutting_pattern" />,
then pushes the result to adjacent inventories.

Their main use is next to a <ItemLink id="pattern_provider" />. Pattern providers have special behavior in this case,
and will send information about the relevant pattern along with the ingredients to adjacent assemblers. Since assemblers auto-eject the results of
crafts to adjacent inventories (and thus into the return slots of the pattern provider), an assembler on a pattern provider
is all that is needed to automate crafting patterns.

<GameScene zoom="4" background="transparent">
<ImportStructure src="../assets/assemblies/assembler_tower.snbt" />
<IsometricCamera yaw="195" pitch="30" />
</GameScene>