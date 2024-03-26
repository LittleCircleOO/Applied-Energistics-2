---
navigation:
  parent: items-blocks-machines/items-blocks-machines-index.md
  title: Cables
  icon: fluix_glass_cable
  position: 110
categories:
- network infrastructure
item_ids:
- ae2:white_glass_cable
- ae2:orange_glass_cable
- ae2:magenta_glass_cable
- ae2:light_blue_glass_cable
- ae2:yellow_glass_cable
- ae2:lime_glass_cable
- ae2:pink_glass_cable
- ae2:gray_glass_cable
- ae2:light_gray_glass_cable
- ae2:cyan_glass_cable
- ae2:purple_glass_cable
- ae2:blue_glass_cable
- ae2:brown_glass_cable
- ae2:green_glass_cable
- ae2:red_glass_cable
- ae2:black_glass_cable
- ae2:fluix_glass_cable
- ae2:white_covered_cable
- ae2:orange_covered_cable
- ae2:magenta_covered_cable
- ae2:light_blue_covered_cable
- ae2:yellow_covered_cable
- ae2:lime_covered_cable
- ae2:pink_covered_cable
- ae2:gray_covered_cable
- ae2:light_gray_covered_cable
- ae2:cyan_covered_cable
- ae2:purple_covered_cable
- ae2:blue_covered_cable
- ae2:brown_covered_cable
- ae2:green_covered_cable
- ae2:red_covered_cable
- ae2:black_covered_cable
- ae2:fluix_covered_cable
- ae2:white_covered_dense_cable
- ae2:orange_covered_dense_cable
- ae2:magenta_covered_dense_cable
- ae2:light_blue_covered_dense_cable
- ae2:yellow_covered_dense_cable
- ae2:lime_covered_dense_cable
- ae2:pink_covered_dense_cable
- ae2:gray_covered_dense_cable
- ae2:light_gray_covered_dense_cable
- ae2:cyan_covered_dense_cable
- ae2:purple_covered_dense_cable
- ae2:blue_covered_dense_cable
- ae2:brown_covered_dense_cable
- ae2:green_covered_dense_cable
- ae2:red_covered_dense_cable
- ae2:black_covered_dense_cable
- ae2:fluix_covered_dense_cable
- ae2:white_smart_cable
- ae2:orange_smart_cable
- ae2:magenta_smart_cable
- ae2:light_blue_smart_cable
- ae2:yellow_smart_cable
- ae2:lime_smart_cable
- ae2:pink_smart_cable
- ae2:gray_smart_cable
- ae2:light_gray_smart_cable
- ae2:cyan_smart_cable
- ae2:purple_smart_cable
- ae2:blue_smart_cable
- ae2:brown_smart_cable
- ae2:green_smart_cable
- ae2:red_smart_cable
- ae2:black_smart_cable
- ae2:fluix_smart_cable
- ae2:white_smart_dense_cable
- ae2:orange_smart_dense_cable
- ae2:magenta_smart_dense_cable
- ae2:light_blue_smart_dense_cable
- ae2:yellow_smart_dense_cable
- ae2:lime_smart_dense_cable
- ae2:pink_smart_dense_cable
- ae2:gray_smart_dense_cable
- ae2:light_gray_smart_dense_cable
- ae2:cyan_smart_dense_cable
- ae2:purple_smart_dense_cable
- ae2:blue_smart_dense_cable
- ae2:brown_smart_dense_cable
- ae2:green_smart_dense_cable
- ae2:red_smart_dense_cable
- ae2:black_smart_dense_cable
- ae2:fluix_smart_dense_cable
---

# 线缆  

<GameScene zoom="3" background="transparent">
  <ImportStructure src="../assets/assemblies/cables.snbt" /> 
  <IsometricCamera yaw="180" pitch="30" />
</GameScene>

虽然毗邻的支持 ME 的机器也能构建一个 ME 网络，但是线缆是将 ME 网络扩展到更大的区域的主要方式。

使用不同颜色的线缆可确保相邻线缆不会相互连接，从而更高效地分配[频道](../ae2-mechanics/channels.md)。
线缆本身的颜色也会影响附着到线缆上的终端的颜色, 所以你不必把所有终端染成紫色。
福鲁伊克斯线缆将与所有其他颜色的线缆相连接。  

值得注意的是, **频道与线缆颜色无关**。

## 重要提示  

**如果你不熟悉 AE2 及其频道，请尽可能使用智能线缆和致密智能线缆。它们将显示频道在你的网络里是如何流通的，这样能更便于理解频道的工作方式。** 

