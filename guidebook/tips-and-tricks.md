---
navigation:
  title: 提示与技巧
  position: 20
---

# 提示与技巧

大量随机的小建议

* 移除 Optifine
* 您可以旋转和缩放（带有缩放和注释隐藏/显示按钮的）指南场景
* 保持网络的树状结构，避免循环
* 除非您深入了解 [频道](ae2-mechanics/channels.md) 如何在网络中路由， 否则完整方块 [设备](ae2-mechanics/devices.md) 的数量不要超过 8 个。
* 选择一种木材，并在所有 [样板](items-blocks-machines/patterns.md) 中坚持使用。
  是的，在样板中启用替代有时会奏效，但在所有地方使用相同的木材类型会大大减少麻烦。
* 在 <ItemLink id="pattern_access_terminal" /> 中竖直摆放 [样板](items-blocks-machines/patterns.md) /
  将样板分散在各个 [样板供应器](items-blocks-machines/pattern_provider.md) 中，以便并行执行配方。
* 添加一个 [能源元件](items-blocks-machines/energy_cells.md) ，使网络能够应对功率峰值。
* 您可以在 <ItemLink id="condenser" /> 中使用水。
* 保持网络清洁的最佳方法是不要将将剑和盔甲等随机生物战利品放入其中，
  每个附魔和耐久的独特组合都是另一种 [类型](ae2-mechanics/bytes-and-types.md)。
* 在返回 [处理样板](items-blocks-machines/patterns.md) 的结果时，必须发生“物品进入系统”事件，
  比如 <ItemLink id="import_bus" />，<ItemLink id="interface" />，或者 <ItemLink id="pattern_provider" /> 的物品返回栏，
  你不能把结果直接导入一个带有 <ItemLink id="storage_bus" /> 的箱子。
* 别忘了，可以旋转和缩放（带有缩放和注释隐藏/显示按钮的）指南场景
* <ItemLink id="pattern_provider" /> 只推送完整的配方批次，而且只通过单侧推送。这对于确保机器不会获得部分批次非常有用，但有时您希望将原料发送到多个地方。
  您可以使用 <ItemLink id="interface" /> 来实现这一目的，可以是 [“管道”子网](example-setups/pipe-subnet.md) ，也可以利用其同时容纳多个不同物品堆叠、液体、化学品等的能力，将其用作某种中间容器/储罐。
* 您可以旋转和缩放（带有缩放和注释隐藏/显示按钮的）指南场景