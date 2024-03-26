---
navigation:
  parent: ae2-mechanics/ae2-mechanics-index.md
  title: 子网络
---

# 子网络

<GameScene zoom="4" interactive={true}>
<ImportStructure src="../assets/assemblies/subnet_demonstration.snbt" />

<DiamondAnnotation pos="6.5 2.5 0.5" color="#00ff00">
        物品管道子网络
    </DiamondAnnotation>

<DiamondAnnotation pos="5.5 2.5 0.5" color="#00ff00">
        流体管道子网络
    </DiamondAnnotation>

<DiamondAnnotation pos="4.5 2.5 0.5" color="#00ff00">
        过滤破坏面板子网络
    </DiamondAnnotation>

<DiamondAnnotation pos="3.5 2.5 0.5" color="#00ff00">
        成型面板子网络
    </DiamondAnnotation>

<DiamondAnnotation pos="2.5 2.5 0.5" color="#00ff00">
        本地存储子网络，通过接口与存储总线的组合来允许主网络的访问
    </DiamondAnnotation>

<DiamondAnnotation pos="1.5 1.5 0.5" color="#00ff00">
        另一个物品管道子网络，将充能后的物品返回给样板供应器
    </DiamondAnnotation>

<IsometricCamera yaw="195" pitch="30" />
</GameScene>

“子网络” 是一个定义相当宽泛的术语，可以说子网络是任何服务于主网络或执行一些小型任务的[网络](../ae2-mechanics/me-network-connections.md)。子网络的主要用途有两种：

* 来限制哪些[设备](../ae2-mechanics/devices.md)可以访问哪些库存（您不会希望 “管道” 子网的输入总线能够访问您的主网络，因为这样会导致物品被放入您的存储元件而不是目标容器）。
* 来节省您主网络的频道数量，例如让一个样板供应器输出到一个连接着多个对着不同机器的存储总线的接口，占用一个频道，而不是用多个样板供应器分别对着每台机器，占用多个频道。

建立子网络时最重要的是时刻把握[网络连接](../ae2-mechanics/me-network-connections.md)。
一些人可能会把接口、总线等东西连在一起，并期望它们能组成一个子网，但却忽略了它们仍能通过各种方块设备连接到主网络。

不同颜色的线缆之间不会互相连接，除此之外线缆的颜色与建立子网络没有任何关系。

一些子网络的例子如下：

* 将您主网络中的垃圾桶或溢出销毁卡替换为一个能够完成废物利用的网络。这个网络能够智能地将不同物品根据用途和需求送往不同的回收装置，例如堆肥桶阵列或其它模组中的回收器。
* 建立抽象。通过您的子网络来管理一个复杂制造过程中的所有细节，这样一来，从主网络的角度看，整个工厂 “就像是” 一台机器。
* 并行处理。将一台速度慢的机器替换为十台相同的机器。从主网络的角度看，没有任何变化，您甚至没有花费更多的频道。
* 一个输入总线和存储总线，用于将物品或流体从一个容器转移到另一个容器，就像物品或流体管道。
* 一个破坏面板和存储总线，这样破坏面板就只能将它破坏的东西存入到存储总线，让您能够为破坏面板设置过滤。
* 一个接口和成型面板，这样任何被放入接口中的物品都会被送到成型面板并被放置或丢出到世界中。
* 一个自动生产赛特斯石英水晶的装置，通过连接主网络的<ItemLink id="level_emitter" />控制和调节。
* 一个专门的存储系统，可以从主网络通过存储总线与接口的组合与之交互，用来储存农场的产物而不用担心产物会无限制地填满您的主网络库存。
* 以此类推。

<ItemLink id="quartz_fiber" />对于子网络的建造有很大帮助。它能在不连通网络的情况下在网络间传递能量，使您可以直接为子网供能而无需到处放置能量接收器和电线。
