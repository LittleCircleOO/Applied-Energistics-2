---
navigation:
  parent: items-blocks-machines/items-blocks-machines-index.md
  title: Controller
  icon: controller
  position: 110
categories:
- network infrastructure
item_ids:
- ae2:controller
---

# 控制器

<BlockImage id="controller" p:state="online" scale="8" />

控制器相当于[ ME 网络](../ae2-mechanics/me-network-connections.md)的集线器。 
如果没有控制器，网络就是“临时”的，且最多只能有总共 8 台[设备](../ae2-mechanics/devices.md)使用通道。 

同一个[ ME 网络](../ae2-mechanics/me-network-connections.md)中不能有多个控制器。  

控制器的每个面提供 32 个[通道](../ae2-mechanics/channels.md)。  

控制器需要每个控制器方块 6 AE/t 的能量供应才能正常工作。每个控制器方块能够存储 8000 AE，因此更大的网络可能需要额外的能量存储。
详细信息请参阅[能量](../ae2-mechanics/energy.md)。  

可以以相当自由的形式搭建多方块结构的控制器

<GameScene zoom="2" background="transparent">
  <ImportStructure src="../assets/assemblies/controllers.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

但是必须遵守以下规则：  

1.  [ME 网络](../ae2-mechanics/me-network-connections.md)上的所有控制器方块必须相连，否则方块会变成红色。  
2.  控制器结构必须在 7x7x7 大小范围内，否则方块会变成红色。 
3.  一个控制器方块最多在 1 个轴上有 2 个相邻的方块，如果有方块违反这个规则，则会被禁用并变成红色。
<GameScene zoom="2" background="transparent">
  <ImportStructure src="../assets/assemblies/controller_rules.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

满足所有规则并接上电力后，控制器会发光并循环变色。

可以右键控制器以获得与<ItemLink id="network_tool" />相同的界面。
## 合成 

<RecipeFor id="controller" />