## 其他提示  

**线缆并不是承载物品/流体/能源等的管道。** 线缆没有内部的存储空间，样板供应器和其他机械并不会向线缆“推”入物品，
线缆的作用仅仅是将 AE2 [设备](../ae2-mechanics/devices.md)连接进入网络。 

## 玻璃线缆  

<GameScene zoom="6" background="transparent">
<ImportStructure src="../assets/assemblies/fluix_glass_cable.snbt" />
<IsometricCamera yaw="195" pitch="30" />
</GameScene>

<ItemLink id="fluix_glass_cable" />是最简单的线缆，能够传输电力和最多 8 个[频道](../ae2-mechanics/channels.md)。
玻璃线缆有 17 种颜色，默认为福鲁伊克斯色，也可以用其他 16 种染料染色。  

用 8 个相同类型的线缆（线缆的颜色可以不同，但是它们必须是同一类型，比如玻璃、智能等。）围一圈，中间放上任意染料。  
也可以用与 Forge 兼容的任意画刷对线缆染色。  

可以用水桶与任意染色的线缆合成以移除染色效果。  

线缆可以与羊毛一起合成<ItemLink id="fluix_covered_cable" />，也可以合成<ItemLink id="fluix_smart_cable" />以更方便地了解你的[频道](../ae2-mechanics/channels.md)的状况。  

<RecipeFor id="fluix_glass_cable" />  

<RecipeFor id="blue_glass_cable" />

## 包层线缆  

<GameScene zoom="6" background="transparent"> 
  <ImportStructure src="../assets/assemblies/fluix_covered_cable.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

与同类的线缆<ItemLink id="fluix_glass_cable" />相比，包层线缆并没有什么玩法上的优势。但是如果你喜欢它包了一层皮的外观，包层线缆也可以作为兼顾美观性的替代品。  

可以使用和<ItemLink id="fluix_glass_cable" />相同的方式为包层线缆染色。使用 4 个<ItemLink id="fluix_covered_cable" />以及红石和荧石制作<ItemLink id="fluix_covered_dense_cable" />。  

<Recipe id="network/cables/covered_fluix" />

<RecipeFor id="blue_covered_cable" />

## 致密线缆  

<GameScene zoom="6" background="transparent">
  <ImportStructure src="../assets/assemblies/fluix_covered_dense_cable.snbt" />
  <IsometricCamera yaw="195" pitch="30" /> 
</GameScene>

更大容量的线缆。相较于其他只能承载 8 个频道的普通线缆，致密线缆可以承载 32 个频道。致密线缆不支持总线，
所以在使用总线或者面板之前，你需要从致密线缆降级至更小的线缆（例如<ItemLink id="fluix_glass_cable" />或<ItemLink id="fluix_smart_cable" />。  

致密线缆略微覆盖了频道的“最短路径”行为，频道将以最短路径到达致密线缆，然后以最短路径通过致密线缆到达控制器。

<Recipe id="network/cables/dense_covered_fluix" /> 

<RecipeFor id="blue_covered_dense_cable" />

## 智能线缆  

<Row>
<GameScene zoom="6" background="transparent">
  <ImportStructure src="../assets/assemblies/fluix_smart_cable.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>
<GameScene zoom="6" background="transparent">
  <ImportStructure src="../assets/assemblies/fluix_smart_dense_cable.snbt" /> 
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>
</Row>

虽然在外观上和<ItemLink id="fluix_covered_cable" />很相似，但智能线缆会提供一个诊断功能：将线缆内的频道使用情况以可视化的形式表现出来。
频道在线缆上显示为在黑色条纹上发光的彩色线条，让你可以了解到你的频道在网络中的使用情况。
对于普通的智能线缆，前四个频道显示为与线缆颜色相同的颜色的线条，后四个频道显示为白色线条。
对于致密智能线缆，每 4 个频道显示为 1 个线条。

在具备<ItemLink id="controller" />的网络中，智能线缆上的线条显示的是频道使用的确切路径。 

不具备控制器的临时网络中，智能线缆上的线条显示的是整个网络中的频道总数，而不是流经该线缆的频道数。   

也可以使用和<ItemLink id="fluix_glass_cable" />相同的方式为智能线缆染色.  

<Recipe id="network/cables/smart_fluix" />

<Recipe id="network/cables/dense_smart_fluix" />

<RecipeFor id="blue_smart_cable" /> 
